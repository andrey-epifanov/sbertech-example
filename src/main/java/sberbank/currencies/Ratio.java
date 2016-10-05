package sberbank.currencies;

/**
 * Created by Андрей on 24.09.2016.
 */
public class Ratio {
    private String fromCurrency;
    private String fromCurrencyRussianName;
    private String toCurrency;
    private String toCurrencyName;
    private String measurementUnits;

    public Ratio(){}

    public Ratio(String fromCurrency, String fromCurrencyName, String toCurrency, String toCurrencyName, String measurementUnits) {
        this.fromCurrency = fromCurrency;
        this.fromCurrencyRussianName = fromCurrencyName;
        this.toCurrency = toCurrency;
        this.toCurrencyName = toCurrencyName;
        this.measurementUnits = measurementUnits;
    }

    public String getFromCurrency() {
        return fromCurrency;
    }

    // TODO: should be fromRussianName
    public String getFromCurrencyRussianName() {
        return fromCurrencyRussianName;
    }

    public String getToCurrency() {
        return toCurrency;
    }

    public String gettoCurrencyName() {
        return toCurrencyName;
    }

    public String getMeasurementUnits() {
        return measurementUnits;
    }

    public void setFromCurrency(String fromCurrency) {
        this.fromCurrency = fromCurrency;
    }

    public void setFromCurrencyRussianName(String fromCurrencyRussianName) {
        this.fromCurrencyRussianName = fromCurrencyRussianName;
    }

    public void setToCurrency(String toCurrency) {
        this.toCurrency = toCurrency;
    }

    public void setToName(String toName) {
        this.toCurrencyName = toName;
    }

    public void setMeasurementUnits(String measurementUnits) {
        this.measurementUnits = measurementUnits;
    }

    @Override
    public String toString() {
        return "Ratio{" +
                "fromCurrency='" + fromCurrency + '\'' +
                ", toCurrency='" + toCurrency + '\'' +
                ", measurementUnits='" + measurementUnits + '\'' +
                '}';
    }
}
