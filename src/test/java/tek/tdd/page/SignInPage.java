package tek.tdd.page;

import com.aventstack.extentreports.service.ExtentTestManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class SignInPage extends SeleniumUtility {
    public SignInPage(){
        PageFactory.initElements(getDriver(),this);
    }
 //   @FindBy(name = "email")
    @FindBy(id = "email")
    public WebElement emailInput;
 //   @FindBy(name = "password")
    @FindBy(id = "password")
    public WebElement passwordInput;
 //   @FindBy(id = "loginBtn")
    @FindBy(id = "loginBtn")
    public WebElement loginButton;
    @FindBy(className = "error")
    public WebElement errorMessage;
    @FindBy(className = "account__information-email")
    public WebElement AccountLink;
    @FindBy(linkText = "Create New Account")
    public WebElement createNewAccountLink;

    public void doSignIn(String email, String password){
        ExtentTestManager.getTest().info("Sign in with " +email + " - and "+password);
    sendText(emailInput,email);
    sendText(passwordInput,password);
    clickOnElement(loginButton);
    }

}
