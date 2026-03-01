package com.generation.lojagamer.application.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.generation.lojagamer.application.port.in.CategoriaUseCase;
import com.generation.lojagamer.application.port.out.CategoriaPersistencePort;
import com.generation.lojagamer.domain.model.Categoria;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class CategoriaService implements CategoriaUseCase {

    private final CategoriaPersistencePort categoriaPersistencePort;

    public CategoriaService(CategoriaPersistencePort categoriaPersistencePort) {
        this.categoriaPersistencePort = categoriaPersistencePort;
    }

    @Override
    public List<Categoria> listarTodas() {
        return categoriaPersistencePort.findAll();
    }

    @Override
    public Optional<Categoria> buscarPorId(Long id) {
        return categoriaPersistencePort.findById(id);
    }

    @Override
    public List<Categoria> buscarPorNome(String nome) {
        return categoriaPersistencePort.findByNomeContainingIgnoreCase(nome);
    }

    @Override
    public Categoria salvar(Categoria categoria) {
        return categoriaPersistencePort.save(categoria);
    }

    @Override
    public void deletar(Long id) {
        if (categoriaPersistencePort.findById(id).isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND);
        }

        categoriaPersistencePort.deleteById(id);
    }
}
