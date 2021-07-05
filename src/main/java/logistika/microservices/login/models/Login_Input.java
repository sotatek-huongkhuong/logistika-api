package logistika.microservices.login.models;

public class Login_Input {
    protected String username;
    protected String password;
    public Login_Input(String username, String password) {
        this.username = username;
        this.password = password;
    }

}
