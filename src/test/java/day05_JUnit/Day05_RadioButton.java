package day05_JUnit;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Day05_RadioButton extends TestBase {
    //    https://testcenter.techproeducation.com/index.php?page=radio-buttons
//    Click on Red
//    Click on Football
    @Test
    public void radioButtonTest(){
//        go to the page
        driver.get("https://testcenter.techproeducation.com/index.php?page=radio-buttons ");
//        locating red
        WebElement red = driver.findElement(By.id("red"));
//        clicking on red
        red.click();
//        verifying if red is checked
        Assert.assertTrue(red.isSelected());

//    Click on Football 2 mins
        WebElement football = driver.findElement(By.id("football"));
        football.click();
        Assert.assertTrue(football.isSelected());
    }

}
