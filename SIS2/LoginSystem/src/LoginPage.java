import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

public class LoginPage implements ActionListener{
	JFrame frame = new JFrame();
	JButton loginButton = new JButton("Login");
	JButton resetButton = new JButton("Reset");
	JTextField userIDField = new JTextField();
	JPasswordField userPasswordField = new JPasswordField();
	JLabel titleLabel = new JLabel("Login");
	JLabel userIDLabel = new JLabel("userID:");
	JLabel userPasswordLabel = new JLabel("password:");
	JLabel messageLabel = new JLabel();
	JLabel lineLabel1 = new JLabel("_______________________");
	JLabel lineLabel2 = new JLabel("_______________________");
	JLabel[] allLabels = new JLabel[6];
	JTextField[] allFields = new JTextField[2];
	JButton[] allButtons = new JButton[2];
	HashMap<String, String> logininfo = new HashMap<String, String>();
	Font myFont = new Font("Montserrat", Font.PLAIN, 16);
	Font myBigFont = new Font("Montserrat", Font.BOLD, 30);
	Color bgColor = new Color(48, 48, 48);
	
	LoginPage(HashMap<String, String> loginInfoOriginal){
		frame.getContentPane().setBackground(bgColor);
		
		allLabels = new JLabel[] {titleLabel, userIDLabel, userPasswordLabel, messageLabel, lineLabel1, lineLabel2};
		allFields = new JTextField[] {userIDField, userPasswordField};
		allButtons = new JButton[] {loginButton, resetButton};
		logininfo = loginInfoOriginal;
		
		titleLabel.setBounds(155, 30, 90, 36);
		titleLabel.setFont(myBigFont);
		userIDLabel.setBounds(110, 100, 75, 25);
		userIDLabel.setFont(myFont);
		userPasswordLabel.setBounds(110, 160, 100, 25);
		userPasswordLabel.setFont(myFont);
		
		messageLabel.setBounds(120, 220, 250, 35);
		messageLabel.setFont(myFont);
		
		userIDField.setBounds(110, 130, 200, 25);
		userPasswordField.setBounds(110, 190, 200, 25);
		
		loginButton.setBounds(155, 270, 100, 25);
		loginButton.setFocusable(false);
		loginButton.addActionListener(this);
		loginButton.setFont(myFont);
		
		resetButton.setBounds(155, 300, 100, 25);
		resetButton.setFocusable(false);
		resetButton.addActionListener(this);
		resetButton.setFont(myFont);
		
		lineLabel1.setBounds(110, 137, 210, 25);
		lineLabel2.setBounds(110, 197, 210, 25);
		
		
		
		for(int i = 0; i < 6; i++) {
			allLabels[i].setFont(myFont);
			allLabels[i].setForeground(Color.WHITE);
			if(allLabels[i] == titleLabel) {
				allLabels[i].setFont(myBigFont);
			}
		}
		
		for(int i = 0; i < 2; i++) {
			allFields[i].setBorder(BorderFactory.createEmptyBorder());
			allFields[i].setBackground(bgColor);
			allFields[i].setForeground(Color.WHITE);
			allFields[i].setFocusable(true);
			allFields[i].setFont(myFont);
		}
		
		for(int i = 0; i < 2; i++) {
			allButtons[i].setFont(new Font("Montserrat", Font.BOLD, 16));
			if(allButtons[i] == loginButton) {
				allButtons[i].setBackground(new Color(160, 219, 142));
			}else {
				allButtons[i].setBackground(new Color(128, 128, 128));
			}
		}
	
		frame.add(titleLabel);
		frame.add(userIDLabel);
		frame.add(userPasswordLabel);
		frame.add(messageLabel);
		frame.add(userIDField);
		frame.add(lineLabel1);
		frame.add(userPasswordField);
		frame.add(lineLabel2);
		frame.add(loginButton);
		frame.add(resetButton);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
		
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == resetButton) {
			userIDField.setText("");
			userPasswordField.setText("");
		}
		
		if(e.getSource() == loginButton) {
			String userID = userIDField.getText();
			String password = String.valueOf(userPasswordField.getPassword());
			
			if(logininfo.containsKey(userID)) {
				if(logininfo.get(userID).equals(password)) {
					messageLabel.setForeground(Color.green);
					messageLabel.setText("Login successful");
					frame.dispose();
					WelcomePage welcomePage = new WelcomePage(userID);
					
				}
				else {
					messageLabel.setForeground(Color.red);
					messageLabel.setText("Wrong password");
				}
			}
			else {
				messageLabel.setForeground(Color.red);
				messageLabel.setText("Username not found");
			}
		}
		
		
	}

}
