package sberbank.pages;

//import my.company.web.elements.SearchArrow;
//import my.company.web.pages.SearchPage;
import my.company.framework.WebDriverFramework;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

import java.util.List;

/**
 * @author Andrey Epifanov
 *         5/6/13, 5:14 PM
 * Description : adress :http://www.sberbank.ru/ru/quotes/currencies
 */
public class CurrenciesPage {

    private WebDriverFramework webDriver;

    public CurrenciesPage(final WebDriverFramework webDriver) {
        PageFactory.initElements(new HtmlElementLocatorFactory(webDriver.getInstance()), this);
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//label")
    public List<WebElement> labelsParents;

    @FindBy(xpath = "//tr")
    public List<WebElement> viewParents;

    public void reInitElements() {
        PageFactory.initElements(new HtmlElementLocatorFactory(webDriver.getInstance()), this);
    }

}
