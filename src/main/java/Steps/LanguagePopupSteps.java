package Steps;

import Page.LanguagePopup;
import Utils.BasePage;
import org.openqa.selenium.WebDriver;

public class LanguagePopupSteps extends BasePage{

    private final LanguagePopup page;

    public LanguagePopupSteps(WebDriver driver) {
        super(driver);
        this.page = new LanguagePopup(driver);
    }

    public LanguagePopupSteps selectLanguage(String language) {
        waitUntilVisible(page.languageElement(language)).click();
        return this;
    }


}

