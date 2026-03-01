package com.generation.lojagamer.application.port.in;

import java.util.List;
import java.util.Optional;

import com.generation.lojagamer.domain.model.Produtos;

public interface ProdutoUseCase {

    List<Produtos> listarTodos();

    Optional<Produtos> buscarPorId(Long id);

    List<Produtos> buscarPorNome(String nome);

    Produtos salvar(Produtos produto);

    void deletar(Long id);
}
