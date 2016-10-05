package sberbank.web;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import my.company.framework.WebDriverFramework;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import sberbank.currencies.Currency;
import sberbank.currencies.Ratio;
import sberbank.pages.CurrenciesPage;

import java.beans.XMLDecoder;
import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Андрей on 24.09.2016.
 */
public class AbstractTest {

    public WebDriverFramework webDriver;

    private final String CURRENCY_RATIO_PATH = "./currencyRatios.xml";
    private List<Ratio> currencyRatios = new ArrayList<Ratio>();
    protected HashMap<Currency, Ratio> currencyRatioMap = new HashMap();

    //Pages
    protected CurrenciesPage currenciesPage;

    @Before
    public void initialization() throws FileNotFoundException {
//        String path = new File(".").getAbsolutePath();
//        System.setProperty("webdriver.chrome.driver", path.substring(0, path.length() - 1) + "chromedriver_win32/chromedriver.exe");
        ChromeDriverManager.getInstance().setup();
        webDriver = new WebDriverFramework(new ChromeDriver());
        webDriver.getInstance().manage().window().maximize();

        // main page for test
        webDriver.getInstance().get("http://www.sberbank.ru/ru/quotes/currencies");
        currenciesPage = new CurrenciesPage(webDriver);

        XMLDecoder d = new XMLDecoder(
                new BufferedInputStream(
                        new FileInputStream(CURRENCY_RATIO_PATH))); //, "UTF-8"
        currencyRatios = (List<Ratio>)d.readObject();

        for(Ratio currrencyRatio: currencyRatios) {
            currencyRatioMap.put(Currency.getBy(currrencyRatio.getFromCurrency()) , currrencyRatio);
        }
    }

    @After
    public void killWebDriver() {
        webDriver.makeScreenShot();
        webDriver.quit();
    }
}
