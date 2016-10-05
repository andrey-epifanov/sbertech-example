package sberbank.currencies;

/**
 * Created by Андрей on 24.09.2016.
 */
public enum Currency {
    EUR("EUR", "Евро"),
    USD("USD", "Доллар США"),
    CNY("CNY", "Китайский юань Жэньминьби");

    private String name;
    private String russitanName;

    Currency(String name, String russitanName) {
        this.name = name;
        this.russitanName = russitanName;
    }

    public String getName() {
        return name;
    }

    public String getRussianName() {
        return russitanName;
    }

    @Override
    public String toString() {
        return "Currency{" +
                "name='" + name + '\'' +
                ", russitanName='" + russitanName + '\'' +
                '}';
    }

    public static Currency getBy(String name) {
        for(Currency currency: values()) {
            if(currency.getName().equals(name))
                return currency;
        }
        throw new IllegalArgumentException("Name = " + name + " is not found.");
//        return null;
    }
}
