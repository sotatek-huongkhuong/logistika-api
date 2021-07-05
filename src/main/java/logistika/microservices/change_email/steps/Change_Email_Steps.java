package logistika.microservices.change_email.steps;

import io.restassured.response.Response;
import logistika.constants.Link_Constants;
import logistika.core.BaseAPI;
import logistika.microservices.change_email.models.Change_Email_Input;
import logistika.microservices.login.steps.Login_Steps;
import logistika.microservices.logout.steps.Logout_Steps;

import static org.junit.Assert.assertEquals;

public class Change_Email_Steps extends BaseAPI {
    Response res;
    public Change_Email_Steps setAuthorization(String username, String password)
    {
        Login_Steps loginSteps= new Login_Steps();
        String token= loginSteps.when_Login(username,password)
                .getToken();
        setHeader("authorization", token);
        return this;
    }
    public Change_Email_Steps when_ResetPassword(String  user_name,String newEmail)
    {
        Change_Email_Input change_email_input = new Change_Email_Input(user_name, newEmail);
        res = sendPut(Link_Constants.URL_LOGOUT,change_email_input);
        return this;
    }
    public Change_Email_Steps verifyStatusCode(int code) {
        validateStatusCode(code, res);
        return this;
    }
    public Change_Email_Steps verifyMessage(String message) {
        assertEquals(getJsonValue("message", res), message);
        return this;
    }
    public Change_Email_Steps verifyError(String name) {
        assertEquals(getJsonValue("name", res), name);
        return this;
    }
    public void printAll()
    {
        System.out.print( res.asString());
    }
}
