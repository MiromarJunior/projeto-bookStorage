package com.bookstore.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.bookstore.bookstore.excecoes.DataIntegrityViolationException;
import com.bookstore.bookstore.excecoes.ObjetoNaoEncontrado;
import com.bookstore.bookstore.model.Categoria;
import com.bookstore.bookstore.repository.CategoriaRepository;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository rep;

    public Categoria listCatId(Long id){
        Optional<Categoria> cat = rep.findById(id);
        return cat.orElseThrow(()-> new ObjetoNaoEncontrado("Objeto não encontrado ID : "+id+" , Tipo: "+Categoria.class.getName()));
    }

    public List<Categoria> buscaCategorias(){
        return rep.findAll();
    }

    public Categoria create(Categoria cat){
        if(cat.getId() != null){
            listCatId(cat.getId());
        }
       return rep.save(cat);
    }

    public void delete(Long id){
        listCatId(id);
        try {
            rep.deleteById(id);
            
        } catch ( org.springframework.dao.DataIntegrityViolationException e) {
            throw new DataIntegrityViolationException("Regitro não pode ser deletado ! Erro : "+e.getMessage());
        
           
        }
        
    }
    
    
}
