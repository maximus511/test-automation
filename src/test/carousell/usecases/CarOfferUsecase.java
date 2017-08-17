package test.carousell.usecases;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import main.carousell.challenge.pageobjects.ChatPage;
import main.carousell.challenge.pageobjects.MainPage;
import main.carousell.challenge.pageobjects.OfferPage;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertTrue;

/**
 * Class for Car offer usecase
 */
public class CarOfferUsecase {

    private AppiumDriver driver;

    private AppiumDriver getDriver() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel25");
        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        return driver;
    }

    @BeforeTest
    public void setup() throws MalformedURLException {
        driver = getDriver();
    }

    @AfterTest
    public void afterTest(){
        driver.quit();
    }

    /**
     * Test for car offer use case
     * @param username
     * @param password
     * @param itemNumber
     * @param offerAmount
     */
    @Test
    @Parameters({"username", "password", "itemNumber", "offerAmount"})
    public void verifyCarOfferTest(String username, String password, String itemNumber, String offerAmount) {
        MainPage page = new MainPage(driver);
        OfferPage offerPage = page
                .clickOnEmailLogin()
                .clickOnLoginTab()
                .loginAction(username, password)
                .clickCarOption()
                .acceptFeatureButton()
                .clickListing(Integer.valueOf(itemNumber))
                .acceptFeatureButton()
                .acceptFeatureButton()
                .clickBuyButton()
                .editOfferPrice(offerAmount);
        assertTrue(offerPage.getOfferTextElement().getText().contains(offerAmount), "The amount did not update");
        ChatPage chatPage = offerPage.submitOffer();
        assertTrue(chatPage.getLatestMessage().getText().contains(offerAmount),
                "The amount does not match with the actual offer placed");
        assertTrue(chatPage.getEditOfferButtonElement().isDisplayed(), "Edit offer button is not available");
        assertTrue(chatPage.getCancelOfferButtonElement().isDisplayed(), "Cancel offer button is not available");
        chatPage.cancelOfferAction();
        assertTrue(chatPage.getLatestMessage().getText().contains("CANCELLED OFFER"),
                "The offer was not cancelled");
    }

}
