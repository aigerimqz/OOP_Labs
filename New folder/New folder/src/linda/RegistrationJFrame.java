package linda;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.BorderLayout;
import javax.swing.border.TitledBorder;
import javax.swing.BoxLayout;

public class RegistrationJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtStudentRegistration;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegistrationJFrame frame = new RegistrationJFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public RegistrationJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 739, 549);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 715, 67);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		txtStudentRegistration = new JTextField();
		txtStudentRegistration.setHorizontalAlignment(JTextField.CENTER);
		panel.add(txtStudentRegistration, BorderLayout.CENTER);
		txtStudentRegistration.setFont(new Font("Montserrat", Font.BOLD, 24));
		txtStudentRegistration.setText("Student Registration");
		txtStudentRegistration.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(36, 153, 313, 248);
		contentPane.add(panel_1);
	}
}
