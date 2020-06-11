package com.tokenitos.superlist;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import static com.tokenitos.superlist.Archivo.*;
import static com.tokenitos.superlist.Listas.*;

public class Main {

    static final String RUTA_PRECIO = "precio.txt";
    static final String RUTA_LISTA = "superlist.txt";
    static File archivoPrecio = new File(RUTA_PRECIO);
    static File archivoLista = new File(RUTA_LISTA);
    static Collection<Articulo> listaPrecio = new ArrayList<>();
    static Collection<Articulo> listaArticulo = new ArrayList<>();



    public static void main(String[] args) throws IOException {

        System.out.println("-------------------------Bienvenido a superlist!-------------------------");

        listaPrecio=leerPrecios(archivoPrecio);

         menu();
    }


    public static void menu() throws IOException {

        Collection<Articulo> listaArticulo = new ArrayList<>();

        listaArticulo.addAll(inicializar(archivoLista));


        Articulo articuloYCantidad = null;
        Scanner arti = new Scanner(System.in);
        Scanner cant = new Scanner(System.in);
        String artiCantidad;
        String artiNombre;


        System.out.println("¿Qué deseas comprar?");
        artiNombre = arti.nextLine();

        while (validarVacio(artiNombre)){

            System.out.println("Por favor ingrese un articulo");
            artiNombre = arti.nextLine();

        }

        while(!"finalizar".equalsIgnoreCase(artiNombre)) {

            System.out.println("¿Qué Cantidad?");
            artiCantidad = cant.nextLine();

            while (!(isNumeric(artiCantidad))){

                System.out.println("Por favor repita la cantidad, está debe ser numerica");
                artiCantidad = cant.nextLine();

            }

            articuloYCantidad = new Articulo(artiNombre,Integer.parseInt(artiCantidad));
            actualizaPrecio(listaPrecio,articuloYCantidad);

            if (!(Listas.existeArticuloActualiza(listaArticulo,articuloYCantidad))) {
                listaArticulo.add(articuloYCantidad);
            }
                System.out.println("¿Qué deseas comprar?");
                artiNombre = cant.nextLine();

                while (validarVacio(artiNombre)){

                    System.out.println("Por favor ingrese un articulo");
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
            manejoPersistencia(archivoLista,listaArticulo);
        }

        System.out.println('\t'+"La lista completa de sus productos es:");
        listaArticulo.stream().forEach(System.out::println);

        System.out.println('\n'+"La cantidad de articulos distintos es: "+ listaArticulo.size());
        System.out.println('\n'+"La suma de articulos distintos es: "+ suma(listaArticulo));

        validarPrecios(listaArticulo,listaPrecio);
        System.out.println('\n'+"El monto total de los articulos es: "+ calculaPrecio(listaArticulo,listaPrecio));

    }




    static boolean isNumeric(String cadena){
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
