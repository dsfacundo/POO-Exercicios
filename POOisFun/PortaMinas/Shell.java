import java.util.*;

class Lead {
    private int size;
    private String hardness;
    private double thickness;

    public Lead(Double thickness, String hardness, int size){
        this.size = size;
        this.hardness = hardness;
        this.thickness = thickness;
    }

    public int usagePerSheet(){
        if (hardness.equals("HB"))
            return 1;
        else if (hardness.equals("2B"))
            return 2;
        else if (hardness.equals("4B"))
            return 4;
        else
            return 6;
    }

    public String getHardness(){
        return this.hardness;
    }

    public int getSize(){
        return this.size;
    }

    public double getThickness(){
        return this.thickness;
    }

    public void setSize(int valor){
        this.size = valor;
    }

    public String toString (){
        return String.format("%.1f:%s:%d", this.thickness, this.hardness, this.size);
    }
}

class Pencil {
    private double thickness;
    private Lead tip;

    public Pencil (double thickness){
        this.thickness = thickness;
        tip = null;
    }

    public boolean hasGrafite (){
        if (tip != null)
            return true;
        else
            return false;
    }

    public boolean insert(Double thickness, String hardness, int length){
        if (hasGrafite()) {
            System.out.println("fail: ja existe grafite");
            return false;
        }else if (this.thickness != thickness){
            System.out.println("fail: calibre incompativel");
            return false;
        }else{
            this.tip = new Lead(thickness, hardness, length);
            return true;
        }
    }

    public Lead remove(){
        if (tip == null){
            System.out.println("fail: nao existe grafite");
            return null;
        }
        Lead aux = tip;
        tip = null;
        return aux;
    }

    public void writePage(){
        if (!hasGrafite()){
            System.out.println("fail: nao existe grafite");
            return;
        }
        if (tip.getSize() <= 10){
            System.out.println("fail: tamanho insuficiente");
            return;
        }
        if ((tip.getSize() - 10) < tip.usagePerSheet()){
            System.out.println("fail: folha incompleta");
            tip.setSize(10);
            return;
        }
        tip.setSize(tip.getSize() - tip.usagePerSheet());
    }

    public String toString () {
        String grafite;
        if (tip != null)
            grafite = "[" +tip.toString()+ "]";
        else
            grafite = "null";
        return String.format("calibre: %.1f, grafite: %s", this.thickness, grafite);
    }

}

class Adapter {
    private Pencil pencil;
    public Adapter(double thickness) {
        pencil = new Pencil(thickness);
    }

    public void insert(Double thickness, String hardness, int length) {
        pencil.insert(thickness, hardness, length);
    }

    public void remove() {
        pencil.remove();
    }

    public void writePage() {
        pencil.writePage();
    }

    public void show() {
        System.out.println(pencil.toString());
    }
}


public class Shell {
    public static void main(String[] _args) {
        Adapter adp = new Adapter(0.5f);

        while (true) {
            String line = input();
            String[] args = line.split(" ");
            write('$' + line);

            if      ("end".equals(args[0])   ) { break;                                                       }
            else if ("init".equals(args[0])  ) { adp = new Adapter(number(args[1]));                          }
            else if ("insert".equals(args[0])) { adp.insert(number(args[1]), args[2], (int) number(args[3])); }
            else if ("remove".equals(args[0])) { adp.remove();                                                }
            else if ("write".equals(args[0]) ) { adp.writePage();                                             }
            else if ("show".equals(args[0])  ) { adp.show();                                                  }
        }
    }

    static Scanner scanner = new Scanner(System.in);
    public static String input()           { return scanner.nextLine();    }
    public static void write(String value) { System.out.println(value);    }
    public static double number(String str) { return Double.parseDouble(str); }
}