package commands;

import exceptions.IllegalKeyException;
import routeClasses.Route;

import java.util.TreeMap;

public class RemoveGreaterKeyCommand {

    /**
     * Главный метод команды remove_greater_key, который удаляет элементы с ключами больше заданного
     *
     * @param collection изменяемая коллекция
     * @param key        ключ, по которому удаляются элементы
     * @throws IllegalKeyException the illegal key exception
     */

    public void mainMethod(TreeMap<Integer, Route> collection, int key) throws IllegalKeyException {
        if (key >= collection.lastKey()) {
            throw new IllegalKeyException(true);
        }
        for (int k : collection.tailMap(key + 1).keySet()) {
            collection.remove(k);
        }
    }
}
