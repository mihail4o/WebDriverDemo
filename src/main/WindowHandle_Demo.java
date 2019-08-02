import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.Iterator;
import java.util.Set;

public class WindowHandle_Demo {
    public static void main(String[] args) {
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");
//        WebDriver driver = new FirefoxDriver();
//        WebDriver driver = new FirefoxDriver();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://demo.guru99.com/popup.php");
        driver.manage().window().maximize();

        String mainWindow = driver.getWindowHandle();
        driver.findElement(By.xpath("//a[contains(text(), 'Click Here')]")).click();

        // To handle all new opened window.
        Set<String> s1 = driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();

        while (i1.hasNext()) {
            String childWindow = i1.next();
            Boolean isNewWindow = !mainWindow.equalsIgnoreCase(childWindow);
            System.out.println(isNewWindow);
            if (isNewWindow) {

                // Switching to Child window
                driver.switchTo().window(childWindow);
                driver.findElement(By.name("emailid"))
                        .sendKeys("baba@dado.com");
                driver.findElement(By.name("btnLogin")).submit();
                // Closing the Child Window.
                driver.close();
            }
        }
        // Switching to Parent window i.e Main Window.
        driver.switchTo().window(mainWindow);
    }

}
