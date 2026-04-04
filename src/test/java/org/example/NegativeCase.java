package org.example;

import Steps.LanguagePopupSteps;
import Steps.LoginPageSteps;
import Utils.BrowserConfig;
import io.qameta.allure.*;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class NegativeCase extends BrowserConfig {

    private LoginPageSteps loginSteps;
    private LanguagePopupSteps languagePopupSteps;

    @BeforeClass
    public void pageSetup() {
        loginSteps = new LoginPageSteps(getDriver());
        languagePopupSteps = new LanguagePopupSteps(getDriver());
    }

    @Epic("Authentication")
    @Feature("Login")
    @Story("User tries invalid credentials")
    @Severity(SeverityLevel.CRITICAL)
    @Description("Ensure system shows proper error when username or password is invalid")
    @Test(dataProvider = "languagesAndTheirErrorTexts", dataProviderClass = Data.DataSets.class)
    public void loginWithWrongCredentialsAndErrorAssertion(String language, String expectedErrorMessage){
        loginSteps.clickLanguageSwitchButton();
        languagePopupSteps.selectLanguage(language);
        loginSteps.enterWrongUsername();
        loginSteps.enterWrongPassword();
        loginSteps.clickSubmitButton();
        loginSteps.errorAssertion(expectedErrorMessage);
    }
}