package com.generation.lojagamer.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.generation.lojagamer.application.port.in.ProdutoUseCase;
import com.generation.lojagamer.application.port.out.ProdutoPersistencePort;
import com.generation.lojagamer.domain.model.Produtos;

@Service
public class ProdutoService implements ProdutoUseCase {

    private final ProdutoPersistencePort produtoPersistencePort;

    public ProdutoService(ProdutoPersistencePort produtoPersistencePort) {
        this.produtoPersistencePort = produtoPersistencePort;
    }

    @Override
    public List<Produtos> listarTodos() {
        return produtoPersistencePort.findAll();
    }

    @Override
    public Optional<Produtos> buscarPorId(Long id) {
        return produtoPersistencePort.findById(id);
    }

    @Override
    public List<Produtos> buscarPorNome(String nome) {
        return produtoPersistencePort.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public Produtos salvar(Produtos produto) {
        return produtoPersistencePort.save(produto);
    }

    @Override
    public void deletar(Long id) {
        produtoPersistencePort.deleteById(id);
    }
}
