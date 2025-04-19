package linda;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.ScrollPane;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.event.ActionListener;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.SystemColor;
import javax.swing.UIManager;
import java.awt.Color;

public class RegJFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JPanel panel_1;
	private JTextField txtName;
	private JTextField txtMobile;
	private JTextField txtCourse;
	private JTable table;

	Connection con1;
	PreparedStatement insert;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RegJFrame frame = new RegJFrame();
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
	public RegJFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 910, 596);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.inactiveCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(SystemColor.inactiveCaption);
		panel.setBounds(10, 10, 876, 81);
		contentPane.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		
				JLabel lblNewLabel_3 = new JLabel("Student Registration");
				lblNewLabel_3.setBackground(SystemColor.inactiveCaption);
				panel.add(lblNewLabel_3, BorderLayout.CENTER);
				lblNewLabel_3.setHorizontalAlignment(JLabel.CENTER);
				lblNewLabel_3.setFont(new Font("Montserrat", Font.BOLD, 36));

		panel_1 = new JPanel();
		panel_1.setBackground(new Color(250, 240, 230));
		panel_1.setBounds(30, 152, 415, 269);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("Student Name");
		lblNewLabel.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblNewLabel.setBounds(47, 46, 105, 16);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Mobile");
		lblNewLabel_1.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblNewLabel_1.setBounds(47, 82, 45, 13);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Course");
		lblNewLabel_2.setFont(new Font("Montserrat", Font.BOLD, 12));
		lblNewLabel_2.setBounds(47, 118, 45, 13);
		panel_1.add(lblNewLabel_2);

		txtName = new JTextField();
		txtName.setBounds(162, 46, 153, 19);
		panel_1.add(txtName);
		txtName.setColumns(10);

		txtMobile = new JTextField();
		txtMobile.setBounds(162, 80, 153, 19);
		panel_1.add(txtMobile);
		txtMobile.setColumns(10);

		txtCourse = new JTextField();
		txtCourse.setBounds(162, 116, 153, 19);
		panel_1.add(txtCourse);
		txtCourse.setColumns(10);

		JButton btnDelete = new JButton("Delete");
		btnDelete.setBackground(new Color(221, 160, 221));
		btnDelete.setFont(new Font("Montserrat", Font.PLAIN, 10));
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				DefaultTableModel Df = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();
				try {
					int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
					int dialogResult = JOptionPane.showConfirmDialog(null, "Do you want to Delete the Record?",
							"Warning", JOptionPane.YES_NO_OPTION);
					if (dialogResult == JOptionPane.YES_OPTION) {

						Class.forName("com.mysql.cj.jdbc.Driver");
						con1 = DriverManager.getConnection("jdbc:mysql://localhost/linda", "root", "");
						insert = con1.prepareStatement("delete from Users where id=?");

						insert.setInt(1, id);
						insert.executeUpdate();

						JOptionPane.showMessageDialog(RegJFrame.this, "Record deleted");
						table_update();

						txtName.setText("");
						txtMobile.setText("");
						txtCourse.setText("");
						txtName.requestFocus();
					}

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException sq) {
					// TODO Auto-generated catch block
					sq.printStackTrace();
				}

			}
		});
		btnDelete.setBounds(318, 226, 76, 21);
		panel_1.add(btnDelete);

		JButton btnEdit = new JButton("Edit");
		btnEdit.setBackground(new Color(221, 160, 221));
		btnEdit.setFont(new Font("Montserrat", Font.PLAIN, 10));
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DefaultTableModel Df = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();

				try {
					int id = Integer.parseInt(Df.getValueAt(selectedIndex, 0).toString());
					String name = txtName.getText();
					String mobile = txtMobile.getText();
					String course = txtCourse.getText();

					Class.forName("com.mysql.cj.jdbc.Driver");
					con1 = DriverManager.getConnection("jdbc:mysql://localhost/linda", "root", "");
					insert = con1.prepareStatement("update Users set name=?, mobile=?, course=? where id=?");
					insert.setString(1, name);
					insert.setString(2, mobile);
					insert.setString(3, course);
					insert.setInt(4, id);
					insert.executeUpdate();

					JOptionPane.showMessageDialog(RegJFrame.this, "Record updated");
					table_update();

					txtName.setText("");
					txtMobile.setText("");
					txtCourse.setText("");
					txtName.requestFocus();

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException sq) {
					// TODO Auto-generated catch block
					sq.printStackTrace();
				}

			}
		});
		btnEdit.setBounds(250, 226, 60, 21);
		panel_1.add(btnEdit);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(221, 160, 221));
		btnAdd.setFont(new Font("Montserrat", Font.PLAIN, 10));
		btnAdd.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String name = txtName.getText();
				String mobile = txtMobile.getText();
				String course = txtCourse.getText();

				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					con1 = DriverManager.getConnection("jdbc:mysql://localhost/linda", "root", "");
					insert = con1.prepareStatement("insert into Users(name, mobile, course) values (?, ?, ?)");
					insert.setString(1, name);
					insert.setString(2, mobile);
					insert.setString(3, course);
					insert.executeUpdate();

					JOptionPane.showMessageDialog(RegJFrame.this, "Record added");
					table_update();

					txtName.setText("");
					txtMobile.setText("");
					txtCourse.setText("");
					txtName.requestFocus();

				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException sq) {
					// TODO Auto-generated catch block
					sq.printStackTrace();
				}

			}
		});
		btnAdd.setBounds(180, 226, 60, 21);
		panel_1.add(btnAdd);

		table = new JTable();

		table.setModel(new DefaultTableModel(new Object[][] {

		}, new String[] { "ID", "Name", "Mobile", "Course" }) {
			Class[] columnTypes = new Class[] { Integer.class, String.class, Integer.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});

		JScrollPane scrollPane = new JScrollPane(table);
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DefaultTableModel Df = (DefaultTableModel) table.getModel();
				int selectedIndex = table.getSelectedRow();

				txtName.setText(Df.getValueAt(selectedIndex, 1).toString());
				txtMobile.setText(Df.getValueAt(selectedIndex, 2).toString());
				txtCourse.setText(Df.getValueAt(selectedIndex, 3).toString());

			}
		});
		scrollPane.setBounds(468, 152, 418, 354);
		contentPane.add(scrollPane);

		table_update();
	}

	private void table_update() {
		int C;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con1 = DriverManager.getConnection("jdbc:mysql://localhost/linda", "root", "");
			insert = con1.prepareStatement("select * from Users");
			ResultSet rs = insert.executeQuery();
			ResultSetMetaData Rss = rs.getMetaData();
			C = Rss.getColumnCount();
			DefaultTableModel Df = (DefaultTableModel) table.getModel();

			Df.setRowCount(0);

			while (rs.next()) {
				Vector v2 = new Vector();

				for (int a = 1; a <= C; a++) {
					v2.add(rs.getString("id"));
					v2.add(rs.getString("name"));
					v2.add(rs.getString("mobile"));
					v2.add(rs.getString("course"));

				}
				Df.addRow(v2);
			}

		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException sq) {
			// TODO Auto-generated catch block
			sq.printStackTrace();
		}

	}
}
