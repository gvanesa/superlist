package com.tokenitos.superlist;

import java.io.*;
import java.util.Collection;
import java.util.Scanner;

public class Archivo {



    static String ruta = "superlist.txt";
    static File archivo = new File(ruta);

    public static void manejoPersistencia(Collection<Articulo> ListaArticulo) throws IOException {
        if (existeArchivo(archivo)) {
            if (sobreEscribe(archivo)){
                escribir(archivo, ListaArticulo);
            }
        }else{
            escribir(archivo, ListaArticulo);

        }

    }

    public static void escribir(File archivo, Collection<Articulo> ListaArticulo) throws IOException {  BufferedWriter bw;

            bw = new BufferedWriter(new FileWriter(archivo));
            for (Articulo p:ListaArticulo) {

                bw.write(String.valueOf(p.toPrint()));
            }
            bw.close();
    }

    public static void escribirOld(File archivo, Collection<Articulo> listaArticulo) throws IOException {  BufferedWriter bw;
        if (archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("El fichero de texto ya estaba creado.");
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Acabo de crear el fichero de texto.");
        }
        bw.close();
    }

    public static boolean existeArchivo(File archivo)  {
        Scanner sobre = new Scanner(System.in);
        if (archivo.exists()){
            return true;
        }
            return false;
    }

    public static boolean sobreEscribe(File archivo)  {
        Scanner sobre = new Scanner(System.in);

        System.out.println("Existe "+ archivo +" quiere sobreescribirlo?");

        if("si".equalsIgnoreCase(sobre.nextLine())) {
            System.out.println("OK Sobreecribe");
            return true;
        }
        return false;
    }


//    public static void existeArchivoold(File archivo) throws IOException {
//        Scanner sobre = new Scanner(System.in);
//        BufferedReader br;
//        if (archivo.exists()){
//
//           // br = new BufferedReader(new FileReader(archivo));
//            System.out.println("Existe "+ archivo +" quiere sobreescribirlo?");
//
//            if("si".equalsIgnoreCase(sobre.nextLine())) {
//                System.out.println("OK Sobreecribe");
//                escribir(archivo, listaArticulo);
//
//            }
//
//            }else{
//            System.out.println("No Existe "+ archivo );
//            escribir(archivo, listaArticulo);
//
//        }
//
//    }


}
