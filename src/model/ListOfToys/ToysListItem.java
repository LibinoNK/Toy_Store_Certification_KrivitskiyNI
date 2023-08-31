package model.ListOfToys;

import model.Toys.Toy;

import java.io.Serializable;
import java.util.Scanner;

public interface ToysListItem<T> extends Serializable {
    String getTitle();
    int getQuantity();
    int getWeight();
    T changeChance(T Toy, int newChance);
}
