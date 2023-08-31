package model.service;


import model.ListOfToys.FileMethods.FileMethods;
import model.ListOfToys.FileMethods.Writable;
import model.ListOfToys.ToysList;
import model.Toys.Toy;

public class Service {
    private ToysList toysList;
    private Writable fileMethods;

    public Service() {toysList = new ToysList<>();
        fileMethods = new FileMethods();}

    public void addToy(int id, String title, int number, int chance){
        Toy toy = new Toy(id, title,  number, chance);
        toysList.addToy(toy);
    }

    public String getToysInfo() {
       return toysList.getToysInfo();
    }

    public void changeChance(Toy toy) {
        toysList.changeChance(toy);
    }

    public Toy findToyById(int id){
        return toysList.findToyById(id);
    }

    public String toyLottery(){
        return toysList.toyLottery();
    }

    public void saveINFile(String winner) {
        fileMethods.saveAllInFile("src/AllWinPrize.out", winner);
    }

    public void readFile(){
        toysList = (ToysList) fileMethods.read("src/AllWinPrize.out");
    }

}
