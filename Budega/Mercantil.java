import java.util.*;

class Mercantil {
    private ArrayList <Pessoa> caixas;
    private LinkedList <Pessoa> fila;

    public Mercantil(int qntdCaixas){
        this.caixas = new ArrayList<Pessoa>();
        this.fila = new LinkedList<Pessoa>();
        for (int i = 0; i < qntdCaixas; i++)
            caixas.add(null);
    }

    public void chegar(Pessoa p){
        fila.addLast(p);
    }

    public boolean chamarNoCaixa(int i){
        if (fila.size() == 0){
            System.out.println("fail: fila vazia");
            return false;
        }
        if (caixas.get(i) != null){
            return false;
        }
        caixas.set(i, fila.removeFirst());
        return true;
    }

    public Pessoa finalizarAtendimento(int i){
       Pessoa aux = caixas.get(i);
       caixas.set(i, null);
       return aux;
    }

    public String toString(){
        String s = "|";
        for (int i = 0; i < caixas.size(); i++){
            if (caixas.get(i) == null)
                s += i + ":-----|";
            else
                s += i + ":" + caixas.get(i).toString() + "|";
        }
        s += "\n";
        s += "Espera: " +fila.toString();
        return s;
    }
}
