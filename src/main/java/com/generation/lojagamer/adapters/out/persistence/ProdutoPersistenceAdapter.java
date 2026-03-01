package com.generation.lojagamer.adapters.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.generation.lojagamer.application.port.out.ProdutoPersistencePort;
import com.generation.lojagamer.domain.model.Produtos;

@Component
public class ProdutoPersistenceAdapter implements ProdutoPersistencePort {

    private final SpringDataProdutoRepository repository;

    public ProdutoPersistenceAdapter(SpringDataProdutoRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Produtos> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Produtos> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Produtos> findByNomeContainingIgnoreCase(String nome) {
        return repository.findAllByNomeContainingIgnoreCase(nome);
    }

    @Override
    public Produtos save(Produtos produto) {
        return repository.save(produto);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
