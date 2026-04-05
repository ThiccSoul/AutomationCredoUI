package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LanguagePopup extends BasePage {

    public LanguagePopup(WebDriver driver) {
        super(driver);
    }

    public WebDriver driver() {
        return driver;
    }

    public WebElement languageElement(String language) {
        return driver.findElement(By.xpath("//div[@class='popup-wrapper']//p[text()='" + language + "']"));
    }
}

