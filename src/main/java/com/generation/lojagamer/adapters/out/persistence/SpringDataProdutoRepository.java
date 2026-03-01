package com.generation.lojagamer.adapters.out.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.lojagamer.domain.model.Produtos;

public interface SpringDataProdutoRepository extends JpaRepository<Produtos, Long> {

    List<Produtos> findAllByNomeContainingIgnoreCase(String nome);
}
