class Moto extends Veiculo{
    public Moto(String id){
        super(id, "Moto");
    }

    @Override
    public double calcularValor(int horaSaida){
        double valor = 0.0;
        valor = (horaSaida - getEntrada()) / 20;
        return valor; 
    }

    public String toString(){
        return String.format("%10s-:-%10s-:-%s", getTipo(), getId(), getEntrada())
            .replace(' ', '_') 
            .replace('-', ' ');
    }
}
