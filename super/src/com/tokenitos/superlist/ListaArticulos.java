package com.tokenitos.superlist;

import java.util.ArrayList;
import java.util.Collection;

public class ListaArticulos {

    Collection<Articulo> listArticulos = new ArrayList<>();

    public void agregarArticulo(Articulo art){
        if(existeArticulo(art)){
            System.out.println("articulo existente");
        }
    }

    private boolean existeArticulo(Articulo art) {
        return false;
    }

    /*public static boolean estaArticulo()
    {
        Collection<Articulo> articulos = getA
        boolean encontrado = false;
        for (int x = 0; x < productos.size(); x++) {
            Producto p = productos.get(x);
            if (p.getCodigo().equals(busqueda.getCodigo())) {
                encontrado = true;
                break; // Terminar ciclo, pues ya lo encontramos
            }
        }
        if (encontrado) {
            System.out.println("El producto existe");
        } else {
            System.out.println("El producto NO existe");
        }



    }*/

}