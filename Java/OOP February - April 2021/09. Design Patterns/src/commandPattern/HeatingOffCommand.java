package commandPattern;

public class HeatingOffCommand implements ICommand{
    @Override
    public void execute() {
        System.out.println("Here is so hot. Heating OFF");
    }
}
