package logistika.microservices.fogot_password.models;

public class forgot_passwordInput {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public forgot_passwordInput() {
    }

    private String   username;
}
