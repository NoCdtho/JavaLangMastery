/* Here: the topics are covered here are:;
    1. file class
    2. type checking:
    This is nothing just conversion of datatype for a value
 */

public class topics3 {
    public static void main(String[] main){
        typeChecking t = new typeChecking(0, "12", 12.98);
        t.String_int();
        t.double_int();
        t.int_String();
        t.int_double();
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