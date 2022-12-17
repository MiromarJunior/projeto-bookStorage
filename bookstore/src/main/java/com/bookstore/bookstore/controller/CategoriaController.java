package com.bookstore.bookstore.controller;

import java.net.URI;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.bookstore.bookstore.dto.CategoriaDTO;
import com.bookstore.bookstore.model.Categoria;
import com.bookstore.bookstore.service.CategoriaService;

@RestController
@RequestMapping("/categoria")
public class CategoriaController {

    @Autowired
    private CategoriaService service;

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> buscaCatId(@PathVariable Long id){
        Categoria cat = service.listCatId(id);
        return ResponseEntity.ok().body(cat);
    }

    @GetMapping
    public ResponseEntity<List<CategoriaDTO>> buscaCategorias(){
        List<Categoria> list = service.buscaCategorias();
        List<CategoriaDTO> listDTO = list.stream().map(res -> new CategoriaDTO(res)).collect(Collectors.toList());
        return ResponseEntity.ok().body(listDTO);


    }

    @PostMapping
    public ResponseEntity<Categoria> create(@RequestBody Categoria cat){
        cat = service.create(cat);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(cat.getId()).toUri();
        return ResponseEntity.created(uri).body(cat);

    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Long id, @RequestBody Categoria cat){
        cat.setId(id);
        // service.listCatId(id);
        service.create(cat);
        return ResponseEntity.ok().body(cat);

    } 

    @DeleteMapping
   // @DeleteMapping("/{id}")     
    public ResponseEntity<Void> delete(@RequestBody Categoria cat){       
        service.delete(cat.getId());
        return ResponseEntity.noContent().build();

    }
    
}
