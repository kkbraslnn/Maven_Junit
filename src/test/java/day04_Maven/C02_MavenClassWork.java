package day04_Maven;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MavenClassWork {
    public static void main(String[] args) {
       WebDriverManager.chromedriver().setup();
       WebDriver driver = new ChromeDriver();
       driver.manage().window().maximize();
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        //Sign in butonuna tiklayin
        driver.findElement(By.cssSelector("i[class='icon-signin']")).click();
        //Login alanina "username" yazdirin
        WebElement login = driver.findElement(By.xpath("//*[@id='user_login']"));
        login.sendKeys("username");
        //Password alanine "password" yazdirin
        WebElement password = driver.findElement(By.xpath("//*[@id='user_password']"));
        password.sendKeys("password");
        //Sign in butonuna tiklayin
        driver.findElement(By.xpath("//*[name='submit']")).click();
        driver.navigate().back();
        //Online banking butonuna basiniz sonra Pay Bills sayfasina gidin
        /*
        <strong>Online Banking </strong>
         */
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        /*
        <span class ="headers" id="pay_bills_link">Pay Bills</span>
         */
        driver.findElement(By.xpath("//*[test()='Pay Bills']")).click();

        //amount kismina yatirmak istediginiz herhangi bir miktari yazin
        WebElement amount = driver.findElement(By.cssSelector("input[id='sp_amount']"));
        amount.sendKeys("500");
        // tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.xpath("//*[@id='sp_date']")).sendKeys("2020-09-10");
        //Pay butonuna tiklayin
        driver.findElement(By.id("pay_saved_payees")).click();
        //"The payment was successfully submitted." mesajinin ciktigini control edin
        WebElement mesaj = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']"));
        if(mesaj.isDisplayed()){
            System.out.println("Test PASSED");
        }else System.out.println("Test FAILED");
        //Sayfayi kapatiniz.
        driver.close();
    }
}
