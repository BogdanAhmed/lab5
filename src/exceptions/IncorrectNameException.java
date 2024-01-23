package exceptions;

/**
 * Исключение, выбрасываемое, если поле name введено некорректно
 */
public class IncorrectNameException extends Exception {
    /**
     * Instantiates a new Incorrect name exception.
     */
    public IncorrectNameException() {
        super("Имя Route не должно быть пустым");
    }
}
