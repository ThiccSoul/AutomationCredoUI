package Utils;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.*;
import org.openqa.selenium.edge.*;
import org.openqa.selenium.firefox.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.*;

import static Data.Constants.CREDO_URL;

public class BrowserConfig {

    private static final Logger logger = LoggerFactory.getLogger(BrowserConfig.class);

    @BeforeClass
    @Parameters("browser")
    public void setUp(@Optional("chrome") String browser) {
        logger.info("Initializing WebDriver for browser: {}", browser);

        WebDriver driver = initializeDriver(browser);
        DriverManager.setDriver(driver);

        driver.manage().window().maximize();
        driver.get(CREDO_URL);

        logger.info("{} browser launched successfully.", browser);
    }

    private WebDriver initializeDriver(String browser) {
        return switch (browser.toLowerCase()) {
            case "firefox" -> new FirefoxDriver(new FirefoxOptions());
            case "edge" -> new EdgeDriver(new EdgeOptions());
            default -> new ChromeDriver(new ChromeOptions());
        };
    }

    @AfterClass(alwaysRun = true)
    public void tearDown() {
        WebDriver driver = DriverManager.getDriver();

        if (driver != null) {
            try {
                driver.quit();
                DriverManager.unload();
                logger.info("Browser closed successfully.");
            } catch (Exception e) {
                logger.error("Error closing browser", e);
            }
        }
    }
}