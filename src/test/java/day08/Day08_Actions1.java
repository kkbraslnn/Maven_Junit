package day08;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.LoggerUtils;
import utilities.TestBase;

public class Day08_Actions1 extends TestBase {
    @Test
    public void contextClickTest(){
        LoggerUtils.info("Opening the URL");
        driver.get("https://testcenter.techproeducation.com/index.php?page=context-menu");
//        When use Right clicks on the box
        LoggerUtils.info("Right click on hte box");
        WebElement box = driver.findElement(By.id("hot-spot"));

//        Creating Actions Class
        Actions actions = new Actions(driver);//creating Actions object
        actions.contextClick(box).perform();//right click on the box
        LoggerUtils.info("Assert alert message");
//        Then verify the alert message is “You selected a context menu”
        Assert.assertTrue(driver.switchTo().alert().getText().equals("You selected a context menu"));
//        Then accept the alert
        driver.switchTo().alert().accept();
        LoggerUtils.info("Testing SUCCESSFUL");

    }
}
