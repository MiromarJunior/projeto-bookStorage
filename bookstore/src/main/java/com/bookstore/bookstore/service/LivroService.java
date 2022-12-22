package com.bookstore.bookstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.bookstore.excecoes.ObjetoNaoEncontrado;
import com.bookstore.bookstore.model.Categoria;
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


    public Livro update(Long id, Livro liv) {
       Livro newLiv = findByI(id);
       updateData(newLiv,liv);
       return rep.save(newLiv);
    }


    private void updateData(Livro newLiv, Livro liv) {
        newLiv.setTitulo(liv.getTitulo());
        newLiv.setNomeAutor(liv.getNomeAutor());
    }


    public Livro create(Long idCat, Livro liv) {
        liv.setId(null);
        Categoria cat  = service.listCatId(idCat);
        liv.setCategoria(cat);
        return rep.save(liv);
    }
    
}
