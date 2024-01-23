package commands;

import routeClasses.Route;

import java.util.Date;
import java.util.TreeMap;

public class InfoCommand {

    /**
     * Главный метод команды info, который выводит информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)
     * @param collection collection to get info about
     * @param initDate date of collection initialization
     * ut
     */

    public void mainMethod(TreeMap<Integer, Route> collection, Date initDate) {
        System.out.printf("Тип коллекции: %s\nДата инициализации: %s\nКоличество элементов: %s\n",
                collection.getClass(), initDate, collection.size());
    }
}
