/**
 * Created with IntelliJ IDEA.
 * User: Steven Kitzes
 * Date: 7/9/13
 * Time: 10:00 AM
 * To change this template use File | Settings | File Templates.
 */
public class Sortable {
    private int value;

    //  Constructor with no params creates Sortable with a randomized value.
    public Sortable() {
        value = (int)(Math.random() * 100) + 1;
        System.out.println("Sortable object created with value: " + value);
    }
    //  Constructor with int param creates Sortable with preset value (with error checking)
    public Sortable(int _value) {
        if(_value < 1 || _value > 100) {
            System.out.println("Error: invalid value passed to Sortable ctor.");
            System.out.print("Generating a new value in the acceptable range: ");
            value = (int)(Math.random() * 100) + 1;
            System.out.println(value);
        }
        else {
            value = _value;
            System.out.println("Sortable object created with passed-in value: " + value);
        }
    }

    //  Check if this Sortable's value equals that of another
    public boolean equals(Sortable that) {
        return (this.value == that.value);
    }
    //  Return the value of this Sortable as a String
    public String toString() {
        return Integer.toString(value);
    }

    //  Return the value of this Sortable as an int
    public int getValue() {
        return value;
    }
}
