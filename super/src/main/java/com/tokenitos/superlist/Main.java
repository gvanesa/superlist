package com.tokenitos.superlist;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

import static com.tokenitos.superlist.Archivo.*;
import static com.tokenitos.superlist.Listas.*;
import static com.tokenitos.superlist.Validaciones.isNumeric;
import static com.tokenitos.superlist.Validaciones.validarVacio;

public class Main {

    static final String RUTA_PRECIO = "precio.json";
    static final String RUTA_LISTA = "articulos.json";
    static File archivoPrecios = new File(RUTA_PRECIO);
    static File archivoArticulos = new File(RUTA_LISTA);
    static Collection<Articulo> listaPrecios = new ArrayList<>();
    static Collection<Articulo> listaArticulos = new ArrayList<>();



    public static void main(String[] args) throws IOException {

        System.out.println("-------------------------Bienvenido a superlist!-------------------------");

        listaPrecios=leerArchivo(archivoPrecios);
       // listaPrecio=leerEImprimir(archivoPrecio);

         menu();
    }


    public static void menu() throws IOException {

        Collection<Articulo> listaArticulos = new ArrayList<>();

        listaArticulos.addAll(inicializar(archivoArticulos));


        Articulo articuloYCantidad = null;
        Scanner leerArticulo = new Scanner(System.in);
        Scanner leerCantidad = new Scanner(System.in);
        String articuloCantidad;
        String articuloNombre;
        Scanner leerRespuesta = new Scanner(System.in);
        String respuesta;


        System.out.println("¿Qué deseas comprar?");
        articuloNombre = leerArticulo.nextLine();

        while (validarVacio(articuloNombre)){

            System.out.println("Por favor ingrese un articulo");
            articuloNombre = leerArticulo.nextLine();

        }

        while(!"finalizar".equalsIgnoreCase(articuloNombre)) {

            System.out.println("¿Qué Cantidad?");
            articuloCantidad = leerCantidad.nextLine();

            while (!(isNumeric(articuloCantidad))){

                System.out.println("Por favor repita la cantidad, está debe ser numerica");
                articuloCantidad = leerCantidad.nextLine();

            }

            articuloYCantidad = new Articulo(articuloNombre,Integer.parseInt(articuloCantidad));
            actualizaPrecio(listaPrecios,articuloYCantidad);

            if (!(existeArticuloActualiza(listaArticulos,articuloYCantidad))) {
                listaArticulos.add(articuloYCantidad);
            }
                System.out.println("¿Qué deseas comprar?");
                articuloNombre = leerArticulo.nextLine();

                while (validarVacio(articuloNombre)){

                    System.out.println("Por favor ingrese un articulo");
                    articuloNombre = leerArticulo.nextLine();

                }

        }
        validarPrecios(listaArticulos,listaPrecios);

        System.out.println("Desea guardar la lista? (si/no)");
        respuesta = leerRespuesta.nextLine();

        while (!(("si".equalsIgnoreCase(respuesta))|| ("no".equalsIgnoreCase(respuesta)))) {
            System.out.println("Desea guardar la lista? (si/no)");
            respuesta = leerRespuesta.nextLine();
        }
        if ("si".equalsIgnoreCase(respuesta)) {
            manejoPersistencia(archivoArticulos,listaArticulos);
        }
        validarPrecios(listaArticulos,listaPrecios);


        manejoPersistencia(archivoPrecios,listaPrecios);



        System.out.println('\t'+"La lista completa de sus productos es:");
        listaArticulos.stream().forEach(System.out::println);

        System.out.println('\n'+"La cantidad de articulos distintos es: "+ listaArticulos.size());
        System.out.println('\n'+"La suma de articulos distintos es: "+ suma(listaArticulos));

        //validarPrecios(listaArticulo,listaPrecio);
        System.out.println('\n'+"El monto total de los articulos es: "+ calculaPrecio(listaArticulos,listaPrecios));

    }

}
