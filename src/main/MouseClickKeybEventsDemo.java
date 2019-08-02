import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;


public class MouseClickKeybEventsDemo {
    public static void main(String[] args) throws InterruptedException {
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get(baseUrl);

        WebElement link_Home = driver.findElement(By.linkText("Home"));
        WebElement td_Home = driver.findElement(By.xpath("/html/body/div[2]/table/tbody/tr/td[1]/table/tbody/tr/td/table/tbody/tr/td/table/tbody/tr[1]"));

        // Instantiate a new Actions object.
        Actions builder = new Actions(driver);
        Action mouseOverHome = builder
                .moveToElement(link_Home)
                .build();

        Thread.sleep(3000);
        String bgColor = td_Home.getCssValue("background-color");
        System.out.println("Before hover: " + bgColor);
        // Perform mouse event from builder
        mouseOverHome.perform();
        Thread.sleep(5000);
        bgColor = td_Home.getCssValue("background-color");
        System.out.println("After hover: " + bgColor);

        // Build multiple actions
        WebElement txtUsername = driver.findElement(By.name("userName"));
        Action uName = builder
                .moveToElement(txtUsername)
                .click()
                .keyDown(txtUsername, Keys.SHIFT)
                .sendKeys(txtUsername, "hello")
                .keyUp(txtUsername, Keys.SHIFT)
                .doubleClick(txtUsername)
                .contextClick()
                .build();
        uName.perform();

    }
}
