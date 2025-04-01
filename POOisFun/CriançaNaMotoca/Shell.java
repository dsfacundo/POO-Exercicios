import java.util.*;


class Person {
    private int age;
    private String name;

    public Person(String name, int age){
        this.name = name;
        this.age = age;
    }

    public String getName(){
        return this.name;
    }

    public int getAge(){
        return this.age;
    }

    public String toString() {
        return String.format("%s:%d", name, age);
    }

}//fim da classe

class Motorcycle{
    private Person person;
    private int power;
    private int time;


    public Motorcycle(int power){
        this.power = power;
        this.time = 0;
        this.person = null;
    }

    public boolean insertPerson(Person person){
        if (this.person != null){
            System.out.println("fail: busy motorcycle");
            return false;
        }
        this.person = person;
        return true;
    }

    public Person remove(){
        if (this.person == null){
            System.out.println("fail: empty motorcycle");
            return null;
        }
        Person aux = person;
        person = null;
        return aux;
    }

    public void buyTime(int time){
        this.time += time;
    }

    public void drive(int time){
        if (this.time == 0){
            System.out.println("fail: buy time first");
            return;
        }
        if (this.person == null){
            System.out.println("fail: empty motorcycle");
            return;
        }
        if (person.getAge() > 10){
            System.out.println("fail: too old to drive");
            return;
        }
        if (this.time < time){
            System.out.format("fail: time finished after %d minutes\n", this.time);
            this.time = 0;
            return;
        }
        this.time -= time;
    }

    public void honk(){
        String buzina = "P";
        for (int i = 0; i < this.power; i++)
            buzina += "e";
        buzina += "m";
        System.out.println(buzina);
    }

    public Person getPerson() {
        return person;
    }


    public int getPower() {
        return power;
    }


    public int getTime() {
        return time;
    }

    public String toString(){
        String pessoa;
        if (person != null)
            pessoa = "(" +person.toString()+ ")";
        else
            pessoa = "(empty)";
        return String.format("power:%d, time:%d, person:%s", this.power, this.time, pessoa);
    }


}

class Adapter {
    Motorcycle moto = new Motorcycle(1);
    public void init(int power) {
        moto = new Motorcycle(power);
    }

    public void enter(String name, int age) {
        moto.insertPerson(new Person(name, age));
    }

    public void buy(int price) {
        moto.buyTime(price);
    }

    public void drive(int km) {
        moto.drive(km);
    }

    public void leave() {
        var person = moto.remove();
        if (person == null) {
            System.out.println("---");
            return;
        }
        System.out.println(person.toString());
    }

    public void honk() {
        moto.honk();
    }

    public void show() {
        System.out.println(moto);
    }
}


public class Shell{
    static Adapter adp = new Adapter();

    public static void main(String[] args) {
        while(true) {
            write("$");
            String line = input();
            args = line.split(" ");
            write(line + "\n");

            if      (args[0].equals("end"))      { break;                                       }
            else if (args[0].equals("show"))     { adp.show();                                  }
            else if (args[0].equals("init"))     { adp.init((int) number(args[1]));             }
            else if (args[0].equals("enter"))    { adp.enter(args[1], (int) number(args[2]));   }
            else if (args[0].equals("buy"))      { adp.buy((int) number(args[1]));              }
            else if (args[0].equals("drive"))    { adp.drive((int) number(args[1]));            }
            else if (args[0].equals("honk"))     { adp.honk();                                  }
            else if (args[0].equals("leave"))    { adp.leave();                                 }
            else                                 { write("fail: comando invalido\n");       }
        }
    }

    static Scanner scanner = new Scanner(System.in);
    public static String input()            { return scanner.nextLine();      }
    public static void write(String value)  { System.out.print(value);        }
    public static double number(String str) { return Double.parseDouble(str); }
}
