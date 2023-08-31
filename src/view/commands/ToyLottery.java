package view.commands;

import view.ConsoleUI;

public class ToyLottery extends Command{
    public ToyLottery(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Розыгрыш игрушки";
    }

    public void execute() {
        consoleUI.toyLottery();
    }
}