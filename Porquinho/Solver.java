import java.util.Scanner;

enum Coin {
    M10(0.10, 1),
    M25(0.25, 2),
    M50(0.50, 3),
    M100(1.00, 4);

    public double value;
    public int volume;
    private Coin(double value, int volume) {
        this.value = value;
        this.volume = volume;
    }
    public int getVolume() {
        return volume;
    }
    public String getDescription() {
        return "Coin: " + value;
    }
    public String toString() {
        return "Coin: " + value + " Volume: " + value;
    }
}

class Item {
    private String description;
    private int volume;
    public Item(String description, int volume){
        this.description = description;
        this.volume = volume;
    }

    public String getDescription(){
        return this.description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public void setVolume(int volume){
        this.volume = volume;
    }

    public int getVolume(){
        return this.volume;
    }
    public String toString(){
        return "description: " +this.description+ " volume: " +this.volume;
    }
}

class Pig{
    private String itens = "";
    private double value = 0;
    private int volume = 0;
    private int volumeMax;
    private boolean broken = false;

    public Pig(int volumeMax){
        this.volumeMax = volumeMax;
    }

    public boolean addCoin(Coin moeda){
        if (broken)
            return false;
        if (getVolume() + moeda.getVolume() > getVolumeMax())
            return false;

        this.volume += moeda.getVolume();
        this.value += moeda.value;
        return true;
    }

    public boolean addItem(Item item){
        if (broken)
            return false;
        if (getVolume() + item.getVolume() > getVolumeMax())
            return false;

        this.volume += item.getVolume();

        if (itens.isEmpty())
            this.itens += item.getDescription();
        else
            this.itens += ", " + item.getDescription();
        return true;
    }

    public boolean breakPig(){
        if (broken)
            return false;
        this.broken = true;
        return true;
    }

    public double getCoins(){
        if (!broken){
            System.out.println("You must break the pig first");
            return 0;
        }
        return value;
    }

    public String getItens(){
        if (!broken){
            System.out.println("You must break the pig first");
            return "";
        }
        return itens;
    }

    public int getVolume(){
        return this.volume;
    }

    public int getVolumeMax(){
        return this.volumeMax;
    }

    public boolean isBroken(){
        return this.broken;
    }

    public String toString(){
        return String.format("I:(%s) M:%.1f V:%d/%d EQ:%s\n",
                itens, value, volume, volumeMax, broken ? "true" : "false");
    }
}

class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pig pig = new Pig(0);

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);

            if(ui[0].equals("init")) {
                pig = new Pig( Integer.parseInt( ui[1]) );
            } else if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("addCoin")) {
                if( ui[1].equals("10") ){
                    pig.addCoin(Coin.M10);
                }else if( ui[1].equals("25") ){
                    pig.addCoin(Coin.M25);
                }else if( ui[1].equals("50") ){
                    pig.addCoin(Coin.M50);
                }else if( ui[1].equals("100") ){
                    pig.addCoin(Coin.M100);
                }
            } else if(ui[0].equals("addItem")) {
                pig.addItem(new Item(ui[1], Integer.parseInt(ui[2])));
            } else if(ui[0].equals("getItens")) {
                System.out.println( pig.getItens() );
            } else if (ui[0].equals("getCoins")) {//km
                System.out.println( pig.getCoins() );
            } else if (ui[0].equals("show")) {//gas
                System.out.println(pig);
            } else if (ui[0].equals("breakPig")) {//gas
                pig.breakPig();
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}