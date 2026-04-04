package Page;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
public class LoginPage extends BasePage {

    public final By
            usernameInput = By.cssSelector("#userName"),
            passwordInput = By.cssSelector("#newPass"),
            submitButton  = By.cssSelector("#submitAuth"),
            errorElement  = By.cssSelector(".notification-container.error"),
            languagePopupButton = By.cssSelector("#languageSwitcherBtn"),
            errorPanel = By.cssSelector("app-notification-panel .notification-container.error");


    public LoginPage(WebDriver driver) {
        super(driver);
    }

}