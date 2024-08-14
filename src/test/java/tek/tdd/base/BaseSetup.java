package tek.tdd.base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.time.Duration;
import java.util.Properties;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public abstract class BaseSetup {
    //Read Config File
    //Open Browser
    //Quit browser
    //Encapsulate instance of WebDriver
    private static final Logger LOGGER = LogManager.getLogger(BaseSetup.class);
    protected static final long WAIT_TIME_IN_SECOND = 25;

    private static WebDriver driver;
    private Properties properties;

    public BaseSetup(){
        //Reading config files and loading to properties
        String configFilePath = System.getProperty("user.dir")
                + "/src/test/resources/configs/dev-config.properties";

        try{
            LOGGER.debug("Reading Config file from path {}",configFilePath);
            InputStream inputStream = new FileInputStream(new File(configFilePath));
            properties = new Properties();
            properties.load(inputStream);
        }catch (IOException ioException){
            LOGGER.error("Config file error with message {}",ioException.getMessage());
            throw new RuntimeException("Config file error with message {}" + ioException.getMessage());
        }
    }

    public void setupBrowser(){
        String url = properties.getProperty("ui.url");
        String browserType = properties.getProperty("ui.browser");
        Boolean isHeadless = Boolean.parseBoolean(properties.getProperty("ui.browser.headless"));
        LOGGER.info("Opening on {} browser",browserType);
        LOGGER.info("Is Headless on {}",isHeadless);

        switch (browserType.toLowerCase()){
            case "chrome":
                ChromeOptions options = new ChromeOptions();
                if(isHeadless) options.addArguments("--headless");
                driver = new ChromeDriver(options);
                break;
            case "edge":
                EdgeOptions edgeOptions = new EdgeOptions();
                if (isHeadless) edgeOptions.addArguments("--headless");
                driver = new EdgeDriver(edgeOptions);
                break;
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) firefoxOptions.addArguments("--headless");
                driver = new FirefoxDriver(firefoxOptions);
                break;
            default:
                throw new RuntimeException("Wrong browser type, choose between chrome, firefox and edge.");
        }
        LOGGER.info("Navigating to URL{}",url);
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(WAIT_TIME_IN_SECOND));
    }

    public void quitBrowser(){
        if (driver!=null){
            LOGGER.info("Quiting the Browser");
            driver.quit();
        }
    }

    public WebDriver getDriver(){
        return driver;
    }
}
