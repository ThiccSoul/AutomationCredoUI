package Steps;

import Page.LoginPage;
import Page.BasePage;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.asserts.SoftAssert;
import org.apache.commons.lang3.RandomStringUtils;

public class LoginPageSteps extends BasePage {

    private final LoginPage page;
    private final SoftAssert softAssert = new SoftAssert();
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
        wait.waitUntilInvisible(page.errorPanel);
        WebElement languageSwitchBtn = wait.waitUntilVisible(page.languagePopupButton);
        languageSwitchBtn.click();

        return this;
    }

    @Step("assert error after invalid login")
    public LoginPageSteps errorAssertion(String expectedErrorMessage) {
        WebElement errorToast = wait.waitUntilVisible(page.errorElement);
        boolean isVisible = errorToast.isDisplayed();
        String actualErrorMessage = errorToast.getText();
        softAssert.assertTrue(isVisible, "Error toast is not visible");
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage,
                "Error message text does not match expected value");
        softAssert.assertAll();

        return this;
    }
}
