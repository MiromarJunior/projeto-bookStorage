package com.bookstore.bookstore.dto;

import java.io.Serializable;

import com.bookstore.bookstore.model.Categoria;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    

    
    private Long id;
    private String nome;
    private String descricao;

    public CategoriaDTO(Categoria cat){
        super();
        this.id = cat.getId();
        this.nome = cat.getNome();
        this.descricao = cat.getDescricao();

    }
    
}
