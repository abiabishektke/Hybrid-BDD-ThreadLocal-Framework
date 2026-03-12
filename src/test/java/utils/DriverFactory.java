package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.Dimension;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverFactory {

    public static WebDriver initializeBrowser(String browser) {

        WebDriver driver = null;

        switch (browser.toLowerCase()) {

        case "chrome":

            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--headless=new");
            chromeOptions.addArguments("--disable-gpu");
            chromeOptions.addArguments("--window-size=1920,1080");

            driver = new ChromeDriver(chromeOptions);
            break;

        case "edge":

            EdgeOptions edgeOptions = new EdgeOptions();
            edgeOptions.addArguments("--headless=new");
            edgeOptions.addArguments("--disable-gpu");
            edgeOptions.addArguments("--window-size=1920,1080");

            driver = new EdgeDriver(edgeOptions);
            break;

        case "firefox":

            FirefoxOptions firefoxOptions = new FirefoxOptions();
            firefoxOptions.addArguments("--headless");

            driver = new FirefoxDriver(firefoxOptions);
            break;

        default:
            throw new IllegalArgumentException("Browser not supported: " + browser);
        }

        driver.manage().window().setSize(new Dimension(1920,1080));

        return driver;
    }
}