package MyLibrary;

import java.util.ArrayList;
import java.io.*;

public class ToyManagement implements IToyManagement, Serializable {
    private static final long serialVersionUID = 1L;
    private ArrayList<ToyBase> listToys = new ArrayList();

    public static Toy getToy(ToyCategory type) {
        Toy toReturn = null;
        switch (type) {
            case SOFT_TOY:
                toReturn = new SoftToy();
                break;
            case CONSTRUCTOR:
                toReturn = new Constructor();
                break;
            default:
                throw new IllegalArgumentException("Wrong doughnut type:" + type);
        }
        return toReturn;
    }


    public void serialization() throws IOException {
        FileOutputStream outputStream = new FileOutputStream("toyBase.bin");
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(listToys);
        objectOutputStream.close();
    }

    public void deserialization() throws IOException, ClassNotFoundException {
        FileInputStream fileInputStream = new FileInputStream("toyBase.bin");
        ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
        listToys = (ArrayList<ToyBase>)objectInputStream.readObject();
        objectInputStream.close();
    }

    public void addToy(String title, ToyCategory category, double price, String factory, String address, int countDetails, String material) throws UnsuitableCategoryException {
        if (category != ToyCategory.CONSTRUCTOR) throw new UnsuitableCategoryException("Неверная категория добавляемой игрушки. Необходимо указать категорию: <<" + ToyCategory.CONSTRUCTOR.getType() + ">>");
        Constructor constructor = new Constructor(title, category, getNextID(), price, factory, address,countDetails, material);
        listToys.add(constructor);
    }

    public void addToy(String title, ToyCategory category, double price, String factory, String address, String colour, String filler) throws UnsuitableCategoryException{
        if (category != ToyCategory.SOFT_TOY) throw new UnsuitableCategoryException("Неверная категория добавляемой игрушки. Необходимо указать категорию: <<" + ToyCategory.SOFT_TOY.getType() + ">>");
        SoftToy softToy = new SoftToy(title, category, getNextID(), price, factory, address, colour, filler);
        listToys.add(softToy);
    }

    private int getNextID() {
        int nextID;
        boolean freeID = true;
        do {
            freeID = true;
            nextID = (int)(Math.random() * 100000);
            for (int i = 0; i < listToys.size(); i++) {
                if (listToys.get(i).id == nextID) {
                    freeID = false;
                }
            }
        }
        while (freeID == false);
        return nextID;
    }

    public void removeToy(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= listToys.size() || index < 0)
            throw new ArrayIndexOutOfBoundsException("Игрушки по данному индексу не существует");
        listToys.remove(index);
    }

    public ToyBase getToy(int index) throws ArrayIndexOutOfBoundsException {
        if (index >= listToys.size() || index < 0) throw new ArrayIndexOutOfBoundsException("Игрушки по данному индексу не существует");
        return listToys.get(index);
    }

    public ArrayList<ToyBase> findToy(String str) throws InterruptedException {
        FindToyThread findToyThread = new FindToyThread(this.listToys, str);
        findToyThread.start();

        findToyThread.join();
        return findToyThread.getListResult();
    }

    public void printToys(){
        if (listToys.isEmpty()){
            System.out.println("В базе нет зарегистрированных изданий.");
        }
        for (int i = 0; i < listToys.size(); i++){
            ToyBase toy = listToys.get(i);
            String str = toy.getInfo();
            System.out.println(str);
            System.out.println("");
        }
    }


}
