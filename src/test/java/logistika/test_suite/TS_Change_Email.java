package logistika.test_suite;

import logistika.constants.Account_Constans;
import logistika.microservices.change_email.steps.Change_Email_Steps;
import org.testng.annotations.Test;

public class TS_Change_Email {
  @Test
  public void enter_Invalid_New_Email()
  {
    Change_Email_Steps change_email_steps = new Change_Email_Steps();
    change_email_steps.setAuthorization(Account_Constans.USERNAME_LOGISTIKA, Account_Constans.PASSWORD_LOGISTIKA)
            .when_ResetPassword(Account_Constans.USERNAME_LOGISTIKA,"huongkhuong")
            .verifyStatusCode(400)
            .verifyMessage("newEmail must be an email")
            .when_ResetPassword(Account_Constans.USERNAME_LOGISTIKA,"huongkhuong@gmail")
            .verifyStatusCode(400)
            .verifyMessage("newEmail must be an email")
            .when_ResetPassword(Account_Constans.USERNAME_LOGISTIKA,"huongkhuong1gmail.com")
            .verifyStatusCode(400)
            .verifyMessage("newEmail must be an email");
  }
  @Test
  public void enter_Username_Do_Not_Exist_In_DB()
  {
    Change_Email_Steps change_email_steps = new Change_Email_Steps();
    change_email_steps.setAuthorization(Account_Constans.USERNAME_LOGISTIKA, Account_Constans.PASSWORD_LOGISTIKA)
            .when_ResetPassword("huongkhong1@gmail.com", "huongkhuong.it@gmail.com")
            .verifyStatusCode(400)
            .verifyMessage("User name is not exist");
  }
  @Test
  public void successful_Change_Email()
  {
    Change_Email_Steps change_email_steps = new Change_Email_Steps();
    change_email_steps.setAuthorization(Account_Constans.USERNAME_LOGISTIKA, Account_Constans.PASSWORD_LOGISTIKA)
            .when_ResetPassword(Account_Constans.USERNAME_LOGISTIKA, "huongkhuong.it@gmail.com")
            .verifyStatusCode(200)
            .verifyMessage("Email has changed successfully");
  }
}
