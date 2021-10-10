package day05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class C04_checkBox {
    /*
    1- go to the website
        https://the-internet.herokuapp.com/checkboxes
    2-lokate checkbox1 ve checkbox2 elements
    3-if checkbox1 is not selected, click on the checkbox.
    4-if checkbox2 is not selected, click on the checkbox.
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
    public void test1 (){
        driver.get("https://the-internet.herokuapp.com/checkboxes");
        WebElement boxOne = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement boxTwo = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));

        if (!boxOne.isSelected()){
            boxOne.click();
        }
        if (!boxTwo.isSelected()){
            boxTwo.click();
        }
    }
}
