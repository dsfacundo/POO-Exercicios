abstract class Veiculo {
    private String id;
    private String tipo;
    private int horaEntrada;

    public Veiculo(String id, String tipo){
        this.id = id;
        this.tipo = tipo;
    }

    public void setEntrada(int horaEntrada){
        this.horaEntrada = horaEntrada;
    }

    public int getEntrada(){
        return this.horaEntrada;
    }

    public String getTipo(){
        return this.tipo;
    }

    public String getId(){
        return this.id;
    }

    public abstract double calcularValor(int horaSaida);

}
