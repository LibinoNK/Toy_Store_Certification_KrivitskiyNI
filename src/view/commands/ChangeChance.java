package view.commands;

import view.ConsoleUI;

public class ChangeChance extends Command{
    public ChangeChance(ConsoleUI consoleUI){
        super(consoleUI);
        description = "Изменить шанс выпадения";
    }

    public void execute() {
        consoleUI.changeChance();
    }
}
