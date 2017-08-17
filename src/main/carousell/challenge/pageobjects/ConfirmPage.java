package main.carousell.challenge.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static main.carousell.challenge.utility.CommonUtils.clickElement;

/**
 * Page object class for Confirmation popup
 */
public class ConfirmPage {

    private AppiumDriver driver;

    @AndroidFindBy(id = "button1")
    private MobileElement confirmButtonElement;

    @AndroidFindBy(id = "button2")
    private MobileElement declineButtonElement;

    public ConfirmPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
        this.driver = driver;
    }

    /**
     * Confirm or Click on yes
     * @return
     */
    public ChatPage confirm() {
        Logger.getAnonymousLogger().log(Level.INFO, "Confirm action");
        clickElement(confirmButtonElement);
        return new ChatPage(driver);
    }

}
