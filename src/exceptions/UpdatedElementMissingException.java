package exceptions;

/**
 * Исключение, выбрасываемое, если элемента, который нужно обновить, не существует
 */
public class UpdatedElementMissingException extends Exception {
    /**
     * Instantiates a new Updated element missing exception.
     *
     * @param key the key
     */
    public UpdatedElementMissingException(int key) {
        super("Элемента с ключом %s не существует".formatted(key));
    }
}
