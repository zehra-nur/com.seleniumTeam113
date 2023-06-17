package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P02 {
    /*
             . .Exercise2...
        1-Java class'imiza chnomedriver. exe'yi tanitalim
        2-Driver oluşturalim
        3-Driver'in tum ekranı kaplamasini saglayalim
        4-Driverla sayfanın yuklenmesini 10.809 milisaniye (10 saniye) boyunca beklesini söyleyelim.
          Eger oncesinde sayfa Yüklenirse, beklemeyi bıraksın.
        5-"https://www.otto.de" adresine gidelim
        6-Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
        7-Title ve url inin "0TT0" kelimesinin içerip icermedigini kontrol edelim
        8-Ardindan "https://wisequarter.com/" adresine gidip
        9-Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini kontrol edelim
        10-Bir onceki web sayfamiza geri donelim
        11-Sayfayı yenileyelim
        12-Daha sonra web sgyfamiza tekrar donelim ve oldugumuuz sayfayi kapatalim
        13- En son adim olarak butun sayfalarimizi kapatmis olalim
     */
    public static void main(String[] args) {

        //1-Java class'imiza chnomedriver. exe'yi tanitalim
        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");

        //1-Driver oluşturalim
        WebDriver driver = new ChromeDriver();

        //3-Driver'in tum ekranı kaplamasini saglayalim
        driver.manage().window().maximize();

        //4-Driverla sayfanın yuklenmesini 10.809 milisaniye (10 saniye) boyunca beklesini söyleyelim.
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(10000));

        //5-"https://www.otto .de" adresine gidelim
        driver.get("https://www.otto.de");

        //6-Bu web adresinin sayfa basligini (title) ve adres (url)ini alalim
        driver.getTitle();
        driver.getCurrentUrl();

        //7-Title ve url inin "0TT0" kelimesinin içerip icermedigini kontrol edelim

        String expectedIcerik = "OTTO";
        String actualTitle = driver.getTitle();
        System.out.println(actualTitle);

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Otto Title testi PASSED");
        }else {
            System.out.println("Otto Title testi FAILED");
        }

        expectedIcerik = "OTTO";
        String actualUrl = driver.getCurrentUrl();
        System.out.println(actualUrl);

        if (actualUrl.contains(expectedIcerik)){
            System.out.println("Otto URL testi PASSED");
        }else {
            System.out.println("Otto URL testi FAILED");
        }

        //8-Ardindan "https://wisequarter.com/" adresine gidip
        driver.navigate().to("https://wisequarter.com/");

        //9-Bu adresin basligini alalim ve "Quarter" kelimesini icerip icermedigini kontrol edelim
        driver.getTitle();
        expectedIcerik = "Quarter";
        actualTitle = driver.getTitle();
        System.out.println(actualTitle);

        if (actualTitle.contains(expectedIcerik)){
            System.out.println("Title wise testi PASSED");
        }else {
            System.out.println("Title wise testi FAILED");
        }

        //10-Bir onceki web sayfamiza geri donelim
        driver.navigate().back();

        //11-Sayfayı yenileyelim
        driver.navigate().refresh();

        //12-Daha sonra web sayfamiza tekrar donelim ve oldugumuz sayfayi kapatalim
        driver.navigate().forward();

        //13- En son adim olarak butun sayfalarimizi kapatmis olalim
        driver.quit();
    }
}
