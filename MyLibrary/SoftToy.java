package MyLibrary;

import java.io.Serializable;

public class SoftToy extends ToyBase implements Toy, Serializable {
    private static final long serialVersionUID = 1L;
    private String colour;
    private String filler;

    public SoftToy(String title, ToyCategory category, int id, double price, String factory, String address, String colour, String filler) {
        super(title, category, id, price, factory, address);
        this.colour = colour;
        this.filler = filler;
    }

    public SoftToy() {
        super();
        this.colour = "Неизвестно";
        this.filler = "Неизвестно";
    }

    @Override
    public String getInfo() {
        String str = "Категория: " + category.getType() +
                ";\nНазвание: " + title +
                ";\nid: " + id +
                ";\nЦена: " + price +
                ";\nПроизводство: " + factory +
                ";\nАдрес: " + address +
                ";\nЦвет: " + colour +
                ";\nНаполнитель: " + filler + ";";
        return str;
    }
}
