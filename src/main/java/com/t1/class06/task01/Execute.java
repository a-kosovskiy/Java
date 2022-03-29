package com.t1.class06.task01;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Execute {
    /*
    1. Создать абстрактный класс «Пользователь». У него должно быть публичное свойство «Логин», приватное свойство «пароль».
    2. От «Пользователя» унаследовать конкретные классы «Покупатель», «Продавец».
    3. У продавца есть дополнительный метод «Посмотреть активных покупателей» , а у покупателя дополнительные свойства "ФИО", "телефон" и "ID".
    4. Есть исходный csv-файл со списком покупателей в формате: ФИО, Логин, пароль, телефон.
    4.1 Если строчка парсится (т.е. для каждого из полей выполняются условия, которые вы сами зададите своими регулярками),
        то такой покупатель создается в системе через конструктор класса "Покупатель". Таким образом,должна появиться коллекция покупателей с присвоенными ID.
    4.2 Если какая-то строка не парсится корректно, то выдается исключение.
    Исключение должно быть перехвачено, чтобы оно не приводило к аварийному завершению программы.
    5. Далее происходит вызов метода продавца  «Посмотреть активных покупателей», в котором реализован вывод в итоговый csv-файл с сортировкой покупателей по ФИО.
    Сортировку реализовать с помощью интерфейса "Comparable".
     */
    public static void main(String[] args) {
        List<Buyer> buyers = new ArrayList<>();

        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/com/t1/class06/task01/BuyersImport.csv"));

            String line;
            while ((line = reader.readLine()) != null) {
                String[] lineParts = line.split(";");
                String fio = lineParts[0];
                String login = lineParts[1];
                String password = lineParts[2];
                String phoneNumber = lineParts[3];
                try {
                    buyers.add(new Buyer(fio, login, password, phoneNumber));
                } catch (IOException e) {
                    System.out.println("Ошибка импорта из файла: " + e.getMessage());
                    e.printStackTrace();
                }
            }
            reader.close();
            Seller seller = new Seller();
            seller.viewActiveBuyers(buyers);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
