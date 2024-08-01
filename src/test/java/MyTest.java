import org.example.Pages.compareProduct;
import org.example.Pages.mainPage;
import org.example.Pages.oneProduct;
import io.qameta.allure.testng.AllureTestNg;
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
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.example.Pages.compareProduct.*;
import static org.testng.Assert.assertEquals;

@Listeners({AllureTestNg.class})
public class MyTest {
    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeTest
    public void SetupDriver() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-blink-features=AutomationControlled");
        driver = new ChromeDriver(options);
        driver.get("https://zoolandia.com.ua/ua/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        mainPage mainPage = new mainPage(driver);
        compareProduct compareProduct = new compareProduct(driver);
        oneProduct oneProduct = new oneProduct(driver);
        driver.manage().window().maximize();
        JavascriptExecutor js = (JavascriptExecutor) driver;
    }

    @Test
    public void loginTest() {
        mainPage.clickOnLoginButton();
        mainPage.enterMail();
        mainPage.enterPassword();
        mainPage.clickOnSubmitButton();
        String expectedErrorMessage = "Невірний логін або пароль";
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("div[class='has-error text-center'] span")));
        assertEquals(mainPage.errorMessage.getText(), expectedErrorMessage, "Error message is not equal");

    }

    @Test
public void compareTest(){
        compareProduct.clickProductCategory();
        compareProduct.clickSubCategory();
        compareProduct.chooseProduct1();
        compareProduct.chooseProduct2();
        compareProduct.clickCompare2Products();
        List<WebElement> selectedProducts = getSelectedProducts();
        System.out.println("Number of selected products: " + selectedProducts.size());
        assertEquals(String.valueOf(selectedProducts.size()), "2", "Size of selection is not equal 2" );
    }

    @Test
    public void oneProductSelection(){
        oneProduct.clickReptiles();
        oneProduct.clickReptileFood();
        oneProduct.choosePryroda();
        WebElement selectedProduct = oneProduct.selectProductByIndex(0);
        List<WebElement> selectedProducts = oneProduct.getSelectedProducts();
        assertEquals(selectedProducts.size(), 1, "Size of selection is not equal to 1");

    }



    @AfterTest
    void closeDriver(){
       driver.quit();

    }
}
