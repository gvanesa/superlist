package com.tokenitos.superlist;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class Archivo {




    public static void manejoPersistencia(File archivo,Collection<Articulo> ListaArticulo) throws IOException {
        if (existeArchivo(archivo)) {
            if (sobreEscribeOUsa(archivo,'s')){
                escribir(archivo, ListaArticulo);
            }
        }else{
            escribir(archivo, ListaArticulo);

        }

    }

   /* public static void escribir(File archivo, Collection<Articulo> ListaArticulo) throws IOException {  BufferedWriter bw;

            bw = new BufferedWriter(new FileWriter(archivo));
            for (Articulo p:ListaArticulo) {

                bw.write(String.valueOf(p.toPrint()));
            }
            bw.close();
    }*/

    public static void escribir(File archivo, Collection<Articulo> ListaArticulo) throws IOException {  BufferedWriter bw;

        Gson gson = new Gson();
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();


        bw = new BufferedWriter(new FileWriter(archivo));

        final String representacionBonita = prettyGson.toJson(ListaArticulo);

        bw.write(representacionBonita);
        bw.close();
    }

   /* public static Collection<Articulo> leerEImprimir(File archivo) throws IOException {

        Collection<Articulo> lista = new ArrayList<>();



        String[] textoSplit;
        String[] textoSplit2;
        BufferedReader br = null;

            //Crear un objeto BufferedReader al que se le pasa
            //   un objeto FileReader con el nombre del fichero
            br = new BufferedReader(new FileReader(archivo));
            //Leer la primera línea, guardando en un String
            String texto = br.readLine();

            //Repetir mientras no se llegue al final del fichero
        while (texto != null) {

                textoSplit2 = texto.split(";");
                //textoSplit2 = textoSplit[1].split("<cantidad>");

                Articulo artGuardado = new Articulo(textoSplit2[0],Integer.parseInt(textoSplit2[1]));

                lista.add(artGuardado);

                texto = br.readLine();
            }
            return lista;


    }*/

    public static Collection<Articulo> leerEImprimir(File archivo) throws IOException {

        Gson gson = new Gson();
        BufferedReader br = null;
        br = new BufferedReader(new FileReader(archivo));

        String texto = "";
        String fichero = "";


        while ((texto=br.readLine())!= null) {


            fichero += texto;

        }


        final Type tipoListaDePrecios = new TypeToken<Collection<Articulo>>(){}.getType();
        final Collection<Articulo> preciosasdas = gson.fromJson(fichero, tipoListaDePrecios);


      //  Collection<Articulo> lista = new ArrayList<>();


        return preciosasdas;






    }

   /* public static void escribirOld(File archivo, Collection<Articulo> listaArticulo) throws IOException {  BufferedWriter bw;
        if (archivo.exists()) {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("El fichero de texto ya estaba creado.");
        } else {
            bw = new BufferedWriter(new FileWriter(archivo));
            bw.write("Acabo de crear el fichero de texto.");
        }
        bw.close();
    }*/


      public static Collection<Articulo> inicializar(File archivo) throws IOException {

        Collection<Articulo> list = new ArrayList<>();

        if (existeArchivo(archivo))
        {
            if (sobreEscribeOUsa(archivo,'u')){
                list=leerEImprimir(archivo);
            }
        }
        return list;
    }

    public static boolean existeArchivo(File archivo)  {
        //Scanner sobre = new Scanner(System.in);
       return archivo.exists();
    }



    public static boolean sobreEscribeOUsa(File archivo,char opcion)  {
        Scanner sobre = new Scanner(System.in);

        if (opcion == 'u') {
            System.out.println("Existe " + archivo + " quiere continuar con la lista? (si/no)");
        }else {
            System.out.println("Existe " + archivo + " quiere sobreescribirlo? (si/no)");
        }
        String sobreRta = sobre.nextLine();

        while (!(("si".equalsIgnoreCase(sobreRta))|| ("no".equalsIgnoreCase(sobreRta)))) {
            if (opcion == 'u') {
                System.out.println("Existe " + archivo + " quiere continuar con la lista? (si/no)");
            }else {
                System.out.println("Existe " + archivo + " quiere sobreescribirlo? (si/no)");
            }
            sobreRta = sobre.nextLine();
        }

        return "si".equalsIgnoreCase(sobreRta);
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
