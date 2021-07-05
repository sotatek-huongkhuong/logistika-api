package logistika.microservices.change_email.models;

public class Change_Email_Input {
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewEmail() {
        return newEmail;
    }

    public void setNewEmail(String newEmail) {
        this.newEmail = newEmail;
    }

    public Change_Email_Input() {
    }

    public Change_Email_Input(String username, String newEmail) {
        this.username = username;
        this.newEmail = newEmail;
    }

    private String username, newEmail;
}
