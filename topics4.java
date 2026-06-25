/* Topics:
1. lamda expression: 
This is used as functionl programming. It is used to implement in the place of unimplemented of a object (for interfaces). 
This can written in place of both constructor and refence variable.

2.annotation:
This are used to give the give meta data of the source code
mainly there are 4: @Deprecated, @override, @suppressWarnings, @Contended 
I can create my own annotations also I will code only that.

3.module:
This is way of creating packages in java.

4.optional:
This are container objects that may or may not contain non-null values.
This are used to represent the absence of value.
This provide methods to check if a value is present or not and to handle cases where value is not present in more controlled manner
*/

import java.util.Optional;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

public class topics4 {
    public static void main(String[] args ){
            
        // instance of stateOwner is created and passed the implementation of interface as arguments instead of another reference variable of stateChangeListener
        stateOwner obj = new stateOwner();
        obj.addStateListener(new stateChangeListener(){
            public void onStateChange(){
                System.out.println("creating the object and passing the arg as anonymous interface");
            }
        });
        
        // we use lamda expression instead of anonymouse inheritance implementaion.
        obj.addStateListener(
            () -> {System.out.println("Using the lamda function overwritting the abstract method again of the interface");}
        );

        // creating the instance of the interface using lamda
        stateChangeListener obj2 = () -> {
            System.out.println("This is what is it");
        };
        obj2.onStateChange();

        optionalTest optt = new optionalTest();
        optt.checkOptional();
    }
}


     // THis interface will be used to pass new and old state below.
    interface stateChangeListener{
        public void onStateChange();
    }

    //  pass the state in which the changes will be made also called listener, this is the state event listener.
    class stateOwner{
    void addStateListener(stateChangeListener var){
        System.out.println("State is passed in the Listener");
            var.onStateChange();
        }
    }


// Annotation
@Retention(RetentionPolicy.CLASS) //This is the default retention annotation behaviour and there 2 more .RUNTIME and .SOURCE
@Target({ElementType.TYPE}) //This is a default behaviour of Target annotation which is used to define where the annotation should be used.
@Inherited //This is used to define that the subclasses of the superclass that is annotated by the below annotation can are annoted as well. 
@Documented //This makes the classes that are annotated by this annotation are visible to the JAVADOC tool.
@interface myAnnotation{
    String name();
    int age();
    String[] Workedbefore();
    String colleage() default "James";
}
// Below classes is annoted by the annotation I created
@myAnnotation(name = "martin", age = 18, Workedbefore = "producer")
class useMyAnnotaion{

}

// Optionals
class optionalTest{
    String name = "Samueal";
    // used .of() method 
    Optional<String> opt = Optional.of(name);
    Boolean v1 = opt.isPresent();

    // use of .empty() method
    String nullname = null;
    Optional<String> opt2 = Optional.empty();
    Boolean v2 = opt2.isPresent();

    // use of .ofNullable(variableName)
    Optional<String> opt3 = Optional.ofNullable(nullname);
    Boolean v3 = opt3.isPresent();

    Optional<String> opt4 = Optional.of("Martin");

    // use of .orElse(): this is used if the created optional has null value if it has then .orEles will be executed.
    String newName =  Optional.ofNullable(nullname).orElse("maachou");

    // flaw of .orElse()
    String getDefault(){
        System.out.println("getDefault method is called");
        return "flawed statement";
    }

    String cooked = Optional.ofNullable(name).orElse(getDefault()); // here the getDefault is called and a redundant or unused object is returned.
    String cookedAgain = Optional.ofNullable(name).orElseGet(this::getDefault);//tried to find the redunctant object creation here also.

    // use of .orElseGet(): this is similar as orELse() but instead of taking the optional value to return it takes supplier functional interface. 
    String result = Optional.ofNullable(nullname).orElseGet(() -> "mathew");


    // used this function to run the executables 
    void checkOptional(){
        System.out.println(v1);
        System.out.println(v2);
        System.out.println(v3);

        // use of .ifPresent() method 
        opt4.ifPresent((name) -> System.out.println(name.length()));

        System.out.println(newName);
        System.out.println(result);
        System.out.println(cooked);

        // Exception with orElseThrow()
        String nullname = "null";
        String e = Optional.ofNullable(nullname).orElseThrow(
            IllegalArgumentException::new
        );
        System.out.println(e);
    }
}