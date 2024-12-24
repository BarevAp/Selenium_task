import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public LoginPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(7));
    }

    public void login(String username, String password) throws InterruptedException {
        webDriver.get("https://podcastle.ai/");

        WebElement logIn = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@class='pc-header-login']")
        ));
        logIn.click();

        WebElement usernameField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@type = 'text' and @placeholder = 'Email']")
        ));
        usernameField.sendKeys(username);

        WebElement passwordField = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//input[@type = 'password' and @placeholder = 'Password']")
        ));
        passwordField.sendKeys(password);

        WebElement submit = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//button[contains(@type, 'submit')]")
        ));
        submit.click();

        Thread.sleep(3000);
    }
}
