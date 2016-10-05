package my.company.framework;

import com.google.common.base.Predicate;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Attachment;
import ru.yandex.qatools.allure.annotations.Step;

/**
 * The content of the following class is for demonstration purposes only.
 * In your project you should organize your code in the different way, an
 * example move all the selectors to separate place. Usually better to use
 * some other library to organize access to your service pages such as
 * Yandex HTMLElements.
 *
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 28.10.13
 */
public class WebDriverFramework {

    private WebDriver driver;
    private WebDriverWait waiter;

    public WebDriverFramework(WebDriver driver) {
        this.driver = driver;
        this.waiter = new WebDriverWait(driver, 10);
    }

    public WebDriver getInstance() {
        return driver;
    }

    public WebDriverWait getWaiter() {
        return waiter;
    }

    public boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Attachment
    @Step("Make screen shot of results page")
    public byte[] makeScreenShot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void quit() {
        driver.quit();
    }


}
