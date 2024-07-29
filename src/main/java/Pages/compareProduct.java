package Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;


public class compareProduct {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public compareProduct(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        PageFactory.initElements(driver, this);

    }
    public static void scrollBy(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }


    public static void navigateTo(String url) {
        driver.get("https://www.mediaexpert.pl/agd-do-zabudowy");
    }


    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    public static WebElement cookiesBar;

    public static void clickOnCookiesBar() {
        wait.until(ExpectedConditions.elementToBeClickable(cookiesBar)).click();
    }

    @FindBy(xpath = "//p[@class='name is-regular'][contains(text(),'Płyty indukcyjne')]")
    public static WebElement productCategory;

    public static void clickProductCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(productCategory)).click();

    }

    @FindBy(xpath = "(//span[@class='label compare-link-text-new'][normalize-space()='Porównaj'])[1]")
    public static WebElement product1;

    public static void chooseProduct1() {
        scrollBy(0, 750);
        wait.until(ExpectedConditions.elementToBeClickable(product1)).click();
    }

    @FindBy(xpath = "(//span[contains(text(),'Porównaj')])[2]")
    public static WebElement product2;


        public static void chooseProduct2() {
            scrollBy(0, 750);
            wait.until(ExpectedConditions.elementToBeClickable(product2)).click();
    }

    @FindBy(xpath = "//span[@class='is-small']")
    public static WebElement compare2Products;

    public static void clickCompare2Products() {
        wait.until(ExpectedConditions.elementToBeClickable(compare2Products)).click();


    }

    public static List<WebElement> getSelectedProducts() {
        By selectedProductsLocator = By.xpath("//div[contains(@class, \"comparison-product \")]");
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectedProductsLocator));
        return driver.findElements(selectedProductsLocator);
    }

}

