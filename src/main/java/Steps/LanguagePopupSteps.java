package Steps;

import Page.LanguagePopup;
import Page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;

public class LanguagePopupSteps extends BasePage{

    private final LanguagePopup page;

    public LanguagePopupSteps(WebDriver driver) {
        super(driver);
        this.page = new LanguagePopup(driver);
    }

    @Step("clicking on desired language button")
    public LanguagePopupSteps selectLanguage(String language) {
        wait.waitUntilVisible(page.languageElement(language)).click();
        return this;
    }


}

