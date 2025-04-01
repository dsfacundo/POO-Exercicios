import java.util.*;
public class Solver {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sc.useLocale(Locale.US);
        Estacionamento estacionamento = new Estacionamento();

        while (true) {
            String line = sc.nextLine();
            System.out.println("$" + line);
            String[] ui = line.split(" ");

            if (line.equals("end")) {
                break;
            } else if (ui[0].equals("tempo")) {
                estacionamento.passarTempo(Integer.parseInt(ui[1]));
            } else if (ui[0].equals("estacionar")) {
                Veiculo veiculo = null;
                if (ui[1].equals("carro")) {
                    veiculo = new Carro(ui[2]);
                    veiculo.setEntrada(estacionamento.getEntrada()); 
                } else if (ui[1].equals("moto")) {
                    veiculo = new Moto(ui[2]);
                    veiculo.setEntrada(estacionamento.getEntrada());
                } else if (ui[1].equals("bike")) {
                    veiculo = new Bike(ui[2]);
                    veiculo.setEntrada(estacionamento.getEntrada());
                } else {
                    System.out.println("fail: tipo inválido");
                    continue;
                }
                estacionamento.estacionar(veiculo);
            } else if (ui[0].equals("pagar")) {
                estacionamento.pagar(ui[1]);
            } else if (ui[0].equals("show")) {
                System.out.println(estacionamento);
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        sc.close();
    }
}