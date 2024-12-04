package com.generation.lojagamer.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.generation.lojagamer.model.Categoria;
import com.generation.lojagamer.repository.CategoriasRepository;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/categorias")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class CategoriasController {
    @Autowired
    private CategoriasRepository categoriasRepository;

    @GetMapping
    public ResponseEntity<List<Categoria>> getAll() {
        return ResponseEntity.ok(categoriasRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> getById(@RequestParam long id) {
        return categoriasRepository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/nome/{nome}")
    public ResponseEntity<List<Categoria>> getByName(@RequestParam String nome) {
        return ResponseEntity.ok(categoriasRepository.findAllByNomeContainingIgnoreCase(nome));
    }

    @PostMapping
    public ResponseEntity<Categoria> post(@RequestBody Categoria categoria) {
        return ResponseEntity.status(201).body(categoriasRepository.save(categoria));
    }

    @PutMapping
    public ResponseEntity<Categoria> put(@RequestBody Categoria categoria) {
        return ResponseEntity.status(200).body(categoriasRepository.save(categoria));
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        Optional<Categoria> categoria = categoriasRepository.findById(id);
        if (categoria.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        categoriasRepository.deleteById(id);
    } 
}