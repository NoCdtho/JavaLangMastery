/*Topics in this file are:
    inheritence, abstaction, super, toString()
*/

public class topics1 {
    public static void main(String[] args){

        Bike bike = new Bike();
        bike.go();

        Hero hero = new Hero("SpiderMan", 19, "spideySense & super Strength");
        System.out.println(hero);         

        Car car1 = new Car("BMW");
        Car car2 = new Car("TESLA");

        Garage gar = new Garage();
        gar.park(car1.car);
        gar.park(car2.car);
        
        // System.out.println(car.toString());

        Food food1 = new Food("apple");
        Food food2 = new Food("pizza");
        Food food3 = new Food("corn");

        Food[] refrigerator = new Food[4];

        refrigerator[0] = food1;
        refrigerator[1] = food2;
        refrigerator[2] = food3;
        refrigerator[3] =  food3; 

        System.out.println(refrigerator[0].name);
        System.out.println(refrigerator[1].name);
        System.out.println(refrigerator[2].name);
        System.out.println(refrigerator[3].name);
    }
}

// overriding the toString method to convert the confusing reference of object into readable format.
// Learn object passing using class garage and Main class 
class Car{
    String model = "Ford";
    String color = "red"; 
    String car;
    
    Car(String carr){
        this.car = carr;
    }
    // Overring the tostring method that the object can access the attributes
    public String toString(){
        return model+"\n"+color;
    }
}

// used to class for object passing from Main class  
class Garage{
    void park(String car){
        System.out.println("The "+ car + " is parked in the garage");
    }
}

// Created array of objects used this class as an array
class Food{
    String name;
    Food(String name) {
        this.name=name;
    }
}

/* The person class and hero class both are used for toString and Super keyword */
class Person{
    String name;
    int age;

    Person(String name, int age){
        this.name = name;
        this.age = age;
    }
    
    public String toString(){
        return name+"\n"+age;
    }
}

class Hero extends Person{
    String power;

    Hero(String name, int age, String power){
        super(name, age);
        this.power = power;
    }
    public String toString(){
        return super.toString()+"\n"+power;
    }
}

/* 
    abstract class cannot be instantiated and the methods don't contain body.
    provides security to the class since no object cannot be created of the class.
    Below class are used to abstraction
*/

abstract class vehicle{
    abstract void go();
} 
class Bike extends vehicle{
    void go(){
        System.out.println("He his riding his bike");
    }
}