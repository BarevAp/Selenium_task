import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class Workspace {

    private final WebDriver driver;
    private final WebDriverWait wait;

    public Workspace(WebDriver webDriver) {
        this.driver = webDriver;
        this.wait = new WebDriverWait(webDriver, Duration.ofSeconds(10));
    }

    public void createWorkspace(String workspaceName) {
        try {
            WebElement addWorkspace = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//button[contains(@class, 'border-border-variant-1')]")
            ));
            addWorkspace.click();

            WebElement workspaceNameField = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//input[@placeholder='Name your Workspace']")
            ));
            workspaceNameField.sendKeys(workspaceName);

            Thread.sleep(2000);

            WebElement teamSize = driver.findElement(By.xpath("//div[contains(@class, 'placeholder')]"));
            teamSize.click();

            List<WebElement> selectSize = driver.findElements(By.xpath("//div[@tabindex='-1']"));
            Random random = new Random();
            int randomIndex = random.nextInt(selectSize.size());
            WebElement selectedSize = wait.until(ExpectedConditions.elementToBeClickable(selectSize.get(randomIndex)));
            selectedSize.click();

            WebElement setUp = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Set up and continue']")));
            setUp.click();

            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void deleteWorkspace(String workspaceName) {
        try {
            WebElement workspaceSettings = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='Workspace settings']")
            ));
            workspaceSettings.click();

            WebElement delete = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='Delete Workspace']")
            ));
            delete.click();

            WebElement confirmDelete = wait.until(ExpectedConditions.elementToBeClickable(
                    By.xpath("//span[text()='Delete']")
            ));
            confirmDelete.click();

            Thread.sleep(3000);
        } catch (Exception e) {
            System.out.println("Error deleting workspace '" + workspaceName + "': " + e.getMessage());
        }
    }
}

