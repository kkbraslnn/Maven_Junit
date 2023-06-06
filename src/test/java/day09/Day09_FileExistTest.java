package day09;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
public class Day09_FileExistTest {
    @Test
    public void isExist(){
        /*
        We cannot handle files with selenium, but we can use JAVA to work with files.
         */
//        Pick a file on your desktop
//        And verify if that file exist on your computer or not

//        Get the path of home directory
        String userHome = System.getProperty("user.home");
        System.out.println(userHome);

        String pathOfFlower = userHome+"/Desktop/flower.jpeg";
//        String pathOfFlower = userHome+"\\Desktop\\flower.jpeg";//WINDOWS
        System.out.println(pathOfFlower);

//        check if the flower file exist in my desktop
        Assert.assertTrue(Files.exists(Paths.get(pathOfFlower)));

    }
}
