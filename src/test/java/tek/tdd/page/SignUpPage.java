package tek.tdd.page;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class SignUpPage extends SeleniumUtility {
  public SignUpPage(){
      PageFactory.initElements(getDriver(),this);
  }
  @FindBy(name = "name") public WebElement nameInput;
  @FindBy(name = "email") public WebElement emailInput;
  @FindBy(name = "password") public WebElement passwordInput;
  @FindBy(name = "confirmPassword") public WebElement confirmPassword;
  @FindBy(id = "signupBtn") public WebElement signUpButton;
  @FindBy(className = "error") public WebElement signUpError;
  @FindBy(id = "nameError") public WebElement nameError;
  @FindBy(id = "emailError") public WebElement emailError;
  @FindBy(id = "passwordError") public WebElement passwordError;
  @FindBy(id = "confirmPasswordError") public WebElement confirmPasswordError;

  public void fillUpCreateAccountForm(String name, String email, String password){
      sendText(nameInput,name);
      sendText(emailInput,email);
      sendText(passwordInput,password);
      sendText(confirmPassword,password);
      clickOnElement(signUpButton);
  }
}
