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
 * Page object class for Listing page
 */
public class ListingPage {

    private final AppiumDriver driver;

    @AndroidFindBy(id = "view_product")
    private List<MobileElement> productElementList;

    @AndroidFindBy(id = "feature_button")
    private MobileElement featureButton;

    public ListingPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
        this.driver = driver;
    }

    /**
     * Click on the product
     * @param index
     * @return
     */
    public ItemPage clickListing(Integer index) {
        Logger.getAnonymousLogger().log(Level.INFO, "Click on product");
        clickElement(productElementList.get(index));
        return new ItemPage(driver);
    }

    /**
     * Handle feature popup and click on "OK, Got it"
     * @return
     */
    public ListingPage acceptFeatureButton() {
        Logger.getAnonymousLogger().log(Level.INFO, "Accept feature action for Listing page");
        clickElement(featureButton);
        return new ListingPage(driver);
    }

}
