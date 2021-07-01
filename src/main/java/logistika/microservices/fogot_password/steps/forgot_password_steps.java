package logistika.microservices.fogot_password.steps;

import io.restassured.response.Response;
import logistika.constants.linkConstants;
import logistika.core.baseAPI;
import logistika.microservices.fogot_password.models.forgot_passwordInput;

import static org.junit.Assert.assertEquals;

public class forgot_password_steps extends baseAPI {
    Response res;
    public void when_forgot_password(String username)
    {
        forgot_passwordInput forgot_passwordInput= new forgot_passwordInput();
        forgot_passwordInput.setUsername(username);
        res= sendPost(linkConstants.URL_FORGOT_PASSWORD,forgot_passwordInput);
    }
    public forgot_password_steps validateStatusCode(int status)
    {
        validateStatusCode(status,res);
        return this;
    }
    public forgot_password_steps validateMessage(String message)
    {
        assertEquals(getJsonValue("message", res), message);
        return this;
    }

}
