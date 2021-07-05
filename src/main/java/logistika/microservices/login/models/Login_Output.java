package logistika.microservices.login.models;

public class Login_Output {
    private String token_type;

    public String getToken_type() {
        return token_type;
    }

    public void setToken_type(String token_type) {
        this.token_type = token_type;
    }

    public String getId_token() {
        return id_token;
    }

    public void setId_token(String id_token) {
        this.id_token = id_token;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getExpiredIn() {
        return expiredIn;
    }

    public void setExpiredIn(String expiredIn) {
        this.expiredIn = expiredIn;
    }

    public String getRefresh_token() {
        return refresh_token;
    }

    public void setRefresh_token(String refresh_token) {
        this.refresh_token = refresh_token;
    }

    private String id_token;
    private String user_id;
    private String expiredIn;
    private String refresh_token;
    public Login_Output(String token_type, String id_token, String user_id, String expiredIn, String refresh_token) {
        this.token_type = token_type;
        this.id_token = id_token;
        this.user_id = user_id;
        this.expiredIn = expiredIn;
        this.refresh_token = refresh_token;
    }
    public Login_Output() {
    }

}
