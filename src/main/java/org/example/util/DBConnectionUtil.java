package org.example.util;

import java.io.IOException;
import java.util.Properties;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public final class DBConnectionUtil {


    // -------------------------------------------------------------------------
    // 1. DECLARAÇÃO DE ATRIBUTOS ESTÁTICOS (CONFIGURAÇÃO)
    // -------------------------------------------------------------------------

    // Armazena as configurações lidas do arquivo (URL, User, Pass).
    // 'static final' garante que ele é criado e lido apenas uma vez.
    private static final Properties PROPERTIES = new Properties();

    // Nome do arquivo de configuração a ser lido do diretório 'resources'.
    private static final String CONFIG_FILE = "application.properties";

    // -------------------------------------------------------------------------
    // 2. BLOCO ESTÁTICO DE INICIALIZAÇÃO
    // -------------------------------------------------------------------------

    // O bloco estático é executado APENAS UMA VEZ quando a classe é carregada
    // pela JVM (na primeira vez que o DBConnectionUtil for referenciado).
    static {
        System.out.println("DEBUG: Carregando configurações do banco de dados...");

        // Estrutura try-with-resources: Garante que o recurso 'input' (arquivo)
        // seja fechado automaticamente no final do bloco, prevenindo vazamento de recursos.
        try (
                // Abre o arquivo de recursos no classpath (src/main/resources)
                InputStream input = DBConnectionUtil.class.getClassLoader().getResourceAsStream(CONFIG_FILE)
        ) {
            // Verifica se o arquivo application.properties foi encontrado
            if (input == null) {
                // Se o arquivo estiver ausente, lança um erro irrecuperável.
                throw new RuntimeException("ERRO: Arquivo de configuração '" + CONFIG_FILE + "' não encontrado em resources.");
            }

            // Lê todas as chaves (db.url, db.username, db.driver, etc.) do arquivo
            // e as armazena no objeto PROPERTIES em memória.
            PROPERTIES.load(input);

            // Tenta carregar o Driver JDBC (ex: com.mysql.cj.jdbc.Driver) na memória.
            // Isso é essencial para que o DriverManager saiba qual driver usar.
            Class.forName(PROPERTIES.getProperty("db.driver"));

            System.out.println("DEBUG: Configurações carregadas com sucesso.");

        }
        // ----------------- TRATAMENTO DE ERROS NA INICIALIZAÇÃO -----------------
        catch (IOException e) {
            // Captura falhas na leitura do arquivo (ex: corrompido)
            System.err.println("ERRO: Falha na leitura do arquivo de propriedades.");
            e.printStackTrace();
            throw new RuntimeException("Falha ao inicializar o utilitário de conexão.", e);
        } catch (ClassNotFoundException e) {
            // Captura falhas ao carregar a classe do driver (ex: JAR do MySQL ausente)
            System.err.println("ERRO: Driver JDBC não encontrado. Verifique se o .jar está no classpath.");
            e.printStackTrace();
            throw new RuntimeException("Driver JDBC indisponível.", e);
        }
    }

    // -------------------------------------------------------------------------
    // 3. MÉTODO PRINCIPAL DE SERVIÇO
    // -------------------------------------------------------------------------

    /**
     * Método público e estático que a Camada Repository chama para iniciar uma transação.
     * Retorna um novo objeto Connection.
     * @return Uma nova conexão aberta com o banco de dados.
     * @throws SQLException Caso ocorra um erro de conexão (ex: credenciais erradas, BD offline).
     */
    public static Connection getConnection() throws SQLException {
        // Usa a classe nativa do JDBC para criar e retornar a conexão.
        // As credenciais são lidas da memória (do objeto PROPERTIES que foi carregado no bloco static).
        return DriverManager.getConnection(
                PROPERTIES.getProperty("db.url"),
                PROPERTIES.getProperty("db.username"),
                PROPERTIES.getProperty("db.password")
        );
    }
}