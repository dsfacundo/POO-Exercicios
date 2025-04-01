import java.util.*;
class ComputaSequencia{

    private ArrayList<Integer> num = new ArrayList<Integer>();

    public void cadastra(int valor){
        if (valor != 0)
            num.add(valor);
        else
            num.remove(num.size() - 1);
    }

    public int computa(){
        int soma = 0;
        for (int i = 0; i < num.size(); i++)
            soma += num.get(i);
        return soma;
    }

    public String toString(){
        return "valores = " +num;
    }



}



class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComputaSequencia sequencia = new ComputaSequencia();

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("cadastra")) {
                sequencia.cadastra( Integer.parseInt( ui[1]) );
            } else if(ui[0].equals("computa")) {
                System.out.println( sequencia.computa() );
            } else if(ui[0].equals("show")) {
                System.out.println( sequencia );
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}