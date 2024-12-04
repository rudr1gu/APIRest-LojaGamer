package com.generation.lojagamer.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "tb_produtos")
public class Produtos {
        
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        
        @NotNull
        @Size(min = 5, max = 100)
        private String nome;
        
        @NotNull
        @Size(min = 5, max = 100)
        private String descricao;
        
        @NotNull
        private double preco;
        
        @NotNull
        private int quantidade;
        
        @ManyToOne
        @JsonIgnoreProperties("produtos")
        private Categoria categoria;
}
