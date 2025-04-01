import java.util.*;


class MediaNotas{

    private ArrayList<Double> notas = new ArrayList<Double>();

    public void addNota(double nota){
        notas.add(nota);
    }

    public void removeNota(int index){
        if (index >= 0 && index < notas.size())
            notas.remove(index);
        else
            System.out.println("fail: indice invalido");
    }

    public void mudaNota(int index, double valor){
        if (index >= 0 && index < notas.size())
            notas.set(index, valor);
        else
            System.out.println("fail: indice invalido");
    }

    public double maiorNota(){
        return Collections.max(notas);
    }

    public double menorNota(){
        return Collections.min(notas);
    }

    double media(){
        double media = 0;
        for (int i = 0; i < notas.size(); i++){
            media += notas.get(i);
        }
        media /= notas.size();
        return media;
    }

    void parametriza(){
        double p = maiorNota();
        for (int i = 0; i < notas.size(); i++){
            mudaNota(i, (notas.get(i) / p) * 10);
        }
    }

    public String toString(){
        String s = "[";
        for (int i = 0; i < notas.size(); i++){
            if(i < notas.size() - 1)
                s += String.format("%.2f, ", notas.get(i));
            else
                s += String.format("%.2f]", notas.get(i));
        }
        return s;
    }
}


class Solver{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MediaNotas m = new MediaNotas();

        while(true) {
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            System.out.println("$" + line);
            if(ui[0].equals("end")) {
                break;
            } else if(ui[0].equals("addNota")) {
                m.addNota( Double.parseDouble( ui[1]) );
            } else if(ui[0].equals("removeNota")) {
                m.removeNota( Integer.parseInt( ui[1]) );
            } else if(ui[0].equals("maiorNota")) {
                System.out.println( m.maiorNota() );
            } else if(ui[0].equals("menorNota")) {
                System.out.println( m.menorNota() );
            } else if(ui[0].equals("media")) {
                System.out.printf( Locale.US, "%.2f\n",  m.media() );
            }else if(ui[0].equals("parametriza")) {
                m.parametriza();
            }else if(ui[0].equals("show")) {
                System.out.println( m );
            }else{
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}
