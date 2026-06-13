package Modelo;

public class Accesorio extends Producto {

    private int    usuarioId;
    private String rareza;
    private String color;
    private String tipo;
    private double precio;

    public Accesorio() { super(); }

    public Accesorio(int id, int usuarioId, String nombre,
                     String rareza, String color, String tipo, double precio) {
        super(id, nombre);
        this.usuarioId = usuarioId;
        this.rareza    = rareza;
        this.color     = color;
        this.tipo      = tipo;
        this.precio    = precio;
    }

    public int    getUsuarioId()              { return usuarioId; }
    public void   setUsuarioId(int u)         { this.usuarioId = u; }

    public String getRareza()                 { return rareza; }
    public void   setRareza(String r)         { this.rareza = r; }

    public String getColor()                  { return color; }
    public void   setColor(String c)          { this.color = c; }

    public String getTipo()                   { return tipo; }
    public void   setTipo(String t)           { this.tipo = t; }

    public double getPrecio()                 { return precio; }
    public void   setPrecio(double p)         { this.precio = p; }
}