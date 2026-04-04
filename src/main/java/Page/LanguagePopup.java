package Page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LanguagePopup extends BasePage {

    public LanguagePopup(WebDriver driver) {
        super(driver);
    }

    public WebDriver driver() {
        return driver;
    }

    public By languageElement(String language) {
        return By.xpath("//div[@class='popup-wrapper']//p[text()='" + language + "']");
    }
}
