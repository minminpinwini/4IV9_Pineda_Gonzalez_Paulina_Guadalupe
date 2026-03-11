//libreria Scanner 

import java.util.Scanner;

class EntradaTexto {
    public static void main(String[] args) {

        // instanciamos el onjeto
        // Las variables locales
        String nombre;
        int edad;
        // Entrada
        System.out.println("Escribe tu nombre");
        nombre = System.console().readLine();

        System.out.println("Hola " + nombre + "bienvenido a programar muy feo ");

        System.out.println("Escribe tu edad");
        edad = System.console().readLine();

    }

}