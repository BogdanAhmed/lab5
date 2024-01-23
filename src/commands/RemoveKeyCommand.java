package commands;

import exceptions.UpdatedElementMissingException;
import routeClasses.Route;

import java.util.TreeMap;

/**
 * The type Remove key command.
 */
public class RemoveKeyCommand {

    /**
     * Главный метод команды remove_key, который удаляет элемент по ключу
     *
     * @param currentCollection изменяемая коллекция
     * @param key               ключ, по которому удаляется элемент
     * @return измененная коллекция
     * @throws UpdatedElementMissingException the updated element missing exception
     */

    public TreeMap<Integer, Route> mainMethod(TreeMap<Integer, Route> currentCollection, int key) throws UpdatedElementMissingException {
        if (!currentCollection.containsKey(key)) {
            throw new UpdatedElementMissingException(key);
        }
        currentCollection.remove(key);
        return currentCollection;
    }
}
