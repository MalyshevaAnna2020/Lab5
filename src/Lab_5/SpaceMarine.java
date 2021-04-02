package Lab_5;
import java.util.Date;

/**
 * The instance of the class is the element of the collection
 * @author Ann
 */
public class SpaceMarine {
    private int id; //Значение поля должно быть больше 0, Значение этого поля должно быть уникальным, Значение этого поля должно генерироваться автоматически
    private String name; //Поле не может быть null, Строка не может быть пустой
    private Coordinates coordinates; //Поле не может быть null
    private Date creationDate; //Поле не может быть null, Значение этого поля должно генерироваться автоматически
    private Long health = null; //Поле может быть null, Значение поля должно быть больше 0
    private int heartCount; //Значение поля должно быть больше 0, Максимальное значение поля: 3
    private String achievements = null; //Поле может быть null
    private AstartesCategory category = null; //Поле может быть null
    private Chapter chapter = null; //Поле может быть null

    /**
     * Method automatically sets id of the object of the collection
     * @param id is int
     */
    public void setId(int id){
        this.id = id;
    }

    /**
     * Method sets the specified name of the object
     * @param name is String
     */
    public void setName(String name){
        if (name.isEmpty()){
            this.name = "id" + id;
            System.err.println("Имя не может представлять собой пустую строку! Сгенерированное автоматически имя: " + this.name);
        }else {
            this.name = name;
        }
    }

    /**
     * Method sets coordinates of the object
     * @param coordinates is Coordinates
     */
    public void setCoordinates(Coordinates coordinates){
        this.coordinates = coordinates;
    }

    /**
     * Method sets the date of creation of the file
     * @param creationDate is java.util.Date
     */
    public void setCreationDate(Date creationDate){
        this.creationDate = creationDate;
    }

    /**
     * Method sets health of the object
     * @param health is Long
     */
    public void setHealth(Long health) {
        if (health <= 0){
            this.health = (long) 0;
            System.err.println("Переменная health не может представлять собой отрицательное число! health = 0");
        }else {
            this.health = health;
        }
    }

    /**
     * Method sets heartCount of the object
     * @param heartCount is int
     */
    public void setHeartCount(int heartCount) {
        if (heartCount < 0){
            this.heartCount = 0;
            System.err.println("Переменная heartCount не может быть меньше 0! heartCount = 0");
        }
        else if (heartCount > 3){
            this.heartCount = 3;
            System.err.println("Переменная heartCount не может быть больше 3! heartCount = 3");
        }
        else {
            this.heartCount = heartCount;
        }
    }

    /**
     * Method sets achievements of the object
     * @param achievements is String
     */
    public void setAchievements(String achievements){
        this.achievements = achievements;
    }

    /**
     * Method sets category of the object
     * @param category is String
     */
    public void setCategory(String category){
        if (category.equals("SUPPRESSOR")){
            this.category = AstartesCategory.SUPPRESSOR;
        }
        if (category.equals("TERMINATOR")){
            this.category = AstartesCategory.TERMINATOR;
        }
        if (category.equals("LIBRARIAN")){
            this.category = AstartesCategory.LIBRARIAN;
        }
        if (category.equals("APOTHECARY")){
            this.category = AstartesCategory.APOTHECARY;
        }
    }

    /**
     * Method sets category of the object
     * @param category is AstartesCategory
     */
    public void setCategory(AstartesCategory category){
        this.category = category;
    }
    /**
     * Method sets chapter of the object
     * @param chapter is String
     */
    public void setChapter(String chapter) {
        int marinesCount = 1;
        String name = chapter;
        if (chapter.contains(".")) {
            name = chapter.substring(0, chapter.indexOf("."));
            try {
                marinesCount = Integer.parseInt(chapter.substring(chapter.indexOf(".") + 2));
            }
            catch(NumberFormatException e){
                System.err.println("Значение MarinesCount представляет собой натуральное число!");
            }
        }
        Chapter chapter1 = new Chapter();
        chapter1.setName(name);
        chapter1.setMarinesCount(marinesCount);
        this.chapter = chapter1;
    }

    /**
     * Method sets chapter of the object
     * @param chapter is Chapter
     */
    public void setChapter(Chapter chapter) {
        this.chapter = chapter;
    }

    /**
     * Method automatically gets id of the object of the collection
     * @return id
     */
    public int getId(){
        return id;
    }
    /**
     * Method gets the specified name of the object
     * @return name
     */
    public String getName(){
        return name;
    }
    /**
     * Method gets coordinates of the object
     * @return coordinates
     */
    public Coordinates getCoordinates(){
        return coordinates;
    }
    /**
     * Method gets the date of creation of the file
     * @return creationDate
     */
    public java.util.Date getCreationDate(){
        return creationDate;
    }
    /**
     * Method gets health of the object
     * @return health
     */
    public Long getHealth(){
        return health;
    }
    /**
     * Method gets heartCount of the object
     * @return heartCount
     */
    public int getHeartCount(){
        return heartCount;
    }
    /**
     * Method gets achievements of the object
     * @return achievements
     */
    public String getAchievements(){
        return achievements;
    }
    /**
     * Method gets category of the object
     * @return category
     */
    public AstartesCategory getCategory(){
        return category;
    }
    /**
     * Method gets chapter of the object
     * @return chapter
     */
    public Chapter getChapter(){
        return chapter;
    }

    /**
     * Method gets name of the object as String
     * @return name of the object as String
     */
    @Override
    public String toString(){
        return this.getName() + " " + this.getId();
    }

}