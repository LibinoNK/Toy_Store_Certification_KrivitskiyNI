package view;

import view.commands.*;

import java.util.ArrayList;
import java.util.List;

public class MainMenu {
    private List<Command> commandList;

    public MainMenu(ConsoleUI consoleUI) {
        commandList = new ArrayList<>();
        commandList.add(new AddToy(consoleUI));
        commandList.add(new GetToysInfo(consoleUI));
        commandList.add(new ChangeChance(consoleUI));
        commandList.add(new ToyLottery(consoleUI));
//        commandList.add(new SaveInFile(consoleUI));
//        commandList.add(new ReadFile(consoleUI));
        commandList.add(new Finish(consoleUI));
    }

    public String menu() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < commandList.size(); i++) {
            stringBuilder.append(i + 1);
            stringBuilder.append(". ");
            stringBuilder.append(commandList.get(i).getDescription());
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }

    public void execute(int choice) {
        Command command = commandList.get(choice - 1);
        command.execute();
    }

    public int getSize() {return commandList.size();}
}