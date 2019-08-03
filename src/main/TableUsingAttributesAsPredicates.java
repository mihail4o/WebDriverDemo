import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TableUsingAttributesAsPredicates {
    public static void main(String[] args) {
        // Check the OS type. Set the correct webdriver property:
        if(System.getProperty("os.name").equals("Mac OS X")) {
            System.setProperty("webdriver.gecko.driver", "/Users/balivo/Downloads/selenium/course/geckodriver");
        } else {
            System.setProperty("webdriver.gecko.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");
        }

        WebDriver driver = new FirefoxDriver();
        driver.get("http://demo.guru99.com/test/newtours/");
        driver.manage().window().maximize();

        WebElement tdElement = driver.findElement(By.xpath("//table[@width='270']/tbody/tr[4]/td"));
        System.out.println("Text: " + tdElement.getText());

//        Shortcut: Use Inspect Element for Accessing Tables in Selenium
//        ==============================================================
//        Find element with Inspector and copy xpath. Then, remove all tags till "/table" - use it for xpat!
//        BEFORE: /html/body/div[2]/table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[2]/tbody/tr[3]/td[2]/font
//        AFTER: "//table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[2]/tbody/tr[3]/td[2]/font"

        WebElement textElement = driver
                .findElement(By.xpath("//table/tbody/tr/td[2]/table/tbody/tr[4]/td/table/tbody/tr/td[2]/table/tbody/tr[2]/td[1]/table[2]/tbody/tr[3]/td[2]/font"));
        System.out.println("Text from shortcut: \n" + textElement.getText());
    }
}
