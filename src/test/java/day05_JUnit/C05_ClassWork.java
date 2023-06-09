package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_ClassWork {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        //verilen test sayfasina gidin
        //htpss://the-internet.herokuapp.com/checkboxes

        driver.get("htpss://the-internet.herokuapp.com/checkboxes");

        //Checkbox1 ve checkbox2 elementlerini locate edin

        WebElement checkbox1 = driver.findElement(By.xpath("//*[@type='checkbox'])[1]"));
        WebElement checkbox2 = driver.findElement(By.xpath("//*[@type='checkbox'])[2]"));

        //Checkbox1 secili degilse onay kutuusuna tiklayin

        Thread.sleep(3000);

        if(!checkbox1.isSelected()){
            checkbox1.click();
        }
        //Checkbox2 secili degilse onay kutusuna tiklayin

        if(!checkbox2.isSelected()){
            checkbox2.click();
        }
    }


}
