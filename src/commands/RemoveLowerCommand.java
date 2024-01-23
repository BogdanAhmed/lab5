package commands;

import exceptions.IncorrectDistanceException;
import exceptions.IncorrectNameException;
import exceptions.NecessaryFieldMissingException;
import routeClasses.Route;

import java.util.TreeMap;

public class RemoveLowerCommand extends ReadRoute {

    /**
     * Главный метод команды remove_lower, удаляющий элементы коллекции, меньшие, чем заданный
     * @param collection коллекция, из которой удаляются элементы
     * @param value Route, с которым сравниваются элементы коллекции
     * @param toParse флаг, определяющий, нужно ли парсить строку
     * @return
     * @throws IncorrectNameException
     * @throws IncorrectDistanceException
     * @throws NecessaryFieldMissingException
     */
    public TreeMap<Integer, Route> mainMethod(TreeMap<Integer, Route> collection, String value, boolean toParse)
            throws IncorrectNameException, IncorrectDistanceException, NecessaryFieldMissingException {
        Route route = toParse ? parseRoute(value) : readRoute(value);
        TreeMap<Integer, Route> collectionCopy = new TreeMap<>(collection);
        for (int key : collection.keySet()) {
            if (collection.get(key).getDistance() < route.getDistance()) {
                collectionCopy.remove(key);
            }
        }
        return collectionCopy;
    }
}
