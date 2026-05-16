public class Cuadrado extends Figura {

    double lado;

    public Cuadrado(double lado){
        this.lado = lado;
    }

    public void calcularArea(){
        area = lado * lado;
    }

    public void calcularPerimetro(){
        perimetro = 4 * lado;
    }
}
