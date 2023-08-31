package presenter;

import model.Toys.Toy;
import model.service.Service;
import view.View;

import java.io.IOException;


public class Presenter {
    private View view;
    private Service service;

    public Presenter(View view){
        this.view = view;
        service = new Service();
    }

    public void addToy(int id, String title, int number, int chance){
        service.addToy(id, title,  number, chance);
    }

    public void getToysInfo() {
        view.printAnswer(service.getToysInfo());
    }

    public void changeChance(Toy toy) {
        service.changeChance(toy);
    }

    public Toy findToyById(int id){
        return service.findToyById(id);
    }

    public String toyLottery(){
       return service.toyLottery();
    }

    public void saveInFile(String winner) {service.saveINFile(winner);}

    public void readFile(){
        service.readFile();
    }
}
