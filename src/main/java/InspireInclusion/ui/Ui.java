package InspireInclusion.ui;
import InspireInclusion.Dictionary;
import InspireInclusion.Music;

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
                + "4. quiz: Explains the quiz rules on the MCQ questions\n"
                + "5. start: Starts the game quiz\n"
                + "6. play music: Starts playing music in the background from the beginning\n"
                + "7. stop music: Stops playing music\n"
                + "8. pause music: Pauses music at the current timeframe \n"
                + "9. resume music: Resumes music from the current timeframe \n"
                + "10. bye: displays a goodbye message. \n" +
                "Start setting up your profile on the app if you haven't already!" +
                " Click on the profile icon on the top right corner to begin!";
    }

    public static String printError() {
        return "Sorry friend, I don't know what this means :( Type 'help' to find out more " +
                "about the app!";
    }

    public static String printQuizRules() {
        return "Sure! Let's go. I will ask you an MCQ Question Of The Day on the definition of" +
                " the dictionary terms. Choose the most appropriate answer by typing 'A','B', 'C', 'D'.\n" +
                "Come back everyday, get the answer right, and maintain a daily streak! \n"+
                "Type 'start' to begin. Good luck!";
    }
    public static String printQuizQuestionOne() {
        return "Question 1: Which of the following is the definition of PeopleOfColor?\n" +
                "A. A collective term for men and women of Asian, African, Latinx and Native American backgrounds, as opposed to the collective ?White?. \n" +
                "B. An umbrella term that can refer to anyone who transgresses society?s view of gender or sexuality. The definitional indeterminacy of the word Queer, its elasticity, is one of its characteristics: ?A zone of possibilities.? \n" +
                "C. An inclusive term for those who identify as lesbian, gay, bisexual, transgender, queer, intersex, and asexual.\n" +
                "D. None of the above";
    }

    public static String printEmptyInput() {
        return "Sorry, the term cannot be empty. Type 'help' " +
                "to find out more about the app!";
    }

    public static String printLoss() {
        return "Sorry, you did not get it right :(. Try again tomorrow.";
    }
    public static String printWin() {
        return "Yes, you got it right :). Come back tomorrow to continue the streak!.";
    }

    public static String printList() {
        return dict.listTerms();
    }

    public static String printDefinition(String term) {
        return dict.defineTerm(term);
    }
    /*public static String printTermAdded(String term) {
        dict.addTerm(term);
        return term + " has been added to the dictionary";
    }*/

    public static String printBye() {
        return "Goodbye! Hope to see you again!";
    }
    public static String playSound() {
        Music.playMusic();
        return "playing music now";
    }
    public static String stopSound() {
        Music.stopMusic();
        return "music stopped";
    }

    public static String pauseSound() {
        Music.pauseMusic();
        return "music paused";
    }

    public static String resumeSound() {
        Music.resumeMusic();
        return "music resumed";
    }
}
