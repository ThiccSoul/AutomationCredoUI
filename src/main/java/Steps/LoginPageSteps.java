package Steps;

import Page.LoginPage;
import Utils.BasePage;
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
    public void enterWrongUsername() {
        WebElement usernameField = waitUntilVisible(page.usernameInput);
        usernameField.clear();
        usernameField.sendKeys(randomUserName);
    }

    @Step("invalid password input")
    public void enterWrongPassword() {
        WebElement passwordField = waitUntilVisible(page.passwordInput);
        passwordField.clear();
        passwordField.sendKeys(randomPassword);
    }

    @Step("clicking on submit button")
    public void clickSubmitButton() {
        WebElement submitBtn = waitUntilVisible(page.submitButton);
        submitBtn.click();
    }

    @Step("click on language switch button")
    public void clickLanguageSwitchButton() {
        waitUntilInvisible(page.errorPanel);
        WebElement languageSwitchBtn = waitUntilVisible(page.languagePopupButton);
        languageSwitchBtn.click();
    }

    @Step("assert error after invalid login")
    public void errorAssertion(String expectedErrorMessage) {
        WebElement errorToast = waitUntilVisible(page.errorElement);
        boolean isVisible = errorToast.isDisplayed();
        String actualErrorMessage = errorToast.getText();
        softAssert.assertTrue(isVisible, "Error toast is not visible");
        softAssert.assertEquals(actualErrorMessage, expectedErrorMessage,
                "Error message text does not match expected value");
        softAssert.assertAll();
    }
}
