package logistika.microservices.login.steps;

import io.restassured.response.Response;
import logistika.constants.linkConstants;
import logistika.core.baseAPI;
import logistika.microservices.login.models.LoginInput;
import logistika.microservices.login.models.LoginOutput;
import logistika.microservices.login.models.LoginOutputFail;

import static org.junit.Assert.assertEquals;

public class LoginSteps extends baseAPI {

    Response response;

    public LoginSteps When_login(LoginInput logininput) {
        LoginOutputFail loginOutputFail = new LoginOutputFail();
        response = sendPost(linkConstants.URL_LOGIN, logininput);//as(LoginOutputFail.class);
        return this;
    }

    public LoginSteps and_verifyStatusCode(int statuscode) {

        validateStatusCode(statuscode, response);
        return this;
    }

    public String getToken() {
        return getJsonValue("id_token", response);
    }

    public LoginSteps verifyTokenType(String tokenType) {
        assertEquals(getJsonValue("token_type", response), tokenType);
        return this;
    }

    public LoginSteps verifyMessage(String Message) {
        assertEquals(getJsonValue("message", response), Message);
        return this;
    }

    public LoginSteps verifyError(String error) {
        assertEquals(getJsonValue("error", response), error);
        return this;
    }

    public LoginSteps verifyUserID(String user_id) {
        assertEquals(getJsonValue("user_id", response), user_id);
        return this;
    }
}
