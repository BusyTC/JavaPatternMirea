package practice_8.command;

public class Test {
    public static void main(String[] args) {
        Person person = new Person();
        Cooker cooker = new Cooker();
        person.addCommand(new TurnOnCookerCommand(cooker));
        person.addCommand(new TurnOfCookerCommand(cooker));
        person.executeCommand();
    }
}
