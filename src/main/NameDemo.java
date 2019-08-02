import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class NameDemo {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("http://demo.guru99.com/test/ajax.html");

        List<WebElement> resultList = driver.findElements(By.name("name"));

        System.out.println("Found " + resultList.size() + " elements.");

        for (WebElement element : resultList) {
            System.out.println("Radio button text: " + element.getAttribute("value"));
        }
    }
}
