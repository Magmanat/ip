package grandduke.command;

import java.util.Scanner;
import grandduke.task.TaskList;

public abstract class Io {
    private static final String LOGO = "  _____                     _______       _        \n"
            + "|  __ \\                   | |  _  \\     | |       \n"
            + "| |  \\/_ __ __ _ _ __   __| | | | |_   _| | _____ \n"
            + "| | __| '__/ _` | '_ \\ / _` | | | | | | | |/ / _ \\ \n"
            + "| |_\\ \\ | | (_| | | | | (_| | |/ /| |_| |   <  __/\n"
            + " \\____/_|  \\__,_|_| |_|\\__,_|___/  \\__,_|_|\\_\\___|\n";

    private static final String EXIT_COMMAND = "bye";
    private static final String LIST_COMMAND = "list";
    private static final String MARK_COMMAND = "mark";
    private static final String UNMARK_COMMAND = "unmark";

    /**
     * Prints a horizontal line
     */
    public static void printLine() {
        System.out.println("        ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
    }

    /**
     * Prints a custom message to the command line
     * 
     * @param message
     *            the message to be printed
     */
    public static void printOutput(String message) {
        System.out.print("        ");
        System.out.println(message);
    }

    /**
     * Prints introduction message to the user
     */
    public static void printIntro() {
        System.out.println("Hello from\n" + LOGO);
        printLine();
        printOutput("Hello! I'm GrandDuke\n" + "        What can I do for you?");
        printLine();
    }

    /**
     * Prints exit message to the user
     */
    public static void printExit() {
        printLine();
        printOutput("Bye. Hope to see you again soon!");
        printLine();
    }

    /**
     * Gets inputs that are sent by the user through the command line
     */
    public static void getInputs() {
        Scanner in = new Scanner(System.in);
        String input;
        Boolean isRunning = true;
        while (isRunning) {
            input = in.nextLine();

            if (input.equals(EXIT_COMMAND)) {
                isRunning = false;
            }

            printLine();
            try {
                parseCommand(input);
            } catch (Exception e) {
                System.out.println("not a valid input");
            }

            printLine();

        }
        in.close();
    }

    /**
     * Parses the command from the user and decides on the appropriate command to
     * execute
     * 
     * @param input
     *            the command sent by the user
     */
    public static void parseCommand(String input) {
        if (input.equals(LIST_COMMAND)) {
            TaskList.printTaskList();
        } else if (input.startsWith(MARK_COMMAND)) {
            TaskList.markTask(input);
        } else if (input.startsWith(UNMARK_COMMAND)) {
            TaskList.unmarkTask(input);
        } else {
            TaskList.addTask(input);
        }
    }
}