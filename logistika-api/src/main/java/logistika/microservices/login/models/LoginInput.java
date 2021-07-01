package logistika.microservices.login.models;

public class LoginInput {
    protected String username;
    protected String password;
    public LoginInput(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
