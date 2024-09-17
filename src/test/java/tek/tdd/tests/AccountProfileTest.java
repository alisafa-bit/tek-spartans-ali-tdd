package tek.tdd.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import tek.tdd.base.UIBaseClass;

public class AccountProfileTest extends UIBaseClass {
 /*--> Story5: Navigate to retail app and login with your credential, Navigate to account page
 and update Name and Phone number.  Validate your number and Name Updated.
 Validate Success toast message displayed.
  */
    @Test
    public void updatePersonalInfoTest() throws InterruptedException {
        validCredentialSignIn();

        clickOnElement(homePage.accountLink);

        accountProfilePage.updateNameAndPhone("alisafa" , "1425361425");

        boolean isToastDisplayed = isElementDisplayed(homePage.toastBody);
        Assert.assertTrue(isToastDisplayed, "Toast Should display");

        String actualUserName = getElementText(accountProfilePage.accountUserNameText);
        Assert.assertEquals(actualUserName, "alisafa");
        Thread.sleep(6000);
        //We are doing reset after this line to name and phone number

        accountProfilePage.updateNameAndPhone("arash" , "2023233635");
        Thread.sleep(1000);
        String actualUserNameReset = getElementText(accountProfilePage.accountUserNameText);
        Assert.assertEquals(actualUserNameReset, "arash");


    }




}

