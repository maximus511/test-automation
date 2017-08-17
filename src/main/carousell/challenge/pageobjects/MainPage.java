package main.carousell.challenge.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static main.carousell.challenge.utility.CommonUtils.*;

/**
 * Page object class for Main App page
 */
public class MainPage {

    private AppiumDriver driver;

    @AndroidFindBy(id = "email_signin_button")
    private WebElement emailButtonElement;

    public MainPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS),
                this);
        this.driver = driver;
    }

    /**
     * Click on Email login
     * @return
     */
    public LoginPage clickOnEmailLogin() {
        clickElement(emailButtonElement);
        return new LoginPage(driver);
    }
}
