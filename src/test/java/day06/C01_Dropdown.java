package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C01_Dropdown {
    WebDriver driver;
    //Eger test sinifinda birden fazla method olusturulmussa @Before kullanilir.
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }
    @Test
    public void selectByIndexTest(){
        // Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown syfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

        //1. LOCATE dropdown element
        WebElement year = driver.findElement(By.xpath("//select[@id='year']"));
        //2.Select Objesi olustur
        Select yearDropdown = new Select(year);
        //3.Select Object i kullanarak 3 farkli sekilde secim yapabilirim
       yearDropdown.selectByIndex(23);//secenek sirasi 0 dan baslar

        //ay secimi
        WebElement ay = driver.findElement(By.xpath("//select[@id='month']"));
        Select ayDropdown = new Select(ay);
        ayDropdown.selectByValue("0");//option in value degeri ile secim yapilabilir.
        //gun secimi
        WebElement gun = driver.findElement(By.id("day"));
        Select gunDropdown = new Select(gun);
        gunDropdown.selectByVisibleText("10");//CASE SENSITIVE

        //Dogum yilini, ayini,su sekilde secer: 2000 , January , 10

    }
}
