package loginpage;

import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.UIDefaults;
import javax.swing.UIManager;

public class Login implements ActionListener{
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
	
	Login(){
		frame.getContentPane().setBackground(bgColor);
		
		allLabels = new JLabel[] {titleLabel, userIDLabel, userPasswordLabel, messageLabel, lineLabel1, lineLabel2};
		allFields = new JTextField[] {userIDField, userPasswordField};
		allButtons = new JButton[] {loginButton, resetButton};
		
		
		titleLabel.setBounds(155, 30, 90, 36);
		titleLabel.setFont(myBigFont);
		userIDLabel.setBounds(110, 100, 75, 25);
		userIDLabel.setFont(myFont);
		userPasswordLabel.setBounds(110, 160, 100, 25);
		userPasswordLabel.setFont(myFont);
		
		messageLabel.setBounds(120, 220, 250, 35);
		messageLabel.setFont(myFont);
		
		userIDField.setBounds(110, 130, 200, 25);
		userIDField.setFocusable(true);
		userPasswordField.setBounds(110, 190, 200, 25);
		userPasswordField.setFocusable(true);
		
		
		
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

	private void btnResetActionPerformed(ActionEvent evt) {
		userIDField.setText("");
		userPasswordField.setText("");
	}
	private void btnLoginActionPerformed(ActionEvent evt) {
		
		String url = "jdbc:postgresql://localhost:5432/mydb"; 
        String user = "postgres"; 
        String pass = "011105"; 
		try {
			Class.forName("org.postgresql.Driver");
			
			
			Connection con = DriverManager.getConnection(url, user, pass);
//			System.out.println("Connected!");
			String username = userIDField.getText();
			String password = userPasswordField.getText();
			
			Statement stm = con.createStatement();
			String sql = "SELECT * FROM login WHERE username = '" + username + "' AND password = '" + password + "'";
 
			ResultSet rs = stm.executeQuery(sql);
			
			if(rs.next()) {
				frame.dispose();
				HomePage hPage = new HomePage();
				
			}else {
				JOptionPane.showMessageDialog(frame, "username or password wrong..");
				userIDField.setText("");
				userPasswordField.setText("");
				
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == resetButton) {
			btnResetActionPerformed(e);
		}
		
		if(e.getSource() == loginButton) {
			btnLoginActionPerformed(e);
		}
		
		
	}

}
