package logistika.test_suite;

import logistika.constants.Account_Constans;
import logistika.microservices.fogot_password.steps.Forgot_Password_steps;
import org.testng.annotations.Test;

public class TS_Forgot_Password {
    @Test
    public void enter_Invalid_Email()
    {
        Forgot_Password_steps forgot_password_steps = new Forgot_Password_steps() ;
        forgot_password_steps.when_Forgot_Password("huongkhuong")
                .verifyStatusCode(400)
                .verifyMessage("username must be an email")
                .verifyError("Bad Request");
    }
    @Test
    public void enter_Email_Do_Not_Exist_In_DB()
    {
        Forgot_Password_steps forgot_password_steps = new Forgot_Password_steps() ;
        forgot_password_steps.when_Forgot_Password("huongkhuong@gmail.com")
                .verifyStatusCode(404)
                .verifyMessage("User not found")
                .verifyError("Not Found");
    }
    @Test
    public void enter_valid_Email_And_Exist_in_the_DB()
    {
        Forgot_Password_steps forgot_password_steps = new Forgot_Password_steps() ;
        forgot_password_steps.when_Forgot_Password(Account_Constans.USERNAME_LOGISTIKA)
                .verifyStatusCode(200)
                .verifyMessage("Check your email for reset instructions");
    }
}
