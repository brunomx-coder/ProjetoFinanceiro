package org.example.repository;

import org.example.model.Transacao;
import java.util.List;
import java.util.Optional;
import java.util.Date;

public interface TransacaoRepository {
    Transacao save(Transacao transacao);
    Optional<Transacao> findById(Integer id);
    Optional<Transacao> findByTipo(String tipo);
    Optional<Transacao> findByData(Date data);
    List<Transacao> findAll();
    void deletedById(Integer id);

    Optional<Transacao> findByDescricao(String descricao);
}
