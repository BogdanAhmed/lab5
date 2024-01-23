package commands;

import routeClasses.Route;

import java.util.ArrayList;
import java.util.Date;
import java.util.TreeMap;

public class ShowCommand {

    /**
     * Главный метод команды show, выводящий элементы коллекции
     * @param collection коллекция, элементы которой нужно вывести
     * @return
     */

    public ArrayList<String> mainMethod(TreeMap<Integer, Route> collection) {

        ArrayList<String> list = new ArrayList<>();
        if (collection.isEmpty()) {
            System.out.println("Коллекция пуста");
            return list;
        }
        for (Route route : collection.values()) {
            list.add(route.toString());
        }
        return list;
    }
}
