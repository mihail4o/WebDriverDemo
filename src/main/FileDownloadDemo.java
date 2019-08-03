import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;

public class FileDownloadDemo {
    public static void main(String[] args) {
        // Check the OS type. Set the correct webdriver property:
        if(System.getProperty("os.name").equals("Mac OS X")) {
            System.setProperty("webdriver.gecko.driver", "/Users/balivo/Downloads/selenium/course/geckodriver");
        } else {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");
        }

        WebDriver driver = new FirefoxDriver();
        driver.get("http://demo.guru99.com/test/yahoo.html");

        WebElement downloadButton = driver.findElement(By.id("messenger-download"));
        String sourceLocation = downloadButton.getAttribute("href");
        String wget_command = "cmd /c C:\\Wget\\wget.exe -P C:\\Wget --no-check-certificate " + sourceLocation;

        try {
            Process exec = Runtime.getRuntime().exec(wget_command);
            int exitVal = exec.waitFor();
            System.out.println("Exit value: " + exitVal);
        }
        catch (IOException | InterruptedException ex) {
            System.out.println(ex.toString());
        }
    }
}
