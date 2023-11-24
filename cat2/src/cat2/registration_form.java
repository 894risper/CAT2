package cat2;

import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class registration_form {

	private JFrame frame;
	private JTextField name;
	private JTextField username;
	private JTextField password;
	private JTextField confirmpass;
	private JTextField email;
	private JTextField phone;
	private JTextField address;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					registration_form window = new registration_form();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public registration_form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 329);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 21, 72, 14);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblUsername.setBounds(10, 50, 83, 14);
		frame.getContentPane().add(lblUsername);
		
		JLabel lblAddress_1 = new JLabel("Address:");
		lblAddress_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAddress_1.setBounds(10, 210, 72, 22);
		frame.getContentPane().add(lblAddress_1);
		
		JLabel lblPhone_1 = new JLabel("Phone:");
		lblPhone_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPhone_1.setBounds(10, 179, 88, 14);
		frame.getContentPane().add(lblPhone_1);
		
		JLabel lblEmail_1 = new JLabel("Email:");
		lblEmail_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblEmail_1.setBounds(10, 139, 46, 14);
		frame.getContentPane().add(lblEmail_1);
		
		JLabel lblConfirmPassword_1 = new JLabel("confirm Password:");
		lblConfirmPassword_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblConfirmPassword_1.setBounds(10, 106, 129, 22);
		frame.getContentPane().add(lblConfirmPassword_1);
		
		JLabel lblNewLabel_1 = new JLabel("Password:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 81, 102, 14);
		frame.getContentPane().add(lblNewLabel_1);
		
		name = new JTextField();
		name.setBounds(151, 19, 136, 20);
		frame.getContentPane().add(name);
		name.setColumns(10);
		
		username = new JTextField();
		username.setColumns(10);
		username.setBounds(151, 49, 136, 20);
		frame.getContentPane().add(username);
		
		password = new JTextField();
		password.setColumns(10);
		password.setBounds(151, 80, 136, 20);
		frame.getContentPane().add(password);
		
		confirmpass = new JTextField();
		confirmpass.setColumns(10);
		confirmpass.setBounds(151, 109, 136, 20);
		frame.getContentPane().add(confirmpass);
		
		email = new JTextField();
		email.setColumns(10);
		email.setBounds(151, 138, 136, 20);
		frame.getContentPane().add(email);
		
		phone = new JTextField();
		phone.setColumns(10);
		phone.setBounds(151, 169, 136, 24);
		frame.getContentPane().add(phone);
		
		address = new JTextField();
		address.setColumns(10);
		address.setBounds(151, 213, 136, 20);
		frame.getContentPane().add(address);
		
		JButton btnNewButton = new JButton("Submit");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
                    // Move the database connection code inside the ActionListener
                    Class.forName("com.mysql.cj.jdbc.Driver");
                    Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cat2", "root", "risper/atieno200314246");

                    String sql = "INSERT INTO REGISTRATION(Name, Username, Password,confirm_Password,Email,Phone,Address) VALUES(?,?,?,?,?,?,?)";
                    PreparedStatement pr = con.prepareStatement(sql);
                    pr.setString(1, name.getText());
                    pr.setString(2, username.getText());
                    pr.setString(3, password.getText());
                    pr.setString(4, confirmpass.getText());
                    pr.setString(5, email.getText());
                    pr.setString(6, phone.getText());
                    pr.setString(7, address.getText());
                    int count = pr.executeUpdate();
                    if (count == 1) {
                        JOptionPane.showMessageDialog(null, "Record added successfully");
                        name.setText("");
                        username.setText("");
                        password.setText("");
                        confirmpass.setText("");
                        email.setText("");
                        phone.setText("");
                        address.setText("");
  
                        
                        
                      con.close();
                    } else {
                        JOptionPane.showMessageDialog(null, "Record not added");
                        con.close();
                    }
                } catch (Exception er) {
                    er.printStackTrace();
                }

				
		
				
				
				
			}
		});
		btnNewButton.setBounds(9, 256, 89, 23);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Reset");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText("");
                username.setText("");
                password.setText("");
                confirmpass.setText("");
                email.setText("");
                phone.setText("");
                address.setText("");

			}
		});
		btnNewButton_1.setBounds(159, 258, 89, 23);
		frame.getContentPane().add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Close");
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton_2.setBounds(335, 258, 89, 23);
		frame.getContentPane().add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Close the application
                frame.dispose();
                System.exit(0);
            }
        });
	}
}
