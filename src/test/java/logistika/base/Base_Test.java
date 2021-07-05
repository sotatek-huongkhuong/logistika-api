package logistika.base;

import io.restassured.RestAssured;
import logistika.core.BaseAPI;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;

public class Base_Test {
    @BeforeClass(alwaysRun = true)
    public void initReqSpec(){
        BaseAPI.initReqSpec();
    }

    @AfterSuite(alwaysRun = true)
    public void postconditions() {
        //AllureUtils.addAllureProperties();
        RestAssured.reset();
    }
}
