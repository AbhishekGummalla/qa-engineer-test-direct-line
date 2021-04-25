package qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    public LoginPage() {
        PageFactory.initElements(driver, this);
        this.wait = new WebDriverWait(this.driver, 50);
    }

    @FindBy(how = How.NAME, using = "loginUsername")
    private WebElement userName;
    @FindBy(how = How.NAME, using = "loginPassword")
    private WebElement password;
    @FindBy(how = How.XPATH, using = "//*[text()='Login']")
    private WebElement loginButton;
    @FindBy(how = How.XPATH, using = "") // TODO - update the element locator
    private WebElement userNameError;
    @FindBy(how = How.XPATH, using = "") // TODO - update the element locator
    private WebElement passwordError;

    public Boolean isUserNameDisplayed() {
        return userName.isDisplayed();
    }

    public Boolean isUserNameErrorDisplayed() {
        return userNameError.isDisplayed();
    }

    public Boolean isPasswordErrorDisplayed() {
        return passwordError.isDisplayed();
    }

    public void sendUserName(String userName) {
        this.userName.sendKeys(userName);
    }

    public void sendPassword(String password) {
        this.password.sendKeys(password);
    }

    public void clickLoginButton() {
        loginButton.click();
    }
}
