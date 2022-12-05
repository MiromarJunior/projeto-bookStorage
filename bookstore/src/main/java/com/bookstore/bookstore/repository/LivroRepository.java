package com.bookstore.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookstore.model.Livro;

public interface LivroRepository extends JpaRepository <Livro, Long>{
    
}
