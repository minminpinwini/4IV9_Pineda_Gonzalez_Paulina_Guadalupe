package Modelo;

public class Producto {

    private int    id;
    private String nombre;
    private String tipo;
    private double precio;
    private int    stock;

    public Producto() {}

    public Producto(int id, String nombre, String tipo, double precio, int stock) {
        this.id     = id;
        this.nombre = nombre;
        this.tipo   = tipo;
        this.precio = precio;
        this.stock  = stock;
    }

    // Constructor para subclases (Usuario, Juego, Accesorio)
    public Producto(int id, String nombre) {
        this.id     = id;
        this.nombre = nombre;
    }

    public int    getId()                  { return id; }
    public void   setId(int id)            { this.id = id; }

    public String getNombre()              { return nombre; }
    public void   setNombre(String n)      { this.nombre = n; }

    public String getTipo()                { return tipo; }
    public void   setTipo(String tipo)     { this.tipo = tipo; }

    public double getPrecio()              { return precio; }
    public void   setPrecio(double precio) { this.precio = precio; }

    public int    getStock()               { return stock; }
    public void   setStock(int stock)      { this.stock = stock; }
}