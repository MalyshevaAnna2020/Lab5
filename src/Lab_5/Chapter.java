package Lab_5;

/**
 * The name and population of the Chapter
 * @author Ann
 */
public class Chapter {
    private String name; //Поле не может быть null, Строка не может быть пустой
    private int marinesCount; //Значение поля должно быть больше 0, Максимальное значение поля: 1000

    /**
     * Sets name of Chapter
     * @param name is name of Chapter
     */
    public void setName(String name) {
        if (name.isEmpty()){
            this.name = "Chapter";
            System.err.println("Название главы не может представлять собой пустую строку! name = Chapter");
        }
        else {
            this.name = name;
        }
    }

    /**
     * Sets number of marines
     * @param marinesCount is number of marines
     */
    public void setMarinesCount(int marinesCount) {
        if (marinesCount < 1){
            this.marinesCount = 1;
            System.err.println("Значение переменной marinesCount должно быть больше 0! marinesCount = 1");
        }
        if (marinesCount > 1000){
            this.marinesCount = 1000;
            System.err.println("Значение переменной marinesCount должно быть меньше 1000! marinesCount = 1000");
        }
        this.marinesCount = marinesCount;
    }

    /**
     * Returns number of Chapter's marines
     * @return number of Chapter's marines
     */
    public int getMarinesCount() {
        return marinesCount;
    }

    /**
     * Returns name of Chapter
     * @return name of Chapter
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @return class Chapter as String
     */
    @Override
    public String toString(){
        return this.getName() + ". Часть " + this.getMarinesCount();
    }
}
