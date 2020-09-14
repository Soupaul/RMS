package rms.models;

public class MenuItem {

    private String name;
    private double price;
    private int id;
    private int qty;

    public MenuItem(String name, double price, int id, int qty) {
        this.name = name;
        this.price = price;
        this.id = id;
        this.qty = qty;
    }

    public String getName() {
        return name;
    }

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

    public void displayDetails(){

        System.out.println(name + " $" + price + " " + qty);

    }

}

