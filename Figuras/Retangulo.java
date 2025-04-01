class Retangulo extends Shape{
    private Ponto2D p1;
    private Ponto2D p2;
    
    public Retangulo(Ponto2D a, Ponto2D b){
        this.p1 = a;
        this.p2 = b;
    }

    public Ponto2D infEsq(){
        return p1;
    }

    public Ponto2D subDir(){
        return p2;
    }

    @Override
    public double area(){
        double base = Math.abs(p1.getX() - p2.getX());
        double altura = Math.abs(p1.getY() - p2.getY());
        return base * altura;
    }

    @Override
    public double getPerimeter(){
        double base = Math.abs(p1.getX() - p2.getX());
        double altura = Math.abs(p1.getY() - p2.getY());
        return 2 * (base + altura);
    }

    @Override
    public boolean inside(Ponto2D p){
        return (p.getX() >= p1.getX() && p.getX() <= p2.getX()) && 
                (p.getY() >= p2.getY() && p.getY() <= p2.getY());
    }

    @Override
    public String toString(){
        return "Retângulo com cantos (" + p1.getX() + "," + p1.getY() + ") e (" + p2.getX() + "," + p2.getY() + ")";
    }

}
