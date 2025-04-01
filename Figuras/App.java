import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ArrayList<Shape> lista = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);

        while (true) {
            String line = sc.nextLine();
            System.out.println("$" + line);
            String[] ui = line.split(" ");
            
            if (line.equals("end")) {
                break;
            } else if (ui[0].equals("circulo")) {
                double x = Double.parseDouble(ui[1]);
                double y = Double.parseDouble(ui[2]);
                double r = Double.parseDouble(ui[3]);
                Ponto2D centro = new Ponto2D(x, y);
                Circulo c = new Circulo(centro, r);
                lista.add(c);
                
            } else if (ui[0].equals("retangulo")) {
                double x1 = Double.parseDouble(ui[1]);
                double y1 = Double.parseDouble(ui[2]);
                double x2 = Double.parseDouble(ui[3]);
                double y2 = Double.parseDouble(ui[4]);
                Ponto2D p1 = new Ponto2D(x1, y1);
                Ponto2D p2 = new Ponto2D(x2, y2);
                Retangulo r = new Retangulo(p1, p2);
                lista.add(r);
                
            } else if (ui[0].equals("area")) {
                double soma = 0;
                for (Shape s : lista) {
                    soma += s.area();
                }
                System.out.printf("area total: %.2f\n", soma);
                
            } else if (ui[0].equals("perimetro")) {
                double soma = 0;
                for (Shape s : lista) {
                    soma += s.getPerimeter();
                }
                System.out.printf("perimetro total: %.2f\n", soma);
                
            } else if (ui[0].equals("inside")) {
                double x = Double.parseDouble(ui[1]);
                double y = Double.parseDouble(ui[2]);
                Ponto2D p = new Ponto2D(x, y);
                for (Shape s : lista) {
                    System.out.println(s.inside(p));
                }

            } else if (ui[0].equals("mostra")) {
                System.out.println("Figura:");
                for (Shape s : lista) {
                    System.out.println(s.toString());
                }
                
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        sc.close();
    }
}
