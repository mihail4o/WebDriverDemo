import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SelectDemo {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();

        driver.get("http://demo.guru99.com/test/newtours/register.php");

        // Create Select object instance:
        Select drpCountry = new Select(driver.findElement(By.name("country")));
        drpCountry.selectByVisibleText("BULGARIA");
        // Check for correct selection.
        System.out.println(drpCountry.getFirstSelectedOption().getText().equals("BULGARIA"));

        // Multiple selection example

        Thread.sleep(3000);

        driver.get("http://output.jsbin.com/osebed/2");

        Select mplSelect = new Select(driver.findElement(By.id("fruits")));
        mplSelect.selectByVisibleText("Banana");
        mplSelect.selectByIndex(1);

        // Check if it is multiple selection and iterate thought it
        if (mplSelect.isMultiple()) {
            List<WebElement> selects = mplSelect.getAllSelectedOptions();
            for (WebElement select: selects) {
                System.out.println("Selected: " + select.getText());
            }
        }

    }
}
