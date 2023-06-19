package TestCases;

import BaseClass.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class IframeHandlingTest extends Base {

    @Test
    void switchToIFrame(){
        WebElement frameElement=driver.findElement(By.cssSelector("#a077aa5e"));
        driver.switchTo().frame(frameElement);
        WebElement element=driver.findElement(By.xpath("html/body/a"));
        element.findElement(By.xpath(".//img")).click();
        System.out.println(element.getAttribute("href"));
        driver.switchTo().defaultContent();

    }

}
