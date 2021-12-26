package MyLibrary;

public enum ToyCategory {
    UNKNOWN ("Неизвестно"),
    SOFT_TOY ("Мягкая игрушка"),
    CONSTRUCTOR ("Конструктор");

    private String type;

    ToyCategory(String type) {
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
