package exceptions;

/**
 * Исключение, выбрасываемое, если такой команды не существует
 */
public class WrongCommandException extends Exception {
    /**
     * Instantiates a new Wrong command exception.
     */
    public WrongCommandException() {
        super("Неверная команда");
    }
}
