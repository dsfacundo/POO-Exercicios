class Bike extends Veiculo{
    public Bike(String id){
        super(id, "Bike");
    }

    @Override
    public double calcularValor(int horaSaida){
        return 3.0;
    }

    public String toString(){
        return String.format("%10s-:-%10s-:-%s", getTipo(), getId(), getEntrada())
            .replace(' ', '_') 
            .replace('-', ' ');
    }
}
