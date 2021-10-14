package tests.day08;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_SoftAssertQuestion {

    /*
    1-go to the "http://zero.webappsecurity.com/"
    2-click to Sign in button,
    3-fill the form with username: username, password: password
    4-click to Sign in button,
    5-go to the Pay Bills page
    6-click to "Purchase Foreign Currency"
    7-"Currency" dropdown menusunden Eurozone'u secin
    8-using Soft assertion to test choosing "Eurozone(Euro)"
    9-using Soft assertion to check dropdown list
     */



    WebDriver driver;

    @BeforeClass
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/");
    }
    @Test
    public void test1(){
        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.xpath("//input[@type='submit']")).click();
        driver.findElement(By.id("details-button")).click();//1
        driver.findElement(By.id("proceed-link")).click();//2
        //I enter my profile. the last two parts for my security stage(number 1 and 2). If you do not have
        //you do not need to use it

    }

    @Test
    public void test2(){
        driver.findElement(By.id("pay_bills_tab")).click();
        driver.findElement(By.linkText("Purchase Foreign Currency")).click();

        //I create dropdown location

        WebElement dropdown = driver.findElement(By.id("pc_currency"));
        Select select = new Select(dropdown);
        select.selectByValue("EUR");

        SoftAssert softAssert = new SoftAssert();
        String expectedOutput = "Eurozone (euro)";
        String actualOutput = select.getFirstSelectedOption().getText();
        softAssert.assertEquals(actualOutput,expectedOutput,"output is not Euro. Some problems occured");


        softAssert.assertAll();
    }
    @Test
    public void test3(){

        //I add the other options to the list to check all.

        WebElement dropdown = driver.findElement(By.id("pc_currency"));
        Select select = new Select(dropdown);
        List<WebElement> allOptions = select.getOptions();
        //allOptions are created by WebElements. That is why we have to change them to the String.

        List<String> allOptionsString = new ArrayList<>();

        for (WebElement each: allOptions
             ) {
            allOptionsString.add(each.getText());
        }
        //I have changed them all
        List<String> expectedOutput = Arrays.asList("Select One",
                "Australia (dollar)",
                "Canada (dollar)",
                "Switzerland (franc)",
                "China (yuan)",
                "Denmark (krone)",
                "Eurozone (euro)",
                "Great Britain (pound)",
                "Hong Kong (dollar)",
                "Japan (yen)",
                "Mexico (peso)",
                "Norway (krone)",
                "New Zealand (dollar)",
                "Sweden (krona)",
                "Singapore (dollar)",
                "Thailand (baht)");

        //after that I check with soft assert

        SoftAssert softAssert = new SoftAssert();

        softAssert.assertEquals(allOptionsString,expectedOutput,"output is different. Some problems occured");

        softAssert.assertAll();
    }



}
