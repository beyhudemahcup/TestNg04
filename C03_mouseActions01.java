package tests.day10;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class C03_mouseActions01 extends TestBase {


    /*
    1-go to he "https://the-internet.herokuapp.com/context_menu"
    2-make right click on your mouse to the specified area
    3-check alert message which is "You selected a context menu"
    4-click on okay button to close alert pop-up
    5-click the link "Elemental Selenium"
    6-test the new page has "Elemental Selenium" on its h1 tag
     */
    @Test
    public void test() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

        //1.
        driver.get("https://the-internet.herokuapp.com/context_menu");
        WebElement selectedArea = driver.findElement(By.xpath("//div[@oncontextmenu='displayMessage()']"));
        //2.
        Actions actions = new Actions(driver);
        actions.contextClick(selectedArea).perform();

        Thread.sleep(2000);

        //3.

        String expectedAlertMessage = "You selected a context menu";
        String actualAlertMessage = driver.switchTo().alert().getText();

        softAssert.assertEquals(actualAlertMessage,expectedAlertMessage,"your alert message is different");

        //4.
        driver.switchTo().alert().accept();

        String firstPageHandle = driver.getWindowHandle();

        //5.
        driver.findElement(By.xpath("//a[@target='_blank']")).click();

        Set<String> allPageHandles =driver.getWindowHandles();
        String secondPageHandle ="";

        for (String each: allPageHandles
             ) {
            if (!each.equals(firstPageHandle)){
                secondPageHandle=each;
            }

        }

        driver.switchTo().window(secondPageHandle);

        //6.
        String actualSecondPageH1 = driver.findElement(By.tagName("h1")).getText();
        String expectedSecondPageH1 = "Elemental Selenium";

        softAssert.assertEquals(actualSecondPageH1,expectedSecondPageH1,"your second page h1 tag is not equal Elemental Selenium");


        softAssert.assertAll();

    }
}
