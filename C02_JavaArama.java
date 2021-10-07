package testler.day02;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class C02_JavaArama {
    public static void main(String[] args) {
        //amazon web sayfasina girip Java kelimesini aratin ve bulunan sonuc sayisini yazdirin

        System.setProperty("webdriver.chrome.driver","C:\\Users\\ibila\\Documents\\selenium dependencies\\drivers\\chromedriver.exe");

        WebDriver driver = new ChromeDriver();

        driver.get("https://www.amazon.com");

        WebElement search = driver.findElement(By.id("twotabsearchtextbox"));

        search.sendKeys("Java" + Keys.ENTER);//direkt enter'a bastirdik

        //sonuclari yazdirabilmek icin sonuclari lokate etmek gerekiyor.. cikan sonuclara
        //incele diyerek girip devam etmeliyiz

        //xpath ile yazdiriliyormus simdi o sekilde yazdiracagiz
        //incelede cikan yere copy xpath yaparak o yolu aliyoruz

        WebElement resultNumber = driver.findElement(By.xpath("//*[@id=\"search\"]/span/div/span/h1/div/div[1]/div/div/span[1]"));

        System.out.println(resultNumber.getText());//web element uzerindeki yaziyi gosterir, referans yerine

        driver.close();
    }
}
