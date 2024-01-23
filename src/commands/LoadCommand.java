package commands;

import exceptions.IncorrectDistanceException;
import exceptions.IncorrectNameException;
import exceptions.NecessaryFieldMissingException;
import routeClasses.Route;

import java.util.TreeMap;

public class LoadCommand extends ReadRoute {

    /**
     * Главный метод команды load, который считывает элементы из файла и добавляет их в коллекцию
     *
     * @param collection коллекция, в которую нужно добавить элемент
     * @param line строка с данными, которую нужно распарсить
     * @throws IncorrectNameException
     * @throws IncorrectDistanceException
     * @throws NecessaryFieldMissingException
     */

    public void mainMethod(TreeMap<Integer, Route> collection, String line)
            throws IncorrectNameException, IncorrectDistanceException, NecessaryFieldMissingException {
        Route route = parseRoute(line);
        collection.put((int) route.getId(), route);
    }
}
