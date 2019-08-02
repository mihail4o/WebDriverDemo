import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class Demo2 {
    public static void main(String[] args) {

        // Set WebDriver property for Firefox browser
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.get("http://demo.guru99.com");

        driver.findElement(By.linkText("Agile Project")).click();
        driver.findElement(By.name("uid")).sendKeys("1303");
        driver.findElement(By.name("password")).sendKeys("Guru99");
        driver.findElement(By.cssSelector("input[name='btnLogin']")).click();
        driver.findElement(By.linkText("Customer")).click();

        System.out.println("alt = " +driver.findElement(By.cssSelector("img[alt='Guru99 Demo Sites']")).getAttribute("alt"));

        // Return list of WebElements
        List<WebElement> listOfElements = driver.findElements(By.xpath("//div"));
        System.out.println(listOfElements.toString());
    }
}
