package org.example.repository;

import org.example.model.Origem;
import java.util.List;
import java.util.Optional;

public interface OrigemRepository {
    //CRUD Básico
    Origem save(Origem origem);
    Optional<Origem> findById(Integer id);
    Optional<Origem> findByTipo(String tipo);
    List<Origem> findAll();
    void deletedById(Integer id);

    //Método personalizado de busca
    Optional<Origem> findByDescricao(String descricao);
}
