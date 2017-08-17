package main.carousell.challenge.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static main.carousell.challenge.utility.CommonUtils.*;

/**
 * Page object class for Login page
 */
public class LoginPage {
    private AppiumDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='LOGIN']")
    private MobileElement loginElement;

    @AndroidFindBy(id = "tabs")
    private MobileElement tabElement;

    @AndroidFindBy(id = "text_username")
    private MobileElement userIdField;

    @AndroidFindBy(id = "text_password")
    private MobileElement pwdField;

    @AndroidFindBy(id = "action_signin")
    private MobileElement loginButton;

    public LoginPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
        this.driver = driver;
    }

    /**
     * Click on Login tab
     * @return
     */
    public LoginPage clickOnLoginTab() {
        clickElement(loginElement);
        return this;
    }

    /**
     * Function for handling login action
     * @param username
     * @param password
     * @return
     */
    public DashboardPage loginAction(String username, String password) {
        setElementValue(userIdField, username);
        setElementValue(pwdField, password);
        clickElement(loginButton);
        return new DashboardPage(driver);
    }

}
