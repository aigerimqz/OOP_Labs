import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.InputStream;


public class Calculator implements ActionListener{
	
	JFrame frame;
	JTextField textfield;
	JButton[] numberButtons = new JButton[10];
	JButton[] functionButtons = new JButton[9];
	JButton addButton, subButton, mulButton, divButton;
	JButton decButton, equButton, delButton, clrButton, negButton;
	JPanel panel;
	JLabel expressionLabel;
	
	
	Color bgColor = new Color(48, 48, 48);
	Font myFont = new Font("Montserrat", Font.BOLD, 30);
	Font myBigFont = new Font("Montserrat", Font.BOLD, 50);
	
	double num1 = 0, num2 = 0, result = 0;
	char operator;
	
	Calculator(){
		
		
		
		frame = new JFrame("Calculator");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 580);
		frame.setLayout(null);
		frame.getContentPane().setBackground(bgColor);
		
		textfield = new JTextField();
		textfield.setBounds(55, 85, 300, 50);
		textfield.setFont(myBigFont);
		textfield.setEditable(false);
		textfield.setBackground(bgColor);
		textfield.setForeground(Color.WHITE);
		textfield.setBorder(BorderFactory.createEmptyBorder());
		
		expressionLabel = new JLabel();
		expressionLabel.setBounds(55, 25, 300, 60);
		expressionLabel.setFont(myFont);
		expressionLabel.setForeground(Color.WHITE);
		expressionLabel.setText("Calculator");
		
		ImageIcon icon = new ImageIcon("src/img/delete.png");
		Image img = icon.getImage().getScaledInstance(36,  36, Image.SCALE_SMOOTH);
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		delButton = new JButton("Delete");
		clrButton = new JButton("C");
		negButton = new JButton("(-)");
		
		delButton.setIcon(new ImageIcon(img));
		delButton.setText("");
		
		functionButtons[0] = addButton;
		functionButtons[1] = subButton;
		functionButtons[2] = mulButton;
		functionButtons[3] = divButton;
		functionButtons[4] = decButton;
		functionButtons[5] = equButton;
		functionButtons[6] = delButton;
		functionButtons[7] = clrButton;
		functionButtons[8] = negButton;
		
		
		for(int i = 0; i < 9; i++) {
			functionButtons[i].addActionListener(this);
			functionButtons[i].setFont(myFont);
			functionButtons[i].setBackground(bgColor);
			functionButtons[i].setFocusable(false);
			functionButtons[i].setForeground(new Color(255, 128, 0));
//			functionButtons[i].setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			functionButtons[i].setBorder(BorderFactory.createEmptyBorder());
		}
		
		for(int i = 0; i < 10; i++) {
			numberButtons[i] = new JButton(String.valueOf(i));
			numberButtons[i].addActionListener(this);
			numberButtons[i].setFont(myFont);
			numberButtons[i].setFocusable(false);
			numberButtons[i].setForeground(Color.WHITE);
			numberButtons[i].setBackground(bgColor);
			numberButtons[i].setBorder(BorderFactory.createEmptyBorder());
		}
		
		negButton.setBounds(50, 460, 100, 50);
		delButton.setBounds(150, 460, 100, 50);
		clrButton.setBounds(250, 460, 100, 50);
		
		panel = new JPanel();
		panel.setBounds(50, 150, 300, 300);
		panel.setLayout(new GridLayout(4, 4, 5, 5));
		panel.setBackground(bgColor);
		
		panel.add(numberButtons[1]);
		panel.add(numberButtons[2]);
		panel.add(numberButtons[3]);
		panel.add(addButton);
		panel.add(numberButtons[4]);
		panel.add(numberButtons[5]);
		panel.add(numberButtons[6]);
		panel.add(subButton);
		panel.add(numberButtons[7]);
		panel.add(numberButtons[8]);
		panel.add(numberButtons[9]);
		panel.add(mulButton);
		panel.add(decButton);
		panel.add(numberButtons[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		
		frame.add(panel);
		frame.add(negButton);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(textfield);
		frame.add(expressionLabel);
		
		
		frame.setVisible(true);
		
		
	}

	public static void main(String[] args) {
		Calculator calculator = new Calculator();
		
		
//		GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
//		String[] fonts = ge.getAvailableFontFamilyNames();
//
//		for (String font : fonts) {
//		    System.out.println(font);
//		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		for(int i = 0; i < 10; i++) {
			if(e.getSource() == numberButtons[i]) {
				textfield.setText(textfield.getText().concat(String.valueOf(i)));
			}
		}
		if(e.getSource() == decButton) {
			textfield.setText(textfield.getText().concat("."));
		}
		if(e.getSource() == addButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '+';
			expressionLabel.setText(num1 + " " + operator);
			textfield.setText("");
		}
		if(e.getSource() == subButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '-';
			expressionLabel.setText(num1 + " " + operator);
			textfield.setText("");
		}
		if(e.getSource() == mulButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '*';
			expressionLabel.setText(num1 + " " + operator);
			textfield.setText("");
		}
		if(e.getSource() == divButton) {
			num1 = Double.parseDouble(textfield.getText());
			operator = '/';
			expressionLabel.setText(num1 + " " + operator);
			textfield.setText("");
		}
		if(e.getSource() == equButton) {
			num2 =Double.parseDouble(textfield.getText());
			switch(operator) {
			case'+':
				result = num1 + num2;
				break;
			case'-':
				result = num1 - num2;
				break;
			case'*':
				result = num1 * num2;
				break;
			case'/':
				result = num1 / num2;
				break;
			}
			textfield.setText(String.valueOf(result));
			expressionLabel.setText(num1 + " " + operator + " " + num2 + " = ");
			num1 = result;
			
		}
		if(e.getSource() == clrButton) {
			textfield.setText("");
			expressionLabel.setText("");
		}
		if(e.getSource() == delButton) {
			String string = textfield.getText();
			textfield.setText("");
			for(int i = 0; i < string.length() - 1; i++) {
				textfield.setText(textfield.getText() + string.charAt(i));
			}
		}
		if(e.getSource() == negButton) {
			double temp = Double.parseDouble(textfield.getText());
			temp*=-1;
			textfield.setText(String.valueOf(temp));
		}
	}

}
