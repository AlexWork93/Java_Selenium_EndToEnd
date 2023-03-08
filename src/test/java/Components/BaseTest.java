package Components;

import Pages.CartPage;
import Pages.CataloguePage;
import Pages.CheckoutPage;
import Pages.LandingPage;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    public LandingPage landingPage;
    public CataloguePage cataloguePage;
    public CartPage cartPage;
    public CheckoutPage checkoutPage;
    private void setUdDriver() throws IOException {
        Properties properties = new Properties();
        FileInputStream propStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/java/resources/GlobalData/properties");
        properties.load(propStream);
        if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {
            driver = new ChromeDriver();
        }else {
            //there could be implementation for any other driver
        }
        driver.manage().window().setSize(new Dimension((int) (1920 * 0.8), (int) (1080 * 0.8)));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }
    @BeforeMethod
    public void beforeMethod() throws IOException {
        setUdDriver();
        landingPage = new LandingPage(driver);
        cataloguePage = new CataloguePage(driver);
        cartPage = new CartPage(driver);
        checkoutPage = new CheckoutPage(driver);
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
