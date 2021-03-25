package Lab_5;
import java.io.*;
import java.util.*;
/**
 * The main class of an application that implements interactive object collection management
 * @author Ann
 */
public class MainConsole {
    /**
     * The main method of the class
     * @param args is empty
     * @throws IOException work with files (writing and reading)
     */
    public static void main(String[] args) throws IOException{
        StringBuilder m_file = new StringBuilder();
        for (String string_arg : args){
            m_file.append(string_arg);
        }
        if (!m_file.toString().contains("^D")) {
            File file_main = new File(m_file.toString());
            try {
                new CheckFile().checkFileRead(file_main);
            } catch (FileNotFoundException | FileNotRead e) {
                file_main = new Console().thefile();
                //if (file_main == null)
            }
            Hashtable<String, SpaceMarine> hashtable = new Hashtable<>();
            Scanner in = new Scanner(System.in);
            try {
                new CheckFile().checkFileRead(file_main);
                InputStreamReader isr = new InputStreamReader(new FileInputStream(file_main));
                hashtable = new Console().console(isr);
                isr.close();
                for (String keytab : hashtable.keySet()) {
                    System.out.println(keytab + ": " + hashtable.get(keytab));
                }
            } catch (FileNotFoundException e) {
                System.err.println("Файл для чтения не найден!");
            } catch (FileNotRead e) {
                System.err.println("Файл не доступен для чтения!");
            } catch (IOException e) {
                e.printStackTrace();
            }
            Play p = new Play();
            System.out.println("Можно начинать вводить команды (длина строки не должна превышать 256)!");
            String newcommand;
            while (true) {
                newcommand = in.nextLine();
                if (newcommand.length() > 256) {
                    System.err.println("Очень длинная строка! Введите более короткий вариант!");
                    continue;
                }
                newcommand = newcommand.trim();
                if (newcommand.equals("exit")) break;
                hashtable = p.play(hashtable, newcommand, file_main);
            }
        }
    }
}
