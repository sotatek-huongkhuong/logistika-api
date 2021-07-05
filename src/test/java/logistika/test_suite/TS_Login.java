package logistika.test_suite;

import logistika.base.Base_Test;
import logistika.constants.Account_Constans;
import logistika.microservices.login.steps.Login_Steps;
import org.testng.annotations.Test;
public class TS_Login extends Base_Test {

    @Test
    public void do_not_Enter_Password() {
        Login_Steps loginSteps = new Login_Steps();
        loginSteps.when_Login(Account_Constans.USERNAME_LOGISTIKA, "")
                .verifyStatusCode(400)
                .verifyError("Bad Request")
                .verifyMessage("[Password must be 8 or more characters with at least one number, one symbol, password must be longer than or equal to 8 characters, password should not be empty]")
                .printmessage();
    }

    @Test
    public void enter_Wrong_Password() {
        Login_Steps loginSteps = new Login_Steps();
        loginSteps.when_Login(Account_Constans.USERNAME_LOGISTIKA, "Logita1@")
                .verifyStatusCode(400)
                .verifyMessage("Incorrect username or password.")
                .verifyError("Bad Request");
    }

    @Test
    public void enter_Password_With_Length_Less_Than_8() {
        Login_Steps loginSteps = new Login_Steps();
        loginSteps.when_Login(Account_Constans.USERNAME_LOGISTIKA, "Logisti")
                .verifyStatusCode(400)
                .verifyError("Bad Request")
                .verifyMessage("[Password must be 8 or more characters with at least one number, one symbol, password must be longer than or equal to 8 characters]")
                .printmessage();
    }

    @Test
    public void login_Successfully() {
        Login_Steps loginSteps = new Login_Steps();
        loginSteps.when_Login(Account_Constans.USERNAME_LOGISTIKA, Account_Constans.PASSWORD_LOGISTIKA)
                .verifyStatusCode(200)
                .verifyTokenType("Bearer")
                .verifyUserID(Account_Constans.USERID_LOGISTIKA);
    }

    @Test
    public void enter_Do_not_Exist_Email() {
        Login_Steps loginSteps = new Login_Steps();
        loginSteps.when_Login("anyemai@gmail.com", Account_Constans.PASSWORD_LOGISTIKA)
                .verifyStatusCode(400)
                .verifyMessage("Incorrect username or password.")
                .verifyError("Bad Request");
    }

    @Test
    public void do_not_Enter_Email_and_Password() {
        Login_Steps loginSteps = new Login_Steps();
        loginSteps.when_Login("", "")
                .verifyStatusCode(400)
                .verifyError("Bad Request")
                .verifyMessage("[username must be an email, username should not be empty, Password must be 8 or more characters with at least one number, one symbol, password must be longer than or equal to 8 characters, password should not be empty]")
                .printmessage();
    }
    @Test
    public void enter_Invalid_Email()
    {
        Login_Steps loginSteps = new Login_Steps();
        loginSteps.when_Login("qqqqqqaaaaa", Account_Constans.PASSWORD_LOGISTIKA)
                .verifyStatusCode(400)
                .verifyError("Bad Request")
                .verifyMessage("[username must be an email]")
                .printmessage();
    }
}
