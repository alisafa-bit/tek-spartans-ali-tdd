package playground;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Activity1 {
    //Write to navigate to facebook.com and print the Title.
    ChromeDriver driver = new ChromeDriver();

    @Test
    public void openChromeBrowser(){
        driver.get("https://www.facebook.com/");
        driver.getTitle();

    }
    @BeforeMethod
    public void BeforeMethod(){
        System.out.println("I am hoping getting ahead of class");
    }
}
