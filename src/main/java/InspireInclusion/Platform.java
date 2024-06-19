package InspireInclusion;

import InspireInclusion.ui.Ui;

import java.util.Scanner;

/**
 * The Platform class can be used to initialize an instance of the platform.
 */

public class Platform{

    /**
     * Initiates interaction with the platform
     * This method prompts the user and takes in their input.
     */
    public void platformInteraction() {
        Ui.printWelcome();
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        scanner.close();
    }
    public static void main(String[] args) {
        Platform platform = new Platform();
        platform.platformInteraction();
    }
    public String getResponse(String input) {
        return Parser.chat(input);
    }
}

