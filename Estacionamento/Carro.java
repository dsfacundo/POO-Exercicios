class Carro extends Veiculo {
    public Carro(String id){
        super(id, "Carro");
    }

    @Override
    public double calcularValor(int horaSaida){
        double valor = 0.0;
        valor = (horaSaida - getEntrada()) / 10;
        if (valor < 5)
            valor = 5;
        return valor;
    }
    public String toString() {
        return String.format("%10s-:-%10s-:-%s", getTipo(), getId(), getEntrada())
            .replace(' ', '_') 
            .replace('-', ' '); 
    }
}