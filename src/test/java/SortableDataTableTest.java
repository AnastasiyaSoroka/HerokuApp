import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SortableDataTableTest extends BaseTest {

    private String endpoint = "tables";

    @Test
    public void checkLastNamesTest() {

        driver.get(URL+endpoint);
        List<WebElement> rows = driver.findElements(By.xpath("//table[@id='table1']/tbody/tr"));

        System.out.println(rows.size());
        ArrayList<String> result = new ArrayList<String>();
        for (int i = 1; i <= rows.size(); i++) {

            String child_xpath = "//table[@id='table1']/tbody/tr[" + i + "]/td[1]";
            WebElement child = driver.findElement(By.xpath(child_xpath));
            result.add(child.getText());
        }

        Collections.sort(result);

        Assert.assertEquals(result.get(0), "Bach", "First line should contain Bach value");
        Assert.assertEquals(result.get(1), "Conway", "First line should contain Conway value");
        Assert.assertEquals(result.get(2), "Doe", "First line should contain Doe value");
        Assert.assertEquals(result.get(3), "Smith", "First line should contain Smith value");
    }
}
