package loginpage;

import java.awt.Color;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class HomePage {
	JFrame frame = new JFrame();
	JLabel welcomeLabel = new JLabel("Hello!");
	Font myBigFont = new Font("Montserrat", Font.BOLD, 24);
	Color bgColor = new Color(255, 228, 225);
	Color textColor = new Color(48, 48, 48);
	JLabel homeLabel = new JLabel("Home");
	JLabel newsLabel = new JLabel("News");
	JLabel blogLabel = new JLabel("Blog");
	
	HomePage(){
		frame.getContentPane().setBackground(bgColor);
		welcomeLabel.setBounds(120, 100, 250, 35);
		welcomeLabel.setFont(myBigFont);
		welcomeLabel.setText("Welcome!");
		
		homeLabel.setBounds(150, 170, 200, 35);
		homeLabel.setFont(myBigFont);
		homeLabel.setForeground(textColor);
		
		homeLabel.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        homeLabel.setForeground(new Color(151,153,186));
		       
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        homeLabel.setForeground(textColor);
		    }
		});
		
		newsLabel.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        newsLabel.setForeground(new Color(151,153,186));
		       
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        newsLabel.setForeground(textColor);
		    }
		});
		
		blogLabel.addMouseListener(new java.awt.event.MouseAdapter() {
		    public void mouseEntered(java.awt.event.MouseEvent evt) {
		        blogLabel.setForeground(new Color(151,153,186));
		       
		    }
		    public void mouseExited(java.awt.event.MouseEvent evt) {
		        blogLabel.setForeground(textColor);
		    }
		});
		
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
