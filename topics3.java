/* Here: the topics are covered here are:;
    1. file class

    2. type checking:
    This is nothing just conversion of datatype for a value.

    3. static keyword:
    assigning a variable, method, class makes them accessible by all the object of that class.

    4. enums:
    are classes that are used to store multiple constants.

    5. interface:
    they are like classes but they don't have any implementation of the methods, they only contain signatures and fields.
    
    6.java records:
    this is special class that defines immutable data-only. The java records consists one or more fields which acts as member/instance 
    variables in a regular java class. And we don't have to write the boilerplate code to access them.

    7. instance initializer block and static block:
    this is block is excuted at the time of object creation and will be executed evrytime a new object is created.
    and the static block will execute at the time class loading.

    8. exception handling:
    3 types of error might occur one at compile time, runtime and other like (out of memory). There are many ways to handle using NullPointer Exception, IOException and many more    
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
        // use of .valuesof()
        Level obj2 = Level.valueOf("high");
        System.out.println("Use of valuesOf func: " + obj2);
        Level level = Level.high;
        System.out.println(level);
        String val = level.write();
        System.out.println(val);

        // Use of .values build-in method return the current constant.
        for (Level level2 :Level.values()){
            String newValue = level2.write();
            System.out.println(newValue);
        } 

        // Interface
        firstinterface obj = new useInterface();
        System.out.println(obj.sayhello());

        // Java records
        Singer singer = new Singer("RAPPER","twentyThree");
        Singer singer2 = new Singer("SLOW");

        System.out.println("Printing the normal values of the recodes....");
        System.out.println("First singer type: " + singer.type() +" and age: "+ singer.age());
        System.out.println("second singer type: " + singer2.type() +" and age: No age mentioned"); 
        System.out.println("Type of singer 2 changed from: " + singer2.type()+ " to: " + singer2.inSmallLetter());
        System.out.println("Nd age of singer 1 change from " + singer.age() + " to " + Singer.toLargeLetter(singer));

        // intance initialzier block and static block
        blocktest obj3 = new blocktest();
        System.out.println(obj3); 

        // Static binding and dynamic binding
        AnimalActivity animal = new AnimalActivity();
        animal.makeNoise(1);
        animal.makeNoise();

        AnimalActivity animal2 = new Dog();
        animal2.makeNoise();

        // passing values in argument as primitive and objects
        primitivesUnitTest test = new  primitivesUnitTest();
        test.passingAsValues();
        nonprimitiveTest test2 = new  nonprimitiveTest();
        test2.passingAsObject();

        // Exception hanlding
        ExceptionTest tt = new ExceptionTest();
        tt.test();
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

// Create a interface
interface firstinterface{
    public String myinterfaceValue = "Hello";
    public String sayhello();
}

// create a class to use the interface
class useInterface implements firstinterface{

    @Override
    public String sayhello(){
        return myinterfaceValue;
    }
}

// Con Java records
 record Singer(String type, String age){
    // records can have multiple constructors
    Singer(String type){
        this(type, null);
    }
    //  methods 
    String inSmallLetter(){
        return type().toLowerCase();
    } 
    // static method
    static String toLargeLetter(Singer singer ){
        return singer.age.toUpperCase();
    }
}

// Instance initializer block
class blocktest{
    static{
        System.out.println("This is the static initilizer blck 1 ");

    }
    {
        System.out.println("hgelloe");
        System.out.println("acai");
    }
    public String toString(){
        return "converted the address of the blocktest object into this printed string";
    }
}

// static vs dynamic binding
// Below method overloading will be done at compile time thus it is static binding 
class AnimalActivity{
   void makeNoise(){
    System.out.println("makiing sometihng but dontknow");
   }
   void makeNoise(int repetation){
    while(repetation != 0){
        System.out.println("noise repetation " + repetation);
        repetation--;
    }
   }
}
// Below method override will be resolved at runtime thus it is dynamic binding  
class Dog extends AnimalActivity{
    void makeNoise(){
        System.out.println("Woof Woof");
    }
}

// Passing of data as object and primitive type
class primitivesUnitTest{
    public void passingAsValues(){
        int x = 10;
        int y = 20;
        System.out.println("They are the values of x and y " + x + " " + y);
        modify(x, y);
        System.out.println("The values of x and y are: " + x + " " + y);
    }
    static void modify(int x1 , int x2){
            x1++;
            x2++;
    }
}

class nonprimitiveTest{
    int x;
    nonprimitiveTest(){
    }
    nonprimitiveTest(int x){
        this.x = x;
    }
    public void passingAsObject(){
        nonprimitiveTest val = new nonprimitiveTest(1);
        nonprimitiveTest val2 = new nonprimitiveTest(12);
        System.out.println("value of x inside 2 objects before modify function call: " + val.x + " and " + val2.x);
        modifyobject(val, val2);
        System.out.println("value of x inside 2 objects after modify call: " + val.x + " and " +val2.x);
    }
    static void modifyobject(nonprimitiveTest t1, nonprimitiveTest t2){
            t1.x++;
            t2.x++;
    }
}

// Exception handling
class ExceptionTest{
    void test(){
        try{
            int num = converttonumber("4");
            System.out.println("wanted to show something: " + num);
        }
        catch(Exception e){
            System.out.println("What rar u saying");
        } 
        finally{
            System.out.println("Exception is being tested reached final block");
        }
    }
    int converttonumber(String i){
        return Integer.parseInt(i);
    }
   
}