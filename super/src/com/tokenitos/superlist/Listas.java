package com.tokenitos.superlist;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

import static com.tokenitos.superlist.Archivo.existeArchivo;
import static com.tokenitos.superlist.Archivo.leerEImprimir;

public class Listas {

    //Collection<Articulo> listaPrecios = new ArrayList<>();



    public static Collection<Articulo> leerPrecios(File archivo) throws IOException {

        Collection<Articulo> listaPrecios = new ArrayList<>();
        if (existeArchivo(archivo))
        {
            listaPrecios=leerEImprimir(archivo);
        }
        return listaPrecios;
    }



    public static boolean existeArticuloActualiza(Collection<Articulo> ListaArticulos, Articulo artiNuevo) {

        for (Articulo aName : ListaArticulos) {
            if ((artiNuevo.getArticulo().compareToIgnoreCase(aName.getArticulo())) == 0) {
                if (aName.equals(artiNuevo)) {
                    aName.setCantidad(artiNuevo.getCantidad());
                    return true;
                }
            }
        }return false;
    }

    public static Articulo existeArticulo(Collection<Articulo> ListaArticulos, Articulo artiNuevo){

        for (Articulo aName : ListaArticulos) {
            //  if ((artiNuevo.getArticulo().compareToIgnoreCase(aName.getArticulo()))==0){
            if (aName.equals(artiNuevo)) {
                return aName;
            }
        }
        return artiNuevo;
    }

    public static boolean existeArticuloConsulta(Collection<Articulo> ListaArticulos, Articulo artiNuevo){

        for (Articulo aName : ListaArticulos) {
            if ((artiNuevo.getArticulo().compareToIgnoreCase(aName.getArticulo()))==0){
            //if (aName.equals(artiNuevo)) {
                return true;
           // }
        }
    }
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
