package com.tokenitos.superlist;

public class Validaciones {


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
