package exceptions;

/**
 * Исключение, указывающее на то, что такого ключа не существует или он недопустим.
 */
public class IllegalKeyException extends Exception {
    public IllegalKeyException(boolean greater) {
        super(greater ? "Нет элементов, ключ которых больше заданного" : "Нет элементов, ключ которых меньше заданного");
    }
}
