import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Test {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        Verification verification = new Verification(driver);
        String workspaceName = "Selenium workspace";

        try {
            LoginPage loginPage = new LoginPage(driver);
            loginPage.login("test@mailinator.com", "123456");

            verification.sizeBeforeCreation("//ul[@class]/li");

            Workspace workspace = new Workspace(driver);
            workspace.createWorkspace(workspaceName);

            verification.isIconCreated("//ul[@class]/li");

            WebElement name = driver.findElement(By.xpath("//p[contains(@class, 'typo-small-medium')][following-sibling::ul]"));
            verification.verifyWorkspaceName(name, workspaceName);

            workspace.deleteWorkspace(workspaceName);
        } catch (Exception e) {
            System.out.println("Test failed: " + e.getMessage());
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}