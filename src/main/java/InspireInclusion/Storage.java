package InspireInclusion;

import java.io.*;
import java.util.HashMap;

/**
 * The Storage class is responsible for reading and writing credentials
 * to and from the userCredentials.txt file.
 */
public class Storage{
    private static final String PASSWORD_FILE = "userCredentials.txt";

    // Save user credentials to a file
    public static void saveCredentials(HashMap<String, String> userCredentials) throws IOException {
        try (ObjectOutputStream file = new ObjectOutputStream(new FileOutputStream(PASSWORD_FILE))) {
            file.writeObject(userCredentials);
        }
    }

    // Load user credentials from a file
    @SuppressWarnings("unchecked")
    public static HashMap<String, String> loadCredentials() throws IOException, ClassNotFoundException {
        try (ObjectInputStream file = new ObjectInputStream(new FileInputStream(PASSWORD_FILE))) {
            return (HashMap<String, String>) file.readObject();
        }
    }
}

