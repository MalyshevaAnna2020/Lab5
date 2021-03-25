package Lab_5;

import java.util.Scanner;

/**
 * Class sets values of the object of the collection
 * All methods run themselves until the entered data is correct
 */
public class Insert {
    /**
     * Method gets value of the object's coordinate X
     * @return Coordinate X
     * @author Ann
     */
    public double insertX(double x){
        Scanner in = new Scanner(System.in);
        Insert insert = new Insert();
        System.out.print("Введите координату X (максимальное значение равно 955): ");
        try {
            x = Double.parseDouble(in.nextLine());
            if (x > 955){
                System.err.println("Координата X не может быть больше 955!");
                x = insert.insertX(x);
            }
        } catch (NumberFormatException e) {
            System.err.println("Координата X представляет собой число!");
            x = insert.insertX(x);
        }
        return x;
    }

    /**
     * Method gets the value of the object's coordinate Y
     *@param coordinates is Coordinates
     *@return Coordinate Y
     */
    public Coordinates insertY(Coordinates coordinates){
        Scanner in = new Scanner(System.in);
        System.out.print("Введите координату Y (целое число): ");
        try {
            coordinates.setY(Integer.parseInt(in.nextLine()));
        }catch (NumberFormatException e){
            System.err.println("Координата Y представляет собой целое число!");
            Insert insert = new Insert();
            coordinates = insert.insertY(coordinates);
        }
        return coordinates;
    }

    /**
     * Method gets the value of the object's health
     * @param health is the health
     * @return health (Long)
     */
    public Long insertHealth(Long health){
        Scanner in = new Scanner(System.in);
        Insert insert = new Insert();
        System.out.print("Введите значение переменной health (неотрицательное число): ");
        try {
            health = Long.parseLong(in.nextLine());
            if (health <= 0){
                System.err.println("Переменная health не может представлять собой отрицательное число!");
                health = insert.insertHealth(health);
            }
        }catch (NumberFormatException e){
            System.err.println("Значение health представляет собой целое число!");
            health = insert.insertHealth(health);
        }
        return health;
    }

    /**
     * Method gets the value of the object's heartCount
     * @param heartCount is the heartCount
     * @return heartCount (int)
     */
    public int insertHeartCount(int heartCount){
        Scanner in = new Scanner(System.in);
        Insert insert = new Insert();
        System.out.print("Введите значение переменной HeartCount (целое число от 0 до 3 включительно): ");
        try {
            heartCount = Integer.parseInt(in.nextLine());
            if (heartCount < 0){
                System.err.println("Переменная heartCount не может быть меньше 0!");
                heartCount = insert.insertHeartCount(heartCount);
            }
            else if (heartCount > 3){
                System.err.println("Переменная heartCount не может быть больше 3!");
                heartCount = insert.insertHeartCount(heartCount);
            }
        }catch (NumberFormatException e){
            System.err.println("Значение HeartCount представляет собой целое число!");
            heartCount = insert.insertHeartCount(heartCount);
        }
        return heartCount;
    }

    /**
     * Method gets the value of the chapter's marinesCount
     * @return marinesCount (int)
     */
    public int insertMarinesCount(int marinesCount){
        Scanner in = new Scanner(System.in);
        Insert insert = new Insert();
        System.out.print("Введите численность части (натуральное число): ");
        try {
            marinesCount = Integer.parseInt(in.nextLine());
            if (marinesCount < 1){
                System.err.println("Значение MarinesCount представляет собой натуральное число!");
                marinesCount = insert.insertMarinesCount(marinesCount);
            }
        }catch (NumberFormatException e){
            System.err.println("Значение MarinesCount представляет собой целое число!");
            marinesCount = insert.insertMarinesCount(marinesCount);
        }
        return marinesCount;
    }

    /**
     * Method gets the value of the chapter's category
     * @param spaceMarine is the object
     * @param category is AstartesCategory
     * @return category of the object
     */
    public AstartesCategory insertCategory(SpaceMarine spaceMarine, AstartesCategory category){
        Scanner in = new Scanner(System.in);
        System.out.println("Введите значение category из следующих: \nSUPPRESSOR,\nTERMINATOR,\nLIBRARIAN,\nAPOTHECARY");
        String s = in.nextLine();
        switch (s) {
            case "SUPPRESSOR":
                spaceMarine.setCategory(AstartesCategory.SUPPRESSOR);
                break;
            case "TERMINATOR":
                spaceMarine.setCategory(AstartesCategory.TERMINATOR);
                break;
            case "LIBRARIAN":
                spaceMarine.setCategory(AstartesCategory.LIBRARIAN);
                break;
            case "APOTHECARY":
                spaceMarine.setCategory(AstartesCategory.APOTHECARY);
                break;
            default:
                System.err.println("Значение category представляет собой имя константы enum AstartesCategory!");
                Insert insert = new Insert();
                category = insert.insertCategory(spaceMarine, category);
                break;
        }
        return category;
    }
}
