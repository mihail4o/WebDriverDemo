import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FileUploadDemo {
    public static void main(String[] args) {
        // Check the OS type. Set the correct webdriver property:
        if(System.getProperty("os.name").equals("Mac OS X")) {
            System.setProperty("webdriver.gecko.driver", "/Users/balivo/Downloads/selenium/course/geckodriver");
        } else {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");
        }

        WebDriver driver = new FirefoxDriver();
        driver.get("http://demo.guru99.com/test/upload/");

        WebElement uploadElement = driver.findElement(By.id("uploadfile_0"));

        // enter the file path onto the file-selection input field
        uploadElement.sendKeys("C:\\Users\\mihovm.MASCORP\\Downloads\\vi_cheat_sheet.pdf");

        // check the "I accept the terms of service" check box
        driver.findElement(By.id("terms")).click();

        // click the "UploadFile" button
        driver.findElement(By.name("send")).click();
    }
}
