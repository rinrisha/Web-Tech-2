package com.example.demo1.logic;

import com.example.demo1.logic.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * The CommandHelper class manages a set of commands available in the application.
 * It provides methods to retrieve specific commands based on their names.
 */
public class CommandHelper {

    /**
     * Singleton instance of the CommandHelper class.
     */
    private static final CommandHelper commandHelper = new CommandHelper();

    /**
     * Map containing CommandName enum as keys and ICommand implementations as values.
     * This map stores the available commands and their associated implementations.
     */
    private final Map<CommandName, ICommand> commands = new HashMap<>();

    /**
     * Constructs a CommandHelper instance and initializes available commands.
     * The constructor populates the commands map with predefined commands.
     */
    public CommandHelper(){
        // Initializing predefined commands
        commands.put(CommandName.LOG_IN, new Login());
        commands.put(CommandName.LOG_OUT, new Logout());
        commands.put(CommandName.REGISTRATE, new Registration());
        commands.put(CommandName.ADD_TO_BASKET, new AddDishToBasket());
        commands.put(CommandName.INCREMENT, new IncrementDish());
        commands.put(CommandName.DECREMENT, new DecrementDish());
        commands.put(CommandName.REMOVE_PRODUCT, new RemoveDish());
        commands.put(CommandName.CHANGE_LANG, new ChangleLang());
    }

    /**
     * Retrieves the singleton instance of the CommandHelper class.
     * @return The singleton instance of CommandHelper.
     */
    public static CommandHelper getCommandHelper(){
        return commandHelper;
    }

    /**
     * Retrieves the ICommand implementation associated with the given command name.
     * @param commandName The name of the command.
     * @return The ICommand implementation corresponding to the command name.
     */
    public ICommand getCommand(String commandName){
        CommandName name = CommandName.valueOf(commandName);
        ICommand command;
        if (name != null){
            command = commands.get(name);
        }else {
            command = commands.get(CommandName.NO_SUCH_COMMAND);
        }
        return command;
    }
}

