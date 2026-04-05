package Steps;

import Page.LoginPage;
import Page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.apache.commons.lang3.RandomStringUtils;

public class LoginPageSteps extends BasePage {

    private final LoginPage page;
    String randomUserName = RandomStringUtils.randomAlphabetic(8);
    String randomPassword = RandomStringUtils.randomAlphanumeric(8);


    public LoginPageSteps(WebDriver driver) {
        super(driver);
        this.page = new LoginPage(driver);
    }

    @Step("invalid username input")
    public LoginPageSteps enterWrongUsername() {
        WebElement usernameField = wait.waitUntilVisible(page.usernameInput);
        usernameField.clear();
        usernameField.sendKeys(randomUserName);

        return this;
    }

    @Step("invalid password input")
    public LoginPageSteps enterWrongPassword() {
        WebElement passwordField = wait.waitUntilVisible(page.passwordInput);
        passwordField.clear();
        passwordField.sendKeys(randomPassword);

        return this;
    }

    @Step("clicking on submit button")
    public LoginPageSteps clickSubmitButton() {
        WebElement submitBtn = wait.waitUntilVisible(page.submitButton);
        submitBtn.click();

        return this;
    }

    @Step("click on language switch button")
    public LoginPageSteps clickLanguageSwitchButton() {
        wait.waitUntilInvisible(page.errorElement);
        WebElement languageSwitchBtn = wait.waitUntilVisible(page.languagePopupButton);
        languageSwitchBtn.click();

        return this;
    }

    @Step("asserting correct error message is shown")
    public void errorAssertion(String expectedErrorMessage) {
        wait.waitUntilVisible(page.errorElement);
        WebElement errorElem = wait.waitUntilVisible(page.errorPanel);
        String actualErrorMessage = errorElem.getText().trim();
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message mismatch!");

    }
}
