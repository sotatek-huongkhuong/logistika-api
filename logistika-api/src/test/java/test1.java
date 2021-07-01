import logistika.microservices.login.models.LoginInput;
import logistika.microservices.login.models.LoginOutputFail;
import logistika.microservices.login.steps.LoginSteps;
import org.testng.annotations.Test;

public class test1 {
    @Test
    public void test(){
        LoginInput logininput= new LoginInput("huong.khuong@sotatek.com","Hello1sotatek!");
        LoginSteps loginSteps= new LoginSteps();
        loginSteps.When_login(logininput)
                .and_verifyStatusCode(201);
              //  .gettoken();

        //loginOutputFail=
      //  System.out.print(loginSteps.login(logininput));
    }
}
