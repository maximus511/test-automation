package main.carousell.challenge.utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.internal.WrapsDriver;

import java.util.Date;
import java.util.NoSuchElementException;

/**
 * Utility class for common functions
 */
public final class CommonUtils {

    /**
     * Retrieve the driver from the element
     * @param element
     * @return
     */
    public static WebDriver getDriver(WebElement element) {
        WebElement parentElement = element.findElement(By.xpath(".."));
        return ((WrapsDriver) parentElement).getWrappedDriver();
    }

    /**
     * Function for waiting for the element to be displayed
     * @param element
     * @param timeInSec
     * @return
     */
    public static boolean waitForElementToBeDisplayed(WebElement element, int timeInSec) {
        boolean isVisible = false;
        int interval = 100; //millisec
        Date date = new Date();
        while (new Date().getTime() - date.getTime() <= timeInSec * 1000 && !isVisible) {
            try {
                if (element.isDisplayed()) {
                    isVisible = true;
                } else {
                    Thread.sleep(interval);
                }
            } catch (Exception e) {
                try {
                    Thread.sleep(interval);
                } catch (InterruptedException ie) {
                    ie.printStackTrace();
                }
            }
        }
        return isVisible;
    }

    /**
     * Function for handling click actions
     * @param element
     * @return
     */
    public static boolean clickElement(WebElement element) {
        try {
            if (waitForElementToBeDisplayed(element, 10)) {
                element.click();
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    /**
     * Function for handling value assignment to the text fields
     * @param element
     * @param value
     * @return
     */
    public static boolean setElementValue(WebElement element, String value) {
        try {
            if (waitForElementToBeDisplayed(element, 10)) {
                element.clear();
                element.sendKeys(value);
                return true;
            } else {
                return false;
            }
        } catch (NoSuchElementException e) {
            return false;
        }
    }
}
