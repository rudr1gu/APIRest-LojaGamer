package com.generation.lojagamer.application.port.out;

import java.util.List;
import java.util.Optional;

import com.generation.lojagamer.domain.model.Produtos;

public interface ProdutoPersistencePort {

    List<Produtos> findAll();

    Optional<Produtos> findById(Long id);

    List<Produtos> findByNomeContainingIgnoreCase(String nome);

    Produtos save(Produtos produto);

    void deleteById(Long id);
}
