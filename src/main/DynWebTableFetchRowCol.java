import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class DynWebTableFetchRowCol {
    public static void main(String[] args) throws ParseException {
        System.setProperty("webdriver.gecko.driver", "C:\\Users\\mihovm.MASCORP\\Downloads\\selenium-java-3.141.59\\geckodriver.exe");
        WebDriver driver = new FirefoxDriver();
        driver.get("http://demo.guru99.com/test/web-table-element.php");
        driver.manage().window().maximize();

        //No.of Columns
        List cols = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
        System.out.println("Column: " + cols.size());

        //No.of rows
        List rows = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[1]"));
        System.out.println("Rows: " + rows.size());

//        Example: Fetch cell value of a particular row and column of the Dynamic Table
//        Let's assume we need 3rd row of the table and its second cell's data.
//        ================================================================================

        System.out.println("Example: Fetch cell value of a particular row and column of the Dynamic Table");
        System.out.println();

        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement baseTable = driver.findElement(By.tagName("table"));

        //To find third row of table
        WebElement tabRows = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]"));
        String rowText = tabRows.getText();
        System.out.println("Third row on the table: \n" + rowText);

        //to get 3rd row's 2nd column data
        WebElement tabData = driver.findElement(By.xpath("//*[@id='leftcontainer']/table/tbody/tr[3]/td[2]"));
        String celText = tabData.getText();
        System.out.println("Second cell data: " + celText);


//        Example: Get Maximum of all the Values in a Column of Dynamic Table
//        In this example, we will get the maximum of all values in a particular column.
        System.out.println();
        System.out.println("Example: Get Maximum of all the Values in a Column of Dynamic Table");
        String max;
        double r=0, m=0;

//        Table columns count: ?! (not necessarily)
        List<WebElement> collumns = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/thead/tr/th"));
        int numCol = collumns.size();
        System.out.println("Columns: " + numCol);

//        Table rows count:  (not necessarily)
        List<WebElement> rowsList = driver.findElements(By.xpath("//*[@id='leftcontainer']/table/tbody/tr/td[4]"));
        int numRows = rowsList.size();
        System.out.println("Number of rows: " + numRows);

        for (WebElement row: rowsList) {
            max = row.getText();

//          Check the var type:
            System.out.println(max.getClass().getSimpleName()); // Returns "String"
//            max is already String! I don't know why is the transformation below:
//            ---------------------------------------------------------------------
//            NumberFormat f = NumberFormat.getNumberInstance();
//            Number num = f.parse(max);
//            max = num.toString();
            m = Double.parseDouble(max);
//            System.out.println("m = Double.parseDouble(max): " + m);
            if (m > r) {
                r = m;
            }
        }
        System.out.println("Maximum current price is: " + r);


//        Example: Get all the values of a Dynamic Table
//        ==============================================

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("http://demo.guru99.com/test/table.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        System.out.println();
        System.out.println("Example: Get all the values of a Dynamic Table");
        System.out.println("==============================================");

        WebElement myTable = driver.findElement(By.tagName("table"));
        List<WebElement> myRows = myTable.findElements(By.tagName("tr"));
        System.out.println("Table rows found: " + myRows.size());
        int numRow = 0;
        for(WebElement row: myRows) {
            List<WebElement> myData = row.findElements(By.tagName("td"));
            System.out.print("Row #" + numRow + " -> ");
            for(WebElement data: myData) {
                System.out.print(data.getText() + " ");
            }
            System.out.println();
            numRow++;
        }
    }
}
