package TestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import BaseClass.Base;

public class DropdownTest extends Base {


    @Test
    void selectDropdown(){
        driver.findElement(By.cssSelector("#content>ul>li:nth-of-type(11)"));
        WebElement element=driver.findElement(By.cssSelector("select[id='dropdown']"));
        Select dropdown=new Select(element);
        dropdown.selectByValue("1");
    }

}
