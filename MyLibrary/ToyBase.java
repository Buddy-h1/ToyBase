package MyLibrary;

import java.io.Serializable;

public abstract class ToyBase implements Serializable {
    protected String title;
    protected ToyCategory category;
    protected int id;
    protected double price;
    protected String factory;
    protected String address;

    public ToyBase(String title, ToyCategory category, int id, double price, String factory, String address) {
        this.title = title;
        this.category = category;
        this.id = id;
        this.price = price;
        this.factory = factory;
        this.address = address;
    }

    public ToyBase() {
        this.title = "Неизвестно";
        this.category = ToyCategory.UNKNOWN;
        this.id = 0;
        this.price = 0;
        this.factory = "Неизвестно";
        this.address = "Неизвестно";
    }

    public String getTitle() {
        return title;
    }
    public ToyCategory getCategory() {
        return category;
    }
    public int getId() {
        return id;
    }
    public double getPrice() {
        return price;
    }
    public String getFactory() {
        return factory;
    }
    public String getAddress() {
        return address;
    }

    abstract public String getInfo();

}
