package hooks;

import java.io.FileInputStream;
import java.util.Properties;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.BrowserUtil;
import utils.DriverFactory;

public class Hooks {

    @Before
    public void setUp() throws Exception {

        Properties prop = new Properties();
        FileInputStream fis = new FileInputStream("src/test/resources/config/config.properties");
        prop.load(fis);

        String browser = prop.getProperty("browser");
        String url = prop.getProperty("url");

        BrowserUtil.setDriver(DriverFactory.initDriver(browser));
        BrowserUtil.getDriver().get(url);
    }

    @After
    public void tearDown() {
        BrowserUtil.getDriver().quit();
        BrowserUtil.removeDriver();
    }
}