package playground;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class MyFirstTest {
    @BeforeMethod
    public void runBeforeTest(){
        System.out.println("This is before test");
    }

    @Test
    public void myFirstTestMethod(){
        System.out.println("Hello world");
    }

    @AfterMethod
    public void runAfterEachTestMethod(){
        System.out.println("This is running after each test");
    }

    @Test
    public void mySecondTestMethod(){
        System.out.println("The second test");
    }
}
