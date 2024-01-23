package commands;

import routeClasses.Route;

import java.util.TreeMap;

public class AverageOfDistanceCommand {

    /**
     * Главный метод команды average_of_distance, выводит среднее значение поля distance для всех элементов коллекции.
     *
     * @param collection the collection
     * @return the double
     */
    public double mainMethod(TreeMap<Integer, Route> collection) {
        double sum = 0;
        if (collection.isEmpty()) {
            System.out.println("Коллекция пуста");
        }
        for (Route route : collection.values()) {
            sum += route.getDistance();
        }
        return sum / collection.size();
    }
}
