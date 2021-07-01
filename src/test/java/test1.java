import logistika.core.baseAPI;
import logistika.microservices.login.models.LoginInput;
import logistika.microservices.login.models.LoginOutputFail;
import logistika.microservices.login.steps.LoginSteps;
import logistika.microservices.logout.steps.LogoutSteps;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class test1 {
    @Test
    public void test() throws IOException {
        baseAPI.initReqSpec();
        LoginInput logininput= new LoginInput("huong.khuong@sotatek.com","Hello1sotatek!");
        LoginSteps loginSteps= new LoginSteps();
       String token= loginSteps
               .When_login(logininput)
               .and_verifyStatusCode(201).getToken();
        LogoutSteps logoutSteps= new LogoutSteps();
        logoutSteps.Logout(token)
                .verifyStatusCode(200).printres();

    }
    @AfterTest
    public void affer() throws IOException {
        Logger logger = Logger.getLogger(test1.class.getName());
        FileHandler fh;

        try {

            // This block configure the logger with handler and formatter
            fh = new FileHandler("C:/MyLogFile.log");
            logger.addHandler(fh);
            SimpleFormatter formatter = new SimpleFormatter();
            fh.setFormatter(formatter);

            // the following statement is used to log any messages
            logger.info("My first log");

        } catch (SecurityException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        logger.info("Hi How r u?");

    }

}
