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
 * Page object class for Dashboard page
 */
public class DashboardPage {

    private AppiumDriver driver;

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='Cars']")
    private MobileElement carListingType;

    public DashboardPage(AppiumDriver driver) {
        PageFactory.initElements(new AppiumFieldDecorator(driver, 15, TimeUnit.SECONDS), this);
        this.driver = driver;
    }

    /**
     * Function for handling scrolling to Cars option and clicking on it
     * @return
     */
    public ListingPage clickCarOption() {
        Logger.getAnonymousLogger().log(Level.INFO, "Scroll and select Car option");
        carListingType = (MobileElement)driver.scrollTo("Cars");
        clickElement(carListingType);
        return new ListingPage(driver);
    }

}
