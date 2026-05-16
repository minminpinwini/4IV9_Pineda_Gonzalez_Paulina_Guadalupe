package herencias;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.*;

public class Principal {

    static Scanner entrada = new Scanner(System.in);

    static ArrayList<Estudiante> estudiantes = new ArrayList<>();
    static ArrayList<Profesor> profesores = new ArrayList<>();

    public static void main(String[] args) {

        cargarDatos();

        int op;

        do {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Estudiantes");
            System.out.println("2. Profesores");
            System.out.println("3. Salir");
            System.out.print("Opcion: ");
            op = entrada.nextInt();

            switch(op) {

                case 1:
                    menuEstudiantes();
                    break;

                case 2:
                    menuProfesores();
                    break;

                case 3:
                    guardarDatos();
                    System.out.println("Programa terminado :D");
                    break;

                default:
                    System.out.println("Opcion invalida :c");
            }

        } while(op != 3);
    }

    //estudiantes

    public static void menuEstudiantes() {

        int op;

        do {
            System.out.println("\n===== CRUD ESTUDIANTES =====");
            System.out.println("1. Registrar");
            System.out.println("2. Editar");
            System.out.println("3. Eliminar");
            System.out.println("4. Mostrar");
            System.out.println("5. Regresar");
            System.out.print("Opcion: ");
            op = entrada.nextInt();

            switch(op) {

                case 1:

                    System.out.print("ID: ");
                    int id = entrada.nextInt();
                    entrada.nextLine();

                    for(Estudiante e : estudiantes){
                        if(e.getId() == id){
                            System.out.println("Error: ID ya existe :c");
                            break;
                        }
                    }

                    System.out.print("Nombre: ");
                    String nombre = entrada.nextLine();

                    if(nombre.trim().isEmpty()){
                        System.out.println("Error: nombre vacio :c");
                        break;
                    }

                    System.out.print("Edad: ");
                    int edad = entrada.nextInt();

                    if(edad <= 0){
                        System.out.println("Error: edad invalida :c");
                        break;
                    }

                    estudiantes.add(new Estudiante(id, nombre, edad));
                    guardarDatos();

                    System.out.println("Estudiante registrado :D");
                    break;

                case 2:

                    System.out.print("ID a editar: ");
                    int idE = entrada.nextInt();
                    entrada.nextLine();

                    boolean encontradoE = false;

                    for(Estudiante e : estudiantes){

                        if(e.getId() == idE){

                            System.out.print("Nuevo nombre: ");
                            String nuevoNombre = entrada.nextLine();

                            if(nuevoNombre.trim().isEmpty()){
                                System.out.println("Nombre vacio :c");
                                break;
                            }

                            System.out.print("Nueva edad: ");
                            int nuevaEdad = entrada.nextInt();

                            if(nuevaEdad <= 0){
                                System.out.println("Edad invalida :c");
                                break;
                            }

                            e.setNombre(nuevoNombre);
                            e.setEdad(nuevaEdad);

                            guardarDatos();

                            System.out.println("Editado correctamente :D");
                            encontradoE = true;
                            break;
                        }
                    }

                    if(!encontradoE){
                        System.out.println("No existe el estudiante :c");
                    }

                    break;

                case 3:

                    System.out.print("ID a eliminar: ");
                    int idDel = entrada.nextInt();

                    boolean eliminado = estudiantes.removeIf(e -> e.getId() == idDel);

                    if(eliminado){
                        guardarDatos();
                        System.out.println("Eliminado correctamente :D");
                    } else {
                        System.out.println("No existe :c");
                    }

                    break;

                case 4:

                    for(Estudiante e : estudiantes){
                        System.out.println(e);
                        System.out.println("---------------");
                    }

                    break;
            }

        } while(op != 5);
    }

    // rpofesores

    public static void menuProfesores() {

        int op;

        do {
            System.out.println("\n===== CRUD PROFESORES =====");
            System.out.println("1. Registrar");
            System.out.println("2. Editar");
            System.out.println("3. Eliminar");
            System.out.println("4. Mostrar");
            System.out.println("5. Regresar");
            System.out.print("Opcion: ");
            op = entrada.nextInt();

            switch(op) {

                case 1:

                    System.out.print("ID: ");
                    int id = entrada.nextInt();
                    entrada.nextLine();

                    for(Profesor p : profesores){
                        if(p.getId() == id){
                            System.out.println("ID ya existe :c");
                            break;
                        }
                    }

                    System.out.print("Nombre: ");
                    String nombre = entrada.nextLine();

                    if(nombre.trim().isEmpty()){
                        System.out.println("Nombre vacio :c");
                        break;
                    }

                    System.out.print("Materia: ");
                    String materia = entrada.nextLine();

                    if(materia.trim().isEmpty()){
                        System.out.println("Materia vacia :c");
                        break;
                    }

                    profesores.add(new Profesor(id, nombre, materia));
                    guardarDatos();

                    System.out.println("Profesor registrado :D");
                    break;

                case 2:

                    System.out.print("ID a editar: ");
                    int idE = entrada.nextInt();
                    entrada.nextLine();

                    boolean encontradoP = false;

                    for(Profesor p : profesores){

                        if(p.getId() == idE){

                            System.out.print("Nuevo nombre: ");
                            String nuevoNombre = entrada.nextLine();

                            if(nuevoNombre.trim().isEmpty()){
                                System.out.println("Nombre vacio :c");
                                break;
                            }

                            System.out.print("Nueva materia: ");
                            String nuevaMateria = entrada.nextLine();

                            if(nuevaMateria.trim().isEmpty()){
                                System.out.println("Materia vacia :c");
                                break;
                            }

                            p.setNombre(nuevoNombre);
                            p.setMateria(nuevaMateria);

                            guardarDatos();

                            System.out.println("Editado correctamente :D");
                            encontradoP = true;
                            break;
                        }
                    }

                    if(!encontradoP){
                        System.out.println("No existe profesor :c");
                    }

                    break;

                case 3:

                    System.out.print("ID a eliminar: ");
                    int idDel = entrada.nextInt();

                    boolean eliminadoP = profesores.removeIf(p -> p.getId() == idDel);

                    if(eliminadoP){
                        guardarDatos();
                        System.out.println("Eliminado :D");
                    } else {
                        System.out.println("No existe :c");
                    }

                    break;

                case 4:

                    for(Profesor p : profesores){
                        System.out.println(p);
                        System.out.println("---------------");
                    }

                    break;
            }

        } while(op != 5);
    }

    
    
    

    public static void guardarDatos() {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(
                    new FileOutputStream("datos.dat")
            );

            oos.writeObject(estudiantes);
            oos.writeObject(profesores);

            oos.close();

            System.out.println("Datos guardados :D");

        } catch(Exception e) {
            System.out.println("No se pudo guardar :c");
        }
    }

    public static void cargarDatos() {

        try {
            ObjectInputStream ois = new ObjectInputStream(
                    new FileInputStream("datos.dat")
            );

            estudiantes = (ArrayList<Estudiante>) ois.readObject();
            profesores = (ArrayList<Profesor>) ois.readObject();

            ois.close();

            System.out.println("Datos cargados :D");

        } catch(Exception e) {
            System.out.println("No hay datos previos :c");
            estudiantes = new ArrayList<>();
            profesores = new ArrayList<>();
        }
    }
}