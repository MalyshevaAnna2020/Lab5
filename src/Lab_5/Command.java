package Lab_5;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

/**
 * Class supports the execution of the main commands
 * @author Ann
 */
public class Command {
    /**
     * Method outputs information about the collection (type, initialization date, number of elements, etc.)
     * @param hashtable is the collection
     */
    public void info(Hashtable<String, SpaceMarine> hashtable){
        if (!hashtable.isEmpty()) {
            for (String key : hashtable.keySet()) {

                System.out.println("key=\"" + key + "\"\t" + "id=\"" + hashtable.get(key).getId() + "\"\t" +
                        "name=\"" + hashtable.get(key).getName() + "\"\t" +
                        "coordinates=\"" + hashtable.get(key).getCoordinates().toString() + "\"\t" +
                        "creationDate=\"" + hashtable.get(key).getCreationDate() + "\"\t" +
                        "health=\"" + hashtable.get(key).getHealth() + "\"\t" +
                        "heartCount=\"" + hashtable.get(key).getHeartCount() + "\"\t" +
                        "achievements=\"" + hashtable.get(key).getAchievements() + "\"\t" +
                        "category=\"" + hashtable.get(key).getCategory() + "\"\t" +
                        "chapter=\"" + hashtable.get(key).getChapter() + "\"");
            }
        }else{
            System.out.println("В коллекции нет элементов!");
        }
    }

    /**
     * Method outputs elements of the collection
     * @param hashtable is the collection
     */
    public void show(Hashtable<String, SpaceMarine> hashtable){
        if (!hashtable.isEmpty()) {
            System.out.print("Элементы коллекции: ");
            System.out.println(hashtable.keySet().toString().substring(1, hashtable.keySet().toString().length() - 1));
        }else{
            System.out.println("В коллекции нет элементов!");
        }
    }

    /**
     * Method adds new ellement with the specified key
     * @param key is the key
     * @param hashtable is the collection
     * @return updated collection
     */
    public Hashtable<String, SpaceMarine> insert(String key, Hashtable<String, SpaceMarine> hashtable){
        SpaceMarine spaceMarine = new SpaceMarine();
        Insert insert = new Insert();
        key = key.trim();

        spaceMarine.setId(hashtable.size() + 1);

        Scanner in = new Scanner (System.in);
        System.out.print("Введите имя: ");
        spaceMarine.setName(in.nextLine());

        Coordinates coordinates = new Coordinates();
        double x = 0;
        x = insert.insertX(x);
        coordinates.setX(x);
        coordinates = insert.insertY(coordinates);
        spaceMarine.setCoordinates(coordinates);

        spaceMarine.setCreationDate(new Date());

        Long health = 0L;
        health = insert.insertHealth(health);
        spaceMarine.setHealth(health);

        int heartCount = 0;
        heartCount = insert.insertHeartCount(heartCount);
        spaceMarine.setHeartCount(heartCount);

        System.out.print("Введите достижения: ");
        spaceMarine.setAchievements(in.nextLine());

        AstartesCategory category = AstartesCategory.APOTHECARY;
        category = insert.insertCategory(spaceMarine, category);
        spaceMarine.setCategory(category);

        Chapter chapter = new Chapter();
        System.out.print("Введите название части: ");
        chapter.setName(in.nextLine());
        int marinesCount = 0;
        marinesCount = insert.insertMarinesCount(marinesCount);
        chapter.setMarinesCount(marinesCount);
        spaceMarine.setChapter(chapter);

        hashtable.put(key, spaceMarine);
        System.out.println("Элемент успешно добавлен в коллекцию!");
        return hashtable;
    }

    /**
     * Method updates the element of the collection with the specified id
     * @param id is the id
     * @param hashtable is the collection
     * @return updated collection
     */
    public Hashtable<String, SpaceMarine> update(int id, Hashtable<String, SpaceMarine> hashtable){
        if (id > 0) {
            int realId = 0;
            String realKey = "";
            for (String key : hashtable.keySet()) {
                if (hashtable.get(key).getId() == id) {
                    realKey = key;
                    realId = id;
                }
            }
            if ((id < hashtable.size()) && ((realId != 0))) {
                Insert insert = new Insert();
                Scanner in = new Scanner (System.in);
                System.out.print("Введите имя: ");
                hashtable.get(realKey).setName(in.nextLine());

                Coordinates coordinates = new Coordinates();
                double x = 0;
                x = insert.insertX(x);
                coordinates.setX(x);
                coordinates = insert.insertY(coordinates);
                hashtable.get(realKey).setCoordinates(coordinates);

                hashtable.get(realKey).setCreationDate(new Date());

                Long health = 0L;
                health = insert.insertHealth(health);
                hashtable.get(realKey).setHealth(health);

                int heartCount = 0;
                heartCount = insert.insertHeartCount(heartCount);
                hashtable.get(realKey).setHeartCount(heartCount);

                System.out.print("Введите достижения: ");
                hashtable.get(realKey).setAchievements(in.nextLine());

                AstartesCategory category = AstartesCategory.APOTHECARY;
                category = insert.insertCategory(hashtable.get(realKey), category);
                hashtable.get(realKey).setCategory(category);

                Chapter chapter = new Chapter();
                System.out.print("Введите название части: ");
                chapter.setName(in.nextLine());
                int marinesCount = 0;
                marinesCount = insert.insertMarinesCount(marinesCount);
                chapter.setMarinesCount(marinesCount);
                hashtable.get(realKey).setChapter(chapter);
                System.out.println("Элемент коллекции успешно обновлен!");
            } else {
                System.err.println("Элемент с данным id отсутствует!");
            }
        }else{
            System.err.println("Переменная id представляет собой натуральное число!");
        }
        return hashtable;
    }

    /**
     * Method delets element from the collection with specified key
     * @param key is the key
     * @param hashtable is the collection
     * @return updated collection
     */
    public Hashtable<String, SpaceMarine> remove_key(String key, Hashtable<String, SpaceMarine> hashtable){
        Hashtable<String, SpaceMarine> subhashtable = new Hashtable<>();
        for (String keys : hashtable.keySet()){
            if (!keys.equals(key)){
                subhashtable.put(keys, hashtable.get(keys));
            }
        }
        System.out.println("Элемент коллекции с ключом " + key + " успешно удален!");
        return subhashtable;
    }

    /**
     * Method clears the collection
     * @param hashtable is the collection
     * @return empty collection
     */
    public Hashtable<String, SpaceMarine> clear(Hashtable<String, SpaceMarine> hashtable){
        hashtable.clear();
        System.out.println("Все элемент коллекции успешно обновлены!");
        return hashtable;
    }

    /**
     * Method writes the collection to the file
     * @param hashtable is the collection
     * @param file is the file in that collection is saved
     * @throws IOException work with files (writing)
     */
    public void save(Hashtable<String, SpaceMarine> hashtable, File file) throws IOException {
        try {
            new CheckFile().checkFileWrite(file);
            FileWriter writer = new FileWriter(file);
            writer.write("<?xml version=\"1.0\" encoding=\"utf-8\"?>\n<!DOCTYPE hashtable>\n<hashtable>\n");
            if (!hashtable.isEmpty()) {
                for (String key : hashtable.keySet()) {
                    writer.write("    <" + key + " id=\"" + hashtable.get(key).getId() + "\" name=\"" + hashtable.get(key).getName() + "\" coordinates=\""
                            + hashtable.get(key).getCoordinates().toString() + "\" creationDate=\"" + hashtable.get(key).getCreationDate()
                            + "\" health=\"" + hashtable.get(key).getHealth() + "\" heartCount=\"" + hashtable.get(key).getHeartCount()
                            + "\" achievements=\"" + hashtable.get(key).getAchievements() + "\" category=\""
                            + hashtable.get(key).getCategory() + "\" chapter=\"" + hashtable.get(key).getChapter() + "\" />\n");
                }
            }
            writer.write("</hashtable>\n");
            writer.close();
            System.out.println("Элементы коллекции успешно сохранены!");
        } catch (FileNotFoundException e){
            System.out.println("В данный файл невозможно сохранить коллекцию!");
        } catch (FileNotWrite e){
            System.err.println("Файл не доступен для записи!");
        }
    }

    /**
     * Method removes elements from the collection with id lower than specified
     * @param hashtable is the collection
     * @param id is the value of the minimum possible id of each element in the collection
     * @return updated collection
     */
    public Hashtable<String, SpaceMarine> remove_lower(Hashtable<String, SpaceMarine> hashtable, int id){
        Hashtable<String, SpaceMarine> subhashtable = new Hashtable<>();
        for (String key : hashtable.keySet()){
            if (hashtable.get(key).getId() >= id){
                subhashtable.put(key, hashtable.get(key));
            }
        }
        System.out.println("Элементы коллекции с id меньше " + id + " успешно удалены!");
        return subhashtable;
    }

    /**
     * Method removes elements which lenght of the key is greater than specified
     * @param hashtable is the collection
     * @param length is the maximum possible length of the key of any element of the collection
     * @return updated collection
     */
    public Hashtable<String, SpaceMarine> remove_greater_key(Hashtable<String, SpaceMarine> hashtable, int length){
        Hashtable<String, SpaceMarine> subhashtable = new Hashtable<>();
        for (String key : hashtable.keySet()){
            if (key.length() <= length){
                subhashtable.put(key, hashtable.get(key));
            }
        }
        System.out.println("Элементы коллекции с длиной ключа больше " + length + " успешно удалены!");
        return subhashtable;
    }

    /**
     * Method removes elements which lenght of the key is lower than specified
     * @param hashtable is the collection
     * @param length is the minimum possible length of the key of any element of the collection
     * @return updated collection
     */
    public Hashtable<String, SpaceMarine> remove_lower_key(Hashtable<String, SpaceMarine> hashtable, int length){
        Hashtable<String, SpaceMarine> subhashtable = new Hashtable<>();
        for (String key : hashtable.keySet()){
            if (key.length() >= length){
                subhashtable.put(key, hashtable.get(key));
            }
        }
        System.out.println("Элементы коллекции с длиной ключа меньше " + length + " успешно удалены!");
        return subhashtable;
    }

    /**
     * Method removes all elements which are in the specified chapter
     * @param hashtable is the collection
     * @param chapter is the chapter
     * @return updated collection
     */
    public Hashtable<String, SpaceMarine> remove_any_by_chapter(Hashtable<String, SpaceMarine> hashtable, String chapter){
        Hashtable<String, SpaceMarine> subhashtable = new Hashtable<>();
        for (String key : hashtable.keySet()){
            if (!hashtable.get(key).getChapter().toString().equals(chapter)){
                subhashtable.put(key, hashtable.get(key));
            }
        }
        System.out.println("Элементы коллекции, принадлежащие " + chapter + " успешно удалены!");
        return subhashtable;
    }

    /**
     * Method outputs the elements with achievements field value greater than the specified value
     * @param hashtable is the collection
     * @param length is the minimum possible length of the achievements of the element to be outputed
     */
    public void filter_greater_than_achievements(Hashtable<String, SpaceMarine> hashtable, int length){
        List<String> list = new ArrayList<>();
        for (String key : hashtable.keySet()){
            if (hashtable.get(key).getAchievements().length() > length){
                list.add(key);
            }
        }
        System.out.println(list.toString().substring(1, list.toString().length() - 1));
    }

    /**
     * Method outputs all elementns of the collection descending category
     * @param hashtable is the collection
     */
    public void print_field_descending_category(Hashtable<String, SpaceMarine> hashtable){
        Hashtable<String, SpaceMarine> subhashtable = new Hashtable<>();
        for (String key : hashtable.keySet()){
            if ((hashtable.get(key).getCategory() != null)
                    && (hashtable.get(key).getCategory().toString().equals("SUPPRESSOR"))){
                subhashtable.put(key, hashtable.get(key));
            }
        }
        for (String key : hashtable.keySet()){
            if ((hashtable.get(key).getCategory() != null)
                    && (hashtable.get(key).getCategory().toString().equals("TERMINATOR"))){
                subhashtable.put(key, hashtable.get(key));
            }
        }
        for (String key : hashtable.keySet()){
            if ((hashtable.get(key).getCategory() != null)
                    && (hashtable.get(key).getCategory().toString().equals("LIBRARIAN"))){
                subhashtable.put(key, hashtable.get(key));
            }
        }
        for (String key : hashtable.keySet()){
            if ((hashtable.get(key).getCategory() != null)
                    && (hashtable.get(key).getCategory().toString().equals("APOTHECARY"))){
                subhashtable.put(key, hashtable.get(key));
            }
        }
        for (String key : hashtable.keySet()){
            if (!subhashtable.contains(hashtable.get(key))){
                subhashtable.put(key, hashtable.get(key));
            }
        }
        show(subhashtable);
    }
}
