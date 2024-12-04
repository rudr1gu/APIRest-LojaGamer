package com.generation.lojagamer.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.generation.lojagamer.model.Produtos;
import com.generation.lojagamer.repository.ProdutosRepository;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/produtos")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ProdutosController {
        
        @Autowired
        private ProdutosRepository repository;
        
        @GetMapping
        public ResponseEntity<List<Produtos>> getAll(){
            return ResponseEntity.ok(repository.findAll());
        }
        
        @GetMapping("/{id}")
        public ResponseEntity<Produtos> getById(@PathVariable long id){
            return repository.findById(id).map(resp -> ResponseEntity.ok(resp)).orElse(ResponseEntity.notFound().build());
        }
        
        @GetMapping("/nome/{nome}")
        public ResponseEntity<List<Produtos>> getByName(@PathVariable String nome){
            return ResponseEntity.ok(repository.findAllByNomeContainingIgnoreCase(nome));
        }
        
        @PostMapping
        public ResponseEntity<Produtos> post(@Valid @RequestBody Produtos produto){
            return ResponseEntity.status(HttpStatus.CREATED).body(repository.save(produto));
        }
        
        @PutMapping
        public ResponseEntity<Produtos> put(@Valid @RequestBody Produtos produto){
            return ResponseEntity.status(HttpStatus.OK).body(repository.save(produto));
        }
        
        @DeleteMapping("/{id}")
        public void delete(@PathVariable long id) {
            repository.deleteById(id);
        }
}
