package logistika.microservices.fogot_password.models;

public class Forgot_Password_Input {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Forgot_Password_Input() {
    }

    private String   username;
}
