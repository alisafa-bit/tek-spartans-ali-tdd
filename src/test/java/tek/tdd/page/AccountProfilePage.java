package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class AccountProfilePage extends SeleniumUtility {
    public AccountProfilePage() {
        PageFactory.initElements(getDriver(),this);
    }
    @FindBy(className = "account__information-email") public WebElement accountEmailInfo;
    @FindBy(name = "name") public WebElement nameInput;
    @FindBy(name = "phoneNumber") public WebElement phoneNumberInput;
    @FindBy(id = "personalUpdateBtn") public WebElement personalUpdateButton;
    @FindBy(className = "account__information-username") public WebElement accountUserNameText;

    @FindBy(xpath="//*[@class='account__information-username']")
    public WebElement accountProfile;
    public void updateNameAndPhone(String name, String phone){
        sendText(nameInput,name);
        sendText(phoneNumberInput,phone);
        clickOnElement(personalUpdateButton);
    }


}
