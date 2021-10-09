package day04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class C03_Test02{
    public static void main(String[] args) {
        /*
        1-go to the http://zero.web.appsecurity.com website
        2- click on sign in
        3-fill login text with "username"
        4-fill password text with "password"
        5-click on sign in button
        6-click pay bills
        7-fill amount part up with some int
        8-write 2020-09-10 as a date in date part.
        9-click on pay button.
        10- check the message is "The payment was successfully submitted" or not.
         */

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);


        driver.get("http://zero.webappsecurity.com/");
        driver.findElement(By.id("signin_button")).click();
        driver.findElement(By.id("user_login")).sendKeys("username");
        driver.findElement(By.id("user_password")).sendKeys("password");
        driver.findElement(By.name("submit")).click();
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
        driver.findElement(By.linkText("Pay Bills")).click();
        driver.findElement(By.id("sp_amount")).sendKeys("300");
        driver.findElement(By.id("sp_date")).sendKeys("2020-09-10");
        driver.findElement(By.id("pay_saved_payees")).click();

        WebElement check= driver.findElement(By.id("alert_content"));
        String checker= "The payment was successfully submitted.";
        if (check.getText().contains("The payment was successfully submitted.")){
        System.out.println("your check test is PASS");
        }else{
        System.out.println("some problem occured!");
        }

    }
}
