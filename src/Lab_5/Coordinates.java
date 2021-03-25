package Lab_5;

/**
 * Class is location of the element
 * @author Ann
 */
public class Coordinates {
    private double x; //Максимальное значение поля: 955
    private int y;

    /**
     * Method sets coordinate "X" of the element
     * @param x is coordinate "X"
     */
    public void setX(double x) {
        if (x > 955){
            this.x = 955;
            System.err.println("Координата X не может быть больше 955! X = 955");
        }
        this.x = x;
    }

    /**
     * Method sets coordinate "Y" of the element
     * @param y is coordinate "Y"
     */
    public void setY(int y){
        this.y = y;
    }

    /**
     * Method returns coordinate "X"
     * @return coordinate "X" (float)
     */
    public double getX(){
        return x;
    }

    /**
     * Method returns coordinate "Y"
     * @return coordinate "Y" (int)
     */
    public int getY(){
        return y;
    }

    /**
     * Method return coordinates as String
     * @return the String
     */
    @Override
    public String toString(){
        return this.getX() + " " + this.getY();
    }
}
