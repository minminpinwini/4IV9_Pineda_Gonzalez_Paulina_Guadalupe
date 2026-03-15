/*
Vamos a crear 14 programas dentro de un menu gigante para poner a prueba sus conocimientos de algoritmia 
1- Desarrollar un prgrama para calcular el bono de un descuento por edad
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
            System.out.println("Ingrese su edad");
            int edad = entrada.nextInt();

            float descuento = 0;

            if(edad > 0){

                if(edad >= 60){
                    descuento = 0.30f;
                    System.out.println("Tiene un descuento del 30%");
                }else if (edad >=30){
                    descuento = 0.20f;
                    System.out.println("Tiene un descuento del 20%");
                }else if(edad >= 18){
                    descuento = 0.10f;
                    System.out.println("Tiene un descuento del 10%");

                }else{
                    descuento = 0;
                    System.out.println("No tiene descuento");
                }
            }else{
                System.out.println("Ingrese una edad valida");
            }

        break;
        case 2:
            //convertir un numero decimal a binario
            System.out.println("Ingrese un numero positivo entero que se desee convertir a binario");
            int numbinario;
            String guardarbinario ="";
            numbinario = entrada.nextInt();

            if(numbinario > 0){
                //realizamos el mod 2
                while(numbinario > 0){
                    if(numbinario%2 == 0){
                        guardarbinario = "0" + guardarbinario;

                    }else{
                        guardarbinario = "1" + guardarbinario;

                    }
                    numbinario = (int)numbinario/2;
                }

            }else if(numbinario == 0){
                
                guardarbinario = "0";
            }else{
               //aqui no se puede 
               guardarbinario = "No se puede convertir ese numero, solo acepta positivos";
            }
            System.out.println("El numero convertido a binario es: " + guardarbinario);
        break;
        case 3:
            
        System.out.println("Seleccione el tipo de conversion ");
        System.out.println("1. C => F");
        System.out.println("2. C => K");

        int opcionn = 0;
        opcionn = entrada.nextInt();

        System.out.println("ingrese la temperatura");
        float temperatura = 0;
        temperatura = entrada.nextFloat();

        float resultadoo = 0;
        if(opcionn == 1){
            resultadoo = (temperatura * 9/5) + 32;
        System.out.println("La temperatura en F es: " + resultadoo);

        }else if(opcionn == 2){
            resultadoo = temperatura + 273.15f;
        System.out.println("L temperatura en K es: " + resultadoo);

        }else{
        System.out.println("Opcion Invalida :c");

        }



        break;
        case 4:
        System.out.println("Cuantos numeros desea ingresar");
        int cantidadnumeros = 0;
        cantidadnumeros = entrada.nextInt();

        int positivos = 0;
        int negativos = 0;

        if(cantidadnumeros >0){

        for(int i = 1; i <= cantidadnumeros; i++){
            System.out.println("Ingrese un numero");
            int numero = 0;
            numero = entrada.nextInt();

            if(numero > 0){
                positivos = positivos + 1;
             }else if(numero <0){
                negativos = negativos + 1;

            
             }

        }
        System.out.println("Numeros positivos: " +  positivos);
        System.out.println("Numeros negativos: " + negativos);

    }else{
        System.out.println("Ingrese solo cantidades positivas");
    }

        
        break;
        case 5:
        System.out.println("Bienvenido a esta hermosa tiendita linda y kawaii");
        System.out.println("Por favor ingrese cuantos elementos va a comprar");
        int elementosproducto = 0;
        elementosproducto = entrada.nextInt();
        if( elementosproducto > 0){

            float compra=0;

            for(int i = 1; i<= elementosproducto; i++){
                System.out.println("Ingresa el nombre del producto");
                String nombreproducto="";
                nombreproducto = entrada.next();
                System.out.println("Ingrese el precio");
                float precio=0;
                precio = entrada.nextFloat();
                float resultado;
                System.out.println("Ingrese la cantidad de producto");
                int cantidad=0;
                cantidad = entrada.nextInt();
                resultado = precio * cantidad;
                
                compra = resultado + compra;


            }
            System.out.println("El total de la compra es: " + compra);

        }else{
            System.out.println("ingrese solo cantidades positivas");
        }
        
        break;
        case 6:
        System.out.println("Seleccione la figura");
        System.out.println("1. Cuadrado");
        System.out.println("2. rectangulo"); 
        System.out.println("3. triangulo"); 
        System.out.println("4. Circulo"); 
        System.out.println("5. Pentagono"); 

        int figura = 0;
        figura = entrada.nextInt();

        float area = 0;
        float perimetro = 0;

        if(figura == 1){
            System.out.println("Ingresa el lado");
            float lado = 0;
            lado = entrada.nextFloat();

            area = lado * lado;
            perimetro = lado * 4;

             }else if(figura == 2){

                System.out.println("Ingrese base");
                float base = 0;
                base = entrada.nextFloat();

                System.out.println("Ingrese altura");
                float altura = 0;
                altura = entrada.nextFloat();

                area = base * altura;
                perimetro = 2 + (base + altura);

              }else if (figura == 3){
                System.out.println("ingrese la base ");
                float base = 0;
                base = entrada.nextFloat();

                System.out.println("Ingrese altura");
                float altura = 0;
                altura = entrada.nextFloat();

                System.out.println("Ingresa lado 2 ");
                float lado2 = 0;
                lado2 = entrada.nextInt();

                System.out.println("Ingresa lado 3");
                float lado3 = 0;
                lado3 = entrada.nextFloat();

                area = (base * altura) /2;
                perimetro = base + lado2 + lado3;
            }else if (figura == 4){

                System.out.println("Ingrese el radio");
                float radio = 0;
                radio = entrada.nextFloat();

                area = 3.1416f * radio * radio;
                perimetro = 2 * 3.1416f * radio;

            }else if (figura == 5) {
                System.out.println("Ingrese el lado");
                float lado = 0;
                lado = entrada.nextFloat();

                System.out.println("Ingrese el apotema");
                float apotema = 0;
                apotema = entrada.nextFloat();

                perimetro = lado * 5;
                area = (perimetro * apotema) / 2;
            }
            System.out.println("el area es:" + area);
            System.out.println("el perimetro es: " + perimetro);

        

 
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
          


        }
        System.out.println("Deseas repetir el programa escribe s o S para si");
        letrapararepetir = entrada.next().charAt(0);  
        }while(letrapararepetir != 's' || letrapararepetir == 'S');    



    }
}