public class Main {
    public static void main(String[] args){

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

        Food[] refrigerator = new Food[3];

        refrigerator[0] = food1;
        refrigerator[1] = food2;
        refrigerator[2] = food3;

        // System.out.println(refrigerator[0].name);
        // System.out.println(refrigerator[1].name);
        // System.out.println(refrigerator[2].name);
    }
}

//learn to use toString in class Car and Main class 
// Learn object passing using class garage and Main class 
class Car{
    String model = "Ford";
    String color = "red"; 

    String car;
    Car(String carr){
        this.car = carr;
    }

    public String toString(){
        return model+"\n"+color;
    }
}

// created array of objects used this class as an array
class Food{
    String name;
    Food(String name) {
        this.name=name;
    }
}

// used to class for object passing from Main class  
class Garage{
    void park(String car){
        System.out.println("The "+ car + " is parked in the garage");
    }
}

// used this class for super keyword 
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

// used this class for super keyword
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