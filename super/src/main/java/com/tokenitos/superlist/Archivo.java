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


    public static void manejoPersistencia(File archivo, Collection<Articulo> ListaArticulo) throws IOException {
        if (existeArchivo(archivo)) {
            if ( "si".equalsIgnoreCase(sobreEscribeOUsa(archivo, 's'))){
           // if (sobreEscribeOUsa(archivo, 's')) {
                escribir(archivo, ListaArticulo);
            }
        } else {
            //escribir(archivo, ListaArticulo);
            if ( "si".equalsIgnoreCase(sobreEscribeOUsa(archivo, 'u'))){
               // if (sobreEscribeOUsa(archivo, 'u')) {
                escribir(archivo, ListaArticulo);
            }

        }

    }


    public static void escribir(File archivo, Collection<Articulo> ListaArticulo) throws IOException {
        BufferedWriter bw;

        Gson gson = new Gson();
        final Gson prettyGson = new GsonBuilder().setPrettyPrinting().create();


        bw = new BufferedWriter(new FileWriter(archivo));

        final String representacionBonita = prettyGson.toJson(ListaArticulo);

        bw.write(representacionBonita);
        bw.close();
    }


    public static Collection<Articulo> leerEImprimir(File archivo) throws IOException {

        Gson gson = new Gson();
        BufferedReader br = null;
        Collection<Articulo> preciosasdas = null;

        if (existeArchivo(archivo)) {


            br = new BufferedReader(new FileReader(archivo));

            String texto = "";
            String fichero = "";


            while ((texto = br.readLine()) != null) {


                fichero += texto;

            }


            final Type tipoListaDePrecios = new TypeToken<Collection<Articulo>>(){}.getType();
            preciosasdas = gson.fromJson(fichero, tipoListaDePrecios);

           /* Class<Articulo[]> articulo = Articulo[].class;
            final Articulo[] articulosBienPresentados = gson.fromJson(fichero,articulo);

            preciosasdas= Arrays.asList(articulosBienPresentados);
*/
        }
        return preciosasdas;

    }


    public static Collection<Articulo> inicializar(File archivo) throws IOException {

        Collection<Articulo> list = new ArrayList<>();

        if (existeArchivo(archivo)) {
            if("si".equalsIgnoreCase(sobreEscribeOUsa(archivo, 'u'))){
           // if (sobreEscribeOUsa(archivo, 'u')) {
                list = leerEImprimir(archivo);
            }
        }
        return list;
    }

    public static boolean existeArchivo(File archivo) {
        //Scanner sobre = new Scanner(System.in);
        return archivo.exists();
    }


    public static String sobreEscribeOUsa(File archivo, char opcion) {
        Scanner sobre = new Scanner(System.in);

       if (opcion == 'u') {
            System.out.println("Existe " + archivo + " quiere continuar con la lista? (si/no)");
        } else {
            System.out.println("Existe " + archivo + " quiere sobreescribirlo? (si/no)");
        }
        String sobreRta = sobre.nextLine();

        while (!(("si".equalsIgnoreCase(sobreRta)) || ("no".equalsIgnoreCase(sobreRta))))
        do {
            if (opcion == 'u') {
                System.out.println("Existe " + archivo + " quiere continuar con la lista? (si/no)");
            } else {
                System.out.println("Existe " + archivo + " quiere sobreescribirlo? (si/no)");
            }
            sobreRta = sobre.nextLine();
        } while (!(("si".equalsIgnoreCase(sobreRta)) || ("no".equalsIgnoreCase(sobreRta))));
        return sobreRta;
    }


}
