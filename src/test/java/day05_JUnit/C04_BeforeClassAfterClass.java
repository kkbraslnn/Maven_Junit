package day05_JUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass notasyonlari sadece static methodalr icin calisir.
    @BeforeClass ve @AfterClass kullanirsak olusturdugumuz @tTest methodalarinin hespsini ayni anda calistirip en son
    @AfterClass i calisitirirz
    Ama sadece @Before ve @After kullanirsak her test icin  @Before ve @After i kullanir.
     */
    @BeforeClass
    public static void setUp(){
       /* System.out.println("Butun testlerden once calisti");
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        */
    }
    @AfterClass
    public static void tearDown(){
        System.out.println("Butun testlerden sonra calisti");
        System.out.println("..............................");
    }
    @Before
    public void setUp01(){
        System.out.println("her testten once calisir");
        System.out.println(".......................");
    }
    @After
    public void tearDown01(){
        System.out.println("her testten sonra calisir");
        System.out.println(".......................");
    }
    @Test
    public void test01(){
        System.out.println("ilk test");
        System.out.println(".......................");
    }
    @Test
    public void test02(){
        System.out.println("ikinci test");
        System.out.println(".......................");
    }
    @Test
    @Ignore //eger bir testi calistirmak istemezsek bu sekilde kullanabiliriz
    public void test03(){
        System.out.println("ucuncu test");

    }
}
