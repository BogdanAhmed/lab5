package exceptions;

/**
 * Исключение, выбрасываемое, если в данных о Route нет обязательных полей
 */
public class NecessaryFieldMissingException extends Exception {
    /**
     * Instantiates a new Necessary field missing exception.
     */
    public NecessaryFieldMissingException() {
        super("Не хватает обязательных полей");
    }
}
