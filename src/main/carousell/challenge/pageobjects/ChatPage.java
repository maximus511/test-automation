package main.carousell.challenge.pageobjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

import static main.carousell.challenge.utility.CommonUtils.clickElement;

/**
 * Page object class for Chat page
 */
public class ChatPage {

    private AppiumDriver driver;

    @AndroidFindBy(id = "text_chat_action")
    private List<MobileElement> offerTextElementList;

    @AndroidFindBy(id = "button_chat_right")
    private MobileElement editOfferButtonElement;

    @AndroidFindBy(id = "button_chat_left")
    private MobileElement cancelOfferButtonElement;

    @AndroidFindBy(id = "button1")
    private MobileElement confirmButtonElement;

    public ChatPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
        this.driver = driver;
    }

    /**
     * Cancel offer action
     * @return
     */
    public ChatPage cancelOfferAction() {
        Logger.getAnonymousLogger().log(Level.INFO, "Click on cancel offer");
        clickElement(cancelOfferButtonElement);
        return new ConfirmPage(driver).confirm();
    }

    /**
     * Retrieve the last message in the chat for confirming the offer has been placed/cancelled
     * @return
     */
    public MobileElement getLatestMessage() {
        Logger.getAnonymousLogger().log(Level.INFO, "Verify if offer message was sent");
        return offerTextElementList.get(offerTextElementList.size() - 1);
    }


    public List<MobileElement> getOfferTextElementList() {
        return offerTextElementList;
    }

    public MobileElement getEditOfferButtonElement() {
        return editOfferButtonElement;
    }

    public MobileElement getCancelOfferButtonElement() {
        return cancelOfferButtonElement;
    }
}
