package com.bookstore.bookstore.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.bookstore.dto.LivroDTO;
import com.bookstore.bookstore.model.Categoria;
import com.bookstore.bookstore.model.Livro;
import com.bookstore.bookstore.service.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable("id") Long id){
      Livro liv =   service.findByI(id);
      return ResponseEntity.ok().body(liv);
    }

    @GetMapping
    //public ResponseEntity<List<LivroDTO>> findAll(@RequestParam(value = "categoria", defaultValue = "0") Long idCat){

    public ResponseEntity<List<LivroDTO>> findAll(@RequestBody Categoria cat){
     Long idCat = cat.getId();
      List<Livro> list = service.findAll(idCat);
      List<LivroDTO> listDTO = list.stream().map(obj -> new LivroDTO(obj)).collect((Collectors.toList()));
      return ResponseEntity.ok().body(listDTO);
    
    }

    
}
