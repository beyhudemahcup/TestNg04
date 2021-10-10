package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C05_radioButton {
    /*
    1-go to the "https://www.facebook.com"
    2-click on create an Account button
    3-locate "radio buttons"
    4- choose an gender which one you prefer if these are not selected
     */


    WebDriver driver;

    @Before
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void test1(){
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        WebElement woman = driver.findElement(By.xpath("//input[@value='1']"));
        WebElement man = driver.findElement(By.xpath("//input[@value='2']"));
        WebElement special = driver.findElement(By.xpath("//input[@value='-1']"));
        WebElement customGender = driver.findElement(By.xpath("//input[@name='custom_gender']"));


        if (woman.isSelected()){
            special.click();
            customGender.sendKeys("non-binary");
        }

        else if (man.isSelected()){
            special.click();
            customGender.sendKeys("non-binary");
        }
        else if (special.isSelected()){
            customGender.sendKeys("non-binary");
        }else{
            special.click();
            customGender.sendKeys("non-binary");

        }
    }
@After
    public void tearDown(){
       // driver.close();
}

}
