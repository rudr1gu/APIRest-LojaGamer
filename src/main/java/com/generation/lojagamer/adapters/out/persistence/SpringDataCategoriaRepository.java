package com.generation.lojagamer.adapters.out.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.lojagamer.domain.model.Categoria;

public interface SpringDataCategoriaRepository extends JpaRepository<Categoria, Long> {

    List<Categoria> findAllByNomeContainingIgnoreCase(String nome);
}
