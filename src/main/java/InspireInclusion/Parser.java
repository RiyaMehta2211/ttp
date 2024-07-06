package InspireInclusion;

import InspireInclusion.ui.Ui;
public class Parser {

    /**
     * Default constructor to initialize the Parser class.
     */
    public Parser() {
    }

    /**
     * Parses user input and executes .
     *
     * @param str The user input string.
     */
    public static String chat(String str) {
        if (str.equals("bye")) {
            return Ui.printBye();
        } else if (str.equals("help")) {
            return Ui.printHelp();
        } else if (str.equals("list")) {
            return Ui.printList();
        } else if (str.startsWith("find ")) {
            String term = str.substring(5);
            if (term.trim().isEmpty()) {
                return Ui.printEmptyInput();
            }
            else {
                return Ui.printDefinition(term);
            }
        } else {
            return Ui.printError();
        }
    }
}
