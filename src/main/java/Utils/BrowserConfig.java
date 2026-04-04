package Utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import static Data.Constants.CREDO_URL;

public class BrowserConfig {

    private static final Logger logger = LoggerFactory.getLogger(BrowserConfig.class);
    protected static WebDriver driver;

    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        logger.info("Initializing WebDriver for browser: {}", browser);
        driver = initializeDriver(browser);
        driver.manage().window().maximize();
        driver.get(CREDO_URL);
        logger.info("{} browser launched successfully and window maximized.", browser);
    }

    private WebDriver initializeDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "firefox":
                WebDriverManager.firefoxdriver().setup();
                return new FirefoxDriver(new FirefoxOptions());
            case "edge":
                WebDriverManager.edgedriver().setup();
                return new EdgeDriver(new EdgeOptions());
            case "chrome":
            default:
                WebDriverManager.chromedriver().setup();
                return new ChromeDriver(new ChromeOptions());
        }
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        if (driver != null) {
            try {
                driver.quit();
                logger.info("Browser closed successfully.");
            } catch (Exception e) {
                logger.error("Error closing browser", e);
            }
        }
    }
}
