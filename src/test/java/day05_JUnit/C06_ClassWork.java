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

public class C06_ClassWork {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }
    @Test
    public void test01() throws InterruptedException {
        //htpps://www.facebook.com adresine gidin
        driver.get("htpps://www.facebook.com");
        //cookies i kabul edin
        //"create an account " butonuna basin
        driver.findElement(By.xpath("(//*[@role='button'])[2]")).click();
        //"radio buttons" elementlerini locate edin
        WebElement female = driver.findElement(By.xpath("//*[@id='u_c_4_8K']"));
        WebElement male = driver.findElement(By.xpath("//*[@id='u_c_5_LO']"));
        WebElement custom = driver.findElement(By.xpath("//*[@id='u_c_6_tb']"));

        //secili degilse cinsiyet butonundan size uygun olanini secin
        if (!female.isSelected()){
            female.click();
        }
        Thread.sleep(3000);
        female.click();
        Thread.sleep(3000);
        custom.click();

    }
}
