package logistika.microservices.change_password.steps;

import io.restassured.response.Response;
import logistika.constants.Link_Constants;
import logistika.core.BaseAPI;
import logistika.microservices.change_password.models.Change_Password_input;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Change_Password_Steps extends BaseAPI {
    Response res;
    public Change_Password_Steps when_ResetPassword(String authorization, Change_Password_input change_password_input)
    {
        setHeader("authorization", authorization);
        res = sendPut(Link_Constants.URL_LOGOUT,change_password_input);
        return this;
    }
    public Change_Password_Steps verifyStatusCode(int code) {
        validateStatusCode(code, res);
        return this;
    }
    public Change_Password_Steps verifyMessage(String message) {
        assertEquals(getJsonValue("message", res), message);
        return this;
    }
    public Change_Password_Steps verifyError(String name) {
        assertEquals(getJsonValue("name", res), name);
        return this;
    }
    public void printAll()
    {
        System.out.print( res.asString());
    }
}
