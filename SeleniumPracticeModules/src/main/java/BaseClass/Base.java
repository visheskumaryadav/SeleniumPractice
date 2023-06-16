package BaseClass;

import ConfigurationClass.ConfigurationData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class Base {
    protected WebDriver driver;
    @BeforeClass
    public void launchBrowser(){
        ConfigurationData.setConfiguration();
        if(ConfigurationData.getBrowserName().equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
            driver.get(ConfigurationData.getURL());
            driver.manage().window().maximize();
        }
        else if(ConfigurationData.getBrowserName().equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
            driver.get(ConfigurationData.getURL());
            driver.manage().window().maximize();
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
