package BaseClass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LaunchBrowser {
   private WebDriver driver;

   public WebDriver setUp(String url){
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        return driver;
    }


    public void tearDown(){ driver.close(); }
}
