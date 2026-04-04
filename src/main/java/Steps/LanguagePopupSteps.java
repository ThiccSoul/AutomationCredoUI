package Steps;

import Page.LanguagePopup;
import Page.BasePage;
import org.openqa.selenium.WebDriver;

public class LanguagePopupSteps extends BasePage{

    private final LanguagePopup page;

    public LanguagePopupSteps(WebDriver driver) {
        super(driver);
        this.page = new LanguagePopup(driver);
    }

    public LanguagePopupSteps selectLanguage(String language) {
        wait.waitUntilVisible(page.languageElement(language)).click();
        return this;
    }


}

