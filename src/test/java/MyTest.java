import Pages.compareProduct;
import Pages.mainPage;
import Pages.oneProduct;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static Pages.compareProduct.*;
import static org.testng.Assert.assertEquals;

public class MyTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void SetupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
//        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        driver.get("https://www.mediaexpert.pl/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        mainPage mainPage = new mainPage(driver);
        compareProduct compareProduct = new compareProduct(driver);
        oneProduct oneProduct = new oneProduct(driver);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
    }

    @Test
    public void loginTest() {
        mainPage.clickOnCookiesBar();
        mainPage.clickOnLoginButton();
        mainPage.enterMail();
        mainPage.enterPassword();
        mainPage.clickOnSubmitButton();
        String expectedErrorMessage = "Nieprawidłowa nazwa użytkownika lub hasło.";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert-content']")));
        assertEquals(mainPage.errorMessage.getText(), expectedErrorMessage, "Error message is not equal");

    }

    @Test
public void compareTest(){
        compareProduct.navigateTo("https://www.mediaexpert.pl/agd-do-zabudowy");
        compareProduct.clickOnCookiesBar();
        compareProduct.clickProductCategory();
        compareProduct.chooseProduct1();
        compareProduct.chooseProduct2();
        compareProduct.clickCompare2Products();
        List<WebElement> selectedProducts = getSelectedProducts();
        System.out.println("Number of selected products: " + selectedProducts.size());
        assertEquals(String.valueOf(selectedProducts.size()), "2", "Size of selection is not equal 2" );
    }

    @Test
    public void oneProductSelection(){
        oneProduct.clickOnCookiesBar();
        oneProduct.clickGaming();
        oneProduct.clickConsoles();
        oneProduct.getMoreFilters();
        oneProduct.chooseLogitech();
        oneProduct.clickFilters();
        WebElement selectedProduct = oneProduct.selectProductByIndex(0);
        List<WebElement> selectedProducts = oneProduct.getSelectedProducts();
        assertEquals(selectedProducts.size(), 1, "Size of selection is not equal to 1");

    }



    @AfterTest
    void closeDriver(){
        driver.quit();

    }
}
