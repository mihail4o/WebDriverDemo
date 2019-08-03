import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

// ****************************************
// **                                    **
// **   Works only with HTTP domains!!!  **
// **                                    **
// ****************************************

public class CheckBrokenLinks {
    public static void main(String[] args) {
        String homePage = "http://polygonaceae.myspecies.info/";
//        String homePage = "http://www.zlti.com";
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;

        // Check the OS type. Set the correct webdriver property:
        if(System.getProperty("os.name").equals("Mac OS X")) {
            System.setProperty("webdriver.gecko.driver", "/Users/balivo/Downloads/selenium/course/geckodriver");
        } else {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");
        }

        WebDriver driver = new FirefoxDriver();
        driver.get(homePage);
        driver.manage().window().maximize();

        List<WebElement> links = driver.findElements(By.tagName("a"));
        for (WebElement link: links) {

            url = link.getAttribute("href");
            System.out.print(url);

            if (url == null || url.isEmpty()) {
                System.out.println(" URL is either not configured for anchor tag or it is empty");
                continue;
            }

            if(!url.startsWith(homePage)) {
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }

            try {
                huc = (HttpURLConnection) (new URL(url).openConnection());

                huc.setRequestMethod("HEAD");
                huc.connect();
                respCode = huc.getResponseCode();

                if (respCode >=400) {
                    System.out.println(url + " is broken link!");
                } else {
                    System.out.println(url + " is valid link.");
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
