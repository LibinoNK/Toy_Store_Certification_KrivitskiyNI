package view;

import model.ListOfToys.ToysList;
import model.Toys.Toy;
import presenter.Presenter;

import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class ConsoleUI implements View{
    private static final String INPUT_ERROR = "Вы ввели неверное значение";
    private Scanner scanner;
    private Presenter presenter;
    private boolean work;
    private MainMenu menu;

    int id = 0;

    public ConsoleUI() {
        scanner = new Scanner(System.in);
        presenter = new Presenter(this);
        work = true;
        menu = new MainMenu(this);
    }

    public void printAnswer(String text) {
        System.out.println(text);
    }

    public void start() {
        hello();
        while (work){
            printMenu();
            execute();
        }
    }

    public void finish() {
        System.out.println("Приятно было поиграть");
        work = false;
    }

    private void hello(){
        System.out.println("Хээээй! Привет! Поиграем?");
    }

    private void execute(){
        String line = scanner.nextLine();
        if (checkTextForInt(line)){
            int numCommand = Integer.parseInt(line);
            if (checkCommand(numCommand)){
                menu.execute(numCommand);
            }
        }
    }

    private boolean checkTextForInt(String text){
        if (text.matches("[0-9]+")){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private boolean checkCommand(int numCommand){
        if (numCommand <= menu.getSize()){
            return true;
        } else {
            inputError();
            return false;
        }
    }

    private void printMenu(){
        System.out.println(menu.menu());
    }

    private void inputError(){
        System.out.println(INPUT_ERROR);
    }

    public void addToy(){
        int id = getId();
        System.out.println("Введите название игрушки: ");
        String title = scanner.nextLine();
        System.out.println("Введите количество добавляемых игрушек: ");
        int number = Integer.parseInt(scanner.nextLine());
        System.out.println("Введите шанс (вес) выпадения игрушки в процентах>: ");
        int weight = Integer.parseInt(scanner.nextLine());

        presenter.addToy(id, title, number, weight);
    }

    public int getId() {
        int id = this.id + 1;
        this.id += 1;
        return id;
    }

    public void getToysInfo() {
        presenter.getToysInfo();
    }

    public void changeChance() {
        System.out.println("Введите ID игрушки: ");
        int Id = Integer.parseInt(scanner.nextLine());
        Toy toy = findToyById(Id);
        presenter.changeChance(toy);
    }

    public Toy findToyById(int id){
        return presenter.findToyById(id);
    }

    public void toyLottery(){
        String winner = presenter.toyLottery();
        saveInFile(winner);
    }

    public void saveInFile(String winner) {
        presenter.saveInFile(winner); }

    public void readFile() {presenter.readFile();}

}
