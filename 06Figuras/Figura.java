public abstract class Figura {

    double area;
    double perimetro;

    public abstract void calcularArea();
    public abstract void calcularPerimetro();

    public void mostrarDatos(){
        System.out.println("Area: " + area);
        System.out.println("Perimetro: " + perimetro);
    }
}
