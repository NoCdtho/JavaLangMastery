/* Topics:
1. lamda expression: 
This is used as functionl programming. It is used to implement in the place of unimplemented of a object (for interfaces). 
This can written in place of both constructor and refence variable.

2.annotation:
This are used to give the give meta data of the source code
mainly there are 4: @Deprecated, @override, @suppressWarnings, @Contended 
I can create my own annotations also I will code only that.

*/

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Target;

public class topics4 {
    public static void main(String[] args ){
        // THis interface will be used to pass new and old state below.
        interface stateChangeListener{
            public void onStateChange();
        }

        //  pass the state in which the changes will be made also called listener, this is the state event listener.
        class stateOwner{
            void addStateListener(stateChangeListener var){
                System.out.println("State is passed in the Listener");
                var.onStateChange();
            };
        }
        
        // instance of stateOwner is created and passed the implementation of interface is passed as arguments instead of another reference variable of stateChangeListener
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
    }
};

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

@myAnnotation(name = "martin", age = 18, Workedbefore = "producer")
class useMyAnnotaion{

}