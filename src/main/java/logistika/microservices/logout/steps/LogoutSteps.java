package logistika.microservices.logout.steps;

import logistika.constants.linkConstants;
import logistika.core.baseAPI;
import io.restassured.response.Response;

import static org.junit.Assert.assertEquals;

public class LogoutSteps extends baseAPI {
    Response res;

    public LogoutSteps Logout(String authorization) {
        setHeader("authorization", authorization);
        res = sendGet(linkConstants.URL_LOGOUT);
        return this;
    }

    public LogoutSteps verifyStatusCode(int code) {
        validateStatusCode(code, res);
        return this;
    }
public void printres()
{
    System.out.print(res.asString());
}
    public LogoutSteps verifyMessage(String message) {
        assertEquals(getJsonValue("message", res), message);
        return this;
    }

    public LogoutSteps verifyName(String name) {
        assertEquals(getJsonValue("name", res), name);
        return this;
    }
}
