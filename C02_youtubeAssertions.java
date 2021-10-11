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

public class C02_youtubeAssertions {

    /*
    1- go to the youtube
    2-check title is "YouTube"
    3-check youtube picture is visible or not
    4- check searchbox is enabled or not
    5-check page title is not "youtube"
     */

    static WebDriver driver;//do not forget to make it static
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.youtube.com");
    }
    @Test
    public void titleCheck() {
        String expectedTitle = "YouTube";
        String actualTitle = driver.getTitle();
        Assert.assertEquals("expected title has not been matched with actual title",expectedTitle,actualTitle);
    }
    @Test
    public void imageCheck(){
        WebElement image = driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue("Youtube icon has not been seen",image.isDisplayed());
    }

    @Test
    public void searchBoxCheck() {
      WebElement searchBox =  driver.findElement(By.xpath("//input[@placeholder='Ara']"));
      Assert.assertTrue("Search Box has not been seen", searchBox.isEnabled());

    }


    @Test
    public void wrongTitleCheck() {
        String unexpectedTitle = "youtube";
        String actualTitle = driver.getTitle();
        Assert.assertNotEquals("unexpected title has been seen in title", unexpectedTitle,actualTitle);
    }
    @AfterClass
    public static void tearDown(){
        driver.close();
    }

}
