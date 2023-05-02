package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C01_DriverGetMethodlari {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        // sisteme webdriver'in ne olacagini ve hangi dosya yolunda olduğunu söyler
        WebDriver driver = new ChromeDriver();
        // bilgisayarımızdaki Chrome browser'in otomasyonla calisacak bir kopyasini olusturur
        // Chrome disinda bir browser kullanmak istersek, o browser'in driver'ini indirip
        // System.setProperty("webdriver.chrome.driver","safari driver'in dosya yolu");

        // Olusturdugumuz driver objesi bizim elimiz, gözümüz gibidir.

        driver.get("https://wwww.amazon.com/");
        // www yazmasak da calisir ancak https:// yazmazsak calismaz

        System.out.println(driver.getTitle()); // bize title'i döndürür.

        System.out.println(driver.getCurrentUrl()); // gidilen url'i döndürür

        System.out.println(driver.getPageSource());
        // gidilen web sayfasinin kaynak kodlarini dondurur

        System.out.println(driver.getWindowHandle());
        // acilan her bir pencereye verilen unique hash code degeridir

        System.out.println(driver.getWindowHandles());
        //eger driver calisirken birden fazla pencere veya tab olusturduysa
        // acilan tum window/tab lerin unique hash code larini bir set olarak dondurur

        Thread.sleep(3000); // milisaniye olarak yazdigimiz sayi suresince kodu bekletir

        driver.close(); // acilan browser'i kapatir
    }
}
