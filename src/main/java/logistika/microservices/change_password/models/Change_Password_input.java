package logistika.microservices.change_password.models;

public class Change_Password_input
{
    public Change_Password_input() {
    }

    public Change_Password_input(String username, String password, String newPassword, String comfirmPassword) {
        this.username = username;
        this.password = password;
        this.newPassword = newPassword;
        this.comfirmPassword = comfirmPassword;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getComfirmPassword() {
        return comfirmPassword;
    }

    public void setComfirmPassword(String comfirmPassword) {
        this.comfirmPassword = comfirmPassword;
    }

    private String username, password,  newPassword, comfirmPassword;

}
