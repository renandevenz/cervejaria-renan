package com.beerhouse.exception;

public class ProdutoExistenteException extends RuntimeException {
    public ProdutoExistenteException(String message) {
        super(message);
    }
}
