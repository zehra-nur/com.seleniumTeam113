package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.locators.RelativeLocator;

import java.time.Duration;

public class P07 {
    /*
       1 ) http://babayigit.net/relativelocators/relative.html adresine gidin
       2 ) Nurse  3 farkli relative locator ile locate edin
       3 ) Relative locator'larin dogru calistigini test edin
     */
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // 1 ) http://babayigit.net/relativelocators/relative.html adresine gidin
        driver.get("http://babayigit.net/relativelocators/relative.html");

        // 2 ) Nurse  3 farkli relative locator ile locate edin
        // 3 ) Relative locator'larin dogru calistigini test edin

        WebElement seller = driver.findElement(By.id("sll_thumb"));
        WebElement nurse = driver.findElement(RelativeLocator.with(By.tagName("img")).above(seller));

        if (nurse.getAttribute("id").equals("nurs_thumb")){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        WebElement fireman = driver.findElement(By.id("frmn_thumb"));
        WebElement nurse2 = driver.findElement(RelativeLocator.with(By.tagName("img")).toRightOf(fireman));

        if (nurse2.getAttribute("id").equals("nurs_thumb")){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        WebElement policeman = driver.findElement(By.id("pol_thumb"));
        WebElement nurse3 = driver.findElement(RelativeLocator.with(By.tagName("img")).toLeftOf(policeman));

        if (nurse3.getAttribute("id").equals("nurs_thumb")){
            System.out.println("Test PASSED");
        }else {
            System.out.println("Test FAILED");
        }

        driver.close();
    }
}
