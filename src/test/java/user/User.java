package user;

public class User {
    private String email;
    private String password;

    public User(String email, String password) {
        this.email = email;
        this.password = password;
        if (email == null || password == null) {
            throw new IllegalArgumentException("Email и пароль не могут быть null");
        }
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
