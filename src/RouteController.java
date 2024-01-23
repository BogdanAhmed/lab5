import commands.*;
import routeClasses.Route;

import java.util.TreeMap;

/**
 * Класс контроллера коллекции, который хранит в себе все команды и коллекцию
 */
public class RouteController {

    /**
     * The Help command.
     */
    HelpCommand help = new HelpCommand();
    /**
     * The Info command.
     */
    InfoCommand info = new InfoCommand();

    /**
     * The Show command.
     */
    ShowCommand show = new ShowCommand();

    /**
     * The Insert command.
     */
    InsertCommand insert = new InsertCommand();

    /**
     * The Update command.
     */
    UpdateCommand update = new UpdateCommand();

    /**
     * The Load command.
     */
    LoadCommand load = new LoadCommand();
    /**
     * The Remove key command.
     */
    RemoveKeyCommand removeKey = new RemoveKeyCommand();

    /**
     * The Clear command.
     */
    ClearCommand clear = new ClearCommand();

    /**
     * The Save command.
     */
    SaveCommand save = new SaveCommand();

    /**
     * The Remove lower command.
     */
    RemoveLowerCommand removeLower = new RemoveLowerCommand();

    /**
     * The Remove greater key command.
     */
    RemoveGreaterKeyCommand removeGreaterKey = new RemoveGreaterKeyCommand();

    /**
     * The Remove lower key command.
     */
    RemoveLowerKeyCommand removeLowerKey = new RemoveLowerKeyCommand();

    /**
     * The Average of distance command.
     */
    AverageOfDistanceCommand averageOfDistance = new AverageOfDistanceCommand();

    /**
     * The Filter contains name command.
     */
    FilterContainsNameCommand filterContainsName = new FilterContainsNameCommand();

    /**
     * The Print field ascending distance command.
     */
    PrintFieldAscendingDistanceCommand printFieldAscendingDistance = new PrintFieldAscendingDistanceCommand();
    private TreeMap<Integer, Route> routesTreeMap = new TreeMap<>();

    /**
     * Gets routes tree map.
     *
     * @return the routes tree map
     */
    public TreeMap<Integer, Route> getRoutesTreeMap() {
        return routesTreeMap;
    }

    /**
     * Sets routes tree map.
     *
     * @param routesTreeMap the routes tree map
     */
    public void setRoutesTreeMap(TreeMap<Integer, Route> routesTreeMap) {
        this.routesTreeMap = routesTreeMap;
    }
}
