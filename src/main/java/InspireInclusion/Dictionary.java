package InspireInclusion;

import java.io.*;
import java.util.Objects;
import java.util.Properties;

public class Dictionary {
    private Properties properties = new Properties();
    InputStream inputStream = Objects.requireNonNull(this.getClass().getResourceAsStream("/dictionary/dict.properties"));
    public Dictionary() {
        try {
            properties.load(inputStream);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public String listTerms() {
        return properties.stringPropertyNames().toString();
    }

    public String defineTerm(String term) {
        String new_term = term.toLowerCase().replace(" ","");
        for(String key: properties.stringPropertyNames()) {
            if (key.toLowerCase().contains(new_term)) {
                return key + ": " + properties.getProperty(key);
            }
        }
        return "Term not found in the dictionary";
    }
}
