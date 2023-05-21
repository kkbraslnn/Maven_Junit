package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_MavenIlkTest {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://www.amazon.com sayfasina gidelim
        driver.get("https://www.amazon.com");

        //arama kutusunu locate edelim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[id=twotabsearchtextbox']"));

        //"samsungheadphones" ile arama yapalim
        aramaKutusu.sendKeys("samsungheadphones"); //Keys.ENTER
        aramaKutusu.submit();//enter a bastik

        //Bulunan sonuc sayisini yazdiralim
        WebElement aramasonucu =driver.findElement(By.xpath("(//*[@class='sg-col-inner']"));
        System.out.println("aramasonucu = " + aramasonucu.getText());

        //Ilk urune tiklayalim
        driver.findElement(By.xpath("(//*[@class='s-image'])[1]")).click();

        //Sayfadaki tum basliklari yazdiralim

        List<WebElement> sayfabasliklarilistesi = driver.findElements(By.xpath("//h1"));
        sayfabasliklarilistesi.forEach(t-> System.out.println(t.getText()));





    }
}
