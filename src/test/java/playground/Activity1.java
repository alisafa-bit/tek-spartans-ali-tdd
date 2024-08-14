package playground;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    //Write to navigate to facebook.com and print the Title.
    private WebDriver driver;

    @BeforeClass
    public void runBeforeTestClass(){
        System.out.println("This is only 1 time per test class");
    }
    @BeforeMethod
    public void setupTest() {
        driver = new ChromeDriver();
        driver.get("https://www.facebook.com/");
    }

    @Test
    public void testFacebookTitle() {
        String applicationTitle = driver.getTitle();
        Assert.assertEquals(applicationTitle, "Facebook - log in or sign up");
    }

    @AfterMethod
    public void cleanupTest() {
        driver.quit();
    }
}