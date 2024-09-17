package tek.tdd.tests;

import com.aventstack.extentreports.service.ExtentTestManager;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;

public class SecurityTest extends UIBaseClass {
    //Navigate to sign in page and sign in with valid username and password.
    //Validate user successfully signed in.

    @Test
    public void validateSignInOne(){
        clickOnElement(homePage.signInLink);

        ExtentTestManager.getTest().info("Sign in with credential");

        signInPage.doSignIn("alisafaa@gmail.com","Password@123");
        boolean isDisplayed = isElementDisplayed(homePage.accountLink);
        Assert.assertTrue(isDisplayed, "Looking for account Link to be displayed after login");
        }
    @Test
    public void validateSignIn() {
        clickOnElement(homePage.signInLink);
        signInPage.doSignIn("alisafaa@gmail.com","Password@123");

        boolean isDisplayed = isElementDisplayed(homePage.accountLink);
        Assert.assertTrue(isDisplayed, "Looking for account Link to be displayed after login");

        clickOnElement(homePage.accountLink);
        boolean isDisplayed1 = isElementDisplayed(accountPage.accountProfile);
        Assert.assertTrue(isDisplayed1,"Your Profile");
    }
    /*Story2: Navigate to sign in page and sign in with Invalid username valid password.
    Validate error message displays "wrong username or password".
    Story3: Navigate to sign in page and sign in with valid user and invalid password .
    Validate error message display "wrong username or password"
    push to your gitHub account
     */

    @Test(dataProvider = "invalidTestData")
    public void negativeSignInTests(String email, String password) {

        clickOnElement(homePage.signInLink);
        signInPage.doSignIn("msdnm87@gmail.com","Password@123");

        String actualMessage = getElementText(signInPage.errorMessage);
        Assert.assertEquals(actualMessage, "wrong username or password");
    }

    @DataProvider(name = "invalidTestData")
    private String[][] invalidTestData() {
         return new String[][] {
                {"mnzzm87@gmail.com", "Password@123"},
                {"Nomail@gmail.com", "Wrong@password"},
                {"mnm78@gmail.com", "password12345"}
        };
    }
}
