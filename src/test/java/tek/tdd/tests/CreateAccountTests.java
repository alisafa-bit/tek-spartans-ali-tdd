package tek.tdd.tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;
import tek.tdd.utility.DataGenerator;

public class CreateAccountTests extends UIBaseClass {
@Test
    public void createNewAccountTestPositive(){
        clickOnElement(homePage.signInLink);
        clickOnElement(signInPage.createNewAccountLink);
        String expectedEmail = DataGenerator.generateRandomEmail("ali");
        signUpPage.fillUpCreateAccountForm("ali", expectedEmail,"Password@123");
        String actualEmail = getElementText(accountProfilePage.accountEmailInfo);
        Assert.assertEquals(actualEmail,expectedEmail, "should matched");
    }
/* Navigate to Create Account page and Create new Account with existing email and
validate error message "this email is already exist, please use another email address"
 */
    @Test
    public void createNewAccountWithExistingEmail(){
        clickOnElement(homePage.signInLink);
        clickOnElement(signInPage.createNewAccountLink);
        signUpPage.fillUpCreateAccountForm("ali","alisafaa@gmail.com","Password@123");
        String actualError = getElementText(signUpPage.signUpError);
        Assert.assertEquals(actualError,"this email is already exist, please use another email address");
    }
    /*Story# 4.2  -->   Navigate to Create new Account page and click sign up button without
    filling the form Validate all errors on all fields. */
    @Test
    public void validateFieldError(){
        clickOnElement(homePage.signInLink);
        clickOnElement(signInPage.createNewAccountLink);
        clickOnElement(signUpPage.signUpButton);
        String actualNameError = getElementText(signUpPage.nameError);
        Assert.assertEquals(actualNameError,"Name is a required field");
        String actualEmailError = getElementText(signUpPage.emailError);
        Assert.assertEquals(actualEmailError,"Email is a required field");
        String actualPasswordError = getElementText(signUpPage.passwordError);
        Assert.assertEquals(actualPasswordError,"Password is a required field");
        String actualConfirmPasswordError = getElementText(signUpPage.confirmPasswordError);
        Assert.assertEquals(actualConfirmPasswordError,"Confirm Password is a required field");
        clickOnElement(signUpPage.signUpButton);
    }
}
