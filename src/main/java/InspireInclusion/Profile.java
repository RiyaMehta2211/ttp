package InspireInclusion;

import java.io.Serializable;

/**
 * The Profile class is responsible for creating and grouping instances of profiles.
 * This profile instances will be written and read
 * to and from the profile data file.
 */
public class Profile implements Serializable{
    private static final long serialVersionUID = 1L;

    private String name;
    private String email;
    private String profileImagePath;

    public Profile(String name, String email, String profileImagePath) {
        this.name = name;
        this.email = email;
        this.profileImagePath = profileImagePath;
    }

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getProfileImagePath() {
        return profileImagePath;
    }

    public void setProfileImagePath(String profileImagePath) {
        this.profileImagePath = profileImagePath;
    }
}
