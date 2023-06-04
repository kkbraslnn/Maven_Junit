package day05_JUnit;

import utilities.TestBase;
import org.junit.Test;
public class Day05_TestBaseTest extends TestBase {
    @Test
    public void testBaseTest(){
        driver.get("https://www.google.com");
    }
}
