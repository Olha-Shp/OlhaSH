package org.example.Pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;

import static java.awt.SystemColor.window;


public class compareProduct {
    private static WebDriver driver;
    private static WebDriverWait wait;

    public compareProduct(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);

    }
    public static void scrollBy(int x, int y) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(arguments[0], arguments[1]);", x, y);
    }
    public static void scrollToTop() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, 0);");
    }



    @FindBy(xpath = "//a[@class='products-menu__title-link' and text()='Котам']")
    public static WebElement productCategory;

    public static void clickProductCategory() {
        wait.until(ExpectedConditions.elementToBeClickable(productCategory)).click();

    }

    @FindBy(xpath = "//a[@href='/ua/shop/koshkam/suhoy-korm-dlya-koshek'][normalize-space()='']")
    public static WebElement subCategory;

    public static void clickSubCategory() {
        scrollBy(0, 400);
        wait.until(ExpectedConditions.elementToBeClickable(subCategory)).click();

    }

    @FindBy(xpath = "(//a[@title='Добавить в избранное'])[1]")
    public static WebElement product1;

    public static void chooseProduct1() {
        scrollBy(0, 300);
        wait.until(ExpectedConditions.elementToBeClickable(product1)).click();
    }

    @FindBy(xpath = "(//a[@title='Добавить в избранное'])[11]")
    public static WebElement product2;


        public static void chooseProduct2() {
            scrollBy(0, 350);
            wait.until(ExpectedConditions.elementToBeClickable(product2)).click();
    }

    @FindBy(xpath = "//*[@id=\"wishlist-widget\"]/a")
    public static WebElement compare2Products;

    public static void clickCompare2Products() {
        scrollToTop();
        wait.until(ExpectedConditions.elementToBeClickable(compare2Products)).click();


    }

    public static List<WebElement> getSelectedProducts() {
        By selectedProductsLocator = By.xpath("//div[@class='item-cart__favorites']");
        wait.until(ExpectedConditions.visibilityOfElementLocated(selectedProductsLocator));
        return driver.findElements(selectedProductsLocator);
    }

}

