package com.tokenitos.superlist;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
	// write your code here
        System.out.println("Bienvenido a superlist!");
	    menu();
    }

    public static void menu(){

        Collection<Articulo> ListaArticulo = new ArrayList<>();
        Articulo articuloYPrecio = null;


        Scanner in = new Scanner(System.in);
        Scanner inN = new Scanner(System.in);
        System.out.println("¿Qué deseas comprar?");
        String s = in.nextLine();
        while(!"fin".equals(s)) {
            System.out.println("Cantidad");
            String n = inN.nextLine();
            articuloYPrecio = new Articulo(s,Integer.parseInt(n));
            ListaArticulo.add(articuloYPrecio);
            System.out.println("¿Qué deseas comprar?");
            s = in.nextLine();
        }
        ListaArticulo.stream().forEach(System.out::println);


//        String s;
//        do{
//            System.out.println("¿Qué deseas comprar?");
//
//             s = in.nextLine();
//            System.out.println("Cantidad");
//            Integer n = inN.nextInt();
//        }while(!"fin".equals(s));

        }




    public static void guardarEnLista(Articulo articulo){
        Collection<Articulo> ListaArticulo = new ArrayList<>();
        ListaArticulo.add(articulo);
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
