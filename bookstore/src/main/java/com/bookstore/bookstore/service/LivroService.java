package com.bookstore.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.excecoes.ObjetoNaoEncontrado;
import com.bookstore.bookstore.model.Livro;
import com.bookstore.bookstore.repository.LivroRepository;

@Service
public class LivroService {

    @Autowired
    private LivroRepository rep;

    @Autowired
    private CategoriaService service;


    public Livro findByI(Long id){
       Optional<Livro> liv =   rep.findById(id);
       return liv.orElseThrow(()-> new ObjetoNaoEncontrado("Objeto não encontrado ID : "+id+" , Tipo: "+Livro.class.getName()));


    }


    public List<Livro> findAll(Long idCat) {
        service.listCatId(idCat);
        return rep.findAllByCategoria(idCat);
    }
    
}
