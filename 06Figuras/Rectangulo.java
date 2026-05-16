public class Rectangulo extends Figura {

    double base, altura;

    public Rectangulo(double base, double altura){
        this.base = base;
        this.altura = altura;
    }

    public void calcularArea(){
        area = base * altura;
    }

    public void calcularPerimetro(){
        perimetro = 2 * (base + altura);
    }
}
