import java.util.Scanner;

public class Figuritas {

    public static void main(String[] args) {

        Scanner entrada = new Scanner(System.in);
        int opcion;
        char letra;

        do {

            System.out.println("===== FIGURAS GEOMETRICAS =====");
            System.out.println("1.- Triangulo");
            System.out.println("2.- Cuadrado");
            System.out.println("3.- Circulo");
            System.out.println("4.- Hexagono");
            System.out.println("5.- Rectangulo");
            System.out.println("6.- Salir");
            System.out.println("Elige una opcion:");

            opcion = entrada.nextInt();

            switch(opcion){

                case 1:
                    System.out.println("Base:");
                    double b = entrada.nextDouble();
                    System.out.println("Altura:");
                    double a = entrada.nextDouble();

                    Triangulo t = new Triangulo(b, a);
                    t.calcularArea();
                    t.calcularPerimetro();
                    t.mostrarDatos();
                    break;

                case 2:
                    System.out.println("Lado:");
                    double l = entrada.nextDouble();

                    Cuadrado c = new Cuadrado(l);
                    c.calcularArea();
                    c.calcularPerimetro();
                    c.mostrarDatos();
                    break;

                case 3:
                    System.out.println("Radio:");
                    double r = entrada.nextDouble();

                    Circulo ci = new Circulo(r);
                    ci.calcularArea();
                    ci.calcularPerimetro();
                    ci.mostrarDatos();
                    break;

                case 4:
                    System.out.println("Lado:");
                    double lh = entrada.nextDouble();

                    Hexagono h = new Hexagono(lh);
                    h.calcularArea();
                    h.calcularPerimetro();
                    h.mostrarDatos();
                    break;

                case 5:
                    System.out.println("Base:");
                    double br = entrada.nextDouble();
                    System.out.println("Altura:");
                    double ar = entrada.nextDouble();

                    Rectangulo re = new Rectangulo(br, ar);
                    re.calcularArea();
                    re.calcularPerimetro();
                    re.mostrarDatos();
                    break;
            }

            System.out.println("Deseas repetir el programa? (S/N)");
            letra = entrada.next().charAt(0);

        } while(letra == 's' || letra == 'S');
    }
}
