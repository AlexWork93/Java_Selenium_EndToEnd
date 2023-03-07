package AbstractHelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    protected void waitUntilElementInCondition(ExpectedCondition<?> condition, int TimeoutSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(TimeoutSeconds));
        wait.until(condition);
    }

    protected void openUrl(String URL) {
        driver.get(URL);
    }

    protected void waitUntilPageIsReady(By locator){
        if (true){
            //here could be code for confirming or skipping some popup message with similar locator for any page
        }
        waitUntilElementInCondition(ExpectedConditions.visibilityOfElementLocated(locator), WaitsPack.FIVE_SECOND.getTimeout());
    }

    protected void waitUntilPageIsReady(){
    }
}
