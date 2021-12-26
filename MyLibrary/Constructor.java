package MyLibrary;

import java.io.Serializable;

public class Constructor extends ToyBase implements Toy, Serializable {
    private static final long serialVersionUID = 1L;
    private int countDetails;
    private String material;

    public Constructor(String title, ToyCategory category, int id, double price, String factory, String address, int countDetails, String material) {
        super(title, category, id, price, factory, address);
        this.countDetails = countDetails;
        this.material = material;
    }

    public Constructor() {
        super();
        this.countDetails = 0;
        this.material = "Неизвестно";
    }

    @Override
    public String getInfo() {
        String str = "Категория: " + category.getType() +
                ";\nНазвание: " + title +
                ";\nid: " + id +
                ";\nЦена: " + price +
                ";\nПроизводство: " + factory +
                ";\nАдрес: " + address +
                ";\nКоличество деталей: " + countDetails +
                ";\nМатериал: " + material + ";";
        return str;
    }
}
