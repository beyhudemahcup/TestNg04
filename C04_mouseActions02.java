package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;


public class C04_mouseActions02 extends TestBase {

/*
go to the "https://demoqa.com/droppable"
hold drag me button and release to drop here box
test that the text has changed drop here to dropped
 */

    @Test
    public void test1(){
        driver.get("https://demoqa.com/droppable");
        Actions actions = new Actions(driver);
        WebElement drag = driver.findElement(By.xpath("//div[@id='draggable']"));
        WebElement drop = driver.findElement(By.xpath("(//div[@id='droppable'])[1]"));

        actions.dragAndDrop(drag,drop).perform();

        String expectedOutput = "Dropped!";
        String actualOutput = driver.findElement(By.xpath("//p[text()='Dropped!']")).getText();

        Assert.assertEquals(actualOutput,expectedOutput,"you did something wrong");


    }
}
