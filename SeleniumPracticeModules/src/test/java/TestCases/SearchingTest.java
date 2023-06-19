package TestCases;

import BaseClass.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class SearchingTest extends Base {
    //li[@class='Y5N33s'][position()>1]
    //li[@class='Y5N33s'][position()>1]//a/div/div
    @Test
    void searchProductFromSuggestion() throws InterruptedException {
        boolean isLoginPopUpPresent=driver.findElement(By.xpath("//div[@class='_2Sn47c']//div[@class='_2QfC02']/button")).isDisplayed();
        System.out.println(":::::::::isLoginPopUpPresent:::::" + isLoginPopUpPresent);
        if(isLoginPopUpPresent)
            driver.findElement(By.xpath("//div[@class='_2Sn47c']//div[@class='_2QfC02']/button")).click();
        driver.findElement(By.cssSelector("div[class='_3OO5Xc']>input")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("ul[class*='_1MRYA1']")));
        List<WebElement> suggestions=driver.findElements(By.xpath("//li[@class='Y5N33s'][position()>1]"));
        System.out.println(":::::::suggestions:"+suggestions.size());
        for(WebElement e:suggestions)
        {
            if(e.getText().equalsIgnoreCase("mobiles")){
                e.click();break;
            }
        }

    }
}
