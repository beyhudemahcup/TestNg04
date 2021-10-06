package testler.day01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04__verifyUrl {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ibila\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.youtube.com");


        String expectedUrl = "www.youtube.com";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)){
            System.out.println("girilen url ortusuyor, test PASS");
        }else{
            System.out.println("girdiginiz urlde bir sorun var. url : " + driver.getCurrentUrl());
        }

        driver.close();



    }
}
