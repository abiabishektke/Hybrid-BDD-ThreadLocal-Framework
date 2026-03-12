package hooks;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import com.assertthat.selenium_shutterbug.core.Capture;
import com.assertthat.selenium_shutterbug.core.Shutterbug;
import io.cucumber.java.Scenario;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BrowserUtil;
import utils.DriverFactory;

public class Hooks {

    @Before
    public void setUp() throws Exception {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src\\test\\java\\config\\config.properties");
        prop.load(fis);

        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");

        BrowserUtil.setDriver(DriverFactory.initDriver(browser));
        BrowserUtil.getDriver().get(url);
    }

    @After
    public void tearDown(Scenario scenario) {

        if (scenario.isFailed()) {

            WebDriver driver = BrowserUtil.getDriver();

            String fileName = scenario.getName().replaceAll(" ", "_");

            Shutterbug.shootPage(driver, Capture.FULL_SCROLL)
                      .save("ExtentReports/Screenshots/" + fileName + ".png");
        }

        BrowserUtil.getDriver().quit();
        BrowserUtil.removeDriver();
    }
}