package org.example.repository;

import org.example.model.Categoria;
import java.util.List;
import java.util.Optional;

public interface CategoriaRepository {
    Categoria save(Categoria categoria);
    Optional<Categoria> findById(Integer id);
    Optional<Categoria> findByTipo(String tipo);
    List<Categoria> findAll();
    void deletedById(Integer id);

    Optional<Categoria> findByDescricao(String descricao);

}
