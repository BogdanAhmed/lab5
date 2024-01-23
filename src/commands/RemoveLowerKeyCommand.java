package commands;

import exceptions.IllegalKeyException;
import routeClasses.Route;

import java.util.TreeMap;

public class RemoveLowerKeyCommand {

    /**
     * Главный метод команды remove_lower_key, удаляющий элементы коллекции с меньшими ключами, чем заданный
     * @param collection коллекция, из которой удаляются элементы
     * @param key ключ, по которому удаляются элементы
     * @throws IllegalKeyException
     */

    public void mainMethod(TreeMap<Integer, Route> collection, int key) throws IllegalKeyException {
        if (key <= collection.firstKey()) {
            throw new IllegalKeyException(false);
        }
        for (int k : collection.headMap(key - 1).keySet()) {
            collection.remove(k);
        }
    }
}
