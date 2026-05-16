public class Hexagono extends Figura {

    double lado;

    public Hexagono(double lado){
        this.lado = lado;
    }

    public void calcularArea(){
        area = (3 * Math.sqrt(3) * lado * lado) / 2;
    }

    public void calcularPerimetro(){
        perimetro = 6 * lado;
    }
}
