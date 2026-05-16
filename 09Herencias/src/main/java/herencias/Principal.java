
package herencias;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);

        Estudiante[] estudiantes = new Estudiante[10];

        int contador = 0;
        int opcion;

        do {

            System.out.println("\n===== CRUD ESTUDIANTES =====");
            System.out.println("1. Registrar");
            System.out.println("2. Editar");
            System.out.println("3. Eliminar");
            System.out.println("4. Buscar");
            System.out.println("5. Mostrar");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");

            opcion = entrada.nextInt();

            switch(opcion){

                case 1:

                    System.out.print("ID: ");
                    int id = entrada.nextInt();

                    entrada.nextLine();

                    System.out.print("Nombre: ");
                    String nombre = entrada.nextLine();

                    System.out.print("Edad: ");
                    int edad = entrada.nextInt();

                    estudiantes[contador] = new Estudiante(id, nombre, edad);

                    contador++;

                    System.out.println("Estudiante registrado");

                    break;

                case 2:

                    System.out.print("ID a editar: ");
                    int idEditar = entrada.nextInt();

                    for(int i = 0; i < contador; i++){

                        if(estudiantes[i] != null &&
                           estudiantes[i].getId() == idEditar){

                            entrada.nextLine();

                            System.out.print("Nuevo nombre: ");
                            estudiantes[i].setNombre(entrada.nextLine());

                            System.out.print("Nueva edad: ");
                            estudiantes[i].setEdad(entrada.nextInt());

                            System.out.println("Estudiante editado");
                        }
                    }

                    break;

                case 3:

                    System.out.print("ID a eliminar: ");
                    int idEliminar = entrada.nextInt();

                    for(int i = 0; i < contador; i++){

                        if(estudiantes[i] != null &&
                           estudiantes[i].getId() == idEliminar){

                            estudiantes[i] = null;

                            System.out.println("Estudiante eliminado");
                        }
                    }

                    break;

                case 4:

                    System.out.print("ID a buscar: ");
                    int idBuscar = entrada.nextInt();

                    boolean encontrado = false;

                    for(int i = 0; i < contador; i++){

                        if(estudiantes[i] != null){

                            int idGuardado = estudiantes[i].getId();

                            if(idGuardado == idBuscar){

                                System.out.println("\nESTUDIANTE ENCONTRADO");
                                System.out.println("ID: " + estudiantes[i].getId());
                                System.out.println("Nombre: " + estudiantes[i].getNombre());
                                System.out.println("Edad: " + estudiantes[i].getEdad());

                                encontrado = true;
                            }
                        }
                    }

                    if(encontrado == false){

                        System.out.println("No encontrado");
                    }

                    break;

                case 5:

                    System.out.println("\n===== ESTUDIANTES =====");

                    for(int i = 0; i < contador; i++){

                        if(estudiantes[i] != null){

                            System.out.println("ID: " + estudiantes[i].getId());
                            System.out.println("Nombre: " + estudiantes[i].getNombre());
                            System.out.println("Edad: " + estudiantes[i].getEdad());
                            System.out.println("----------------");
                        }
                    }

                    break;

                case 6:

                    System.out.println("Fin del programa");
                    break;

                default:

                    System.out.println("Opcion invalida");
            }

        } while(opcion != 6);
    }
}