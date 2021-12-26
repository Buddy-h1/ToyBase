package MyLibrary;

import java.util.ArrayList;

public class FindToyThread extends Thread{
    private ArrayList<ToyBase> listToys;
    private String str;
    private ArrayList<ToyBase> listResult = new ArrayList<ToyBase>();

    FindToyThread(ArrayList<ToyBase> listToys, String str) {
        this.listToys = listToys;
        this.str = str;
    }

    public ArrayList<ToyBase> getListResult() {
        return listResult;
    }

    public void run() {
        System.out.println("Поток <<поиска>> начал работу");
        for (int i = 0; i < listToys.size(); i++) {
            ToyBase toy = listToys.get(i);
            if (toy.title.indexOf(str) >= 0) listResult.add(toy);
        }
        System.out.println("Поток <<поиска>> завершил работу");
    }
}
