package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class oneProduct {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public oneProduct(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(25));
        PageFactory.initElements(driver, this);

    }

    public static void scrollBy(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }

    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    public static WebElement cookiesBar;

    public static void clickOnCookiesBar() {
        wait.until(ExpectedConditions.elementToBeClickable(cookiesBar)).click();
    }

    @FindBy(xpath = "//div[@class='menu-bar']//span[@class='item-name'][normalize-space()='Gaming']")
    public static WebElement gaming;

    public static void clickGaming() {
        wait.until(ExpectedConditions.elementToBeClickable(gaming)).click();
    }

    @FindBy(xpath = "//div[@lazyload='true']//img[@alt='Konsole przenośne']")
    public static WebElement consoles;

    public static void clickConsoles() {
        wait.until(ExpectedConditions.elementToBeClickable(consoles)).click();

    }

    @FindBy(xpath = "//div[@class='filter-group']//a[@class='show-more is-hover-underline is-primary ui-link spark-link-raw'][contains(text(),'Pokaż więcej')]")
    public static WebElement filtersMore;

    public static void getMoreFilters(){
        scrollBy(0, 450);
        wait.until(ExpectedConditions.elementToBeClickable(filtersMore)).click();

    }

    @FindBy(xpath = "//a[@title='Konsole przenośne - MARKA: LOGITECH']")
    public static WebElement Logitech;

    public static void chooseLogitech() {
//        scrollBy(0, 650);
        wait.until(ExpectedConditions.elementToBeClickable(Logitech)).click();

    }

    @FindBy(xpath = "//button[@class='spark-button btn-filter is-tablet is-primary is-default icon-left is-new-loading']")
    public static WebElement filters;

    public static void clickFilters() {
        wait.until(ExpectedConditions.elementToBeClickable(filters)).click();

    }

    public static WebElement selectProductByIndex(int index) {
        scrollBy(0, 200);
        By productLocator = By.xpath("//a[@class='is-animate ui-link']");
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productLocator));
        if (index < 0 || index >= products.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return products.get(index);
    }
    public static List<WebElement> getSelectedProducts() {
        scrollBy(0, 200);
        By selectedProductsLocator = By.xpath("//a[@class='is-animate ui-link']");
        return driver.findElements(selectedProductsLocator);
    }

}