package practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class P03 {
    /*   ...Exercise3...
         Navigate to  https://testpages.herokuapp.com/styled/index.html
         Click on  Calculater under Micro Apps
         Type any number in the first input
         Type any number in the second input
         Click on Calculate
         Get the result
         Print the result
      */

    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver","src/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Navigate to  https://testpages.herokuapp.com/styled/index.html
        driver.navigate().to("https://testpages.herokuapp.com/styled/index.html");

        //Click on  Calculater under Micro Apps
        WebElement calculatorLinkElement = driver.findElement(By.id("calculatetest"));
        calculatorLinkElement.click();

        //Type any number in the first input
        WebElement textboxElement1 = driver.findElement(By.id("number1"));
        textboxElement1.sendKeys("123654");

        //Type any number in the second input
        WebElement textboxElement2 = driver.findElement(By.id("number2"));
        textboxElement2.sendKeys("789654");

        //Click on Calculate
        WebElement calculateButton = driver.findElement(By.id("calculate"));
        calculateButton.click();

        //Get the result
        WebElement resultTextElement = driver.findElement(By.id("answer"));
        resultTextElement.getText();

        //Print the result
        System.out.println(resultTextElement.getText());

        driver.quit();

    }
}
