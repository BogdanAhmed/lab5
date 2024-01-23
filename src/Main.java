/**
 * Входная точка программы.
 */
public class Main {
    /**
     *
     * @param args первый элемент должен содержать имя файла, из которого нужно считывать команды
     */
    public static void main(String[] args) {
        try {
            Console command = new Console(args[0]);
            command.run();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Вы не ввели имя файла как аргумент командной строки");
        }
    }
}