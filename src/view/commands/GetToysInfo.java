package view.commands;

import view.ConsoleUI;

public class GetToysInfo extends Command{
    public GetToysInfo(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Посмотреть все игрушки";
    }

    public void execute() {
        consoleUI.getToysInfo();
    }
}
