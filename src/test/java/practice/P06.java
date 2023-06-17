package practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P06 {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        String https = "https://www.";
        driver.get(https+"google.com");
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getTitle());
        driver.navigate().to(https+"amazon.com");
        Thread.sleep(2000);
        driver.navigate().back();
        Thread.sleep(2000);
        driver.navigate().forward();
        Thread.sleep(2000);
        driver.navigate().refresh();
        System.out.println(driver.getTitle());
        String amazonWindowHandle = driver.getWindowHandle();
        System.out.println(driver.getWindowHandle()); // 7B2C721405FFC10430BD545564B420D8 - F29BEBDAB971C62C40B68A05B4402250
        driver.switchTo().newWindow(WindowType.TAB);
        driver.navigate().to(https+"wisequarter.com");
        System.out.println(driver.getWindowHandle()); // B0CC4B0FBE4F5F03600143D80D3BBE3D
        System.out.println(driver.getWindowHandles()); // [4C60648EA1B4474894058D1B61AA832A, B0CC4B0FBE4F5F03600143D80D3BBE3D]
        driver.switchTo().window(amazonWindowHandle);
        driver.close(); // açık olan son browser'ı kapatır. Tüm sekmeleriyle..
        //driver.quit(); // birden fazla açılmış olan tüm browser'ları kapatır.

    }
}
