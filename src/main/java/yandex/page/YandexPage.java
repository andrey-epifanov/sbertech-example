package yandex.page;

import my.company.framework.WebDriverFramework;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

/**
 * Created by aepifanov on 30.09.2016.
 */
public class YandexPage {

    protected WebDriverFramework webDriverFramework;

    public YandexPage(final WebDriverFramework webDriverFramework) {
        PageFactory.initElements(new HtmlElementLocatorFactory(webDriverFramework.getInstance()), this);
        this.webDriverFramework = webDriverFramework;
    }

    @FindBy(id = "text")
    protected WebElement textField;

    @FindBy(className = "suggest2-form__button")
    protected WebElement submitButton;
}
