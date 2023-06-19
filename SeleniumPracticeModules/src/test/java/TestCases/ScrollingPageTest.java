package TestCases;

import BaseClass.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

public class ScrollingPageTest extends Base {

    @Test
    void scrollByAction() throws InterruptedException {
        WebElement targetPosition=driver.findElement(By.cssSelector("div[class='desktop-shopLinks']>a:nth-of-type(5)"));
        Actions scrollTo=new Actions(driver);
        scrollTo.moveToElement(targetPosition).perform();
        Thread.sleep(5000);
    }

}
