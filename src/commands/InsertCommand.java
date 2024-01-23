package commands;

import exceptions.*;
import routeClasses.Route;
import utils.InputValidation;

import java.util.TreeMap;

/**
 * The type Insert command.
 */
public class InsertCommand extends ReadRoute {


    private final InputValidation validator = new InputValidation();

    /**
     * Метод, добавляющий элемент в коллекцию, при этом он либо берет данные из ввода пользователя (readRoute),
     * либо парсит их из файла (parseRoute) в зависимости от значения toParse
     *
     * @param currentCollection коллекция, из которой удаляются элементы
     * @param key               ключ, по которому добавляется элемент
     * @param value             Route, с которым сравниваются элементы коллекции
     * @param toParse           флаг, определяющий, нужно ли парсить строку
     * @throws IncorrectNameException         the incorrect name exception
     * @throws IncorrectDistanceException     the incorrect distance exception
     * @throws NecessaryFieldMissingException the necessary class missing exception
     */
    public void addRoute(TreeMap<Integer, Route> currentCollection, int key, String value, boolean toParse)
            throws IncorrectNameException, IncorrectDistanceException, NecessaryFieldMissingException {
        Route route = toParse ? parseRoute(value) : readRoute(value);
        if (currentCollection.isEmpty()) {
            route.setId(1);
        } else {
            route.setId(currentCollection.lastKey() + 1);
        }

        currentCollection.put(key, route);
    }

    /**
     * Главный метод команды insert, который добавляет элемент в коллекцию по ключу
     *
     * @param currentCollection the current collection
     * @param key               the key
     * @param value             the value
     * @param toParse           the to parse
     * @throws ElementAlreadyExistsException  the element already exists exception
     * @throws UpdatedElementMissingException the updated element missing exception
     * @throws IncorrectNameException         the incorrect name exception
     * @throws IncorrectDistanceException     the incorrect distance exception
     * @throws NecessaryFieldMissingException the necessary class missing exception
     */
    public void mainMethod(TreeMap<Integer, Route> currentCollection, int key, String value, boolean toParse)
            throws ElementAlreadyExistsException, UpdatedElementMissingException, IncorrectNameException,
            IncorrectDistanceException, NecessaryFieldMissingException {
        if (currentCollection.containsKey(key)) {
            throw new ElementAlreadyExistsException(key);
        }
        addRoute(currentCollection, key, value, toParse);
    }

}
