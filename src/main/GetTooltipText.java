import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.*;

import java.util.concurrent.TimeUnit;

public class GetTooltipText {
    public static void main(String[] args) {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/social-icon.html");

        // Retrieving tooltip with attribute "title" set: (easy scenarios)

        String expectedTooltip = "Github";

        WebElement tooltipElement = driver.findElement(By.cssSelector(".github"));
        String githubTooltip = tooltipElement.getAttribute("title");

        // Compare expected tooltip and received!
        if (expectedTooltip.equals(githubTooltip)) {
            System.out.println("Test passed.");
        } else {
            System.out.println("Test failed");
        }

        Actions builder = new Actions(driver);
        builder.moveToElement(driver.findElement(By.cssSelector(".rss")));
    }
}
