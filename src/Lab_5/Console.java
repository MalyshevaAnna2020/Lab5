package Lab_5;

import java.io.*;
import java.util.*;

/**
 * Class populate the collection with the values from the file, when the application starts
 * @author Ann
 */
public class Console {

    public File thefile(){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите имя файла для чтения:");
        String file = in.nextLine();
        if (!file.contains("^D")) {
            File file_main = new File(file);
            try {
                new CheckFile().checkFileRead(file_main);
            } catch (FileNotFoundException | FileNotRead e) {
                file_main = new Console().thefile();
            }
            return file_main;
        }
        return null;
    }
    /**
     * Method fills the collection with the values from the file
     * @param isr is InputStreamReader to read from the file
     * @return updated collection
     */

    public Hashtable<String, SpaceMarine> console(InputStreamReader isr) {
        int id = 0;
        Hashtable<String, SpaceMarine> subhashtable = new Hashtable<>();
        Hashtable<String, SpaceMarine> hashtable = new Hashtable<>();
        List<String> list = new ArrayList<>();
        while (true) {
            String s = getLine(isr);
            if (s.length() == 1) break;
            int equals = s.indexOf("/>");
            if (equals > -1) {
                SpaceMarine spaceMarine = new SpaceMarine();
                setSpaceMarine(s, spaceMarine, ++id);
                String key = s.substring(s.indexOf("<") + 1,s.substring(s.indexOf("<")).indexOf(" ") + s.indexOf("<"));
                subhashtable.put(key, spaceMarine);
                list.add(key);
            }
        }
        list.sort(Comparator.naturalOrder());
        for (String key : list){
            hashtable.put(key, subhashtable.get(key));
        }
        return hashtable;
    }
    /**
     * Method reads the next line of the file
     * @param isr is InputStreamReader to read from the file
     * @return the next line
     */
    public String getLine(InputStreamReader isr) {
        StringBuilder builder = new StringBuilder();
        while (true) {
            try {
                char c = (char) isr.read();
                if (c == '\n') break;
                builder.append(c);
            } catch (IOException e) {
                System.err.println("!");
            }
        }
        return builder.toString();
    }

    /**
     * Method fills the element with values (id, name, coordinates and etc.)
     * @param s is the string from which the element gets values
     * @param spaceMarine is the element
     * @param id is the id of the element
     */
    public void setSpaceMarine(String s, SpaceMarine spaceMarine, int id) {
        spaceMarine.setId(id);

        if (s.contains("name")) {
            int subs = s.substring(s.indexOf("name")).indexOf("\"") + 1;
            String name = s.substring(s.indexOf("name")).substring(subs, s.substring(s.indexOf("name")).substring(subs).indexOf("\"") + subs);
            spaceMarine.setName(name);
        }else{
            spaceMarine.setName("");
        }

        Coordinates coordinates = new Coordinates();
        if (s.contains("coordinates")) {
            int subs = s.substring(s.indexOf("coordinates")).indexOf("\"") + 1;
            String strcoordinates = s.substring(s.indexOf("coordinates")).substring(subs, s.substring(s.indexOf("coordinates")).substring(subs).indexOf("\"") + subs);
            try {
                coordinates.setX(Double.parseDouble(strcoordinates.substring(0, strcoordinates.indexOf(" "))));
            } catch (NumberFormatException e) {
                System.err.println("Значение координаты X объекта " + spaceMarine.toString() + " определенно не коректно! Значение координаты X: 0.0");
                coordinates.setX(0);
            }
            try {
                coordinates.setY(Integer.parseInt(strcoordinates.substring(strcoordinates.indexOf(" ") + 2)));
            } catch (NumberFormatException e) {
                System.err.println("Значение координаты Y объекта " + spaceMarine.toString() + " определенно не коректно! Значение координаты Y: 0");
                coordinates.setY(0);
            }
        }else{
            coordinates.setX(0);
            coordinates.setY(0);
        }
        spaceMarine.setCoordinates(coordinates);

        spaceMarine.setCreationDate(new Date());

        if (s.contains("health")) {
            int subs = s.substring(s.indexOf("health")).indexOf("\"") + 1;
            try {
                spaceMarine.setHealth(Long.parseLong(s.substring(s.indexOf("health")).substring(subs, s.substring(s.indexOf("health")).substring(subs).indexOf("\"") + subs)));
            } catch (NumberFormatException e) {
                System.err.println("Значение переменной health объекта " + spaceMarine.toString() + " определенно не коректно! переменной health: null");
                spaceMarine.setHealth((long) 0);
            }
        }else{
            spaceMarine.setHealth((long) 0);
        }

        if (s.contains("heartCount")) {
            int subs = s.substring(s.indexOf("heartCount")).indexOf("\"") + 1;
            try {
                spaceMarine.setHeartCount(Integer.parseInt(s.substring(s.indexOf("heartCount")).substring(subs, s.substring(s.indexOf("heartCount")).substring(subs).indexOf("\"") + subs)));
            } catch (NumberFormatException e) {
                System.err.println("Значение переменной heartCount объекта " + spaceMarine.toString() + " определенно не коректно! переменной heartCount: null");
                spaceMarine.setHealth((long) 0);
            }
        }else{
            spaceMarine.setHeartCount(0);
        }

        if (s.contains("heartCount")) {
            int subs = s.substring(s.indexOf("achievements")).indexOf("\"") + 1;
            String achievements = s.substring(s.indexOf("achievements")).substring(subs, s.substring(s.indexOf("achievements")).substring(subs).indexOf("\"") + subs);
            spaceMarine.setAchievements(achievements);
        }else{
            spaceMarine.setAchievements("");
        }

        if (s.contains("category")) {
            int subs = s.substring(s.indexOf("category")).indexOf("\"") + 1;
            String category = s.substring(s.indexOf("category")).substring(subs, s.substring(s.indexOf("category")).substring(subs).indexOf("\"") + subs);
            spaceMarine.setCategory(category);
        }else{
            spaceMarine.setCategory("");
        }

        if (s.contains("chapter")) {
            int subs = s.substring(s.indexOf("chapter")).indexOf("\"") + 1;
            String chapter = s.substring(s.indexOf("chapter")).substring(subs, s.substring(s.indexOf("chapter")).substring(subs).indexOf("\"") + subs);
            spaceMarine.setChapter(chapter);
        }else{
            spaceMarine.setChapter("");
        }
    }
}
