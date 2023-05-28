package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C02_DropdownReusable {


WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        // Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown syfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }
    //REUSABLE METHOD:Dropdown icin tekrar tekrar kullanabilecegimiz method olusturalim.
    public void selectFromDropdown(WebElement dropdown,String secenek){
        //selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']")),"2005");
        //selectFromDropdown(driver.findElement(By.xpath("//select[@id='month']")),"January");
        //selectFromDropdown(driver.findElement(By.id("day")),"12");

        //Gonderilen dropdown elemention tum options alinir.
       List<WebElement> options = dropdown.findElements(By.tagName("option"));//tum option tag li elementleri alir
       for (WebElement eachOption : options){
           if(eachOption.getText().equals(secenek)){
               eachOption.click();
               break;
           }
       }



    }
@Test
    public void selectFromDropdown(){
        selectFromDropdown(driver.findElement(By.xpath("//select[@id='year']")),"2005");
}
}
//not :sonraki derste tekrar ve kullanimi