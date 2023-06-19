package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import BaseClass.Base;

public class AlertHandlingTest extends Base {

	

    @Test
    void jsAlertTest(){
    	WebElement jsAlertBtn=driver.findElement(By.cssSelector("div[class='example'] ul>li:nth-of-type(1)>button"));
        jsAlertBtn.click();
        String alertPopUpText=driver.switchTo().alert().getText();
        System.out.println(alertPopUpText); driver.switchTo().alert().accept();
    	
    }
    @Test
    void jsConfirmationTest(){
        WebElement jsConfirmationBtn=driver.findElement(By.cssSelector("div[class='example'] ul>li:nth-of-type(2)>button"));
        jsConfirmationBtn.click();
        String confirmationPopUpText=driver.switchTo().alert().getText();
        System.out.println(confirmationPopUpText);
        driver.switchTo().alert().dismiss();
    }
    @Test
    void jsPromptTest(){
        WebElement jsPromptBtn=driver.findElement(By.cssSelector("div[class='example'] ul>li:nth-of-type(3)>button"));
        jsPromptBtn.click();
        String promptPopUpText=driver.switchTo().alert().getText();
        System.out.println(promptPopUpText);
        driver.switchTo().alert().sendKeys("TestUser123");
        driver.switchTo().alert().accept();

    }


}
