package com.generation.lojagamer.adapters.out.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.generation.lojagamer.application.port.out.CategoriaPersistencePort;
import com.generation.lojagamer.domain.model.Categoria;

@Component
public class CategoriaPersistenceAdapter implements CategoriaPersistencePort {

    private final SpringDataCategoriaRepository repository;

    public CategoriaPersistenceAdapter(SpringDataCategoriaRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Categoria> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Categoria> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    public List<Categoria> findByNomeContainingIgnoreCase(String nome) {
        return repository.findAllByNomeContainingIgnoreCase(nome);
    }

    @Override
    public Categoria save(Categoria categoria) {
        return repository.save(categoria);
    }

    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
