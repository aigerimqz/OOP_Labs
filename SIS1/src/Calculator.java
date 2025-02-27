import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Calculator implements ActionListener{
	
	JFrame frame;
	JTextField textField;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[8];
	JButton addButton, suButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton;
	JPanel panel;
	
	
	
	Font myFont = new Font("Montserrat", Font.BOLD, 30);
	
	
	
	Calculator(){
		
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
