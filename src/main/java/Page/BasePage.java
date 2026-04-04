package Page;

import Utils.WaitUtils;
import org.openqa.selenium.WebDriver;

public abstract class BasePage {

    protected WebDriver driver;
    protected WaitUtils wait;

    protected BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WaitUtils(driver);
    }
}