import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class HandlingAlertDemo {
    public static void main(String[] args) throws InterruptedException {
        // Check the OS type. Set the correct webdriver property:
        if(System.getProperty("os.name").equals("Mac OS X")) {
            System.setProperty("webdriver.gecko.driver", "/Users/balivo/Downloads/selenium/course/geckodriver");
        } else {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");
        }

        WebDriver driver = new FirefoxDriver();
        driver.get("http://demo.guru99.com/test/delete_customer.php");

        driver.findElement(By.name("cusid")).sendKeys("54345");
        driver.findElement(By.name("submit")).submit();

        // Switching to Alert
        Alert alert = driver.switchTo().alert();

        // Capturing alert message.
        String alertMsg = driver.switchTo().alert().getText();

        // Displaying alert message
        System.out.println(alertMsg);
        Thread.sleep(5000);

        // Accepting alert
        alert.accept();
    }
}
