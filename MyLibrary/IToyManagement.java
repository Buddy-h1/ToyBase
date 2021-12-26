package MyLibrary;

import java.util.ArrayList;

public interface IToyManagement {
    public void addToy(String title, ToyCategory category,
                       double price, String factory, String address, int countDetails, String material) throws UnsuitableCategoryException;
    public void addToy(String title, ToyCategory category,
                       double price, String factory, String address, String colour, String filler) throws UnsuitableCategoryException;
    public void removeToy(int index);
    public ToyBase getToy(int index);
    public ArrayList<ToyBase> findToy(String str) throws InterruptedException;
    public void printToys();
}
