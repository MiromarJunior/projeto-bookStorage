package com.bookstore.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.bookstore.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
    
}
