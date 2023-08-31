package model.Toys;

import model.ListOfToys.ToysListItem;

import java.io.Serializable;

public class Toy implements Serializable, ToysListItem<Toy> {
    private int id;
    private String title;
    private int quantity;
    private int weight;


    public Toy(int id, String title, int number, int weight) {
        this.id = id;
        this.title = title;
        this.quantity = number;
        this.weight = weight;
    }


    public Toy changeChance(Toy toy, int newChance) {
        toy.weight = newChance;
        return toy;
    }

    public Toy changeQuantity(Toy toy){
        toy.quantity -= 1;
        return toy;
    }

    public String getTitle() {
        return title;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getWeight() {
        return weight;
    }

    public int getId() {return id;}

    @Override
    public String toString() {return getInfo();}

    public String getInfo(){
        StringBuilder sb = new StringBuilder();
        sb.append("ID: ");
        sb.append(id);
        sb.append(", ");
        sb.append(title);
        sb.append(", ");
        sb.append(quantity);
        sb.append(" штук, шанс выпадения (вес):  ");
        sb.append(weight);
        return sb.toString();
    }
}
