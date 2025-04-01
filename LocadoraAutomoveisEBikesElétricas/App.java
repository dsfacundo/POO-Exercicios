import java.util.*;
 enum CarModel {
    CELTA(10), COROLLA(20);
    
    private final double pricePerHour;
    
    CarModel(double pricePerHour) {
        this.pricePerHour = pricePerHour;
    }
    
    public double getPricePerHour() {
        return pricePerHour;
    }
}
 abstract class Vehicle {
    protected String id_veiculo;
    protected boolean isRented;
    public Vehicle(String id_veiculo) {
       this.id_veiculo = id_veiculo;
       this.isRented = false;
    }
    public String getId() {
        return this.id_veiculo;
    }
    public boolean isRented() {
        return this.isRented;
    }
    public void rent() {
        this.isRented = true;
    }
    public void returnVehicle() {
        System.out.println("Veiculo retornado.");
        this.isRented = false;
    }
    public abstract double calculateRentalCost(int hours);
 }
 class Car extends Vehicle {
    private CarModel model;
    private int wearLevel;
    private static final int MAX_WEAR = 500;
    public Car(String id_veiculo, CarModel model) {
        super(id_veiculo);
        this.model = model;
        this.wearLevel = 0;
    }
    @Override
    public double calculateRentalCost(int hours) {
        return hours * model.getPricePerHour();
    }
    //cada hora de aluguel aumenta o desgaste em 2
    public void applyWear(int hours) {
        for (int i = 0; i < hours; i++)
            this.wearLevel += 2;
    }
    //o carro só pode ser alugado se não estiver alugado e se o desgaste for menor que 500
    public boolean isAvailable() {
       if (isRented){
            System.out.println("Carro nao disponivel.");
            return false;
       }
       if (wearLevel > MAX_WEAR){
            System.out.println("Carro nao disponivel.");
            return false;
       }
       return true;
    }
    public String toString() {
        String s = String.format("Carro: ID=%s, Modelo=%s, Preco/Hora=%.1f, Alugado=%s, Desgaste=%d", getId(), model.name(), model.getPricePerHour(), isRented, wearLevel);
        if (wearLevel > MAX_WEAR)
            s += " (Indisponivel)";
        return s;
    }    
 }
 class ElectricBike extends Vehicle {
    private int battery;
    public ElectricBike(String id_veiculo) {
        super(id_veiculo);
        this.battery = 100;
    }
    public int getBattery(){
        return this.battery;
    }
    @Override
    public void rent() {
        if (battery == 0){
            System.out.println("Bicicleta sem bateria! Recarregue antes de alugar.");
            return;
        }
        isRented = true;
        battery = 0;
    }
    public void chargeBattery() {
       if (isRented()){
            System.out.println("Não é possível carregar uma bicicleta alugada!");
            return;
       }
       battery = 100;
       System.out.println("Bateria recarregada!");
    }
    @Override
    public double calculateRentalCost(int hours) {
        return 0.0;
    }
    public String toString() {
        if (!isRented())
            return String.format("Bike Eletrica: ID=%s, Bateria=%d%%, Alugado=%s", getId(), battery, isRented);
        return String.format("Bike Eletrica: ID=%s, Alugado=%s", getId(), isRented);
    }
 }
 class Locadora {
    private ArrayList<Car> cars;
    private ArrayList<ElectricBike> bikes;
    
    public Locadora() {
        this.cars = new ArrayList<Car>();
        this.bikes = new ArrayList<ElectricBike>();
    }
    
    public void addCar(String id, String modelStr) {   
        //seta o modelo do carro pra maisculo
        CarModel model = CarModel.valueOf(modelStr.toUpperCase());
        for (Car c : cars)
            if (c.getId() == id)
                return;
        Car c = new Car(id, model);
        cars.add(c);
    }
    public void addBike(String id) {
        for (ElectricBike b : bikes)
            if (b.getId() == id)
                return;
        ElectricBike b = new ElectricBike(id);
        bikes.add(b);
    }
    public void rentCar(String id, int hours) {
        for (Car c : cars)
            if (c.getId().equals(id)){
                if (!c.isAvailable())
                    return;
                c.rent();
                c.applyWear(hours);
                System.out.format("Custo R$%.1f\n", c.calculateRentalCost(hours));
                return;
            }
            System.out.println("Carro nao disponivel.");    
    }
    public void rentBike(String id) {
        for (ElectricBike b : bikes)
            if (b.getId().equals(id)){
                b.rent();
                return;
            }    
    }
    
    public void chargeBattery(String id) {
        for (ElectricBike b : bikes)
            if (b.getId().equals(id)){
                b.chargeBattery();
                return;
            }
    }
    
    public void returnVehicle(String id) {
        for (Car c : cars)
            if (c.getId().equals(id)){
                c.returnVehicle();
                return;
            }
        for (ElectricBike b : bikes)
            if (b.getId().equals(id)){
                b.returnVehicle();
                return;
            }
    }
    
    public void show() {
        for (Car c : cars)
            System.out.println(c);
        for (ElectricBike b : bikes)
            System.out.println(b);
    }
 }
 public class App {
    public static void main(String[] args) {
        Locadora locadora = new Locadora();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String[] parts = line.split(" ");
            String cmd = parts[0];
            if (cmd.equals("end")) break;
            else if (cmd.equals("addCar")) locadora.addCar(parts[1], parts[2]);
            else if (cmd.equals("addBike")) locadora.addBike(parts[1]);
            else if (cmd.equals("rentCar")) locadora.rentCar(parts[1], Integer.parseInt(parts[2]));
            else if (cmd.equals("rentBike")) locadora.rentBike(parts[1]);
            else if (cmd.equals("chargeBattery")) locadora.chargeBattery(parts[1]);
            else if (cmd.equals("return")) locadora.returnVehicle(parts[1]);
            else if (cmd.equals("show")) locadora.show();
            else System.out.println("Comando invalido.");
        }
        scanner.close();
    }
 }