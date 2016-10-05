package sberbank.web;

import org.apache.commons.io.FileUtils;
import org.apache.xml.serializer.Serializer;
import org.junit.Test;
import sberbank.currencies.Currency;
import sberbank.currencies.Ratio;

import javax.swing.*;
import java.beans.XMLDecoder;
import java.beans.XMLEncoder;
import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by Андрей on 24.09.2016.
 */
public class SerializationTest {

    private final String CURRENCY_RATIO_PATH = "./currencyRatios.xml";
    protected HashMap<Currency, Ratio> currencyRatioMap = new HashMap();

    @Test
    public void serialize() throws IOException {
        List<Ratio> currencyRatios = new ArrayList<Ratio>();
        currencyRatios.add(new Ratio("EUR", "Евро", "RUR", "", "1"));
        currencyRatios.add(new Ratio("USD", "Доллар США", "RUR", "", "1"));
        currencyRatios.add(new Ratio("CNY", "Китайский юань Жэньминьби", "RUR", "", "10"));

        FileUtils.write(new File("example.txt"), "");

        XMLEncoder e = new XMLEncoder(
                new BufferedOutputStream(
                        new FileOutputStream("Test.xml")));
        e.writeObject(new JButton("Hello, world"));
        e.close();

        XMLEncoder encoder=null;
        try{
            encoder = new XMLEncoder(new BufferedOutputStream(new FileOutputStream(CURRENCY_RATIO_PATH)));
        }catch(FileNotFoundException fileNotFound){
            System.out.println("ERROR: While Creating or Opening the File dvd.xml");
        }
        encoder.writeObject(currencyRatios);
        encoder.close();
    }

    @Test
    public void deserialize() throws IOException {
        List<Ratio> currencyRatios = new ArrayList<Ratio>();

        XMLDecoder d = new XMLDecoder(
                new BufferedInputStream(
                        new FileInputStream(CURRENCY_RATIO_PATH)));
        currencyRatios = (List<Ratio>)d.readObject();

        for(Ratio currrencyRatio: currencyRatios) {
            currencyRatioMap.put(Currency.getBy(currrencyRatio.getFromCurrency()) , currrencyRatio);
        }

        d.close();
    }
}
