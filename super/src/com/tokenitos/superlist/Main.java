package com.tokenitos.superlist;
import java.io.File;
import java.io.IOException;
import java.util.*;

import static com.tokenitos.superlist.Archivo.*;
import static java.util.stream.Collectors.toMap;

public class Main {

    public static void main(String[] args) throws IOException {

        System.out.println("Bienvenido a superlist!");
	    menu();
    }

    public static void menu() throws IOException {

        Collection<Articulo> ListaArticulo = new ArrayList<>();

        ListaArticulo.addAll(inicializar());


        Articulo articuloYPrecio = null;
        Scanner arti = new Scanner(System.in);
        Scanner cant = new Scanner(System.in);
        String artiCantidad;
        String artiNombre;


        System.out.println("¿Qué deseas comprar?");
        artiNombre = arti.nextLine();

        while (validarVacio(artiNombre)){

            System.out.println("Por favor infrese un articulo");
            artiNombre = arti.nextLine();

        }

        while(!"finalizar".equalsIgnoreCase(artiNombre)) {

            System.out.println("¿Qué Cantidad?");
            artiCantidad = cant.nextLine();

            while (!(isNumeric(artiCantidad))){

                System.out.println("Por favor repita la cantidad, está debe ser numerica");
                artiCantidad = cant.nextLine();

            }

            articuloYPrecio = new Articulo(artiNombre,Integer.parseInt(artiCantidad));

            if (!(existeArticulo(ListaArticulo,articuloYPrecio))) {
                ListaArticulo.add(articuloYPrecio);
            }
                System.out.println("¿Qué deseas comprar?");
                artiNombre = cant.nextLine();

                while (validarVacio(artiNombre)){

                    System.out.println("Por favor infrese un articulo");
                    artiNombre = arti.nextLine();

                }

        }
        System.out.println("Desea guardar la lista? (si/no)");
        artiNombre = arti.nextLine();

        while (!(("si".equalsIgnoreCase(artiNombre))|| ("no".equalsIgnoreCase(artiNombre)))) {
            System.out.println("Desea guardar la lista? (si/no)");
            artiNombre = arti.nextLine();
        }
        if ("si".equalsIgnoreCase(artiNombre)) {
            manejoPersistencia(ListaArticulo);
        }

        System.out.println("La lista completa de sus productos es:");
        ListaArticulo.stream().forEach(System.out::println);

        System.out.println('\n'+"La cantidad de articulos es: "+ ListaArticulo.size());




    }




    public static boolean existeArticulo(Collection<Articulo> ListaArticulos, Articulo artiNuevo){

        for (Articulo aName : ListaArticulos) {
            //  if ((artiNuevo.getArticulo().compareToIgnoreCase(aName.getArticulo()))==0){
            if (aName.equals(artiNuevo)) {
                aName.setCantidad(artiNuevo.getCantidad());
                return true;
            }
        }
        return false;
    }


    private static boolean isNumeric(String cadena){
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe){
            return false;
        }
    }

    public static boolean validarVacio(String cadena){
        return cadena.trim().isEmpty();
    }


}
