package com.bookstore.bookstore.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bookstore.bookstore.model.Livro;

public interface LivroRepository extends JpaRepository <Livro, Long>{

    @Query("SELECT obj FROM Livro obj WHERE obj.categoria.id = :idCat ORDER BY titulo ")
    List<Livro> findAllByCategoria( @Param(value = "idCat") Long idCat);

    
}
