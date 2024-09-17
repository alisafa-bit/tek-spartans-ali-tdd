package tek.tdd.api.test;

import com.aventstack.extentreports.service.ExtentTestManager;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.api.models.EndPoints;
import tek.tdd.base.ApiTestBase;

public class GetPrimaryAccountTest extends ApiTestBase {

    @Test
    public void getAccountAndValidate(){
        RequestSpecification requestSpecification = getDefaultRequest();
        requestSpecification.queryParam("primaryPersonId",1194);
        Response response = requestSpecification.when().get(EndPoints.GET_PRIMARY_ACCOUNT.getValue());
        response.then().statusCode(200);
        response.prettyPrint();
        String actualEmail = response.jsonPath().getString("email");

        ExtentTestManager.getTest().info(response.asPrettyString());

        Assert.assertEquals(actualEmail, "ShadabAli147@gmail.com");
    }
    //
}
