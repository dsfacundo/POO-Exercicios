import java.util.LinkedList;

class Pencil {
    private double thickness;
    private Lead tip;
    private LinkedList <Lead> barrel;

    public Pencil(double thickness){
        this.thickness = thickness;
        this.barrel = new LinkedList<Lead>();
        this.tip = null;
    }

    public double getThickness(){
        return this.thickness;
    }

    public boolean hasGrafite(){
        if (tip == null)
            return false;
        return true;
    }

    public boolean insert(Lead l){
        if (l.getThickness() != getThickness()){
            System.out.println("fail: calibre incompatível");
            return false;
        }
        this.barrel.addLast(l);
        return true;
    }

    public Lead remove(){
        Lead aux = tip;
        tip = null;
        return aux;
    }

    public boolean pull(){
        if (hasGrafite()){
            System.out.println("fail: ja existe grafite no bico");
            return false;
        }
        if (this.barrel.size() == 0){
            System.out.println("fail: tambor vazio");
            return false;
        }
        tip = barrel.removeFirst();
        return true;
    }

    public void writePage(){
        if (!hasGrafite()){
            System.out.println("fail: nao existe grafite no bico");
            return;
        }
        if (tip.getSize() < 10){
            System.out.println("fail: tamanho insuficiente");
            return;
        }

        if (tip.getSize() - tip.usagePerSheet() < 10){
            System.out.println("fail: folha incompleta");
            tip.setSize(10);
            return;
        }

        tip.setSize(tip.getSize() - tip.usagePerSheet());
    }

    public String toString(){
        String s = "calibre : " +getThickness()+ "bico : [";
        if (!hasGrafite())
            s += "]";
        else
            s += tip + "]";
        
        if (this.barrel.size() > 0){
            s += ", tambor : <";
            for (int i = 0; i < this.barrel.size(); i++)
                s += "[" +this.barrel.get(i)+ "]";
            s += ">";
        }else
            s += ", tambor : <>";
        
        return s;
    }
}
