package commands;

import routeClasses.Route;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;
import routeClasses.RouteDistanceComparator;

public class PrintFieldAscendingDistanceCommand {

    /**
     * Главный метод команды print_field_ascending_distance, который выводит значения поля distance всех элементов в порядке возрастания
     *
     * @param collection коллекция, из которой берутся элементы
     * @return distances возвращает значения поля distance всех элементов в порядке возрастания
     */

    public ArrayList<Long> mainMethod(TreeMap<Integer, Route> collection) {
        ArrayList<Long> distances = new ArrayList<>();
        ArrayList<Route> routes = new ArrayList<>(collection.values());
        routes.sort(new RouteDistanceComparator());
        for (Route route : routes) {
            distances.add(route.getDistance());
        }
        return distances;
    }
}
