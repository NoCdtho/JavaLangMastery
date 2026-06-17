/* Here: the topics are covered here are:;
    1. file class

    2. type checking:
    This is nothing just conversion of datatype for a value.
    3. static keyword:
    assigning a variable, method, class makes them accessible by all the object of that class.
    4. enums:
    are classes that are used to store multiple constants.
 */

public class topics3 {
    public static void main(String[] main){
        typeChecking t = new typeChecking(0, "12", 12.98);
        t.String_int();
        t.double_int();
        t.int_String();
        t.int_double();

        System.out.println("num. of moon before assigning to any planner: " + Solar.Moon);
        System.out.println("Number of Sun same for all in our solar: " + Solar.Sun);
        new Solar.earth();
        System.out.println("For earth " + Solar.Moon);
        new Solar.mars();
        System.out.println("For mars " + Solar.Moon);

        // Enum
        Level level = Level.high;
        System.out.println(level);
        String val = level.write();
        System.out.println(val);

        for (Level level2 :Level.values()){
            String newValue = level2.write();
            System.out.println(newValue);
        } 
    }    
}

class typeChecking{
    int i;
    String k;
    double l;
    typeChecking(int i, String k, double l){
        this.i = i;
        this.k = k;
        this.l = l;
    }
    // Convert int in to double'
    void int_double(){
        double ans = i;
        System.out.println("converted from int: "+ i + "to double : " + ans);
    }
    // Convert double into int
    void double_int(){
        int ans = (int) l;
        System.out.println("converted from double: "+ l + "to int : " + ans);
    }
    // Convert int into String
    void int_String(){
        String ans = String.valueOf(k);
        System.out.println("converted from int: "+ i + "to int : " + ans);
    }
    // Convert Sting into int
    void String_int(){
        int ans = Integer.parseInt(k);
        System.out.println("converted from String: "+ k + "to int : " + ans);
    }
} 

/* create static variable 
    create inner class 
    create static method 
    Note: when we make a static block then the attributes only belongs to the outer class members 
*/
class Solar{
    static int Moon;
    static int Sun = 1;
    Solar(){

    }
    static class earth{
        int Moon;
        earth(){
            Solar.Moon = 1; 
        }
    }
    static class mars{
        mars(){
            Solar.Moon = 2;
        }
    }
}


// Create a enum write a block with local varible and method 
 enum Level{
    high("highest point"), medium("average points"), low("below Average");

    private final String description;
    Level(String des){
        this.description = des;
    };
    String write(){
        return description;
    }
} 