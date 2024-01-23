package exceptions;

/**
 * Исключение, указывающее на то, что элемент уже содержится в коллекции.
 */
public class ElementAlreadyExistsException extends Exception {

    private long ID;

    /**
     * Instantiates a new Element already exists exception.
     *
     * @param ID the id
     */
    public ElementAlreadyExistsException(long ID) {
        super("Элемент %s уже существует".formatted(ID));
        this.ID = ID;
    }
}
