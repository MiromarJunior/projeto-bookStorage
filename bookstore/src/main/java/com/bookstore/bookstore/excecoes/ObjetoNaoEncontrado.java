package com.bookstore.bookstore.excecoes;

public class ObjetoNaoEncontrado extends RuntimeException{
    private static final long serialVersionUID = 1L;

    public ObjetoNaoEncontrado(String arg0) {
        super(arg0);
    }
    

    public ObjetoNaoEncontrado(String arg0, Throwable arg1) {
        super(arg0, arg1);
    }

    

    
    
}
