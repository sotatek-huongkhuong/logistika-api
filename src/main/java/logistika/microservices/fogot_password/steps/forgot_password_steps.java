package logistika.microservices.fogot_password.steps;

import io.restassured.response.Response;
import logistika.constants.Link_Constants;
import logistika.core.BaseAPI;
import logistika.microservices.fogot_password.models.Forgot_Password_Input;

import static org.junit.Assert.assertEquals;

public class Forgot_Password_steps extends BaseAPI {
    Response res;
    public Forgot_Password_steps when_Forgot_Password(String username)
    {
        Forgot_Password_Input forgot_passwordInput= new Forgot_Password_Input();
        forgot_passwordInput.setUsername(username);
        res= sendPost(Link_Constants.URL_FORGOT_PASSWORD,forgot_passwordInput);
        return this;
    }
    public Forgot_Password_steps verifyStatusCode(int status)
    {
        validateStatusCode(status,res);
        return this;
    }
    public Forgot_Password_steps verifyMessage(String message)
    {
        assertEquals(getJsonValue("message", res), message);
        return this;
    }
    public Forgot_Password_steps verifyError(String error)
    {
        assertEquals(getJsonValue("error", res), error);
        return this;
    }

}
