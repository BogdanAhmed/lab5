package commands;

import routeClasses.Route;

import java.util.TreeMap;

/**
 * The type Clear command.
 */
public class ClearCommand {

    /**
     * Главный метод команды clear, очищает коллекцию.
     *
     * @param currentCollection the current collection
     */
    public void mainMethod(TreeMap<Integer, Route> currentCollection) {
        currentCollection.clear();
    }
}
