import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//import org.testng.annotations.BeforeTest;
//import org.testng.annotations.AfterTest;

public class TestNG {

//    System.setProperty("webdriver.chrome.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\chromedriver.exe");
// Check the OS type. Set the correct webdriver property:
//        if(System.getProperty("os.name").equals("Mac OS X")) {
//        System.setProperty("webdriver.gecko.driver", "/Users/balivo/Downloads/selenium/course/geckodriver");
//    } else {
//        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");
//    }
//
    public String baseUrl = "http://newtours.demoaut.com";
    public WebDriver driver;

    @BeforeTest
    public void setBaseURL() {
        driver = new ChromeDriver();
        driver.get(baseUrl);
    }

    @Test
    public void verifyHomepageTitle() {
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = driver.getTitle();
        Assert.assertEquals(actualTitle, expectedTitle);
    }

    @AfterTest
    public void endSession() {
        driver.quit();
    }
}
