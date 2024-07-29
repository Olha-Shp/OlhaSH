package Pages;

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
    @FindBy(xpath = "//*[@id=\"onetrust-accept-btn-handler\"]")
    public static WebElement cookiesBar;

    public static void clickOnCookiesBar(){
        wait.until(ExpectedConditions.elementToBeClickable(cookiesBar)).click();
    }

    @FindBy(xpath = "//span[@class='title is-regular']")
    public static WebElement loginButton;

    public static void clickOnLoginButton(){
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }


    @FindBy(xpath = "//input[@type='email']")
    public static WebElement mailInput;
    public static void enterMail(){
        mailInput.sendKeys("javamakesmecry@gmail.com");

    }
    @FindBy(xpath = "//input[@type='password']")
    public static WebElement passwordInput;
    public static void enterPassword(){
        passwordInput.sendKeys("123456");
    }

    @FindBy(xpath = "//button[@class='spark-button submit is-primary is-default icon-left is-new-loading']")
    public static WebElement submitButton;

    public static void clickOnSubmitButton(){
        wait.until(ExpectedConditions.elementToBeClickable(submitButton)).click();
    }

    @FindBy(xpath = "//div[@class='alert-content']")
    public static WebElement errorMessage;
    String ExpectedErrorMessage = "Nieprawidłowa nazwa użytkownika lub hasło.";
    public static void getTextErrorMessage(){
        System.out.printf(errorMessage.getText());
    }

}


