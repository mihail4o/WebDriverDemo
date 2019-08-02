import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Main {

    public static void main(String[] args) {

        // Set WebDriver property for Firefox browser
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");

        // Set WebDriver property for Chrome browser
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\chromedriver.exe");

        // Set WebDriver property for MS Edge browser
        System.setProperty("webdriver.edge.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\MicrosoftWebDriver.exe");

        // Set WebDriver property for MS IE browser
        System.setProperty("webdriver.ie.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\IEDriverServer.exe");

//        WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();

        // Creating the JavascriptExecutor interface object by Type casting
        JavascriptExecutor js = (JavascriptExecutor) driver;

        //Launching the Site.
        driver.get("http://demo.guru99.com/V4/");

        //Fetching the Domain Name of the site. Tostring() change object to name.
        String DomainName = js.executeScript("return document.domain;").toString();
        System.out.println("Domain name of the site = "+DomainName);

        //Fetching the URL of the site. Tostring() change object to name
        String url = js.executeScript("return document.URL;").toString();
        System.out.println("URL of the site = "+url);

        //Method document.title fetch the Title name of the site. Tostring() change object to name
        String TitleName = js.executeScript("return document.title;").toString();
        System.out.println("Title of the page = "+TitleName);

        //Navigate to new Page i.e to generate access page. (launch new url)
        js.executeScript("window.location = 'http://demo.guru99.com/'");

        // Maximizing window
        driver.manage().window().maximize();

        // Get site title
        System.out.println(driver.getTitle());

        // JavascriptExecutor - Vertical scroll down by 600  pixels
        js.executeScript("window.scrollBy(0,600)");

        driver.quit();
    }
}
