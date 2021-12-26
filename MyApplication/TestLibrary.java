package MyApplication;
import MyLibrary.*;
import java.util.ArrayList;
public class TestLibrary {
    public static void main(String[] args) {
        try {
            ToyBase toy = new Constructor("Скоростной вездеход",
                    ToyCategory.CONSTRUCTOR, 42095, 4357,
                    "LEGO", "БЦ Мосэнка Плаза 3 Садовая-Самотечная, 24/27",
                    490, "Пластик");
            System.out.println(toy.getInfo());
            ToyManagement toyManagement = new ToyManagement();
            toyManagement.addToy("Скоростной вездеход",
                    ToyCategory.CONSTRUCTOR, 4357,
                    "LEGO", "БЦ Мосэнка Плаза 3 Садовая-Самотечная, 24/27, Москва, Россия",
                    490, "Пластик");
            toyManagement.addToy("Lamborghini Sian FKP 37",
                    ToyCategory.CONSTRUCTOR, 22859,
                    "LEGO", "Ходынский бул.,4, Москва, Россия",
                    1000, "Пластик");
            toyManagement.addToy("Медвежонок Чиба с зайцем",
                    ToyCategory.SOFT_TOY, 1219,
                    "Fancy", "ТРЦ Армада, Петра Смородина, 13а, Липецк, Россия",
                    "Коричневый", "Синтепон");
            System.out.println("-------------------------------------------");

            ArrayList<ToyBase> baseArrayList = new ArrayList<ToyBase>();
            System.out.println("Выполняем поиск зарегистрированных изданий, в названии которых встречается подстрока 'вездеход':");
            baseArrayList = toyManagement.findToy("вездеход");
            if (baseArrayList.isEmpty()){
                System.out.println("Поиск не дал результатов");
            } else{
                for (int i = 0; i < baseArrayList.size(); i++) {
                    System.out.println(baseArrayList.get(i).getInfo());
                }
            }
            System.out.println("-------------------------------------------");
            baseArrayList.clear();
            System.out.println("Выполняем поиск зарегистрированных изданий, в названии которых встречается подстрока 'Чиба':");
            baseArrayList = toyManagement.findToy("Чиба");
            if (baseArrayList.isEmpty()){
                System.out.println("Поиск не дал результатов");
            } else{
                for (int i = 0; i < baseArrayList.size(); i++) {
                    System.out.println(baseArrayList.get(i).getInfo());
                }
            }
            System.out.println("-------------------------------------------");
            baseArrayList.clear();
            System.out.println("Выполняем поиск зарегистрированных изданий, в названии которых встречается подстрока 'Sian':");
            baseArrayList = toyManagement.findToy("Sian");
            if (baseArrayList.isEmpty()){
                System.out.println("Поиск не дал результатов");
            } else{
                for (int i = 0; i < baseArrayList.size(); i++) {
                    System.out.println(baseArrayList.get(i).getInfo());
                }
            }
            System.out.println("-------------------------------------------");
            baseArrayList.clear();
            System.out.println("Выполняем поиск зарегистрированных изданий, в названии которых встречается подстрока 'Ёжик':");
            baseArrayList = toyManagement.findToy("Ёжик");
            if (baseArrayList.isEmpty()){
                System.out.println("Поиск не дал результатов");
            } else{
                for (int i = 0; i < baseArrayList.size(); i++) {
                    System.out.println(baseArrayList.get(i).getInfo());
                }
            }
            System.out.println("-------------------------------------------");
        }
        catch (InterruptedException err1) {
            System.out.println(err1.getMessage());
        }
        catch (UnsuitableCategoryException err2) {
            System.out.println("Возникла ошибка с категорией добавления: ");
            System.out.print(err2.getMessage());
        }
    }
}
