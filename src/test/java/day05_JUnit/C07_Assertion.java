package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_Assertion {
    WebDriver driver;

    @Before
    public void setUp() {
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
    /*
1)Bir class olusturun:YoutubeAssertions
2)https://www.youtube.com adresinegidin
3) Asagidaki adlara kullanarak 3 test metodu olusturun ve gerekli testleriyapin
Ttitle Test => Sayfa basliginan "YouTube" oldugunu testedin
image Test => YouTube resminin görüntülendigini (isDisplayed()) testedin
Search Box 'in erisilebilir oldugun test edin(isEnabledO)
wrongTitleTest => Sayfa basliginin "YouTube" olmadiginidogrulayin

     */
    @Test
    public void test01(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Amazon";
       Assert.assertTrue(actualTitle.contains(expectedTitle));
    }
    @Test
    public void test02(){
        WebElement sayfaResmi = driver.findElement(By.id("nav-logo-sprites"));
        if (!sayfaResmi.isDisplayed()){
            System.out.println("test passed");
        }else System.out.println("test failed");
        Assert.assertTrue(sayfaResmi.isDisplayed());


    }
}