package com.bookstore.bookstore.dto;

import java.io.Serializable;

import com.bookstore.bookstore.model.Livro;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LivroDTO  implements Serializable{

 private static final long serialVersionUID = 1L   ;

 private Long id;    
 private String titulo;
 
public LivroDTO(Livro liv) {
    this.id = liv.getId();
    this.titulo = liv.getTitulo();
}

 

    
}
