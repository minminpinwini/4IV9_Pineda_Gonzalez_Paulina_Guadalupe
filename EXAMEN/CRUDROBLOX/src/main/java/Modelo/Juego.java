package Modelo;

public class Juego extends Producto {

    private String desarrollador;
    private long   visitas;
    private double rating;
    private String genero;

    public Juego() { super(); }

    public Juego(int id, String nombre, String desarrollador,
                 long visitas, double rating, String genero) {
        super(id, nombre);
        this.desarrollador = desarrollador;
        this.visitas       = visitas;
        this.rating        = rating;
        this.genero        = genero;
    }

    public String getDesarrollador()         { return desarrollador; }
    public void   setDesarrollador(String d) { this.desarrollador = d; }

    public long   getVisitas()               { return visitas; }
    public void   setVisitas(long v)         { this.visitas = v; }

    public double getRating()                { return rating; }
    public void   setRating(double r)        { this.rating = r; }

    public String getGenero()                { return genero; }
    public void   setGenero(String g)        { this.genero = g; }
}