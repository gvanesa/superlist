package com.tokenitos.superlist;


public class Valor {
    private String articulo;
    private int valor;


    public Valor(String articulo, int valor) {
        this.articulo = articulo;
        this.valor = valor;
    }

    @Override
    public String toString() {
        return getArticulo() + ", " + getValor();
    }

    private String getArticulo() {
        return articulo;
    }

    private Object getValor() {
        return valor;
    }

    Valor(){}

}