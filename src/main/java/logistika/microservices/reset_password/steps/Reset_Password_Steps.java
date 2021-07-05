package logistika.microservices.reset_password.steps;

import io.restassured.response.Response;
import logistika.constants.Link_Constants;
import logistika.core.BaseAPI;
import logistika.microservices.logout.steps.Logout_Steps;
import logistika.microservices.reset_password.models.Reset_Password_Input;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

public class Reset_Password_Steps extends BaseAPI {
    Response res;
    public Reset_Password_Steps when_ResetPassword(String user_name, String confirmation_code , String newPassword ,String comfirmPassword)
    {
        Reset_Password_Input reset_password_input= new Reset_Password_Input(newPassword,comfirmPassword);
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("user_name",user_name);
        map.put("confirmation_code",confirmation_code);
        res = sendPostWithParams(Link_Constants.URL_RESET_PASSWORD,reset_password_input,map);
        return this;
    }
    public Reset_Password_Steps verifyStatusCode(int code) {
        validateStatusCode(code, res);
        return this;
    }
    public Reset_Password_Steps verifyMessage(String message) {
        assertEquals(getJsonValue("message", res), message);
        return this;
    }
    public Reset_Password_Steps verifyError(String name) {
        assertEquals(getJsonValue("name", res), name);
        return this;
    }
    public void printAll()
    {
        System.out.print( res.asString());
    }
}
