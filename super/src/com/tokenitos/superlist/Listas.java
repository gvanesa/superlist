package com.tokenitos.superlist;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Scanner;

import static com.tokenitos.superlist.Archivo.existeArchivo;
import static com.tokenitos.superlist.Archivo.leerEImprimir;
import static com.tokenitos.superlist.Main.isNumeric;

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



    public static boolean existeArticuloActualiza(Collection<Articulo> listaArticulos, Articulo artiNuevo) {

        for (Articulo aName : listaArticulos) {
            if ((artiNuevo.getArticulo().compareToIgnoreCase(aName.getArticulo())) == 0) {
                if (aName.equals(artiNuevo)) {
                    aName.setCantidad(artiNuevo.getCantidad());
                    return true;
                }
            }
        }return false;
    }

    public static Articulo existeArticulo(Collection<Articulo> listaArticulos, Articulo artiNuevo){

        for (Articulo aName : listaArticulos) {
            if (aName.equals(artiNuevo)) {
                return aName;
            }
        }
        return artiNuevo;
    }

    public static boolean existeArticuloConsulta(Collection<Articulo> listaArticulos, Articulo artiNuevo){

        for (Articulo aName : listaArticulos) {
            if ((artiNuevo.getArticulo().compareToIgnoreCase(aName.getArticulo()))==0){
                return true;

        }
    }
        return false;
    }

    public static int suma(Collection<Articulo> lista) {
        int suma = 0;
        for (Articulo aName : lista) {
            suma = suma + aName.getCantidad();
        }
        return suma;
    }

    public static int calculaPrecio(Collection<Articulo> listaArt,Collection<Articulo>listaPrecio) {
        int precioTotal = 0;
        for (Articulo aName : listaArt) {
            precioTotal = precioTotal + aName.getCantidad() * existeArticulo(listaPrecio,aName).getCantidad();

        }
        return precioTotal;
    }

    public static void actualizaPrecio(Collection<Articulo> lista, Articulo artiNuevo) {
        String artiCantidad = "0";
        Scanner cant = new Scanner(System.in);



        if (!(existeArticuloConsulta(lista,artiNuevo))){

                    System.out.println("su "+ artiNuevo.getArticulo() +" no se encuentra en la lista de precios, indique precio corresponde");
         
                    artiCantidad = cant.nextLine();

                    while (!(isNumeric(artiCantidad))){

                        System.out.println("su "+ artiNuevo.getArticulo() +"no se encuentra en la lista de precios, indique precio corresponde");
                        artiCantidad = cant.nextLine();

                    }
                Articulo articuloYCantidad = new Articulo(artiNuevo.getArticulo(), Integer.parseInt(artiCantidad));
                lista.add(articuloYCantidad);
                }
             }

    public static void validarPrecios(Collection<Articulo> listaArticulo, Collection<Articulo> listaPrecio){

        Iterator it = listaArticulo.iterator();

        while(it.hasNext()){
            Articulo elemento= (Articulo) it.next();

            if (!(existeArticuloConsulta(listaPrecio,elemento))) {
                actualizaPrecio(listaPrecio,elemento);
                //listaPrecio.add(elemento);
            }
        }
    }


}
