package day06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class C01_Assertions {

    /*
    1-go to the address "https://www.bestbuy.com/"
    2- check website url's equal "https://www.bestbuy.com/"
    3-check website's title does not contain "Rest"
    4-check the visibility of logo of bestbuy
    5-check that is french link visible or not
     */

    static WebDriver driver;
    @BeforeClass
    public static void setup (){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.bestbuy.com/");
    }

    @Test
    public void urlTest(){
        String expectedUrl="https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals("Can not find expected URL",actualUrl,expectedUrl);
    }

    @Test
    public void titleContain(){
        String nonExpectedTitle = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(" the title has non expected word",actualTitle.contains(nonExpectedTitle));

    }
    @Test
    public void logoTest(){
        WebElement logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue("logo is not visible",logo.isDisplayed());

    }

    @Test
    public void frenchLinkTest(){
        WebElement frenchLink = driver.findElement(By.xpath("//button[@lang='fr']"));
        Assert.assertTrue("French text is not visible", frenchLink.isDisplayed());
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }
}
