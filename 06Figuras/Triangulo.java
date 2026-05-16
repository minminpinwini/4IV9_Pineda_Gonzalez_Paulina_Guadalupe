public class Triangulo extends Figura {

    double base, altura;

    public Triangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    public void calcularArea(){
        area = (base * altura) / 2;
    }

    public void calcularPerimetro(){
        perimetro = base * 3;
    }
}
