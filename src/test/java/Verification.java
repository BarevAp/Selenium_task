import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Verification {

    private final WebDriver driver;
    private int beforeSize;

    public Verification(WebDriver driver) {
        this.driver = driver;
    }

    public void sizeBeforeCreation(String xpath) {
        this.beforeSize = getListSize(xpath);
    }

    public int getListSize(String xpath) {
        List<WebElement> elements = driver.findElements(By.xpath(xpath));
        return elements.size();
    }

    public void isIconCreated(String xpath) {
        try {
            int afterSize = getListSize(xpath);
            if (afterSize > beforeSize)
                System.out.println("Icon is created");
        } catch (Exception e) {
            System.out.println("Error can't detect icon: " + e.getMessage());
        }
    }

    public void verifyWorkspaceName(WebElement element, String expectedName) {
        try {
            String actualName = element.getText();
            assertEquals(expectedName, actualName);
            System.out.println("Workspace created with the correct name");
        } catch (AssertionError e) {
            System.out.println("Assertion failed: " + e.getMessage());
        }
    }
}
