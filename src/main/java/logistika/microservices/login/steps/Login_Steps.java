package logistika.microservices.login.steps;

import io.restassured.response.Response;
import logistika.constants.Link_Constants;
import logistika.core.BaseAPI;
import logistika.microservices.login.models.Login_Input;
import logistika.microservices.login.models.Login_OutputFail;

import static org.junit.Assert.assertEquals;

public class Login_Steps extends BaseAPI {

    Response response;

    public Login_Steps when_Login(String username,String  password) {
        Login_Input login_input= new Login_Input(username,password);
        response = sendPost(Link_Constants.URL_LOGIN, login_input);
        return this;
    }

    public Login_Steps verifyStatusCode(int statuscode) {

        validateStatusCode(statuscode, response);
        return this;
    }

    public String getToken() {
        return getJsonValue("id_token", response);
    }

    public Login_Steps verifyTokenType(String tokenType) {
        assertEquals(getJsonValue("token_type", response), tokenType);
        return this;
    }

    public Login_Steps verifyMessage(String Message) {
        assertEquals(getJsonValue("message", response), Message);
        return this;
    }
    public void printmessage()
    {
        System.out.print(getJsonValue("message", response));
    }

    public Login_Steps verifyError(String error) {
        assertEquals(getJsonValue("error", response), error);
        return this;
    }

    public Login_Steps verifyUserID(String user_id) {
        assertEquals(getJsonValue("user_id", response), user_id);
        return this;
    }
}
