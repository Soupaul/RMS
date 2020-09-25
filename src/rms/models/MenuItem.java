package rms.models;

public class MenuItem {

    private String name;
    private double price;
    private int id;
    private int nppt; // Number of plates that can be prepared per time unit
    private int tpp; // Time to prepare a certain number of plates, i.e. nppt
    private int qty;

    public MenuItem(String name, double price,int nppt,int tpp, int id, int qty) {
        this.name = name;
        this.price = price;
        this.nppt = nppt;
        this.tpp = tpp;
        this.id = id;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

    public int getId(){ return id; }
    
    public int getQty(){ return qty; }
    public void setQty(int qty){ this.qty = qty; }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
    
    public int getTpp(){ return tpp; };
    public int getNppt(){ return nppt; }

    public void displayDetails(){

        System.out.println(name + " $" + price + " " + qty);

    }

}

