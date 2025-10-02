package user;

import utils.PropertyReader;

public class UserFactory {
    public static User withAdminPermission() {
        return new User(PropertyReader.getProperty("sandbox.user"),
                        PropertyReader.getProperty("sandbox.password"));
    }
}
