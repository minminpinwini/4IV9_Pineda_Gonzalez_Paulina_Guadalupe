/*
Vamos a crear 14 programas dentro de un menu gigante para poner a prueba sus conocimientos de algoritmia 
1- Desarrollar un prgrama para calcular el boo de un descuento por edad
2- Convertir numeros de decimales a binarios 
3-Convertir temperaturas entre los principales grados c -> F y K 
4- Realizar un nuevo programa para contar numeros de positivos a negativos de una serie de numeros
5- Desarrollar una tiendita para agregar productos y precios 
6- Desarrollar un programa para calcular el area y perimetro de 5 diferentes figuras 
7- Desarrollar una tabla
8- Desarrollar un proograma para calcular un factorial con recursividad
9- Vamos a hacer dinujitos 
10- Desarrolar una figura hueca
11- Realizar algunos patrones 
12- Realizar un diamante
13- Desarrollar una calculadora basica suma, resta, multiplicacion, divicion 
*/

import java.util.Scanner;

public class EstructuraDeDatos{
    public static void main(String[] args) {
        
    
    //aqui van las variables
    int opcion;
    char letrapararepetir;

    //aqui van los objetos
    Scanner entrada = new Scanner(System.in);

    //aqui va el menu 
    do{

    System.out.println("Bienvenido a aeste programa para ver cuanto saben programar a partir de algoritmos ");

    System.out.println("1- Desarrollar un prgrama para calcular el boo de un descuento por edad");
    System.out.println("2- Convertir numeros de decimales a binarios ");
    System.out.println("3-Convertir temperaturas entre los principales grados c -> F y K ");
    System.out.println("4- Realizar un nuevo programa para contar numeros de positivos a negativos de una serie de numeros");
    System.out.println("5- Desarrollar una tiendita para agregar productos y precios ");
    System.out.println("6- Desarrollar un programa para calcular el area y perimetro de 5 diferentes figuras");
    System.out.println("7- Desarrollar una tabla");
    System.out.println("8- Desarrollar un proograma para calcular un factorial con recursividad");
    System.out.println("9- Vamos a hacer dinujitos ");
    System.out.println("10- Desarrolar una figura hueca");
    System.out.println("11- Realizar algunos patrones ");
    System.out.println("12- Realizar un diamante");
    System.out.println("13- Desarrollar una calculadora basica suma, resta, multiplicacion, divicion ");

    System.out.println("14-. Salir");

    //Entrada de datos

    opcion = entrada.nextInt();


    //Ahora tengo que evaluar entrada
    switch (opcion) {
        case 1:
            
        break;
        case 2:
            // Convertir decimal a binario
         System.out.println("Ingrese un numero decimal positivo que desee convertir a binario");
            int numbinario;
            String guardarbinario = "";
            numbinario = entrada.nextInt();

        if (numbinario > 0) {
        while (numbinario > 0) {

        if (numbinario % 2 == 0) {
            guardarbinario = "0" + guardarbinario;
         } else {
         guardarbinario = "1" + guardarbinario;
         }

         numbinario = numbinario / 2;
        }

        } else if (numbinario == 0) {
         guardarbinario = "0";

        } else {

        guardarbinario = "No se puede convertir ese numero, solo se aceptan positivos";

         }

         System.out.println("El numero en binario es: " + guardarbinario);
        break;
        case 3:
            
        break;
        case 4:
        
        break;
        case 5:
            System.out.println("Buenvenido a esta hermosa tiendita linada y kawaii");
            System.out.println("Por faavor ingrese cuantos elementos va a comprar");
            int elementosproducto = 0;

            elementosproducto = entrada.nextInt();
            if( elementosproducto > 0){

                float compra=0;

                for (int i = 1; i<=
                elementosproducto; i++
                ){
                    System.out.println("Ingresa el nombre del producto");
                    String nombreproducto;
                    nombreproducto = entrada.next();

                    System.out.println("Ingrese el precio");
                    float precio=0;
                    precio = entrada.nextFloat();
                    float resultado;

                    System.out.println("Ingrese el cantidad");
                    int cantidad=0;
                    precio = entrada.nextInt();
                    
                    resultado = precio * cantidad;
                    
                    compra = resultado + compra;
                    
                    
                }
                System.out.println("El total de  la compra es: " + compra);

            }else {
                System.out.println("Ingrese solo valores positivos");
            }
            
        break;
        case 6:
            
        break;
        case 7:
            
        break;
        case 8:
            
        break;
        case 9:
            
        break;
        case 10:
            
        break;
        case 11:
            
        break;
        case 12:
            
        break;
        case 13:
            
        break;
        
        default:
            throw new AssertionError();


        }
        System.out.println("Deseas repetir el programa, escribe S o s para si ");
        letrapararepetir = entrada.next().charAt(0);
    }while(letrapararepetir != 's' || letrapararepetir == 'S');


    }
}