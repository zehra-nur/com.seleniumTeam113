package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P05 {
    /*
       1-Driver oluşturalim gerekli ayarlamaları yapalım
       2-Navigate to http://www.babayigit.net/murat/testpage.html
       3-first name, surname, age, Your Job, Birth Palace, Last graduated school, Number of Children alanlarına gerekli bilgileri yazsın
       4-Submit tuşuna bassın.
       5- All information was entered correctly.. yazısının göründüğünü test etsin
       6- Clear butonu ile tüm butonları temizlesin
       7- Manuel olarak temizlendiğini görecek kadar beklesin
       8- Sayfayı kapatsın
     */

    public static void main(String[] args) throws InterruptedException {
        // 1-Driver oluşturalim gerekli ayarlamaları yapalım.
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 2-Navigate to http://www.babayigit.net/murat/testpage.html
        driver.get("http://www.babayigit.net/murat/testpage.html");

        // 3-first name, surname, age, Your Job, Birth Palace, Last graduated school, Number of Children alanlarına gerekli bilgileri yazsın.
        // first name
        driver.findElement(By.xpath("//*[@id='ad']")).sendKeys("Zehra");
        // surname
        driver.findElement(By.xpath("//*[@id='soyad']")).sendKeys("Nur");
        // age
        driver.findElement(By.xpath("//*[@id='yas']")).sendKeys("29");
        // Your Job
        driver.findElement(By.xpath("//*[@id='meslek']")).sendKeys("SDET");
        // Birth Palace
        driver.findElement(By.xpath("//*[@id='dogum_yeri']")).sendKeys("Turkey");
        // Last graduate school
        driver.findElement(By.xpath("//*[@id='mezun_okul']")).sendKeys("Universite");
        // Number of Children
        driver.findElement(By.xpath("//*[@id='cocuk_sayisi']")).sendKeys("2");

        // 4-Submit tuşuna bassın.
        driver.findElement(By.xpath("//input[@type='submit']")).click();

        // 5- All information was entered correctly... yazısının göründüğünü test etsin
        WebElement textElement = driver.findElement(By.xpath("//*[@id='uyari']"));
        if (textElement.isDisplayed()){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        // 6- Clear butonu ile tüm butonları temizlesin
        driver.findElement(By.xpath("//input[@type='reset']")).click();

        // 7- Manuel olarak temizlendiğini görecek kadar beklesin
        Thread.sleep(3000);

        // 8- Sayfayı kapatsın
        driver.close();
    }

}
