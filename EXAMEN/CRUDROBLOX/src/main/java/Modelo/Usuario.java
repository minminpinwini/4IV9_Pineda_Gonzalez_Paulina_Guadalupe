package Modelo;

public class Usuario extends Producto {

    private int     nivel;
    private String  pais;
    private boolean premium;
    private int     horasJugadas;

    public Usuario() { super(); }

    public Usuario(int id, String nombre, int nivel, String pais,
                   boolean premium, int horasJugadas) {
        super(id, nombre);
        this.nivel        = nivel;
        this.pais         = pais;
        this.premium      = premium;
        this.horasJugadas = horasJugadas;
    }

    public int     getNivel()                  { return nivel; }
    public void    setNivel(int nivel)         { this.nivel = nivel; }

    public String  getPais()                   { return pais; }
    public void    setPais(String pais)        { this.pais = pais; }

    public boolean isPremium()                 { return premium; }
    public void    setPremium(boolean premium) { this.premium = premium; }

    public int     getHorasJugadas()           { return horasJugadas; }
    public void    setHorasJugadas(int h)      { this.horasJugadas = h; }
}