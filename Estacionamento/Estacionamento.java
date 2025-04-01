import java.util.ArrayList;

class Estacionamento {
    private ArrayList <Veiculo> veiculos;
    private int horaAtual;

    public Estacionamento(){
        this.veiculos = new ArrayList<Veiculo>();
        this.horaAtual = 0;
    }

    public int getEntrada(){
        return this.horaAtual;
    }

    private int procurarVeiculo(String id){
        for (int i = 0; i < veiculos.size(); i++)
            if (veiculos.get(i).getId().equals(id))
                return i;
        return -1;
    }
    
    public void estacionar(Veiculo v){
        veiculos.add(v);
    }

    public void pagar(String id){
        int index = procurarVeiculo(id);
        if (index == -1){
            System.out.println("fail: veiculo não encontrado");
            return;
        }

        Veiculo v = veiculos.get(index);
        System.out.format("%s chegou %d saiu %d. Pagar R$ %.2f\n", v.getTipo(), v.getEntrada(), horaAtual, v.calcularValor(horaAtual));
    }

    public void sair(String id){
        int index = procurarVeiculo(id);
        if (index == -1){
            System.out.println("fail: veiculo não encontrado");
            return;
        }
        veiculos.remove(index);
    }

    public void passarTempo(int tempo){
        this.horaAtual += tempo;
    }

    public String toString(){
        String s = "";
        for (Veiculo v : veiculos){
            s += v.toString();
            s += "\n";
        }
        s += "Hora atual: " + horaAtual;
        return s;
    }


}
