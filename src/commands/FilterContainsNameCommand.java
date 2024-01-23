package commands;

import routeClasses.Route;

import java.util.ArrayList;
import java.util.TreeMap;

public class FilterContainsNameCommand {

    /**
     * Главный метод команды filter_contains_name, который выводит элементы, значение поля name которых содержит заданную подстроку
     *
     * @param collection collection you want to filter
     * @param name       name you want to filter by
     * @return filtered collection
     */

    public ArrayList<Route> mainMethod(TreeMap<Integer, Route> collection, String name) {
        ArrayList<Route> routes = new ArrayList<>();
        for (Route route : collection.values()) {
            if (route.getName().contains(name)) {
                routes.add(route);
            }
        }
        return routes;
    }
}
