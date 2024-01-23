package commands;

import routeClasses.Route;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.TreeMap;

public class SaveCommand {

    /**
     * Главный метод команды save, сохраняющий коллекцию в файл
     * @param filename место сохранения файла
     * @param currentCollection коллекция, которую нужно сохранить
     */

    public void mainMethod(String filename, TreeMap<Integer, Route> currentCollection) {
        try (PrintWriter writer = new PrintWriter(filename)) {
            for (Route route : currentCollection.values()) {
                writer.println(route.getSerializedString());
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
