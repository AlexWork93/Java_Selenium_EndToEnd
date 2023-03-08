package AbstractHelpers;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }

    private final By successNotificationLocator = By.cssSelector("[role='alertdialog']");
    private final By cartButtonLocator = By.cssSelector("[routerlink='/dashboard/cart']");


    protected void waitUntilElementInCondition(ExpectedCondition<?> condition, WaitsPack timeout) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout.getTimeout()));
        wait.until(condition);
    }

    protected void openUrl(String URL) {
        driver.get(URL);
    }

    protected void waitUntilPageIsReady(By locator){
        if (true){
            //here could be code for confirming or skipping some popup message with similar locator for any page
        }
        waitUntilElementInCondition(ExpectedConditions.visibilityOfElementLocated(locator), WaitsPack.FIVE_SECOND);
    }

    protected void waitUntilPageIsReady(){
    }

    protected void verifyNotificationWithTextIsDisplayed(NotificationMessages notificationText) throws Exception {
        waitUntilElementInCondition(ExpectedConditions.visibilityOfElementLocated(successNotificationLocator), WaitsPack.FIVE_SECOND);
        WebElement notification = driver.findElement(successNotificationLocator);
        String actualNotificationText = notification.getText();
        if (!actualNotificationText.equalsIgnoreCase(notificationText.getMessage())){
            throw new Exception("Expected notification text:\n" + notificationText.getMessage() + "\nActual notification text:\n" + actualNotificationText);
        }
        //This click should close the notification
        notification.click();
    }

    public void openCart() {
        driver.findElement(cartButtonLocator).click();
    }
}
