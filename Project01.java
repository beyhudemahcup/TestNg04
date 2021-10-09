package testler.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Project01 {
    public static void main(String[] args) throws InterruptedException {
        /*
        1-go to the "https://the-internet.herokuapp.com/add_remove_elements/"
        2-click on button: "Add Element"
        3-test visibility of delete button
        4-click on delete button
        5-test visibility of delete button

        */

        System.setProperty("webdriver.chrome.driver","C:\\Users\\ibila\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");

        Thread.sleep(1000);//sometimes Selenium cannot reach the speed of chrome. That is why I added some periods
        WebElement addElement = driver.findElement(By.xpath("//button[@onclick='addElement()']"));
        addElement.click();

        WebElement deleteButton = driver.findElement(By.xpath("//button[@onclick='deleteElement()']"));
        if (deleteButton.isDisplayed()){
            System.out.println("delete button is visible, Test PASS");
        }else{
            System.out.println("delete button is not visible, Check your code again!");
        }

        Thread.sleep(1000);
        deleteButton.click();//I deleted delete button. Now, I will check visibility again

        //but now there is a tricky part: we do not test non exist button.
        //so, last part that we can not check!


    }
}
