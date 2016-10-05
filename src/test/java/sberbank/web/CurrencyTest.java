package sberbank.web;

import junit.framework.Assert;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import sberbank.Utils;
import sberbank.currencies.Currency;

import java.util.List;

import org.apache.log4j.Logger;
import org.apache.log4j.LogManager;

import static org.junit.Assert.*;
import static org.junit.Assert.assertEquals;

/**
 * @author Andrey Epifanov
 *         24/09/16, 2:51 PM
 */
public class CurrencyTest extends AbstractTest {
    private static final Logger logger = LogManager.getLogger(CurrencyTest.class);

    @Test
    public void turnOnEuro() {
        // main page for test
        // this is need, if we have one browser for all tests.
//        webDriver.getInstance().get("http://www.sberbank.ru/ru/quotes/currencies");

        WebElement eurLabel = Utils.searchLabel(
                currenciesPage.labelsParents,
                Currency.EUR);
        WebElement eurCheckbox = eurLabel.findElement(By.xpath("//span[@class='checkbox']"));
        webDriver.makeScreenShot();
        eurCheckbox.click();

        WebElement eurRurView = Utils.searchView(
                currenciesPage.viewParents,
                Currency.EUR);
        WebElement eurRurMesurementUnits = eurRurView.findElement(By.xpath("//td[2]"));

        webDriver.makeScreenShot();
        assertEquals(
                currencyRatioMap.get(Currency.EUR).getMeasurementUnits(),
                eurRurMesurementUnits.getText());
    }

    @Test
    public void turnOffDollar() throws InterruptedException {
        // main page for test
        // this is need, if we have one browser for all tests.
//        webDriver.getInstance().get("http://www.sberbank.ru/ru/quotes/currencies");

        //wait
        WebElement eurCheckboxW = webDriver.getWaiter()
                .until(
                        ExpectedConditions.elementToBeClickable(By.xpath("//span[@class='checkbox']"))
                );
        WebElement eurLabel = Utils.searchLabel(
                currenciesPage.labelsParents,
                Currency.EUR);
        // labelsParents.get(1).findElement(By.xpath("//p")).getText() // should be find
        WebElement eurCheckbox = eurLabel.findElement(By.xpath("//span[@class='checkbox']"));
        webDriver.makeScreenShot();
        eurCheckbox.click();

        currenciesPage.reInitElements();
        WebElement usdLabel = Utils.searchLabel(
                currenciesPage.labelsParents,
                Currency.USD);

        // not work - NullPointer Exception . All elements is Euro!
//        WebElement usdCheckbox = usdLabel.findElement(By.xpath("//span[@class='checkbox']"));
        WebElement usdCheckbox = webDriver.getInstance()
                .findElement(By.xpath("//label/p[text()='" + Currency.USD.getRussianName() + "']/../span"));
        webDriver.makeScreenShot();
        usdCheckbox.click();

        List<WebElement> viewParents = webDriver.getInstance()
                .findElements(By.xpath("//tr")); // all elements are Euro!!! - bug
        WebElement usdRurView = Utils.searchView(viewParents, Currency.USD);
        assertTrue(usdRurView == null);

        assertFalse(webDriver.isElementPresent(
                By.xpath("//tr/td/span[text()='" + Currency.USD.getName() + "']")));

//        WebElement eurRurMesurementUnits = eurRurView.findElement(By.xpath("//td[2]"));
//        assertFalse(eurRurMesurementUnits.isDisplayed());
    }

    @Test
    public void selectCNY() {
        // main page for test
        // this is need, if we have one browser for all tests.
//        webDriver.getInstance().get("http://www.sberbank.ru/ru/quotes/currencies");

        // Find select
        WebElement selectCurrency =
            webDriver.getWaiter()
                    .until(
                            ExpectedConditions.elementToBeClickable(By.xpath("//div[@class='select']"))
                    );
//        WebElement selectCurrency = webDriver.getInstance().findElement(By.xpath("//div[@class='select']"));
        selectCurrency.click();
        webDriver.makeScreenShot();

        // select operation
        WebElement cnyInSelect = webDriver.getInstance()
                .findElement(By.xpath("//span[text()='" + Currency.CNY.getRussianName() + "']"));
        cnyInSelect.click();
        //may be - waiter
        webDriver.makeScreenShot();

        //wait
        webDriver.getWaiter()
                .until(
                        ExpectedConditions.elementToBeClickable(By.xpath("//p[text()='" + Currency.CNY.getRussianName() + "']"))
                );
        webDriver.makeScreenShot();

        // Find currency
        WebElement currencyRatioMainCurrency = webDriver.getInstance()
                .findElement(By.xpath("//tr/td/span[text()='" + Currency.CNY.getName() + "']"));
        assertEquals("Name of CNY in block of Currencies Ratio.",
                Currency.CNY.getName(),
                currencyRatioMainCurrency.getText());

        WebElement cnyRatioMesurementUnits = webDriver.getInstance()
                .findElement(By.xpath("//tr/td/span[text()='" + Currency.CNY.getName() + "']/../../td[2]"));
        assertEquals(
                currencyRatioMap.get(Currency.CNY).getMeasurementUnits(),
                cnyRatioMesurementUnits.getText());
    }

}
