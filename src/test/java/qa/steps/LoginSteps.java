package qa.steps;


import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import qa.pages.LoginPage;
import qa.utils.ConfigurationReader;

public class LoginSteps {
    LoginPage loginPage;
    ConfigurationReader configurationReader;

    public LoginSteps() {
        loginPage = new LoginPage();
        configurationReader = new ConfigurationReader();
    }

    @Given("^user is on the application home page$")
    public void launchApp() {
        Assert.assertTrue(loginPage.isUserNameDisplayed());
    }

    @When("^user enters valid loginID and Password$")
    public void enterValidCredentials() {
        loginPage.sendUserName(configurationReader.get("username"));
        loginPage.sendPassword(configurationReader.get("password"));
    }

    @When("^user enters ([^\"]*) in the userName field$")
    public void enterInValidUserName(String userString) {
        loginPage.sendUserName(userString);
    }

    @And("^user should see invalid username error$")
    public void verifyInvalidUsernameError() {
        Assert.assertTrue(loginPage.isUserNameErrorDisplayed());
    }

    @When("^user enters ([^\"]*) in the password field$")
    public void enterInValidPassword(String userString) {
        loginPage.sendPassword(userString);
    }

    @And("^user should see invalid password error$")
    public void verifyInvalidPasswordError() {
        Assert.assertTrue(loginPage.isPasswordErrorDisplayed());
    }

    @And("^user clicks submit button$")
    public void clickSubmitButton() {
        loginPage.clickLoginButton();
    }

    @Then("^user should be logged in$")
    public void userIsLoggedIn() {
// TODO - Add assertion to validate login page
    }

}
