package com.tokenitos.superlist;
import java.io.IOException;
import java.util.*;

import static com.tokenitos.superlist.Archivo.manejoPersistencia;

public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here
        System.out.println("Bienvenido a superlist!");
	    menu();
    }

    public static void menu() throws IOException {

        Collection<Articulo> ListaArticulo = new ArrayList<>();
        Articulo articuloYPrecio = null;
        Scanner arti = new Scanner(System.in);
        Scanner cant = new Scanner(System.in);
        String artiCantidad;
        String artiNombre;


        System.out.println("¿Qué deseas comprar?");
        artiNombre = arti.nextLine();

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

        }
        System.out.println("Desea guardar la lista?");
        artiNombre = arti.nextLine();

        if("si".equalsIgnoreCase(artiNombre)) {

            manejoPersistencia(ListaArticulo);

            }
        System.out.println("La lista completa de sus productos es:");
        ListaArticulo.stream().forEach(System.out::println);



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


}
