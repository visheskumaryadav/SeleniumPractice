package TestCases;

import BaseClass.LaunchBrowser;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;

import javax.swing.*;
import java.time.Duration;
import java.util.List;

public class AlertHandling {

    WebDriver driver;
    LaunchBrowser lb;
    @Parameters({"url"})
    @BeforeClass
    public void openPage(String url){
        lb=new LaunchBrowser();
        driver= lb.setUp(url);
    }

    @BeforeMethod
    public void openAlertScreen(){
        driver.findElement(By.linkText("JavaScript Alerts")).click();
    }
    @Test
    public void basicAlert(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".example>ul>li:first-of-type")));
        driver.findElement(By.cssSelector(".example>ul>li>button:first-of-type")).click();
        Alert alert=driver.switchTo().alert();
        String alertText=alert.getText();
        alert.dismiss();
        System.out.println(alertText);
    }

    @Test
    public void confirmAlert(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".example>ul>li")));

        driver.findElement(By.cssSelector("button[onclick='jsConfirm()']")).click();
        Alert alert=driver.switchTo().alert();
        alert.accept();
    }
    @Test
    public void inputAlert(){
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(5000));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".example>ul>li")));

        driver.findElement(By.cssSelector("button[onclick='jsPrompt()']")).click();
        Alert alert=driver.switchTo().alert();
        alert.sendKeys("nova");
        alert.accept();
        String[] text=driver.findElement(By.id("result")).getText().split(":");
        String result=text[1].trim();
        System.out.println(result);

    }
    @AfterMethod
    public void moveBackToHomeScreen(){
        driver.navigate().back();
    }

    @AfterClass
    public void close(){
        lb.tearDown();
    }
}
