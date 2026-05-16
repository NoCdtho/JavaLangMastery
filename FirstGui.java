import javax.swing.JOptionPane;

public class FirstGui { 
  public static void main(String[] args){
     
	String name = JOptionPane.showInputDialog("Enter name mf: ");
	JOptionPane.showMessageDialog(null,"Hello"+name);

  	int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age: "));
	JOptionPane.showMessageDialog(null, "The age is "+age);

 	double height = Double.parseDouble(JOptionPane.showInputDialog("ENter height: "));
	JOptionPane.showMessageDialog(null, "mfs height is:  ");
    }
}
 