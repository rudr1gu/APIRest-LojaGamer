package com.generation.lojagamer.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.generation.lojagamer.model.Categoria;

public interface CategoriasRepository extends JpaRepository<Categoria, Long> {
    public List<Categoria> findAllByNomeContainingIgnoreCase(String nome);

}
