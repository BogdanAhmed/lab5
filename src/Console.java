import exceptions.*;

import routeClasses.Route;
import utils.InputValidation;

import java.io.*;
import java.util.*;

/**
 * Класс, отвечающий за работу консоли, предоставляющей пользователю доступ к коллекции посредством команд
 */
public class Console {

    /**
     * The Route controller.
     */
    RouteController routeController = new RouteController();

    private final InputValidation inputValidation = new InputValidation();

    private final String fileName;


    // Булева метка, означающая продолжение работы программы
    private boolean flag = true;

    private Date initDate = new Date();

    /**
     * Instantiates a new Console.
     *
     * @param fileName the file name
     */
    public Console(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Метод для загрузки коллекции из файла
     *
     * @throws IOException the io exception
     */
    public void loadInitialCollection() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        int lineCounter = 0;
        TreeMap<Integer, Route> currentCollection = routeController.getRoutesTreeMap();
        while (reader.ready()) {
            try {
                ++lineCounter;
                String line = reader.readLine();
                routeController.load.mainMethod(currentCollection, line);
            } catch (NumberFormatException e) {
                System.err.printf("В записи %s неверный формат числа", lineCounter);
            } catch (NecessaryFieldMissingException e) {
                System.err.printf("В записи %s отсутствуют необходимые поля", lineCounter);
            } catch (IncorrectNameException e) {
                System.err.printf("В записи %s неверный формат имени", lineCounter);
            } catch (IncorrectDistanceException e) {
                System.err.printf("В записи %s неверный формат дистанции", lineCounter);
            }
        }
    }

    /**
     * Метод для запуска консоли
     */
    public void run() {
        try {
            loadInitialCollection();
        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден");
        } catch (IOException e) {
            System.err.println("Ошибка чтения файла");
            return;
        }
        System.out.println("Добро пожаловать в программу управления коллекцией маршрутов! Введите команды или help для получения списка команд");
        Scanner scanner = new Scanner(System.in);
        while (flag) {
            String command = scanner.nextLine();
            ProceedCommand(command, 1);
        }
    }

    /**
     * Метод для обработки команды
     *
     * @param command the command
     * @param depth   the depth
     */
    public void ProceedCommand(String command, int depth) {
        if (depth > 1000) {
            System.err.println("Превышена максимальная глубина рекурсии, проверьте запускаемый файл");
            return;
        }
        TreeMap<Integer, Route> currentCollection = routeController.getRoutesTreeMap();
        String[] commandParts = command.trim().split(" ", 3);

        try {
            inputValidation.checkCommand(commandParts[0]);
            switch (commandParts[0]) {
                case "help":
                    try {
                        inputValidation.checkLengthArraysOfOne(commandParts.length);
                        routeController.help.mainMethod();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Команда help не принимает аргументы");
                    }
                    break;
                case "info":
                    try {
                        inputValidation.checkLengthArraysOfOne(commandParts.length);
                        routeController.info.mainMethod(currentCollection, initDate);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Команда info не принимает аргументы");
                    }
                    break;
                case "exit":
                    try {
                        inputValidation.checkLengthArraysOfOne(commandParts.length);
                        flag = false;
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Команда exit не принимает аргументы");
                    }
                    break;
                case "show":
                    try {
                        inputValidation.checkLengthArraysOfOne(commandParts.length);
                        for (String s : routeController.show.mainMethod(currentCollection)) {
                            System.out.println(s);
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Команда show не принимает аргументы");
                    }
                    break;
                case "insert":
                    try {
                        int key = inputValidation.checkIfNumber(commandParts[1]);
                        String value = commandParts[2];
                        routeController.insert.mainMethod(currentCollection, key, value, depth > 1);
                        System.out.println("Элемент успешно добавлен");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Команда insert принимает 2 аргумента");
                    } catch (NumberFormatException e) {
                        System.err.println("аргумент-ключ должен быть числом");
                    } catch (IncorrectNameException e) {
                        System.err.println("Неверный формат имени, оно не должно быть пустым");
                    } catch (IncorrectDistanceException e) {
                        System.err.println("Неверный формат дистанции, она должна быть число больше 1");
                    } catch (ElementAlreadyExistsException e) {
                        System.err.println("Элемент с таким ключом уже существует");
                    } catch (UpdatedElementMissingException e) {
                        System.err.println("Элемента с таким ключом не существует, его нельзя обновить");
                    } catch (NecessaryFieldMissingException e) {
                        System.err.println("В записи отсутствуют необходимые поля");
                    }
                    break;
                case "update":
                    try {
                        int key = inputValidation.checkIfNumber(commandParts[1]);
                        String value = commandParts[2];
                        routeController.update.mainMethod(currentCollection, key, value, depth > 1);
                        System.out.println("Элемент успешно обновлен");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Команда update принимает 2 аргумента");
                    } catch (NumberFormatException e) {
                        System.err.println("аргумент-ключ должен быть числом");
                    } catch (UpdatedElementMissingException e) {
                        System.err.println("Элемента с таким ключом не существует, его нельзя обновить");
                    } catch (IncorrectNameException e) {
                        System.err.println("Неверный формат имени, оно не должно быть пустым");
                    } catch (IncorrectDistanceException e) {
                        System.err.println("Неверный формат дистанции, она должна быть число больше 1");
                    } catch (NecessaryFieldMissingException e) {
                        System.err.println("В записи отсутствуют необходимые поля");
                    }
                    break;
                case "remove_key":
                    try {
                        inputValidation.checkLengthArraysOfTwo(commandParts.length);
                        int key = inputValidation.checkIfNumber(commandParts[1]);
                        routeController.removeKey.mainMethod(currentCollection, key);
                        System.out.println("Элемент успешно удалён");
                    } catch (NumberFormatException e) {
                        System.err.println("аргумент-ключ должен быть числом");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Команда remove_key принимает 1 аргумент");
                    } catch (UpdatedElementMissingException e) {
                        System.err.println("Элемента с таким ключом не существует, его нельзя обновить");
                    }
                    break;
                case "clear":
                    try {
                        inputValidation.checkLengthArraysOfOne(commandParts.length);
                        routeController.clear.mainMethod(currentCollection);
                        System.out.println("Коллекция успешно очищена");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Команда clear не принимает аргументы");
                    }
                    break;
                case "save":
                    try {
                        inputValidation.checkLengthArraysOfOne(commandParts.length);
                        routeController.save.mainMethod(fileName, currentCollection);
                        System.out.println("Коллекция успешно сохранена в файл " + fileName);
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Команда save не принимает аргументы");
                    }
                    break;
                case "execute_script":
                    try (BufferedReader reader = new BufferedReader(new FileReader(commandParts[1]))) {
                        String line = reader.readLine();
                        while (line != null) {
                            ProceedCommand(line, depth + 1);
                            line = reader.readLine();
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Команда execute_script принимает 1 аргумент");
                    } catch (FileNotFoundException e) {
                        System.err.println("Файл не найден");
                    } catch (IOException e) {
                        System.err.println("Ошибка чтения файла");
                    }
                    break;
                case "remove_lower":
                    try {
                        inputValidation.checkLengthArraysOfTwo(commandParts.length);
                        routeController.setRoutesTreeMap(routeController.removeLower.mainMethod(currentCollection, commandParts[1], depth > 1));
                        System.out.println("Элементы меньше данного успешно удалены");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Команда remove_lower принимает 1 аргумент");
                    } catch (IncorrectNameException e) {
                        System.err.println("Неверный формат имени, оно не должно быть пустым");
                    } catch (IncorrectDistanceException e) {
                        System.err.println("Неверный формат дистанции, она должна быть число больше 1");
                    } catch (NecessaryFieldMissingException e) {
                        System.err.println("В записи отсутствуют необходимые поля");
                    }
                    break;
                case "remove_greater_key":
                    try {
                        inputValidation.checkLengthArraysOfTwo(commandParts.length);
                        int key = inputValidation.checkIfNumber(commandParts[1]);
                        routeController.removeGreaterKey.mainMethod(currentCollection, key);
                        System.out.println("Элементы с ключом больше данного успешно удалены");
                    } catch (NumberFormatException e) {
                        System.err.println("аргумент-ключ должен быть числом");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Команда remove_greater_key принимает 1 аргумент");
                    } catch (IllegalKeyException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case "remove_lower_key":
                    try {
                        inputValidation.checkLengthArraysOfTwo(commandParts.length);
                        int key = inputValidation.checkIfNumber(commandParts[1]);
                        routeController.removeLowerKey.mainMethod(currentCollection, key);
                        System.out.println("Элементы с ключом меньше данного успешно удалены");
                    } catch (NumberFormatException e) {
                        System.err.println("аргумент-ключ должен быть числом");
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Команда remove_greater_key принимает 1 аргумент");
                    } catch (IllegalKeyException e) {
                        System.err.println(e.getMessage());
                    }
                    break;
                case "average_of_distance":
                    try {
                        inputValidation.checkLengthArraysOfOne(commandParts.length);
                        System.out.println("Среднее значение поля distance: " + routeController.averageOfDistance.mainMethod(currentCollection));
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Команда average_of_distance не принимает аргументы");
                    }
                    break;
                case "filter_contains_name":
                    try {
                        inputValidation.checkLengthArraysOfTwo(commandParts.length);
                        ArrayList<Route> routesContainingName = routeController.filterContainsName.mainMethod(currentCollection, commandParts[1]);
                        for (Route route : routesContainingName) {
                            System.out.println(route);
                        }
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Команда remove_greater_key принимает 1 аргумент");
                    }
                    break;
                case "print_field_ascending_distance":
                    try {
                        inputValidation.checkLengthArraysOfOne(commandParts.length);
                        ArrayList<Long> distances = routeController.printFieldAscendingDistance.mainMethod(currentCollection);
                        System.out.println("Поля distance в порядке возрастания:");
                        for (Long distance : distances) {
                            System.out.print(distance + " ");
                        }
                        System.out.println();
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.err.println("Команда print_field_ascending_distance не принимает аргументы");
                    }
                    break;

            }
        } catch (WrongCommandException e) {
            System.err.println("Такой команды нет, введите help для получения списка команд");
        }
    }
}
