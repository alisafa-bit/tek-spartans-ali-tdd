package tek.tdd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;

public class BasicSetupTest extends UIBaseClass {

    private void validateLogo(){
       // HomePage homePage = new HomePage();
        String actualLogoText = getElementText(homePage.topLeftLogo);
        Assert.assertEquals(actualLogoText,"TEKSCHOOL", "TekSchool logo is present");
    }

    @Test
    public void validateTopLeftCornerLogo(){
        validateLogo();
    }
    //Activity--> Navigate to retail app and make sure top-left corner text in TEKSCHOOL
    //and make sure Sign in button is enabled.

    @Test
    public void testingLoggingBtnAndLogo(){
       validateLogo();
       //HomePage homePage = new HomePage
       boolean isEnabled = isElementEnabled(homePage.signInLink);
       Assert.assertTrue(isEnabled,"Sign in button be enabled");
    }
}
