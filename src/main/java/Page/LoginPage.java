package Page;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(css = "#userName")
    public WebElement usernameInput;

    @FindBy(css = "#newPass")
    public WebElement passwordInput;

    @FindBy(css = "#submitAuth")
    public WebElement submitButton;

    @FindBy(css = ".notification-container.error")
    public WebElement errorElement;

    @FindBy(css = "#languageSwitcherBtn")
    public WebElement languagePopupButton;

    @FindBy(css = "app-notification-panel .notification-container.error")
    public WebElement errorPanel;


    public LoginPage(WebDriver driver) {
        super(driver);
    }

}