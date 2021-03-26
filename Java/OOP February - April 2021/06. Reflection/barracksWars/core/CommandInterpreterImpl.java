package barracksWars.core;

import barracksWars.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {

    private static final String COMMANDS_PATH = "barracksWars.core.commands.";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data) {
        Executable command = null;
        String commandName = data[0];
        commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);

        try {
            Class<?> clazz = Class.forName(COMMANDS_PATH + commandName);
            Constructor<?> ctor = clazz.getDeclaredConstructor(String[].class);
            ctor.setAccessible(true);
            command = (Executable) ctor.newInstance(new Object[]{data});
            Field[] executableFields = command.getClass().getDeclaredFields();
            Field[] localFields = this.getClass().getDeclaredFields();
            for (Field executableField : executableFields) {
                if (executableField.isAnnotationPresent(Inject.class)) {
                    for (Field localField : localFields) {
                        if (executableField.getType().equals(localField.getType())) {
                            executableField.setAccessible(true);
                            executableField.set(command, localField.get(this));
                        }
                    }
                }
            }
        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return command;
    }
}
