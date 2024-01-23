package exceptions;

/**
 * Исключение, выбрасываемое, если поле distance введено некорректно
 */
public class IncorrectDistanceException extends Exception {
    /**
     * Instantiates a new Incorrect distance exception.
     */
    public IncorrectDistanceException() {
        super("Поле distance должно быть целым числом больше 1");
    }
}
