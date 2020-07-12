package com.tokenitos.superlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.tokenitos.superlist.Validaciones.isNumeric;
import static com.tokenitos.superlist.Validaciones.validarVacio;


public class ValidacionesTest {


    @Test
    @DisplayName("Test successful parse string to int conversion")
    void inNumericTest() {
        String cadena = "123";
        Assertions.assertTrue(isNumeric(cadena));

    }

    @Test
    @DisplayName("Test successful validar vacio")
    void validarVacioTest() {
        String cadena = "";
        Assertions.assertTrue(validarVacio(cadena));

    }
   /* @Test
    void testConvertToDecimalSuccess() {
        double result = MathTools.convertToDecimal(3, 4);
        Assertions.assertEquals(0.75, result);
    }

    @Test
    void testConvertToDecimalInvalidDenominator() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> MathTools.convertToDecimal(3, 0));
    }*/
}