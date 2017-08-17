package main.carousell.challenge.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.concurrent.TimeUnit;

import static main.carousell.challenge.utility.CommonUtils.*;

/**
 * Page object class for Enter Offer page
 */
public class OfferPage {

    private AppiumDriver driver;

    @AndroidFindBy(id = "text_offer")
    private MobileElement offerTextElement;

    @AndroidFindBy(id = "action_submit")
    private MobileElement submitButtonElement;

    @AndroidFindBy(id = "button1")
    private MobileElement confirmButtonElement;


    public OfferPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
        this.driver = driver;
    }

    /**
     * Edit offer price
     * @param amount
     * @return
     */
    public OfferPage editOfferPrice(String amount) {
        setElementValue(offerTextElement, amount);
        return this;
    }

    /**
     * Submit offer
     * @return
     */
    public ChatPage submitOffer() {
        clickElement(submitButtonElement);
        clickElement(confirmButtonElement);
        return new ChatPage(driver);
    }

    public MobileElement getOfferTextElement() {
        return offerTextElement;
    }
}
