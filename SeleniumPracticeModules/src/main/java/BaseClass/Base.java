package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import ConfigurationClass.ConfigurationData;

public class Base {
    protected WebDriver driver;
    
    @Parameters({"url"})
    @BeforeClass
    public void launchBrowser(String URL){
        ConfigurationData.setConfiguration();
        if(ConfigurationData.getBrowserName().equalsIgnoreCase("chrome")){
            driver=new ChromeDriver();
          //  driver.manage().window().maximize();
            driver.get(URL);

        }
        else if(ConfigurationData.getBrowserName().equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();
            driver.get(URL); 
            driver.manage().window().maximize();
        }
    }
    @AfterClass
    public void tearDown(){
        driver.quit();
    }
}
