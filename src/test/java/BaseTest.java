import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.HashMap;

public class BaseTest {

    WebDriver driver;
    public final String URL = "http://the-internet.herokuapp.com/";
    public String downloadPath = System.getProperty("user.dir");
    ChromeOptions options = new ChromeOptions();

    @BeforeMethod
    public void setup() {

        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
        options.setHeadless(false);
        setChromeFileDownload();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
    }

    private void setChromeFileDownload() {

        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", downloadPath);
        options.setExperimentalOption("prefs", chromePrefs);

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

}
