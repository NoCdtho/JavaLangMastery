/*Topics covered here:
    1. Encapsulation (use of getter and setter functions):
    --> The attributes of the class are made private and can only be accessed via getter or setter func's
    2. Copy objects in java:
    --> One we can do that by creating a copy method or new constructor of the same class that use the copy method.
    3. Polymorphism:
    --> ability of an object to identify as more then one type
*/

public class topics2 {
    public static void main(String args[]){
        Car car = new Car("BMW", "i200", "Red");
        Car car2 = new Car("Audi", "x40" ,"Silver");

    /* Never do this car=car2 this changes the memory pointer of car to point to memory 
    address of car2 
    */
        // This prints the address of those objects in memory
        System.out.println(car);
        System.out.println(car2);
        
        System.out.println("Below is result of the getter fun callod car: ");
        System.out.println(car.getmake()); 
        System.out.println(car.getcolor());   
        System.out.println(car.getmodel());
        
        System.out.println("Below is result of the setter fun call of car: ");
        System.out.println(car.setmodel("wagenor"));
    
        System.out.println("Below are the getter of car2");
        System.out.println(car2.getmake()); 
        System.out.println(car2.getcolor());   
        System.out.println(car2.getmodel());

        // after copy the values of car2 object the address of the car should remain same.
        car.copy(car2);
        System.out.println("Below are the getter of car2 after copy");
        System.out.println(car);
        System.out.println(car.getcolor());
        System.out.println(car.getmodel());
        System.out.println(car.getmake());

        // Another way to copy objects using constructor.
        Car car3 = new Car(car);
        System.out.println(car3);
        System.out.println(car3.getcolor());
        System.out.println(car3.getmodel());
        System.out.println(car3.getmake());
    }
}

// This class is used for understanding of moving objects
class Car{
    private String make;
    private String model;
    private String color;

    Car(String make,String model ,String color){
        this.make=make;
        this.model=model;
        this.color=color;
    }

    // declared a new constructor for copying objects
    Car(Car x){
        this.copy(x);
    }

    // Below methods are  getter 
    String getmake(){
        return make;
    }
    String getmodel(){
        return model;
    }
    String getcolor(){
        return color;
    }

    // Below methods are setter and this methods assigns the attributes of the class objects
    String setmake(String make){
        return this.make = make; 
    } 
    String setcolor(String color){
        return this.color = color; 
    }
    String setmodel(String model){
        return this.model = model; 
    } 

    // Creating the copy method:
    /* This function should take the values of the passed object and return it in the current object*/
    void copy(Car x){
        this.setcolor(x.getcolor());
        this.setmake(x.getmake());
        this.setmodel(x.getmodel());
    }

}


