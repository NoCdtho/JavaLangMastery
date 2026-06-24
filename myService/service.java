package myService;
/*
If I make a module-info.java then this will be modular project so each file would have to be in a named package
it cannot be inside a unnamed package
*/

public class service {
 public static void main(String[] args){
    service s = new service();
    String ans = s.action(); 
    System.out.println(ans);    
 }    
 String action(){
    return "First actiopn"; 
 }
}
