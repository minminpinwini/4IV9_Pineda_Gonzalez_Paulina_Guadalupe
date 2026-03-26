/*Menú con 3 opciones:

1.Datos del cliente
Pedir:
-Nombre
-Apellido paterno
-Apellido materno
-Fecha de nacimiento
-Dirección

2.Mostrar tipos de piso
-Porcelanato  $22.35 m²
-Marmoleado  $34.27 m²
-Acrílico  $22.94 m²

3.Cálculo de compra
-Pedir número de cuartos (entre 1 y 5)
-Pedir largo y ancho de cada cuarto
-Elegir tipo de piso
-Calcular costo por cuarto
-Mostrar total general + datos del cliente


-Aplicar IVA 16%
-Preguntar si compra:
-Si = aplicar descuento 7.95%
-No = cancelar compra


 */


import java.util.Scanner;

public class Examen {
    public static void main(String[] args) {
        Scanner datos = new Scanner(System.in);

        //Datos del cliente
        String nombre = "";
        String apellidoPaterno = "";
        String apellidoMaterno = "";
        String fechaNacimiento = "";
        String direccionRecidencial = "";

        System.out.println("~Programa para calculo  del costo de piso~");

        //menuuuuuuuu

        while (true) {
             System.out.println("\n\n|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
             System.out.println("|             MENUUU :3            |");
             System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
             System.out.println("|1-Ingresar datos del cliente      |");
             System.out.println("|2-Tipos de piso y precio          |");
             System.out.println("|3-Calcular el total de compra     |");
             System.out.println("|4.Salir                           |");
             System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");

             System.out.print("elige una opcion: ");
             int opcion = datos.nextInt();
                datos.nextLine(); 

                switch (opcion){
                    case 1:
                    System.out.println(" \nOpcion 1: Datos del comprador");

                    System.out.print("Nombre: ");
                    nombre = datos.nextLine();

                    System.out.print("Apellido paterno: ");
                    apellidoPaterno = datos.nextLine();

                    System.out.print("Apellido materno: ");
                    apellidoMaterno = datos.nextLine();

                    System.out.print("Fecha de nacimiento (DD/MM/AAAA):");
                    fechaNacimiento = datos.nextLine();

                    System.out.print("Direccion recidencial: ");
                    direccionRecidencial = datos.nextLine();

                    System.out.print("DATOS GUARDADOS :3");

                    break;

                case 2:
                System.out.println("\n|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
                System.out.println("|Opcion 2: Tipos de piso y precios |");
                System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");
                System.out.println("|1-Porcelanato------------$22.35 m²|");
                System.out.println("|2-Acrilico---------------$22.94 m²|");
                System.out.println("|3-Marmoleado-------------$34.27 m²|");
                System.out.println("|~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~|");

                break;

                case 3:
                    if (nombre.equals("")) {
                        System.out.println("Primero ingrese los datos del cliente (Opcion 1)");

                        break;

                    }
                int numCuartos;
                do {
                    System.out.println("Cuntos cuartos tiene el lugar' (ingrese cantidad entre 1 - 5: ");
                    numCuartos = datos.nextInt();

                    
                    } while (numCuartos < 1 || numCuartos > 5);

                    double totalBase = 0;

                    for (int i = 1; i<= numCuartos; i++) {
                        System.out.println("\n~~~~~~~~~ Cuarto " + i + "~~~~~~~~~");

                        System.out.print("Largo del cuarto en metros: ");
                        double largo = datos.nextDouble();

                        System.out.print("Ancho del cuarto en metros: ");
                        double ancho = datos.nextDouble();

                        System.out.println("Tipo de piso: 1-Porcelanato 2-Acrilico 3-Marmoleado:");
                        int tipoPiso = datos.nextInt();

                        double precio = 0;
                        String nombreTipo = "";

                        if(tipoPiso == 1) {
                            precio = 22.35;
                            nombreTipo = "Porcelanato";

                        }else if (tipoPiso == 2){
                            precio = 22.94;
                            nombreTipo = "Acrilico";

                        }else {
                            precio = 34.27;
                            nombreTipo = "Marmoleado";
                        }

                        double area = largo * ancho;
                        double costo = area * precio;
                        totalBase += costo;

                        System.out.println("Area: " + area + "m²");
                        System.out.println("Costo del cuarto; $" + costo);


                    }
                    System.out.println("\nTotal sin IVA: $" + totalBase);

                    double iva = totalBase * 0.16;
                    double totalConIva = totalBase + iva;

                    System.out.println("IVA : $" + iva);
                    System.out.println("Desea comprar? (SII/No :c):");
                    datos.nextLine();
                    String respuesta = datos.nextLine();

                    if(respuesta.equalsIgnoreCase("SII")) {
                        double descuento = totalConIva * 0.0795;
                        double totalfinal = totalConIva - descuento;
                        
                        System.out.println("Descuento: $" + descuento);
                        System.out.println("Total a pagar: $" + totalfinal);
                        System.out.println("Gracias por su compra :3");

                        return; 

                    }else {
                        System.out.println("Compra cancelada :c");
                        


                    }
                    break;
                    case 4:
                    System.out.println("Saliendo del programa......Graciassss :3");

                    return;

                    default:
                    System.out.println("Opcion no validaaaa :c");

                      } 
                 }
             }
        }
    
    

