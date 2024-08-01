package org.example.Pages;

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


    @FindBy(xpath = "//a[@class='products-menu__title-link' and @href='/ua/shop/reptilii-i-cherepahi' and text()='Рептиліям']")
    public static WebElement reptiles;

    public static void clickReptiles() {
        wait.until(ExpectedConditions.elementToBeClickable(reptiles)).click();
    }

    @FindBy(xpath = "//a[contains(@href, 'reptilii-i-cherepahi/korm-dlya-reptiliy-i-cherepah') and contains(text(), 'Корм для рептилій і черепах')]")
    public static WebElement reptileFood;

    public static void clickReptileFood() {
        scrollBy(0, 350);
        wait.until(ExpectedConditions.elementToBeClickable(reptileFood)).click();

    }


    @FindBy(xpath = "//input[@id='mp-4']")
    public static WebElement pryroda;

    public static void choosePryroda() {
        scrollBy(0, 450);
        wait.until(ExpectedConditions.elementToBeClickable(pryroda)).click();

    }


    public static WebElement selectProductByIndex(int index) {
        scrollBy(0, 200);
        By productLocator = By.cssSelector(".product-list__caption-title");
        List<WebElement> products = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(productLocator));
        if (index < 0 || index >= products.size()) {
            throw new IndexOutOfBoundsException("Index out of bounds: " + index);
        }
        return products.get(index);
    }
    public static List<WebElement> getSelectedProducts() {
        scrollBy(0, 200);
        By selectedProductsLocator = By.cssSelector(".product-list__caption-title");
        return driver.findElements(selectedProductsLocator);
    }

}