package TestCases;

import BaseClass.Base;
import ConfigurationClass.ConfigurationData;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WindowHandlingTest extends Base {
    List<WebElement> productList;
    @Test
    void searchProduct(){
        WebElement searchInput=driver.findElement(By.cssSelector("input[placeholder^='Search']"));
        searchInput.sendKeys(ConfigurationData.productToBeSearch()+ Keys.ENTER);
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElements(driver.findElements(By.cssSelector("ul[class$='results-base']>li[class^='product'] a"))));
        productList=driver.findElements(By.cssSelector("ul[class$='results-base']>li[class^='product'] a"));
        for(int i=0;i<5;i++)
        {
            productList.get(i).click();
        }
    }

    @Test
    void windowHandle(){
        StringBuffer targetPageURL=new StringBuffer(productList.get(3).getAttribute("href"));
        Set<String> windowHandles=driver.getWindowHandles();
        Iterator<String> it=windowHandles.iterator();
        while(it.hasNext()){
            driver.switchTo().window(it.next());
            if(driver.getCurrentUrl().contentEquals(targetPageURL)) break;
        }
        System.out.println("Page we were looking for:"+targetPageURL);
        System.out.println(("Page we get:"+driver.getCurrentUrl()+"\n"+driver.getTitle()));

    }
}
