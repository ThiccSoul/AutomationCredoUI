package Steps;

import Page.LanguagePopup;
import Page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LanguagePopupSteps extends BasePage{

    private final LanguagePopup page;

    public LanguagePopupSteps(WebDriver driver) {
        super(driver);
        this.page = new LanguagePopup(driver);
    }

    @Step("clicking on desired language button")
    public LanguagePopupSteps clickLanguageElement(String language) {
        WebElement langElem = wait.waitUntilVisible(page.languageElement(language));
        langElem.click();
        return this;
    }
}


