package main.carousell.challenge.pageobjects;

import main.carousell.challenge.utility.CommonUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static main.carousell.challenge.utility.CommonUtils.*;

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
        clickElement(productElementList.get(index));
        return new ItemPage(driver);
    }

    /**
     * Handle feature popup and click on "OK, Got it"
     * @return
     */
    public ListingPage acceptFeatureButton() {
        clickElement(featureButton);
        return new ListingPage(driver);
    }

}
