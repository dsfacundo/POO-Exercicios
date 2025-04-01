class Lead {
    private String hardness;
    private double thickness;
    private int size;

    public Lead(String hardness, double thickness, int size){
        this.hardness = hardness;
        this.thickness = thickness;
        this.size = size;
    }

    public int usagePerSheet(){
        if (hardness == "HB")
            return 1;
        else if (hardness == "2B")
            return 2;
        else if (hardness == "4B")
            return 4;
        else
            return 6;    
    }

    public int getSize(){
        return this.size;
    }

    public double getThickness(){
        return this.thickness;
    }

    public String getHardness(){
        return this.hardness;
    }

    public void setSize(int size){
        this.size = size;
    }

    public String toString(){
        return String.format("%.1f:%s:%d", getThickness(), getHardness(), getSize());
    }
}
