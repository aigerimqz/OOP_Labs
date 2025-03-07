import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomePage {
	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("Hello!");
	Font myBigFont = new Font("Montserrat", Font.BOLD, 24);
	Color bgColor = new Color(255, 228, 225);
	Color textColor = new Color(48, 48, 48);
	JLabel homeLabel = new JLabel("Home");
	JLabel newsLabel = new JLabel("News");
	JLabel blogLabel = new JLabel("Blog");
	
	WelcomePage(String userID){
		frame.getContentPane().setBackground(bgColor);
		welcomeLabel.setBounds(70, 100, 250, 35);
		welcomeLabel.setFont(myBigFont);
		welcomeLabel.setText("Welcome, " + userID + "!");
		
		homeLabel.setBounds(150, 170, 200, 35);
		homeLabel.setFont(myBigFont);
		homeLabel.setForeground(textColor);
		
		newsLabel.setBounds(152, 210, 200, 35);
		newsLabel.setFont(myBigFont);
		newsLabel.setForeground(textColor);
		
		blogLabel.setBounds(158, 250, 200, 35);
		blogLabel.setFont(myBigFont);
		blogLabel.setForeground(textColor);
		
		frame.add(welcomeLabel);
		frame.add(homeLabel);
		frame.add(newsLabel);
		frame.add(blogLabel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(420, 420);
		frame.setLayout(null);
		frame.setVisible(true);
	}

}
