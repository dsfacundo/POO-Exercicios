class Circulo extends Shape{
    private Ponto2D centro;
    private double raio;
    
    public Circulo(Ponto2D p, double raio){
        this.centro = p;
        this.raio = raio;
    }

    public Ponto2D getCentro(){
        return this.centro;
    }

    public double getRaio(){
        return this.raio;
    }

    @Override
    public double area(){
        return Math.PI * getRaio() * getRaio();
    }

    @Override
    public double getPerimeter(){
        return 2 * Math.PI * getRaio();
    }

    @Override
    public boolean inside(Ponto2D p){
        double dx = p.getX() - centro.getX();
        double dy = p.getY() - centro.getY();
        return Math.sqrt(dx * dx - dy * dy) <= getRaio();
    }

    @Override
    public String toString(){
        return "Circulo com centro em (" + centro.getX() + "," + centro.getY() + ") e raio " +getRaio();
    }
}
