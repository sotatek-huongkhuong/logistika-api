package logistika.test_suite;

import logistika.constants.Account_Constans;
import logistika.microservices.login.steps.Login_Steps;
import logistika.microservices.logout.steps.Logout_Steps;
import org.testng.annotations.Test;

public class TS_Logout {
    @Test
    public void successful_Logout()
    {
        Logout_Steps logoutSteps =  new Logout_Steps();
        logoutSteps.setAuthorization(Account_Constans.USERNAME_LOGISTIKA,Account_Constans.PASSWORD_LOGISTIKA)
                .when_Logout()
                .verifyStatusCode(200)
                .verifyMessage("successfully logged out");

    }
    @Test
    public void logout_Failed()
    {
        Logout_Steps logoutSteps =  new Logout_Steps();
        logoutSteps.setAuthorization(Account_Constans.USERNAME_LOGISTIKA,Account_Constans.PASSWORD_LOGISTIKA)
                .when_Logout()
                .verifyStatusCode(200)
                .verifyMessage("successfully logged out")
                .when_Logout()
                .verifyStatusCode(401)
                .verifyMessage("Unauthorized");

    }
}
