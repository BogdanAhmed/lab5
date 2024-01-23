package commands;

import exceptions.IncorrectDistanceException;
import exceptions.IncorrectNameException;
import exceptions.NecessaryFieldMissingException;
import exceptions.WrongCommandException;
import routeClasses.Coordinates;
import routeClasses.LocationFrom;
import routeClasses.LocationTo;
import routeClasses.Route;
import utils.InputValidation;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Базовый абстрактный класс для команд, осуществляющих чтение данных о Route.
 */
public abstract class ReadRoute {


    /**
     * The Necessary fields.
     */
    protected final String[] necessaryFields = new String[]{"id", "name", "coordinatesX", "coordinatesY",
            "creationDate", "fromX", "fromY", "fromName", "distance"};

    /**
     * The Validator.
     */
    InputValidation validator = new InputValidation();

    /**
     * Метод для чтения объекта Route из строки
     *
     * @param value строка, из которой нужно считать объект
     * @return объект Route
     * @throws IncorrectNameException     the incorrect name exception
     * @throws IncorrectDistanceException the incorrect distance exception
     */
    public Route readRoute(String value) throws IncorrectNameException, IncorrectDistanceException {
        Route route = new Route();
        Coordinates coordinates = new Coordinates();
        LocationFrom fromLocation = new LocationFrom();
        LocationTo toLocation = new LocationTo();

        value = value.trim().replace("\"", "").replace("'", "")
                .replace("{", "").replace("}", "");
        String[] pairs = value.split(",");
        String name, distance;
        if (pairs.length != 2) {
            throw new ArrayIndexOutOfBoundsException();
        }
        // Ввод названия и дистанции - полей стандартных типов
        for (int i = 0; i < 2; ++i) {
            if (i == 0) {
                name = pairs[i].split("=")[1];
                validator.checkName(name);
                route.setName(name);
            } else {
                distance = pairs[i].split("=")[1];
                route.setDistance(validator.checkDistance(distance));
            }
        }
        Scanner sc = new Scanner(System.in);
        // ввод координат
        while (true) {
            try {
                System.out.println("Введите значение координаты X - целое число");
                String x = sc.nextLine();
                coordinates.setX(Long.parseLong(x));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода, попробуйте снова");
            }
        }

        while (true) {
            try {
                System.out.println("Введите значение координаты Y - вещественное число");
                String y = sc.nextLine();
                coordinates.setY(Double.parseDouble(y));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода, попробуйте снова");
            }
        }
        route.setCoordinates(coordinates);
        route.setCreationDate(LocalDate.now());
        // ввод локации FROM
        while (true) {
            try {
                System.out.println("Введите значение координаты X локации - вещественное число");
                String x = sc.nextLine();
                fromLocation.setX(Float.parseFloat(x));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода, попробуйте снова");
            }
        }

        while (true) {
            try {
                System.out.println("Введите значение координаты Y локации - целое число");
                String y = sc.nextLine();
                fromLocation.setY(Long.parseLong(y));
                break;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода, попробуйте снова");
            }
        }
        boolean hasLocationFromName;
        while (true) {
            try {
                System.out.println("Введите YES, если хотите ввести название локации FROM, иначе введите NO");
                String answer = sc.nextLine();
                validator.checkYesOrNo(answer);
                hasLocationFromName = answer.equalsIgnoreCase("yes");
                break;
            } catch (WrongCommandException e) {
                System.out.println("Неверный формат ввода, попробуйте снова");
            }

        }
        if (hasLocationFromName) {
            while (true) {
                try {
                    System.out.println("Введите название локации");
                    name = sc.nextLine();
                    validator.checkName(name);
                    fromLocation.setName(name);
                    break;
                } catch (IncorrectNameException e) {
                    System.out.println("Название не может быть пустым, попробуйте снова");
                }
            }
        } else {
            fromLocation.setName("null");
        }

        route.setFrom(fromLocation);
        boolean hasTo;
        while (true) {
            try {
                System.out.println("Введите YES, если хотите ввести локацию TO, иначе введите NO");
                String answer = sc.nextLine();
                validator.checkYesOrNo(answer);
                hasTo = answer.equalsIgnoreCase("yes");
                break;
            } catch (WrongCommandException e) {
                System.out.println("Неверный формат ввода, попробуйте снова");
            }
        }
        // ввод локации TO, если это нужно
        if (hasTo) {
            while (true) {
                try {
                    System.out.println("Введите значение координаты X локации - целое число");
                    String x = sc.nextLine();
                    toLocation.setX(Integer.parseInt(x));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат ввода, попробуйте снова");
                }
            }

            while (true) {
                try {
                    System.out.println("Введите значение координаты Y локации - вещественное число");
                    String y = sc.nextLine();
                    toLocation.setY(Float.parseFloat(y));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат ввода, попробуйте снова");
                }
            }

            while (true) {
                try {
                    System.out.println("Введите значение координаты Z локации - вещественное число");
                    String z = sc.nextLine();
                    toLocation.setY(Float.parseFloat(z));
                    break;
                } catch (NumberFormatException e) {
                    System.out.println("Неверный формат ввода, попробуйте снова");
                }
            }
            while (true) {
                try {
                    System.out.println("Введите название локации");
                    name = sc.nextLine();
                    validator.checkLocationToName(name);
                    toLocation.setName(name);
                    break;
                } catch (IncorrectNameException e) {
                    System.out.println("Название не может быть пустым и его длина не может превосходить 875, попробуйте снова");
                }
            }
            route.setTo(toLocation);
        }
        return route;
    }

    /**
     * Метод для парсинга объекта Route из строки
     *
     * @param value the value
     * @return route
     * @throws IncorrectNameException         the incorrect name exception
     * @throws IncorrectDistanceException     the incorrect distance exception
     * @throws NecessaryFieldMissingException the necessary class missing exception
     */
    public Route parseRoute(String value) throws IncorrectNameException, IncorrectDistanceException, NecessaryFieldMissingException {
        String[] pairs = value.trim().replace("\"", "").replace("'", "")
                .replace("{", "").replace("}", "").split(",");
        Route route = new Route();
        Coordinates coordinates = new Coordinates();
        LocationFrom locationFrom = new LocationFrom();
        LocationTo locationTo = new LocationTo();
        HashMap<String, String> fields = new HashMap<>();
        for (String pair : pairs) {
            String[] keyValue = pair.split("=");
            fields.put(keyValue[0], keyValue[1]);
        }
        for (String necField : necessaryFields) {
            if (!fields.containsKey(necField)) {
                throw new NecessaryFieldMissingException();
            }
        }
        if (fields.containsKey("id")) {
            route.setId(Long.parseLong(fields.get("id")));
        }
        validator.checkName(fields.get("name"));
        route.setName(fields.get("name"));
        coordinates.setX(Long.parseLong(fields.get("coordinatesX")));
        coordinates.setY(Float.parseFloat(fields.get("coordinatesY")));
        route.setCoordinates(coordinates);
        route.setCreationDate(LocalDate.parse(fields.get("creationDate")));
        locationFrom.setX(Float.parseFloat(fields.get("fromX")));
        locationFrom.setY(Long.parseLong(fields.get("fromY")));
        locationFrom.setName(fields.get("fromName"));
        route.setFrom(locationFrom);
        validator.checkDistance(fields.get("distance"));
        route.setDistance(validator.checkDistance(fields.get("distance")));
        if (fields.containsKey("toX") && fields.containsKey("toY") && fields.containsKey("toName")) {
            locationTo.setX(Integer.parseInt(fields.get("toX")));
            locationTo.setY(Float.parseFloat(fields.get("toY")));
            locationTo.setZ(Float.parseFloat(fields.get("toZ")));
            locationTo.setName(validator.checkLocationToName(fields.get("toName")));
            route.setTo(locationTo);
        }
        return route;
    }
}
