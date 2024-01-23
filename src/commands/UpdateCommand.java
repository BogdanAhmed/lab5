package commands;

import exceptions.*;
import routeClasses.Route;
import utils.InputValidation;

import java.util.TreeMap;

public class UpdateCommand extends InsertCommand {

    private final InputValidation validator = new InputValidation();

    /** Метод, обновляющий существующий по данному ключу элемент в коллекцию,
     * при этом он либо берет данные из ввода пользователя (readRoute),
     * либо парсит их из файла (parseRoute) в зависимости от значения toParse
     * @param currentCollection  коллекция, из которой удаляются элементы
     * @param key                ключ, по которому добавляется элемент
     * @param value              Route, с которым сравниваются элементы коллекции
     * @param toParse             флаг, определяющий, нужно ли парсить строку
     * @throws IncorrectNameException
     * @throws IncorrectDistanceException
     * @throws NecessaryFieldMissingException
     */

    public void mainMethod(TreeMap<Integer, Route> currentCollection, int key, String value, boolean toParse)
            throws UpdatedElementMissingException, IncorrectNameException, IncorrectDistanceException, NecessaryFieldMissingException {
        if (!currentCollection.containsKey(key)) {
            throw new UpdatedElementMissingException(key);
        }
        addRoute(currentCollection, key, value, toParse);
    }
}
