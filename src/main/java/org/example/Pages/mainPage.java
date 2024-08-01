package org.example.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class mainPage {
    private WebDriver driver;
    private static WebDriverWait wait;

    public mainPage(WebDriver driver){
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);

    }


    @FindBy(xpath = "//a[contains(text(),'Кабінет')]")
    public static WebElement loginButton;

    public static void clickOnLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }


    @FindBy(xpath = "//input[@name='data[email]']")
    public static WebElement mailInput;
    public static void enterMail(){
        mailInput.sendKeys("javamakesmecry@gmail.com");

    }
    @FindBy(xpath = "//input[@name='data[password]']")
    public static WebElement passwordInput;
    public static void enterPassword(){
        passwordInput.sendKeys("123456");
    }

    @FindBy(xpath = "//input[@value='Увійти']")
    public static WebElement submitButton;

    public static void clickOnSubmitButton(){
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    @FindBy(css = "div[class='has-error text-center'] span")
    public static WebElement errorMessage;
    String ExpectedErrorMessage = "Невірний логін або пароль";
    public static void getTextErrorMessage(){
        System.out.printf(errorMessage.getText());
    }

}


