package my.company.tests;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import my.company.framework.WebDriverFramework;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.chrome.ChromeDriver;
import yandex.actions.YandexPageAction;

/**
 * @author Dmitry Baev charlie@yandex-team.ru
 *         Date: 28.10.13
 */
public class SearchTest {

    private WebDriverFramework webDriverFramework;
    private YandexPageAction yandexPageAction;

    @Before
    public void setUp() throws Exception {
        ChromeDriverManager.getInstance().setup();
        webDriverFramework = new WebDriverFramework(new ChromeDriver());

        yandexPageAction = new YandexPageAction(webDriverFramework);
    }

    @Test
    public void searchTest() throws Exception {
        yandexPageAction.openMainPage();
        yandexPageAction.search("Allure framework");
    }

    @After
    public void finish(){
        webDriverFramework.quit();
    }
}