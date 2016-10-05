package yandex.actions;

import com.google.common.base.Predicate;
import my.company.framework.WebDriverFramework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.allure.annotations.Step;
import yandex.page.YandexPage;

/**
 * Created by aepifanov on 30.09.2016.
 */
public class YandexPageAction extends YandexPage{

    public YandexPageAction(WebDriverFramework webDriverFramework) {
        super(webDriverFramework);
    }

    @Step
    public void openMainPage() {
        webDriverFramework.getInstance().get("http://ya.ru");
        webDriverFramework.makeScreenShot();
    }

    @Step
    public void search(String text) {
        textField.sendKeys(text);
        webDriverFramework.makeScreenShot();
        submitButton.submit();
        new WebDriverWait(webDriverFramework.getInstance(), 10)
                .withMessage("Could not load results page")
                .until(mainContainLoaded());
        webDriverFramework.makeScreenShot();
    }

    private Predicate<WebDriver> mainContainLoaded() {
        return new Predicate<WebDriver>() {
            @Override
            public boolean apply(WebDriver input) {
                return webDriverFramework.getInstance().findElement(By.className("main__content")).isDisplayed();
            }
        };
    }


}
