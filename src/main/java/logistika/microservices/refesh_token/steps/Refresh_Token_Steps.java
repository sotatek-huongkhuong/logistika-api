package logistika.microservices.refesh_token.steps;

import io.restassured.response.Response;
import logistika.constants.Link_Constants;
import logistika.core.BaseAPI;
import logistika.microservices.login.models.Login_Input;
import logistika.microservices.login.models.Login_OutputFail;
import logistika.microservices.login.steps.Login_Steps;
import logistika.microservices.refesh_token.models.Refresh_Token_Input;

import static org.junit.Assert.assertEquals;

public class Refresh_Token_Steps extends BaseAPI {
    Response response;

    public Refresh_Token_Steps when_Refresh_Token(String refreshToken, String userID) {
        Refresh_Token_Input refresh_token_input = new Refresh_Token_Input(refreshToken,userID);
        response = sendPost(Link_Constants.URL_LOGIN, refresh_token_input);
        return this;
    }

    public Refresh_Token_Steps verifyStatusCode(int statuscode) {
        validateStatusCode(statuscode, response);
        return this;
    }

    public Refresh_Token_Steps verifyMessage(String Message) {
        assertEquals(getJsonValue("message", response), Message);
        return this;
    }

    public Refresh_Token_Steps verifyError(String error) {
        assertEquals(getJsonValue("error", response), error);
        return this;
    }

}
