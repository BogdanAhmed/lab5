package utils;

import exceptions.IncorrectDistanceException;
import exceptions.IncorrectNameException;
import exceptions.WrongCommandException;

import java.util.Objects;

/**
 *  Класс, содержащий методы для валидации вводимых данных
 */
public class InputValidation {

    /**
     * Check command.
     *
     * @param command the command
     * @throws WrongCommandException the wrong command exception
     */
    public void checkCommand(String command) throws WrongCommandException {
        if (!(command.equals("help") | command.equals("info") | command.equals("show") | command.equals("insert")
                | command.equals("update") | command.equals("remove_key") | command.equals("clear")
                | command.equals("save") | command.equals("execute_script") | command.equals("exit")
                | command.equals("remove_greater_key") | command.equals("remove_lower_key") | command.equals("remove_lower")
                | command.equals("average_of_distance") | command.equals("filter_contains_name")
                | command.equals("print_field_ascending_distance") | command.equals("sort"))) {
            throw new WrongCommandException();
        }
    }

    /**
     * Check length arrays of one.
     *
     * @param length the length
     */
    public void checkLengthArraysOfOne(Integer length){
        if (length != 1){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Check length arrays of two.
     *
     * @param length the length
     */
    public void checkLengthArraysOfTwo(Integer length){
        if (length != 2){
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * Check if number int.
     *
     * @param number the number
     * @return the int
     * @throws NumberFormatException the number format exception
     */
    public int checkIfNumber(String number) throws NumberFormatException {
        return Integer.parseInt(number);
    }

    /**
     * Check name.
     *
     * @param name the name
     * @throws IncorrectNameException the incorrect name exception
     */
    public void checkName(String name) throws IncorrectNameException {
        if (Objects.equals(name, "")) {
            throw new IncorrectNameException();
        }
    }

    /**
     * Check distance long.
     *
     * @param d the d
     * @return the long
     * @throws IncorrectDistanceException the incorrect distance exception
     */
    public Long checkDistance(String d) throws IncorrectDistanceException {
        try {
            if (Long.parseLong(d) <= 1) {
                throw new IncorrectDistanceException();
            }
            return Long.parseLong(d);
        } catch (NumberFormatException e) {
            throw new IncorrectDistanceException();
        }
    }

    /**
     * Check location to name string.
     *
     * @param name the name
     * @return the string
     * @throws IncorrectNameException the incorrect name exception
     */
    public String checkLocationToName(String name) throws IncorrectNameException {
        if (name.length() > 875) {
            throw new IncorrectNameException();
        }
        return name;
    }

    /**
     * Check yes or no.
     *
     * @param answer the answer
     * @throws WrongCommandException the wrong command exception
     */
    public void checkYesOrNo(String answer) throws WrongCommandException {
        answer = answer.toLowerCase();
        if (!(answer.equals("yes") | answer.equals("no"))) {
            throw new WrongCommandException();
        }
    }
}
