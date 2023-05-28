package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import javax.print.DocFlavor;
import java.time.Duration;
import java.util.List;

public class C01_Dropdown {
    WebDriver driver;
    //Eger test sinifinda birden fazla method olusturulmussa @Before kullanilir.
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown syfasindayken
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");

    }
    @Test
    public void selectByIndexTest(){

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

    @Test
    public void printAllTest(){

        //Tum eyalet isimlerini konsola yazdir.
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropDown = new Select(state);
        List<WebElement> statelist = stateDropDown.getOptions();
       // for(WebElement eachState : statelist){
       //     System.out.println(eachState.getText());
      //  }
        statelist.stream().forEach(t-> System.out.println(t.getText()));
    }

    @Test
    public void getSelectedOptionsTest(){

        //State dropdownindaki varsiylan seili secenegin 'select a state' oldugunu verify edelim
        WebElement state = driver.findElement(By.xpath("//select[@id='state']"));
        Select stateDropdown = new Select(state);
        String varsayilanText = stateDropdown.getFirstSelectedOption().getText();
        Assert.assertEquals("Select a State",varsayilanText);

    }
    @After
    public void tearDown(){
        driver.close();
    }

    /*
    1.What is dropdown? Dropdown nedir?
    Dropdown liste olusturmak icin kullanilir.
    2.How to handle dropdown elements?Dropdown nasil automate edilir?
    -dropdown i locate ederim
    -select objesi olustururum
    -select onjesi ile istedigim secenegi secerim
    Not:select objesi olusturma nedenim,dropdownlarin select classi ile olusturulmasi
    3.Tum dropdown seceneklerini nasil print ederiz?
    -tum dropdown elementlerini getOptions() methodu ile listeye koyariz
    -sonra secenkleri loop ile yazdirabiliriz
    4.Bir secenegin secili oldugunu otomate etmek icin ne yapilir?
    ornek:gun olarak 10 u sectik ama ya secilmediyse?
    getFirstSelectedOption() secili olan secenegi return eder
     */
}
