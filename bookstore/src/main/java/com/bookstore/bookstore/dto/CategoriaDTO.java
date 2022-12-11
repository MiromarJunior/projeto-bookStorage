package com.bookstore.bookstore.dto;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import com.bookstore.bookstore.model.Categoria;

import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaDTO implements Serializable{
    private static final long serialVersionUID = 1L;
    

    
    private Long id;
    @NotEmpty(message = "Campo nome não pode ser vazio")
    @Length(min = 3, max = 100, message = "O campo nome tem que ser de 3 a 100 caracteres")
    private String nome;

    @NotEmpty(message = "Campo descriçãp não pode ser vazio")
    @Length(min = 3, max = 200, message = "O campo descriçãp tem que ser de 3 a 200 caracteres")
    private String descricao;

    public CategoriaDTO(Categoria cat){
        super();
        this.id = cat.getId();
        this.nome = cat.getNome();
        this.descricao = cat.getDescricao();

    }
    
}
