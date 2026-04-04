package Page;

import Utils.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LanguagePopup extends BasePage {

    public final By
            chosenLanguage = By.cssSelector("#languageSwitcherBtn > p");

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
