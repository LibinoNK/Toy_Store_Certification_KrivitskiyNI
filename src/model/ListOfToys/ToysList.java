package model.ListOfToys;

import model.ListOfToys.FileMethods.Writable;
import model.Toys.Toy;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class ToysList<E extends ToysList<E>> implements Serializable{

    private List<Toy> toysList;

    public ToysList() {toysList = new ArrayList<>();}

    public boolean addToy(Toy toy){
        if(toy == null){return false;}
        if(!toysList.contains(toy)){
            toysList.add(toy);
            return true;
        }
        return false;
    }

    public String getToysInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("В розыгрыше участвуют ");
        stringBuilder.append(toysList.size());
        stringBuilder.append(" игрушек:\n");
        for (Toy toy : toysList) {
            stringBuilder.append(toy);
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public Toy changeChance(Toy toy) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите новый шанс(вес): ");
        int newChance = scanner.nextInt();
        toy.changeChance(toy, newChance);
        return toy;
    }

    public Toy findToy(int chance){
        for (Toy toy: toysList){
            if(toy.getWeight() == chance){
                return toy;
            }
        }
        return null;
    }

    public Toy findToyById(int id){
        for (Toy toy: toysList){
            if(toy.getId() == id){
                return toy;
            }
        }
        return null;
    }

    public String toyLottery(){
        if (toysList.isEmpty()){
            System.out.println("Разыгрываемые игрушки закончились! :с");
            return null;
        }

        Random random = new Random();
        int rand = random.nextInt(1, findAllWeight());
        ArrayList<Integer> allChance = findAllChance();
        int tempSumm = 0;
        int index = 0;
        while (rand > tempSumm){
            tempSumm += allChance.get(index);
            index += 1;
        }


        Toy prizeToy = findToy(allChance.get(index-1));
        toysList.set(index-1, prizeToy.changeQuantity(prizeToy));
        if (prizeToy.getQuantity() <= 0){
            toysList.remove(prizeToy);
        }

        System.out.print("Ваш приз: ");
        System.out.println(prizeToy.getTitle());


        return prizeToy.getTitle();
    }

    private int findAllWeight(){
        int allWeight = 0;
        for (Toy toy: toysList){
            allWeight += toy.getWeight();
        }
        return allWeight;
    }

    private ArrayList findAllChance(){
        ArrayList<Integer> allChance = new ArrayList<>();
        for (Toy toy: toysList){
            allChance.add(toy.getWeight());
        }
        return allChance;
    }

}
