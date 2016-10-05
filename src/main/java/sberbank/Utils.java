package sberbank;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import sberbank.currencies.Currency;

import java.util.List;

/**
 * Created by Андрей on 24.09.2016.
 */
public class Utils {
    private static final Logger logger = LogManager.getLogger(Utils.class);

    public static WebElement searchLabel(List<WebElement> labelsParents, Currency currency) {
        for(int i = 0; i < Constants.ATTEMPT_FIND_ELEMENT; i++){
            for (WebElement labelParent : labelsParents) {
                WebElement text = labelParent.findElement(By.xpath("//p"));
                logger.info("Current text: " + text.getText());
                if (currency.getRussianName().equals(text.getText()))
                    return labelParent;
            }
            sleep();
        }
        return null;
    }

    public static WebElement searchView(List<WebElement> viewParents, Currency currency) {
        for(int i = 0; i < Constants.ATTEMPT_FIND_ELEMENT; i++){
            for(WebElement labelParent: viewParents) {
            WebElement text = labelParent.findElement(By.xpath("//td/span"));
            logger.info("Current text: " + text.getText());
            if(currency.getName().equals(text.getText()))
                return labelParent;
            }
            sleep();
        }
        return null;
    }

    private static void sleep() {
        sleep( 1 );
    }

    private static void sleep(int sec) {
        try {
            Thread.sleep(sec * 1000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
