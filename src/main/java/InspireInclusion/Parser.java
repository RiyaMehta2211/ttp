package InspireInclusion;

import InspireInclusion.ui.Ui;
import java.util.Timer;
import java.util.TimerTask;

public class Parser {

    /**
     * Default constructor to initialize the Parser class.
     */
    public Parser() {
    }
    static Timer timer = new Timer();
    /**
     * Parses user input and executes .
     *
     * @param str The user input string.
     */
    static boolean question_asked = false;
    public static String chat(String str) {
        if (str.equals("A") && question_asked) {
            return Ui.printWin();
        }
        if ((str.equals("B") || str.equals("C") || str.equals("D")) && question_asked) {
            return Ui.printLoss();
        }
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
        } else if (str.equals("quiz")) {
            return Ui.printQuizRules();
        } else if (str.equals("start")) {
            question_asked = true;
            return Ui.printQuizQuestionOne();
        } else if (str.equals("play music")) {
            return Ui.playSound();
        } else if (str.equals("stop music")) {
            return Ui.stopSound();
        } else if (str.equals("pause music")) {
            return Ui.pauseSound();
        } else if (str.equals("resume music")) {
            return Ui.resumeSound();
        }
        else {
            return Ui.printError();
        }
    }
}
