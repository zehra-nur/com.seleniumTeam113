package day03_locators;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Locator_findElement {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        // amazon anasayfaya gidin

        driver.get("https:www.amazon.com");

        // arama kutusuna Nutella yazdirin
        /*
           Test otomasyonu yaparken
           bir web elementi kullanmak istersek 2 seye ihtiyacimiz var
           1- o webelementi benzersiz olarak tarif edebileceğimiz bir locator
           2- bu locator'i soyledigimizde bize web elementi bulup getirecek method

           orneğin amazon sitesindeki arama kutusunun unique tarif edicisi olarak
           id = "twotabsezrchtextbox" kullanabilirsiniz
         */

          WebElement aramaKutusuElementi = driver.findElement(By.id("twotabsearchtextbox"));
        //  data türü    objenin adi     =    findElement : webelementi bulan method
        //                                    By : webelementi bulacagimiz locator'in turunu yazdigimiz method
        //                                    twotabsearchtextbox : unique tarif için id attribute degeri

        /*
           findElement() verdigimiz locator turu ve o locator icin verdigimiz degere gore webelementi arar.
           locator icin verdigimiz deger hataliysa veya
           locator stratejisinde hata yaptiysak
           aranan web elementi implicitlyWait olarak tanimladigimiz
           maximum sure boyunca arar
           bulamadigi icin "NoSuchElementException" firlatir ve kodlarin kalanini calistirmaz
         */

        aramaKutusuElementi.sendKeys("Nutella");

        //Enter tuşuna basarak arama yapin

        aramaKutusuElementi.submit();

        Thread.sleep(7000);
        driver.close();
    }
}
