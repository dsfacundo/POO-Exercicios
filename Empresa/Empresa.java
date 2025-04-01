import java.util.ArrayList;

public class Empresa{
    private ArrayList <Empregado> empregados;

    Empresa(){
        this.empregados = new ArrayList<Empregado>();    
    }

    public void adicionaEmpregado(Empregado e){
        empregados.add(e);
    }

    public void mostraEmpregado(){
        System.out.println("Empresa: ");
        for (Empregado empregado : empregados){
            System.out.println(empregado);
        }
    }

    public double calculaFolha(){
        Double pagamento = 0.0;
        for (Empregado empregado : empregados){
            pagamento += empregado.pagamento();
        }
        return pagamento;
    }



}