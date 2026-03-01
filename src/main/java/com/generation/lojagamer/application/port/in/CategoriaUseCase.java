package com.generation.lojagamer.application.port.in;

import java.util.List;
import java.util.Optional;

import com.generation.lojagamer.domain.model.Categoria;

public interface CategoriaUseCase {

    List<Categoria> listarTodas();

    Optional<Categoria> buscarPorId(Long id);

    List<Categoria> buscarPorNome(String nome);

    Categoria salvar(Categoria categoria);

    void deletar(Long id);
}
