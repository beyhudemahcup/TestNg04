package tests.day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C03_ActionClass extends TestBase {


    /*
    go to the "http://webdriveruniversity.com/Actions" website
    wait on Hover over me first button with mouse
    click link 1
    print pop up message
    close pop up click to ok button
    click and hold on "Click and Hold" button :)
    print the message from click and hold button
    double click to the "double click me" button
    */

    @Test
    public void test() throws InterruptedException {
        driver.get("http://webdriveruniversity.com/Actions");
        Actions actions = new Actions(driver);
        WebElement hoverMeButton = driver.findElement(By.xpath("(//button[@class='dropbtn'])[1]"));
        WebElement link1 = driver.findElement(By.xpath("(//div[@class='dropdown-content'])[1]"));

        actions.moveToElement(hoverMeButton).click(link1).perform();

        //I click to link1 button, now, I will write down all alert message

        System.out.println(driver.switchTo().alert().getText());

        driver.switchTo().alert().accept();

        //2. part : click and hold

        WebElement clickAndHoldButton = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickAndHoldButton).perform();
        System.out.println(clickAndHoldButton.getText());


        //3. part : double click

        WebElement doubleClickButton = driver.findElement(By.className("div-double-click"));

        actions.doubleClick(doubleClickButton).perform();





    }
        }






