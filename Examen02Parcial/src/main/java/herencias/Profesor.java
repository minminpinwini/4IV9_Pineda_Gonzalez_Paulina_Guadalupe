package herencias;

import java.io.Serializable;

public class Profesor implements Serializable {

    private int id;
    private String nombre;
    private String materia;

    public Profesor() {
    }

    public Profesor(int id, String nombre, String materia) {
        this.id = id;
        this.nombre = nombre;
        this.materia = materia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return "ID: " + id +
               "\nNombre: " + nombre +
               "\nMateria: " + materia;
    }
}