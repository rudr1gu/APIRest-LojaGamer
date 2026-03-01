package com.generation.lojagamer.application.port.out;

import java.util.List;
import java.util.Optional;

import com.generation.lojagamer.domain.model.Categoria;

public interface CategoriaPersistencePort {

    List<Categoria> findAll();

    Optional<Categoria> findById(Long id);

    List<Categoria> findByNomeContainingIgnoreCase(String nome);

    Categoria save(Categoria categoria);

    void deleteById(Long id);
}
