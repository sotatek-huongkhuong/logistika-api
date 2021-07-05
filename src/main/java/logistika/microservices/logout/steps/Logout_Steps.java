package logistika.microservices.logout.steps;

import logistika.constants.Account_Constans;
import logistika.constants.Link_Constants;
import logistika.core.BaseAPI;
import io.restassured.response.Response;
import logistika.microservices.login.steps.Login_Steps;

import static org.junit.Assert.assertEquals;

public class Logout_Steps extends BaseAPI {
    Response res;

    public Logout_Steps setAuthorization(String username, String password)
    {
        Login_Steps loginSteps= new Login_Steps();
        String token= loginSteps.when_Login(username,password)
                .getToken();
        setHeader("authorization", token);
        return this;
    }
    public Logout_Steps when_Logout() {

        res = sendGet(Link_Constants.URL_LOGOUT);
        return this;
    }

    public Logout_Steps verifyStatusCode(int code) {
        validateStatusCode(code, res);
        return this;
    }
//public void printres()
//{
//    System.out.print(res.asString());
//}
    public Logout_Steps verifyMessage(String message) {
        assertEquals(getJsonValue("message", res), message);
        return this;
    }

    public Logout_Steps verifyError(String name) {
        assertEquals(getJsonValue("name", res), name);
        return this;
    }
}
