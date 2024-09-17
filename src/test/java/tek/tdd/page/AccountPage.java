package tek.tdd.page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import tek.tdd.utility.SeleniumUtility;

public class AccountPage extends SeleniumUtility {
    public AccountPage(){
        PageFactory.initElements(getDriver(),this);

    }
    @FindBy(xpath="//*[@class='account__information-username']")
    public WebElement accountProfile;

}
