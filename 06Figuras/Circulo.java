public class Circulo extends Figura {

    double radio;

    public Circulo(double radio){
        this.radio = radio;
    }

    public void calcularArea(){
        area = Math.PI * radio * radio;
    }

    public void calcularPerimetro(){
        perimetro = 2 * Math.PI * radio;
    }
}
