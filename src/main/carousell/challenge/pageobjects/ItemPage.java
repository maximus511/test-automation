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
 * Page object class for Item page
 */
public class ItemPage {

    private AppiumDriver driver;

    @AndroidFindBy(id = "text_buy")
    private MobileElement buyButton;

    @AndroidFindBy(id = "text_chat")
    private MobileElement chatButton;

    @AndroidFindBy(id = "feature_button")
    private MobileElement featureButton;

    public ItemPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
        this.driver = driver;
    }

    /**
     * Click on Buy
     * @return
     */
    public OfferPage clickBuyButton() {
        Logger.getAnonymousLogger().log(Level.INFO, "Click on Buy button");
        clickElement(buyButton);
        return new OfferPage(driver);
    }

    /**
     * Handle feature popup and click on "OK, Got it"
     * @return
     */
    public ItemPage acceptFeatureButton() {
        Logger.getAnonymousLogger().log(Level.INFO, "Accept feature action for product page");
        clickElement(featureButton);
        return new ItemPage(driver);
    }

}
