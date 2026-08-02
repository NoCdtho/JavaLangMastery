import javax.swing.JOptionPane;

public class FirstGui { 
  public static void main(String[] args){
		String name = JOptionPane.showInputDialog("Enter name: ");
		JOptionPane.showMessageDialog(null,"Hello "+ name);

  		int year = Integer.parseInt(JOptionPane.showInputDialog("Enter your DOY: "));
		int age = 2026 - year;
		JOptionPane.showMessageDialog(null, "Your  age is "+ age);

 		double height = Double.parseDouble(JOptionPane.showInputDialog("Enter height: "));
		JOptionPane.showMessageDialog(null, "your height is:  "+ height);
    }
}
 