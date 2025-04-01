import java.util.*;

class Pet{
    private int energyMax, hungryMax, cleanMax;
    private int energy, hungry, shower;
    private int diamonds;
    private int age;
    private boolean alive;
    // Atribui o valor de energia
    // Se o valor ficar abaixo de 0, o pet morre de fraqueza
    // Garanta que os valores ficarão no interalo 0 - max
    // Use esse modelo para fazer os outros métodos set
    void setEnergy(int value){
        if (value <= 0){
            this.energy = 0;
            System.out.println("fail: pet morreu de fraqueza");
            this.alive = false;
        }
        else if (value > this.energyMax)
            this.energy = this.energyMax;
        else
            this.energy = value;
    }
    public void setHungry(int value){
        if (value <= 0){
            this.hungry = 0;
            System.out.println("fail: pet morreu de fome");
            this.alive = false;
        }else if (value > this.hungryMax)
            this.hungry = this.hungryMax;
        else
            this.hungry = value;
    }

    void setClean(int value){
        if (value <= 0){
            this.shower = 0;
            System.out.println("fail: pet morreu de sujeira");
            this.alive = false;
        }else if (value > this.cleanMax)
            this.shower = this.cleanMax;
        else
            this.shower = value;
    }

    public Pet(int energy, int hungry, int shower){
        this.energy = energy;
        this.energyMax = energy;
        this.hungry = hungry;
        this.hungryMax = hungry;
        this.shower = shower;
        this.cleanMax = shower;
        this.age = 0;
        this.diamonds = 0;
    }

    public String toString(){
        return "E:" +getEnergy()+ "/" +getEnergyMax()+ ", S:" +getHungry()+ "/" +getHungryMax()+ ", L:" +getClean()+ "/" +getCleanMax()+ ", D:" +this.diamonds+ ", I:" +this.age;
    }

    private boolean testAlive(){
        if (getEnergy() == 0 || getHungry() == 0 || getClean() == 0){
            this.alive = false;
            System.out.println("fail: pet esta morto");
            return false;
        }else
            return true;
    }
    // Invoca o método testAlive para verificar se o pet esta vivo
    // Se estiver vivo, altere os atributos utilizando os métodos set e get
    public void play(){
        if (!testAlive())
            return;
        setEnergy(getEnergy() - 2);
        setHungry(getHungry() - 1);
        setClean(getClean() - 3);
        diamonds += 1;
        age += 1;
    }
    public void shower(){
        if (!testAlive())
            return;
        setEnergy(getEnergy() - 3);
        setHungry(getHungry() - 1);
        setClean(getCleanMax());
        this.age += 2;
    }

    public void eat(){
        if (!testAlive())
            return;
        setEnergy(getEnergy() - 1);
        setHungry(getHungry() + 4);
        setClean(getClean() - 2);
        this.age ++;
    }

    public void sleep(){
        if (!testAlive())
            return;
        int turno = getEnergyMax() - getEnergy();
        if (getEnergy() <= getEnergyMax() - 5){
            setEnergy(getEnergyMax());
            setHungry(getHungry() - 1);
            this.age += turno;
        }else
            System.out.println("fail: nao esta com sono");
    }
    //Métodos GET
    int getClean(){
        return this.shower;
    }
    int getHungry(){
        return this.hungry;
    }
    int getEnergy(){
        return this.energy;
    }
    int getEnergyMax(){
        return this.energyMax;
    }
    int getCleanMax(){
        return this.cleanMax;
    }
    int getHungryMax(){
        return this.hungryMax;
    }
}
class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pet pet = new Pet(0, 0, 0);
        while(true) {
            String line = scanner.nextLine();
            System.out.println("$" + line);
            String ui[] = line.split(" ");
            if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("show")) {
                System.out.println(pet.toString());
            } else if(ui[0].equals("init")) {
                int energy = Integer.parseInt(ui[1]);
                int hungry = Integer.parseInt(ui[2]);
                int shower = Integer.parseInt(ui[3]);
                pet = new Pet(energy, hungry, shower);
            } else if(ui[0].equals("play")) {
                pet.play();
            } else if(ui[0].equals("eat")) {
                pet.eat();
            } else if(ui[0].equals("clean")) {
                pet.shower();
            } else if(ui[0].equals("sleep")) {
                pet.sleep();
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
