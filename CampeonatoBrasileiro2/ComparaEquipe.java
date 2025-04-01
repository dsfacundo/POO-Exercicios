import java.util.Comparator;

class ComparaEquipe implements Comparator <Equipe>{
    @Override   
    public int compare(Equipe t1, Equipe t2){
        if (t1.getTotalPontos() != t2.getTotalPontos())
            return Integer.compare(t2.getTotalPontos(), t1.getTotalPontos());
        if (t1.getTotalVitorias() != t2.getTotalVitorias())
            return Integer.compare(t2.getTotalVitorias(), t2.getTotalVitorias());
        if (t1.getSaldoGols() != t2.getSaldoGols())
            return Integer.compare(t2.getSaldoGols(), t1.getSaldoGols());
        return Integer.compare(t2.getGolsPro(), t1.getGolsPro());
    }
}
