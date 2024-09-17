package tek.tdd.base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.service.ExtentTestManager;
import com.aventstack.extentreports.testng.listener.ExtentITestListenerClassAdapter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import tek.tdd.page.*;
import tek.tdd.utility.SeleniumUtility;

@Listeners({ExtentITestListenerClassAdapter.class})
public class UIBaseClass extends SeleniumUtility {
    private static final Logger LOGGER = LogManager.getLogger(UIBaseClass.class);
    public HomePage homePage;
    public SignInPage signInPage;
    public SignUpPage signUpPage;
    public AccountPage accountPage;
    public AccountProfilePage accountProfilePage;

    @BeforeMethod
    public void setupTests(){
    LOGGER.info("Setup test and opening browser");
    setupBrowser();
    homePage = new HomePage();
    accountPage = new AccountPage();
    signInPage = new SignInPage();
    accountProfilePage = new AccountProfilePage();
    signUpPage = new SignUpPage();
    }

    @AfterMethod
    public void testCleanUp(ITestResult result){
        if(result.getStatus()== ITestResult.FAILURE) {
            TakesScreenshot screenshot = (TakesScreenshot)getDriver();
            String shot = screenshot.getScreenshotAs(OutputType.BASE64);

            ExtentTestManager.getTest().fail("Test failed Taking screen shot",
                    MediaEntityBuilder.createScreenCaptureFromBase64String(shot).build());
        }
        LOGGER.info("Running after each test and closing browser");
        quitBrowser();
    }

    public void validCredentialSignIn(){
        clickOnElement(homePage.signInLink);
        signInPage.doSignIn("alisafaa@gmail.com","Password@123");
    }
}
