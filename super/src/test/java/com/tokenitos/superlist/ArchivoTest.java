package com.tokenitos.superlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.tokenitos.superlist.Archivo.existeArchivo;
import static com.tokenitos.superlist.Archivo.sobreEscribeOUsa;
import static com.tokenitos.superlist.Main.archivoPrecios;




public class ArchivoTest {



    @Test
    @DisplayName("Test successful existe Archivo")
    void existeArchivoTest() {

        Assertions.assertTrue(existeArchivo(archivoPrecios));
    }

    @Test
    @DisplayName("Test successful NO existe Archivo")
    void existeArchivoTestFail() {

        Assertions.assertFalse(existeArchivo(new File("pepe.txt")));
    }


    @Test
    @DisplayName("Test successful NO existe Archivo")
    void sobreEscribeOUsaTestFail() {


       // Assertions.assertFalse(sobreEscribeOUsa(new File("elArchivo.txt"), 'u'));
        System.out.println("si");

        Assertions.assertEquals("si",sobreEscribeOUsa(new File("elArchivo.txt"), 'u'));
    }

}
