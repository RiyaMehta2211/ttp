package InspireInclusion.ui;
import InspireInclusion.Dictionary;

/**
 * The Ui class is responsible for user interaction and displaying messages to the user.
 */
public class Ui {
    static Dictionary dict = new Dictionary();
    /**
     * Retrieves and returns a welcome message to be displayed to the user.
     * @return A welcome message to be shown to the user.
     */
    public static String printWelcome() {
        return "Welcome to InspireInclusion! Inspire inclusion and engage communities! \nType " +
                "'help' to find out more about my abilities!" ;
    }
    public static String printResponse(String input) {
        return input;
    }

    public static String printHelp() {
        return "No worries, buddy! Diversity is here to help :D \n"
                + "Here are the commands for use: \n"
                + "1. help: shows this list of commands and features\n"
                + "2.. list: displays the whole dictionary\n"
                + "3. find <keyword>: returns a new list of tasks containing the matching keyword in the task description\n"
                + "4. bye: displays a goodbye message. \n" +
                "Start setting up your profile on the app if you haven't already!" +
                " Click on the profile icon on the top right corner to begin!";
    }

    public static String printError() {
        return "Sorry friend, I don't know what this means :( Type 'help' to find out more " +
                "about the app!";
    }

    public static String printEmptyInput() {
        return "Sorry, the term cannot be empty. Type 'help' " +
                "to find out more about the app!";
    }

    public static String printList() {
        return dict.listTerms();
    }

    public static String printDefinition(String term) {
        return dict.defineTerm(term);
    }

    public static String printBye() {
        return "Goodbye! Hope to see you again!";
    }
}
