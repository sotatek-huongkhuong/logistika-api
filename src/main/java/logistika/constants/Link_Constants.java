package logistika.constants;

public class Link_Constants {
    private final static String BASE_URL="https://api.dev.logistika.com.my";
    public final static String URL_LOGIN=BASE_URL+"/api/authenticate/login";
    public final static String URL_LOGOUT=BASE_URL+"/api/authenticate/logout";
    public final static String URL_FORGOT_PASSWORD=BASE_URL+"/api/authenticate/forgot-password";
    public final static String URL_RESET_PASSWORD=BASE_URL+"/api/authenticate/reset-password";
    public final static String URL_CHANGE_PASSWORD=BASE_URL+"/api/authenticate/change-password";
    public final static String URL_CHANGE_EMAIL=BASE_URL+"/api/authenticate/change-email";
    public final static String URL_REFRESH_TOKEN=BASE_URL+"/api/authenticate/refresh-token";
    public final static String URL_TOKEN=BASE_URL+"/api/authenticate/token";
}
