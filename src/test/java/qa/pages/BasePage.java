package qa.pages;

import io.github.bonigarcia.wdm.WebDriverManager;
import qa.utils.ConfigurationReader;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    WebDriver driver;
    ConfigurationReader configurationReader;
    protected WebDriverWait wait;

    //TODO - To move - driver initialization within @Before hook
    public BasePage() {
        configurationReader = new ConfigurationReader();
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(configurationReader.get("appUrl"));
    }

    //TODO - To move - quit driver to @After hook
    public void quitDriver() {
        driver.quit();
    }
}