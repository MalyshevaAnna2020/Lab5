package Lab_5;

import java.io.*;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Scanner;

/**
 * This class implements the correct execution of commands
 * @author Ann
 */
public class Play {

    /**
     * The only method of this class. It can call itself. It's a recursive method
     * @param hashtable is the collection
     * @param play is the String, name of the command
     * @return the updated hashtable
     * @throws IOException if the file doesn't exits and checks the read or write permission
     */
    public Hashtable<String, SpaceMarine> play(Hashtable<String, SpaceMarine> hashtable, String play, File file_main) throws IOException {
        Scanner in = new Scanner(System.in);
        Command command = new Command();
        List<String> files = new ArrayList<>();
        if (play.contains("help")){
                System.out.println("help : вывести справку по доступным командам\n" +
                        "info : вывести в стандартный поток вывода информацию о коллекции (тип, дата инициализации, количество элементов и т.д.)\n" +
                        "show : вывести в стандартный поток вывода все элементы коллекции в строковом представлении\n" +
                        "insert null {element} : добавить новый элемент с заданным ключом\n" +
                        "update id {element} : обновить значение элемента коллекции, id которого равен заданному\n" +
                        "remove_key null : удалить элемент из коллекции по его ключу\n" +
                        "clear : очистить коллекцию\n" +
                        "save : сохранить коллекцию в файл\n" +
                        "execute_script file_name : считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.\n" +
                        "exit : завершить программу (без сохранения в файл)\n" +
                        "remove_lower {element} : удалить из коллекции все элементы, меньшие, чем заданный\n" +
                        "remove_greater_key null : удалить из коллекции все элементы, ключ которых превышает заданный\n" +
                        "remove_lower_key null : удалить из коллекции все элементы, ключ которых меньше, чем заданный\n" +
                        "remove_any_by_chapter chapter : удалить из коллекции один элемент, значение поля chapter которого эквивалентно заданному\n" +
                        "filter_greater_than_achievements achievements : вывести элементы, значение поля achievements которых больше заданного\n" +
                        "print_field_descending_category : вывести значения поля category всех элементов в порядке убывания");
            }
            else if (play.contains("info")){
                command.info(hashtable);
            }
            else if(play.contains("show")){
                command.show(hashtable);
            }
            else if (play.contains("insert")){
                hashtable = command.insert(play.substring(play.indexOf("insert") + 6), hashtable);
            }
            else if (play.contains("update")){
                String s2 = play.substring(play.indexOf("update") + 6);
                String s = s2.substring(s2.indexOf("id") + 2);
                try {
                    int s1 = Integer.parseInt(s.trim());
                    hashtable = command.update(s1, hashtable);
                }catch (NumberFormatException e){
                    System.err.println("Переменная id представляет собой число!");
                }
            }
            else if (play.contains("remove_key")){
                hashtable = command.remove_key(play.substring(play.indexOf("remove_key") + 10).trim(), hashtable);
            }
            else if (play.contains("clear")){
                hashtable = command.clear(hashtable);
            }
            else if (play.contains("save")){
                command.save(hashtable, file_main);
            }
            else if (play.contains("print_field_descending_category")){
                command.print_field_descending_category(hashtable);
            }
            else if (play.contains("remove_any_by_chapter")) {
                hashtable = command.remove_any_by_chapter(hashtable, play.substring(play.indexOf("remove_any_by_chapter") + 21).trim());
            }
            else if (play.contains("remove_lower")) {
                try {
                    int i = Integer.parseInt(play.substring(play.indexOf("remove_lower") + 12).trim());
                    hashtable = command.remove_lower(hashtable, i);
                } catch (NumberFormatException e) {
                    System.err.println("Переменная id представляет собой натуральное число!");
                }
            }
            else if (play.contains("remove_greater_key")){
                try {
                    int i = Integer.parseInt(play.substring(play.indexOf("remove_greater_key") + 18).trim());
                    hashtable = command.remove_greater_key(hashtable, i);
                } catch (NumberFormatException e) {
                    System.err.println("Введите целое число!");
                }
            }
            else if (play.contains("remove_lower_key")) {
                try {
                    int i = Integer.parseInt(play.substring(play.indexOf("remove_lower_key") + 16).trim());
                    hashtable = command.remove_lower_key(hashtable, i);
                } catch (NumberFormatException e) {
                    System.err.println("Введите целое число!");
                }
            }
            else if (play.contains("filter_greater_than_achievements")) {
                try {
                    int i = Integer.parseInt(play.substring(play.indexOf("filter_greater_than_achievements") + 32).trim());
                    command.filter_greater_than_achievements(hashtable, i);
                } catch (NumberFormatException e) {
                    System.err.println("Введите целое число!");
                }
            }
            else if (play.contains("execute_script")){
                String file = play.substring(play.indexOf("execute_script") + 14).trim();
                try {
                    new CheckFile().checkFileRead(new File(in.nextLine()));
                    InputStreamReader isr = new InputStreamReader(new FileInputStream(file));
                    files.add(file);
                    mylabel:
                    while(isr.ready()) {
                        StringBuilder builder = new StringBuilder();
                        while (true) {
                            try {
                                char c = (char) isr.read();
                                builder.append(c);
                                if (!isr.ready()) break mylabel;
                                if (c == '\n') break;
                            } catch (IOException e) {
                                System.err.println("!");
                            }
                        }
                        String s = builder.toString();
                        if (s.length() > 257){
                            System.err.println("Очень длинная строка! Введите более короткий вариант!");
                            continue;
                        }
                        if (s.contains("execute_script")){
                            String newfile = s.substring(play.indexOf("execute_script") + 14).trim();
                            for (String value : files) {
                                if (newfile.equals(value)) {
                                    System.err.println("Это команда на исполнение этого же файла, возможна рекурсия!");
                                    if (!s.contains("\n")) break;
                                    continue mylabel;
                                }
                            }
                        }
                        play(hashtable, s.substring(0, s.length() - 1), file_main);
                        if (!s.contains("\n")) break;
                    }
                } catch (FileNotFoundException e){
                    System.err.println("Файл для чтения не найден!");
                } catch (FileNotRead e){
                    System.err.println("Файл не доступен для чтения!");
                }
            }
            else{
                System.err.println("Введите команду help для получений сведений о существующих командах");
            }
            return hashtable;
    }
}
