import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.SpringLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JEditorPane;
import javax.swing.JScrollPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JMenuBar;
import java.awt.Toolkit;
import javax.swing.SwingConstants;
import java.awt.SystemColor;
import java.awt.Label;
import java.awt.Button;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class prototype extends JFrame {

	private JPanel contentPane;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_17;
	private JTextField textField_19;
	private JTextField textField_21;
	private JTextField textField_38;
	private JTextField textField_39;
	private JTextField textField_40;
	private JTextField textField_41;
	private JTextField textField_42;
	private JTextField textField_43;
	private JTextField textField_44;
	private JTextField textField_45;
	private JTextField textField_54;
	private JTextField textField_55;
	private JTextField textField_56;
	private JTextField textField_57;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_8;
	private JTextField textField_11;
	private JTextField textField_12;
	private JTextField textField_13;
	private JTextField textField_14;
	private JTextField textField_15;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					prototype frame = new prototype();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	private static boolean isUsernameCorrect(String input) {
		boolean isCorrect = true;
		String correctPassword = "IakovosKallis";
		if (input.length() != correctPassword.length()) {
			isCorrect = false;
		} else {
			isCorrect = input.equals(correctPassword);
		}

		return isCorrect;
	}

	private static boolean isPasswordCorrect(String input) {
		boolean isCorrect = true;
		String correctPassword = "121212";
		if (input.length() != correctPassword.length()) {
			isCorrect = false;
		} else {
			isCorrect = input.equals(correctPassword);
		}

		return isCorrect;
	}
	
	private static boolean dbDriverLoaded = false;

	private static Connection conn = null;

	// handling the keyboard inputs through a BufferedReader

	// This variable became global for your convenience.

	private static BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
	private JTable table_1;
	private JTable table;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;

	/**

	* A method that returns a connection to MS SQL server DB

	*

	*

	@return The connection object to be used.

	*/

	private Connection getDBConnection() {

		String dbConnString = "jdbc:sqlserver://apollo.in.cs.ucy.ac.cy:1433;user=meleft04;password=********;";
		if (!dbDriverLoaded)
			try {
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				dbDriverLoaded = true;
			} catch (ClassNotFoundException e) {
				System.out.println("Cannot load DB driver!");
				return null;
			}
		try {
			if (conn == null)
				conn = DriverManager.getConnection(dbConnString);
			else if (conn.isClosed())
				conn = DriverManager.getConnection(dbConnString);
			conn.setHoldability(ResultSet.CLOSE_CURSORS_AT_COMMIT);
		} catch (SQLException e) {
			System.out.print("Cannot connect to the DB!\nGot error: ");
			System.out.print(e.getErrorCode());
			System.out.print("\nSQL State: ");
			System.out.println(e.getSQLState());
			System.out.println(e.getMessage());
		}
		return conn;
	}

	/**
	 * Create the frame.
	 */
	public prototype() {
		String username = null, password = null;
		final JPanel loginpanel = new JPanel();
		final JPanel Wrong = new JPanel();
		final JLabel login = new JLabel("Username:");
		final JTextField field1 = new JTextField(10);
		loginpanel.add(login);
		loginpanel.add(field1);
		final JLabel login2 = new JLabel("Password:");
		loginpanel.add(login2);
		final JTextField field2 = new JTextField(10);
		loginpanel.add(field2);
		final JLabel wrong = new JLabel("Wrong Username or Password:");
		Wrong.add(wrong);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 705, 540);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new CardLayout(0, 0));
		
		JPanel start = new JPanel();
		start.setBackground(new Color(253, 245, 230));
		contentPane.add(start, "name_28240127544978");

		JLabel lblNewLabel_95 = new JLabel("");
		ImageIcon input1 = new ImageIcon(getClass().getResource("logo.png"));
		SpringLayout sl_start = new SpringLayout();
		sl_start.putConstraint(SpringLayout.NORTH, lblNewLabel_95, 0, SpringLayout.NORTH, start);
		sl_start.putConstraint(SpringLayout.WEST, lblNewLabel_95, 99, SpringLayout.WEST, start);
		sl_start.putConstraint(SpringLayout.SOUTH, lblNewLabel_95, -102, SpringLayout.SOUTH, start);
		sl_start.putConstraint(SpringLayout.EAST, lblNewLabel_95, -100, SpringLayout.EAST, start);
		start.setLayout(sl_start);
		lblNewLabel_95.setIcon(input1);
		start.add(lblNewLabel_95);

		JButton btnNewButton_30 = new JButton("LOGIN");
		sl_start.putConstraint(SpringLayout.NORTH, btnNewButton_30, 20, SpringLayout.SOUTH, lblNewLabel_95);
		sl_start.putConstraint(SpringLayout.WEST, btnNewButton_30, 250, SpringLayout.WEST, start);
		sl_start.putConstraint(SpringLayout.SOUTH, btnNewButton_30, -30, SpringLayout.SOUTH, start);
		sl_start.putConstraint(SpringLayout.EAST, btnNewButton_30, -254, SpringLayout.EAST, start);
		btnNewButton_30.setBackground(new Color(220, 220, 220));
		btnNewButton_30.setFont(new Font("Cambria", Font.PLAIN, 18));
		btnNewButton_30.addActionListener(new ActionListener() {
			private Component frame;

			public void actionPerformed(ActionEvent arg0) {
				int i = 0;
				int value = JOptionPane.showConfirmDialog(frame, loginpanel,
						"Enter text", JOptionPane.OK_CANCEL_OPTION);
				if (value == JOptionPane.OK_OPTION) {
					boolean iscorrect = false;
					boolean pasiscorrect = false;

					iscorrect = isUsernameCorrect(field1.getText());
					pasiscorrect = isPasswordCorrect(field2.getText());

					while (((iscorrect == false) || (pasiscorrect == false))
							&& (i < 3)) {
						value = JOptionPane.showConfirmDialog(frame, Wrong,
								"Enter text", JOptionPane.OK_CANCEL_OPTION);
						try {
							Thread.sleep(100);
						} catch (InterruptedException ex) {
							Thread.currentThread().interrupt();
						}
						field1.setText("");
						field2.setText("");
						value = JOptionPane.showConfirmDialog(frame,
								loginpanel, "Enter text",
								JOptionPane.OK_CANCEL_OPTION);
						iscorrect = isUsernameCorrect(field1.getText());
						pasiscorrect = isPasswordCorrect(field2.getText());
						i++;

					}

					if (i > 2)
						System.exit(0);
					// OK was pressed
					CardLayout cl = (CardLayout) contentPane.getLayout();
					cl.next(contentPane);
					// handle them
				}
			}

		});
		start.add(btnNewButton_30);

		JPanel Main_Menu = new JPanel();
		Main_Menu.setForeground(new Color(105, 105, 105));
		Main_Menu.setBackground(new Color(255, 250, 240));
		contentPane.add(Main_Menu, "name_50788888364615");
		SpringLayout sl_Main_Menu = new SpringLayout();
		Main_Menu.setLayout(sl_Main_Menu);

		JButton btnNewButton = new JButton("CUSTOMERS");
		sl_Main_Menu.putConstraint(SpringLayout.WEST, btnNewButton, 29,
				SpringLayout.WEST, Main_Menu);
		sl_Main_Menu.putConstraint(SpringLayout.EAST, btnNewButton, -390,
				SpringLayout.EAST, Main_Menu);
		btnNewButton.setForeground(new Color(0, 0, 102));
		btnNewButton.setFont(new Font("Cambria Math", Font.BOLD, 18));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.next(contentPane);
			}
		});
		Main_Menu.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("DEBTORS");
		sl_Main_Menu.putConstraint(SpringLayout.WEST, btnNewButton_1, 88,
				SpringLayout.EAST, btnNewButton);
		sl_Main_Menu.putConstraint(SpringLayout.EAST, btnNewButton_1, -42,
				SpringLayout.EAST, Main_Menu);
		btnNewButton_1.setForeground(new Color(0, 0, 102));
		btnNewButton_1.setFont(new Font("Cambria Math", Font.BOLD, 18));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
			}
		});
		Main_Menu.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("INSURANCE \r\nCOMPANIES");
		sl_Main_Menu.putConstraint(SpringLayout.SOUTH, btnNewButton, -69,
				SpringLayout.NORTH, btnNewButton_2);
		sl_Main_Menu.putConstraint(SpringLayout.WEST, btnNewButton_2, 29,
				SpringLayout.WEST, Main_Menu);
		sl_Main_Menu.putConstraint(SpringLayout.SOUTH, btnNewButton_2, -55,
				SpringLayout.SOUTH, Main_Menu);
		sl_Main_Menu.putConstraint(SpringLayout.EAST, btnNewButton_2, -390,
				SpringLayout.EAST, Main_Menu);
		sl_Main_Menu.putConstraint(SpringLayout.NORTH, btnNewButton_2, 345,
				SpringLayout.NORTH, Main_Menu);
		btnNewButton_2.setForeground(new Color(0, 0, 102));
		btnNewButton_2.setFont(new Font("Cambria Math", Font.BOLD, 18));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
			
			}
		});
		Main_Menu.add(btnNewButton_2);

		JButton btnNewButton_3 = new JButton("BANKS");
		sl_Main_Menu.putConstraint(SpringLayout.NORTH, btnNewButton_3, 345,
				SpringLayout.NORTH, Main_Menu);
		sl_Main_Menu.putConstraint(SpringLayout.SOUTH, btnNewButton_1, -69,
				SpringLayout.NORTH, btnNewButton_3);
		sl_Main_Menu.putConstraint(SpringLayout.WEST, btnNewButton_3, 88,
				SpringLayout.EAST, btnNewButton_2);
		sl_Main_Menu.putConstraint(SpringLayout.SOUTH, btnNewButton_3, -55,
				SpringLayout.SOUTH, Main_Menu);
		sl_Main_Menu.putConstraint(SpringLayout.EAST, btnNewButton_3, -42,
				SpringLayout.EAST, Main_Menu);
		btnNewButton_3.setForeground(new Color(0, 0, 102));
		btnNewButton_3.setFont(new Font("Cambria Math", Font.BOLD, 18));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				
			}
		});
		Main_Menu.add(btnNewButton_3);

		JLabel lblNewLabel_63 = new JLabel("MAIN MENU");
		sl_Main_Menu.putConstraint(SpringLayout.NORTH, btnNewButton_1, 71,
				SpringLayout.SOUTH, lblNewLabel_63);
		sl_Main_Menu.putConstraint(SpringLayout.NORTH, btnNewButton, 71,
				SpringLayout.SOUTH, lblNewLabel_63);
		sl_Main_Menu.putConstraint(SpringLayout.NORTH, lblNewLabel_63, 59,
				SpringLayout.NORTH, Main_Menu);
		sl_Main_Menu.putConstraint(SpringLayout.WEST, lblNewLabel_63, 206,
				SpringLayout.WEST, Main_Menu);
		sl_Main_Menu.putConstraint(SpringLayout.SOUTH, lblNewLabel_63, -379,
				SpringLayout.SOUTH, Main_Menu);
		sl_Main_Menu.putConstraint(SpringLayout.EAST, lblNewLabel_63, -198,
				SpringLayout.EAST, Main_Menu);
		lblNewLabel_63.setBackground(new Color(255, 255, 255));
		lblNewLabel_63.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_63.setFont(new Font("Cambria Math", Font.BOLD, 36));
		lblNewLabel_63.setForeground(new Color(119, 136, 153));
		Main_Menu.add(lblNewLabel_63);

		JPanel Customer = new JPanel();
		Customer.setBackground(new Color(255, 250, 250));
		contentPane.add(Customer, "name_50790408448602");
		SpringLayout sl_Customer = new SpringLayout();
		Customer.setLayout(sl_Customer);

		JButton btnBack = new JButton("Back");
		sl_Customer.putConstraint(SpringLayout.NORTH, btnBack, 384,
				SpringLayout.NORTH, Customer);
		sl_Customer.putConstraint(SpringLayout.WEST, btnBack, 357,
				SpringLayout.WEST, Customer);
		sl_Customer.putConstraint(SpringLayout.EAST, btnBack, -136,
				SpringLayout.EAST, Customer);
		btnBack.setForeground(new Color(0, 0, 102));
		btnBack.setFont(new Font("Cambria Math", Font.BOLD, 18));
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.previous(contentPane);
			}
		});
		Customer.add(btnBack);

		JLabel lblCustomers = new JLabel("Customers");
		sl_Customer.putConstraint(SpringLayout.NORTH, lblCustomers, 24,
				SpringLayout.NORTH, Customer);
		sl_Customer.putConstraint(SpringLayout.WEST, lblCustomers, 61,
				SpringLayout.WEST, Customer);
		sl_Customer.putConstraint(SpringLayout.SOUTH, lblCustomers, -400,
				SpringLayout.SOUTH, Customer);
		sl_Customer.putConstraint(SpringLayout.EAST, lblCustomers, -386,
				SpringLayout.EAST, Customer);
		lblCustomers.setForeground(new Color(105, 105, 105));
		lblCustomers.setFont(new Font("Cambria Math", Font.BOLD, 36));
		Customer.add(lblCustomers);

		JButton btnNewButton_29 = new JButton("ADD");
		sl_Customer.putConstraint(SpringLayout.NORTH, btnNewButton_29, 51,
				SpringLayout.SOUTH, lblCustomers);
		sl_Customer.putConstraint(SpringLayout.WEST, btnNewButton_29, 61,
				SpringLayout.WEST, Customer);
		sl_Customer.putConstraint(SpringLayout.SOUTH, btnNewButton_29, -271,
				SpringLayout.SOUTH, Customer);
		sl_Customer.putConstraint(SpringLayout.EAST, btnNewButton_29, -432,
				SpringLayout.EAST, Customer);
		btnNewButton_29.setForeground(new Color(0, 0, 128));
		btnNewButton_29.setFont(new Font("Cambria Math", Font.BOLD, 18));
		btnNewButton_29.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.next(contentPane);
			}
		});
		Customer.add(btnNewButton_29);

		JButton btnDelete = new JButton("DELETE");
		sl_Customer.putConstraint(SpringLayout.NORTH, btnDelete, 46,
				SpringLayout.SOUTH, btnNewButton_29);
		sl_Customer.putConstraint(SpringLayout.EAST, btnDelete, 0,
				SpringLayout.EAST, btnNewButton_29);
		sl_Customer.putConstraint(SpringLayout.WEST, btnDelete, 61,
				SpringLayout.WEST, Customer);
		btnDelete.setForeground(new Color(0, 0, 128));
		btnDelete.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Customer.add(btnDelete);

		JScrollPane scrollPane_1 =new JScrollPane();


		final DefaultTableModel model = new DefaultTableModel();

		final JTable table = new JTable(model);

		// Create a couple of columns

		model.addColumn("Id");
		model.addColumn("Name");
		model.addColumn("Surname");
		model.addColumn("Tel1");
		model.addColumn("Tel2");
		model.addColumn("Address");
		model.addColumn("E-mail");
		model.addColumn("DOB");
		model.addColumn("Insurance");
		scrollPane_1.setViewportView(table);
		JButton btnView = new JButton("VIEW");
	
		btnView.setForeground(new Color(0, 0, 102));
		btnView.setFont(new Font("Tahoma", Font.BOLD, 13));

		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				prototype anObj = new prototype();
				conn = anObj.getDBConnection();
				if (conn == null) {
					return;
				}

				ResultSet rs = null;

				// Query to be executed.

				String query = "SELECT * FROM CUSTOMER";

				try { Statement stmt =
						conn.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
						rs = stmt.executeQuery(query);
						while (rs.next()) {
							// retrieve the columns in any order
							String col1 = rs.getString("Customer_id");
							String col2 = rs.getString("Name");
							String col3 = rs.getString("Surname");
							String col4 = rs.getString("Tel1");
							String col5 = rs.getString("Tel2");
							String col6 = rs.getString("Cust_Address");
							String col7 = rs.getString("e_mail");
							String col8 = rs.getString("DOB");
							String col9 = rs.getString("Type_of_insurance");
							// printing out a row

							final Object r[] = { col1, col2, col3, col4, col5, col6, col7, col8, col9 };
							model.addRow(r);
					}
				}

				catch (SQLException e) {

				System.out.println(e.getMessage());
				}
				try {
					if (!conn.isClosed()) {
						conn.close();
					}
				}
				catch (Exception e) {
					// Ignore the error and continues
				}
			}
		});
		
		sl_Customer.putConstraint(SpringLayout.NORTH, btnView, 384,
				SpringLayout.NORTH, Customer);
		sl_Customer.putConstraint(SpringLayout.SOUTH, btnView, -30,
				SpringLayout.SOUTH, Customer);
		sl_Customer.putConstraint(SpringLayout.SOUTH, btnBack, 0,
				SpringLayout.SOUTH, btnView);
		sl_Customer.putConstraint(SpringLayout.SOUTH, btnDelete, -39,
				SpringLayout.NORTH, btnView);
		sl_Customer.putConstraint(SpringLayout.EAST, btnView, 0,
				SpringLayout.EAST, btnNewButton_29);
		sl_Customer.putConstraint(SpringLayout.WEST, btnView, 61,
				SpringLayout.WEST, Customer);
		btnView.setForeground(new Color(0, 0, 128));
		btnView.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Customer.add(btnView);

		JPanel Register_customer = new JPanel();
		Register_customer.setBackground(new Color(255, 250, 250));
		Register_customer.setForeground(new Color(0, 0, 128));
		contentPane.add(Register_customer, "name_50792032574777");
		SpringLayout sl_Register_customer = new SpringLayout();
		Register_customer.setLayout(sl_Register_customer);

		JLabel lblNewLabel_3 = new JLabel("Name");
		lblNewLabel_3.setBackground(new Color(255, 250, 250));
		lblNewLabel_3.setForeground(new Color(0, 0, 128));
		lblNewLabel_3.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Register_customer.add(lblNewLabel_3);

		textField_3 = new JTextField();
		sl_Register_customer.putConstraint(SpringLayout.NORTH, textField_3, -1,
				SpringLayout.NORTH, lblNewLabel_3);
		Register_customer.add(textField_3);
		textField_3.setColumns(10);

		JLabel lblNewLabel_4 = new JLabel("ID");
		lblNewLabel_4.setBackground(new Color(255, 250, 250));
		sl_Register_customer.putConstraint(SpringLayout.WEST, lblNewLabel_3, 0,
				SpringLayout.WEST, lblNewLabel_4);
		sl_Register_customer.putConstraint(SpringLayout.SOUTH, lblNewLabel_3,
				-35, SpringLayout.NORTH, lblNewLabel_4);
		lblNewLabel_4.setForeground(new Color(0, 0, 128));
		lblNewLabel_4.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Register_customer.add(lblNewLabel_4);

		textField_4 = new JTextField();
		sl_Register_customer.putConstraint(SpringLayout.EAST, textField_3, 0,
				SpringLayout.EAST, textField_4);
		sl_Register_customer.putConstraint(SpringLayout.NORTH, textField_4, -1,
				SpringLayout.NORTH, lblNewLabel_4);
		Register_customer.add(textField_4);
		textField_4.setColumns(10);

		JLabel lblNewLabel_5 = new JLabel("Tel1");
		lblNewLabel_5.setBackground(new Color(255, 250, 250));
		sl_Register_customer.putConstraint(SpringLayout.WEST, lblNewLabel_4, 0,
				SpringLayout.WEST, lblNewLabel_5);
		sl_Register_customer.putConstraint(SpringLayout.SOUTH, lblNewLabel_4,
				-42, SpringLayout.NORTH, lblNewLabel_5);
		lblNewLabel_5.setForeground(new Color(0, 0, 128));
		lblNewLabel_5.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Register_customer.add(lblNewLabel_5);

		textField_5 = new JTextField();
		sl_Register_customer.putConstraint(SpringLayout.EAST, textField_4, 0,
				SpringLayout.EAST, textField_5);
		sl_Register_customer.putConstraint(SpringLayout.NORTH, textField_5, -1,
				SpringLayout.NORTH, lblNewLabel_5);
		Register_customer.add(textField_5);
		textField_5.setColumns(10);

		JButton btnNewButton_8 = new JButton("SAVE");
		sl_Register_customer.putConstraint(SpringLayout.SOUTH, btnNewButton_8,
				-22, SpringLayout.SOUTH, Register_customer);
		sl_Register_customer.putConstraint(SpringLayout.WEST, btnNewButton_8,
				0, SpringLayout.WEST, lblNewLabel_3);
		sl_Register_customer.putConstraint(SpringLayout.EAST, btnNewButton_8,
				0, SpringLayout.EAST, textField_3);
		btnNewButton_8.setForeground(new Color(0, 0, 102));
		btnNewButton_8.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Register_customer.add(btnNewButton_8);

		JLabel lblNewLabel = new JLabel("Tel2");
		lblNewLabel.setBackground(new Color(255, 250, 250));
		sl_Register_customer.putConstraint(SpringLayout.WEST, lblNewLabel_5, 0,
				SpringLayout.WEST, lblNewLabel);
		sl_Register_customer.putConstraint(SpringLayout.SOUTH, lblNewLabel_5,
				-36, SpringLayout.NORTH, lblNewLabel);
		lblNewLabel.setForeground(new Color(0, 0, 128));
		lblNewLabel.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Register_customer.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Address");
		sl_Register_customer.putConstraint(SpringLayout.NORTH, btnNewButton_8,
				26, SpringLayout.SOUTH, lblNewLabel_1);
		lblNewLabel_1.setBackground(new Color(255, 250, 250));
		sl_Register_customer.putConstraint(SpringLayout.WEST, lblNewLabel, 0,
				SpringLayout.WEST, lblNewLabel_1);
		sl_Register_customer.putConstraint(SpringLayout.SOUTH, lblNewLabel,
				-40, SpringLayout.NORTH, lblNewLabel_1);
		sl_Register_customer.putConstraint(SpringLayout.WEST, lblNewLabel_1,
				47, SpringLayout.WEST, Register_customer);
		sl_Register_customer.putConstraint(SpringLayout.SOUTH, lblNewLabel_1,
				-108, SpringLayout.SOUTH, Register_customer);
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Register_customer.add(lblNewLabel_1);

		textField = new JTextField();
		sl_Register_customer.putConstraint(SpringLayout.WEST, textField_5, 0,
				SpringLayout.WEST, textField);
		sl_Register_customer.putConstraint(SpringLayout.NORTH, textField, -1,
				SpringLayout.NORTH, lblNewLabel);
		Register_customer.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		sl_Register_customer.putConstraint(SpringLayout.WEST, textField, 0,
				SpringLayout.WEST, textField_1);
		sl_Register_customer.putConstraint(SpringLayout.NORTH, textField_1, -1,
				SpringLayout.NORTH, lblNewLabel_1);
		sl_Register_customer.putConstraint(SpringLayout.WEST, textField_1, 37,
				SpringLayout.EAST, lblNewLabel_1);
		Register_customer.add(textField_1);
		textField_1.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("Email");
		lblNewLabel_2.setBackground(new Color(255, 250, 250));
		sl_Register_customer.putConstraint(SpringLayout.NORTH, lblNewLabel_2,
				0, SpringLayout.NORTH, lblNewLabel_3);
		lblNewLabel_2.setForeground(new Color(0, 0, 128));
		lblNewLabel_2.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Register_customer.add(lblNewLabel_2);

		JLabel lblNewLabel_6 = new JLabel("Date of Birth");
		lblNewLabel_6.setBackground(new Color(255, 250, 250));
		sl_Register_customer.putConstraint(SpringLayout.WEST, lblNewLabel_2, 0,
				SpringLayout.WEST, lblNewLabel_6);
		sl_Register_customer.putConstraint(SpringLayout.WEST, lblNewLabel_6,
				68, SpringLayout.EAST, textField_4);
		lblNewLabel_6.setForeground(new Color(0, 0, 128));
		lblNewLabel_6.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Register_customer.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Type of Insurance");
		lblNewLabel_7.setBackground(new Color(255, 250, 250));
		sl_Register_customer.putConstraint(SpringLayout.SOUTH, lblNewLabel_6,
				-31, SpringLayout.NORTH, lblNewLabel_7);
		sl_Register_customer.putConstraint(SpringLayout.NORTH, lblNewLabel_7,
				0, SpringLayout.NORTH, lblNewLabel_5);
		sl_Register_customer.putConstraint(SpringLayout.WEST, lblNewLabel_7,
				65, SpringLayout.EAST, textField_5);
		lblNewLabel_7.setForeground(new Color(0, 0, 128));
		lblNewLabel_7.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Register_customer.add(lblNewLabel_7);

		textField_2 = new JTextField();
		sl_Register_customer.putConstraint(SpringLayout.NORTH, textField_2, -1,
				SpringLayout.NORTH, lblNewLabel_3);
		Register_customer.add(textField_2);
		textField_2.setColumns(10);

		textField_6 = new JTextField();
		sl_Register_customer.putConstraint(SpringLayout.EAST, textField_2, 0,
				SpringLayout.EAST, textField_6);
		sl_Register_customer.putConstraint(SpringLayout.NORTH, textField_6, -1,
				SpringLayout.NORTH, lblNewLabel_4);
		Register_customer.add(textField_6);
		textField_6.setColumns(10);

		textField_7 = new JTextField();
		sl_Register_customer.putConstraint(SpringLayout.WEST, textField_6, 0,
				SpringLayout.WEST, textField_7);
		sl_Register_customer.putConstraint(SpringLayout.NORTH, textField_7, -1,
				SpringLayout.NORTH, lblNewLabel_5);
		sl_Register_customer.putConstraint(SpringLayout.WEST, textField_7, 53,
				SpringLayout.EAST, lblNewLabel_7);
		Register_customer.add(textField_7);
		textField_7.setColumns(10);

		JLabel lblRegisterNewCustomer = new JLabel("Register New Customer");
		sl_Register_customer.putConstraint(SpringLayout.NORTH,
				lblRegisterNewCustomer, 34, SpringLayout.NORTH,
				Register_customer);
		sl_Register_customer.putConstraint(SpringLayout.WEST,
				lblRegisterNewCustomer, 0, SpringLayout.WEST, lblNewLabel_3);
		lblRegisterNewCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterNewCustomer.setForeground(new Color(105, 105, 105));
		lblRegisterNewCustomer.setFont(new Font("Cambria Math", Font.BOLD, 36));
		lblRegisterNewCustomer.setBackground(Color.WHITE);
		Register_customer.add(lblRegisterNewCustomer);

		JButton btnBack_1 = new JButton("BACK");
		btnBack_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.previous(contentPane);
			}
		});
		sl_Register_customer.putConstraint(SpringLayout.NORTH, btnBack_1, 0,
				SpringLayout.NORTH, btnNewButton_8);
		sl_Register_customer.putConstraint(SpringLayout.WEST, btnBack_1, 101,
				SpringLayout.EAST, btnNewButton_8);
		sl_Register_customer.putConstraint(SpringLayout.SOUTH, btnBack_1, 0,
				SpringLayout.SOUTH, btnNewButton_8);
		sl_Register_customer.putConstraint(SpringLayout.EAST, btnBack_1, 294,
				SpringLayout.EAST, btnNewButton_8);
		btnBack_1.setForeground(new Color(0, 0, 102));
		btnBack_1.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Register_customer.add(btnBack_1);

		JPanel Debtors = new JPanel();
		Debtors.setBackground(new Color(255, 250, 250));
		contentPane.add(Debtors, "name_50799248911408");
		SpringLayout sl_Debtors = new SpringLayout();
		Debtors.setLayout(sl_Debtors);

		JButton btnNewButton_10 = new JButton("DELETE");
		sl_Debtors.putConstraint(SpringLayout.WEST, btnNewButton_10, 116,
				SpringLayout.WEST, Debtors);
		btnNewButton_10.setForeground(new Color(0, 0, 102));
		btnNewButton_10.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Debtors.add(btnNewButton_10);

		JButton btnNewButton_11 = new JButton("VIEW");
		sl_Debtors.putConstraint(SpringLayout.NORTH, btnNewButton_11, 62,
				SpringLayout.SOUTH, btnNewButton_10);
		sl_Debtors.putConstraint(SpringLayout.WEST, btnNewButton_11, 0,
				SpringLayout.WEST, btnNewButton_10);
		sl_Debtors.putConstraint(SpringLayout.SOUTH, btnNewButton_11, 134,
				SpringLayout.SOUTH, btnNewButton_10);
		sl_Debtors.putConstraint(SpringLayout.EAST, btnNewButton_11, 0,
				SpringLayout.EAST, btnNewButton_10);
		btnNewButton_11.setForeground(new Color(0, 0, 102));
		btnNewButton_11.setFont(new Font("Cambria Math", Font.BOLD, 18));
		btnNewButton_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				
			}
		});
		Debtors.add(btnNewButton_11);

		JButton btnNewButton_13 = new JButton("Back");
		sl_Debtors.putConstraint(SpringLayout.NORTH, btnNewButton_13, 0,
				SpringLayout.NORTH, btnNewButton_11);
		sl_Debtors.putConstraint(SpringLayout.WEST, btnNewButton_13, 145,
				SpringLayout.EAST, btnNewButton_11);
		sl_Debtors.putConstraint(SpringLayout.SOUTH, btnNewButton_13, 0,
				SpringLayout.SOUTH, btnNewButton_11);
		sl_Debtors.putConstraint(SpringLayout.EAST, btnNewButton_13, 325,
				SpringLayout.EAST, btnNewButton_11);
		btnNewButton_13.setForeground(new Color(0, 0, 102));
		btnNewButton_13.setFont(new Font("Cambria Math", Font.BOLD, 18));
		btnNewButton_13.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				
			}
		});
		Debtors.add(btnNewButton_13);

		JButton button_1 = new JButton("ADD");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.next(contentPane);
			}
		});
		sl_Debtors.putConstraint(SpringLayout.SOUTH, button_1, -330,
				SpringLayout.SOUTH, Debtors);
		sl_Debtors.putConstraint(SpringLayout.NORTH, btnNewButton_10, 84,
				SpringLayout.SOUTH, button_1);
		sl_Debtors.putConstraint(SpringLayout.SOUTH, btnNewButton_10, 156,
				SpringLayout.SOUTH, button_1);
		sl_Debtors.putConstraint(SpringLayout.EAST, btnNewButton_10, 0,
				SpringLayout.EAST, button_1);
		sl_Debtors.putConstraint(SpringLayout.WEST, button_1, 116,
				SpringLayout.WEST, Debtors);
		sl_Debtors.putConstraint(SpringLayout.EAST, button_1, -383,
				SpringLayout.EAST, Debtors);
		button_1.setForeground(new Color(0, 0, 128));
		button_1.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Debtors.add(button_1);

		JLabel lblDebtors = new JLabel("Debtors");
		sl_Debtors.putConstraint(SpringLayout.NORTH, button_1, 37,
				SpringLayout.SOUTH, lblDebtors);
		sl_Debtors.putConstraint(SpringLayout.NORTH, lblDebtors, 10,
				SpringLayout.NORTH, Debtors);
		sl_Debtors.putConstraint(SpringLayout.WEST, lblDebtors, 28,
				SpringLayout.WEST, Debtors);
		lblDebtors.setForeground(new Color(105, 105, 105));
		lblDebtors.setFont(new Font("Cambria Math", Font.BOLD, 36));
		Debtors.add(lblDebtors);

		JPanel New_Debtor = new JPanel();
		New_Debtor.setBackground(new Color(255, 250, 250));
		contentPane.add(New_Debtor, "name_50800801481888");
		SpringLayout sl_New_Debtor = new SpringLayout();
		New_Debtor.setLayout(sl_New_Debtor);

		JLabel lblNewLabel_17 = new JLabel("Description");
		sl_New_Debtor.putConstraint(SpringLayout.WEST, lblNewLabel_17, 45,
				SpringLayout.WEST, New_Debtor);
		sl_New_Debtor.putConstraint(SpringLayout.EAST, lblNewLabel_17, 146,
				SpringLayout.WEST, New_Debtor);
		lblNewLabel_17.setForeground(new Color(0, 0, 102));
		lblNewLabel_17.setFont(new Font("Cambria Math", Font.BOLD, 18));
		New_Debtor.add(lblNewLabel_17);

		JLabel lblNewLabel_18 = new JLabel("Receipt No");
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, lblNewLabel_18, 39,
				SpringLayout.SOUTH, lblNewLabel_17);
		sl_New_Debtor.putConstraint(SpringLayout.WEST, lblNewLabel_18, 45,
				SpringLayout.WEST, New_Debtor);
		sl_New_Debtor.putConstraint(SpringLayout.SOUTH, lblNewLabel_18, 61,
				SpringLayout.SOUTH, lblNewLabel_17);
		sl_New_Debtor.putConstraint(SpringLayout.EAST, lblNewLabel_18, 139,
				SpringLayout.WEST, New_Debtor);
		lblNewLabel_18.setForeground(new Color(0, 0, 102));
		lblNewLabel_18.setFont(new Font("Cambria Math", Font.BOLD, 18));
		New_Debtor.add(lblNewLabel_18);

		JLabel lblNewLabel_19 = new JLabel("Name");
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, lblNewLabel_19, 209,
				SpringLayout.NORTH, New_Debtor);
		sl_New_Debtor.putConstraint(SpringLayout.WEST, lblNewLabel_19, 45,
				SpringLayout.WEST, New_Debtor);
		lblNewLabel_19.setForeground(new Color(0, 0, 102));
		lblNewLabel_19.setFont(new Font("Cambria Math", Font.BOLD, 18));
		New_Debtor.add(lblNewLabel_19);

		JLabel lblNewLabel_20 = new JLabel("Address");
		sl_New_Debtor.putConstraint(SpringLayout.EAST, lblNewLabel_19, 0,
				SpringLayout.EAST, lblNewLabel_20);
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, lblNewLabel_20, 265,
				SpringLayout.NORTH, New_Debtor);
		sl_New_Debtor.putConstraint(SpringLayout.WEST, lblNewLabel_20, 45,
				SpringLayout.WEST, New_Debtor);
		lblNewLabel_20.setForeground(new Color(0, 0, 102));
		lblNewLabel_20.setFont(new Font("Cambria Math", Font.BOLD, 18));
		New_Debtor.add(lblNewLabel_20);

		JLabel lblNewLabel_21 = new JLabel("Tel1");
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, lblNewLabel_21, 27,
				SpringLayout.SOUTH, lblNewLabel_20);
		sl_New_Debtor.putConstraint(SpringLayout.WEST, lblNewLabel_21, 45,
				SpringLayout.WEST, New_Debtor);
		lblNewLabel_21.setForeground(new Color(0, 0, 102));
		lblNewLabel_21.setFont(new Font("Cambria Math", Font.BOLD, 18));
		New_Debtor.add(lblNewLabel_21);

		JLabel lblNewLabel_22 = new JLabel("Tel2");
		sl_New_Debtor.putConstraint(SpringLayout.WEST, lblNewLabel_22, 0,
				SpringLayout.WEST, lblNewLabel_17);
		lblNewLabel_22.setForeground(new Color(0, 0, 102));
		lblNewLabel_22.setFont(new Font("Cambria Math", Font.BOLD, 18));
		New_Debtor.add(lblNewLabel_22);

		JLabel lblNewLabel_24 = new JLabel("Date");
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, lblNewLabel_24, 0,
				SpringLayout.NORTH, lblNewLabel_18);
		sl_New_Debtor.putConstraint(SpringLayout.EAST, lblNewLabel_24, -287,
				SpringLayout.EAST, New_Debtor);
		lblNewLabel_24.setForeground(new Color(0, 0, 102));
		lblNewLabel_24.setFont(new Font("Cambria Math", Font.BOLD, 18));
		New_Debtor.add(lblNewLabel_24);

		JLabel lblNewLabel_26 = new JLabel("Credit");
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, lblNewLabel_26, 0,
				SpringLayout.NORTH, lblNewLabel_20);
		sl_New_Debtor.putConstraint(SpringLayout.WEST, lblNewLabel_26, 0,
				SpringLayout.WEST, lblNewLabel_24);
		lblNewLabel_26.setForeground(new Color(0, 0, 102));
		lblNewLabel_26.setFont(new Font("Cambria Math", Font.BOLD, 18));
		New_Debtor.add(lblNewLabel_26);

		JLabel lblNewLabel_27 = new JLabel("Balances");
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, lblNewLabel_27, 0,
				SpringLayout.NORTH, lblNewLabel_21);
		sl_New_Debtor.putConstraint(SpringLayout.WEST, lblNewLabel_27, 0,
				SpringLayout.WEST, lblNewLabel_24);
		lblNewLabel_27.setForeground(new Color(0, 0, 102));
		lblNewLabel_27.setFont(new Font("Cambria Math", Font.BOLD, 18));
		New_Debtor.add(lblNewLabel_27);

		textField_17 = new JTextField();
		sl_New_Debtor.putConstraint(SpringLayout.WEST, lblNewLabel_24, 54,
				SpringLayout.EAST, textField_17);
		sl_New_Debtor.putConstraint(SpringLayout.WEST, textField_17, 176,
				SpringLayout.WEST, New_Debtor);
		New_Debtor.add(textField_17);
		textField_17.setColumns(10);

		textField_19 = new JTextField();
		sl_New_Debtor.putConstraint(SpringLayout.EAST, lblNewLabel_26, 131,
				SpringLayout.EAST, textField_19);
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, textField_19, 84,
				SpringLayout.SOUTH, textField_17);
		sl_New_Debtor.putConstraint(SpringLayout.WEST, textField_19, 176,
				SpringLayout.WEST, New_Debtor);
		New_Debtor.add(textField_19);
		textField_19.setColumns(10);

		textField_21 = new JTextField();
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, lblNewLabel_22, -4,
				SpringLayout.NORTH, textField_21);
		sl_New_Debtor.putConstraint(SpringLayout.EAST, lblNewLabel_22, -92,
				SpringLayout.WEST, textField_21);
		sl_New_Debtor.putConstraint(SpringLayout.WEST, textField_21, 176,
				SpringLayout.WEST, New_Debtor);
		New_Debtor.add(textField_21);
		textField_21.setColumns(10);

		JButton btnBack_2 = new JButton("Back");
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, btnBack_2, 418,
				SpringLayout.NORTH, New_Debtor);
		sl_New_Debtor.putConstraint(SpringLayout.WEST, btnBack_2, -237,
				SpringLayout.EAST, New_Debtor);
		sl_New_Debtor.putConstraint(SpringLayout.SOUTH, btnBack_2, -21,
				SpringLayout.SOUTH, New_Debtor);
		sl_New_Debtor.putConstraint(SpringLayout.EAST, btnBack_2, -51,
				SpringLayout.EAST, New_Debtor);
		btnBack_2.setForeground(new Color(0, 0, 102));
		btnBack_2.setFont(new Font("Cambria Math", Font.BOLD, 18));
		btnBack_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.previous(contentPane);
			}
		});
		New_Debtor.add(btnBack_2);

		JButton btnSave = new JButton("SAVE");
		sl_New_Debtor.putConstraint(SpringLayout.SOUTH, textField_21, -23,
				SpringLayout.NORTH, btnSave);
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, btnSave, 0,
				SpringLayout.NORTH, btnBack_2);
		sl_New_Debtor.putConstraint(SpringLayout.SOUTH, btnSave, 53,
				SpringLayout.NORTH, btnBack_2);
		sl_New_Debtor.putConstraint(SpringLayout.WEST, btnSave, 45,
				SpringLayout.WEST, New_Debtor);
		sl_New_Debtor.putConstraint(SpringLayout.EAST, btnSave, -211,
				SpringLayout.WEST, btnBack_2);
		btnSave.setForeground(new Color(0, 0, 102));
		btnSave.setFont(new Font("Cambria Math", Font.BOLD, 18));
		New_Debtor.add(btnSave);

		JLabel lblRegisterNewDebtor = new JLabel("Register New Debtor");
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, textField_17, 96,
				SpringLayout.SOUTH, lblRegisterNewDebtor);
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, lblNewLabel_17, 31,
				SpringLayout.SOUTH, lblRegisterNewDebtor);
		sl_New_Debtor.putConstraint(SpringLayout.SOUTH, lblNewLabel_17, 53,
				SpringLayout.SOUTH, lblRegisterNewDebtor);
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, lblRegisterNewDebtor,
				20, SpringLayout.NORTH, New_Debtor);
		sl_New_Debtor.putConstraint(SpringLayout.WEST, lblRegisterNewDebtor,
				38, SpringLayout.WEST, New_Debtor);
		lblRegisterNewDebtor.setHorizontalAlignment(SwingConstants.CENTER);
		lblRegisterNewDebtor.setForeground(new Color(105, 105, 105));
		lblRegisterNewDebtor.setFont(new Font("Cambria Math", Font.BOLD, 36));
		lblRegisterNewDebtor.setBackground(Color.WHITE);
		New_Debtor.add(lblRegisterNewDebtor);

		textField_9 = new JTextField();
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, textField_9, 0,
				SpringLayout.NORTH, lblNewLabel_21);
		sl_New_Debtor.putConstraint(SpringLayout.WEST, textField_9, 92,
				SpringLayout.EAST, lblNewLabel_21);
		textField_9.setColumns(10);
		New_Debtor.add(textField_9);

		textField_10 = new JTextField();
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, textField_10, 0,
				SpringLayout.NORTH, lblNewLabel_17);
		sl_New_Debtor.putConstraint(SpringLayout.WEST, textField_10, 0,
				SpringLayout.WEST, textField_17);
		textField_10.setColumns(10);
		New_Debtor.add(textField_10);

		textField_8 = new JTextField();
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, textField_8, 0,
				SpringLayout.NORTH, lblNewLabel_19);
		sl_New_Debtor.putConstraint(SpringLayout.WEST, textField_8, 0,
				SpringLayout.WEST, textField_17);
		textField_8.setColumns(10);
		New_Debtor.add(textField_8);

		JLabel lblId = new JLabel("ID");
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, lblId, 0,
				SpringLayout.NORTH, lblNewLabel_17);
		sl_New_Debtor.putConstraint(SpringLayout.WEST, lblId, 0,
				SpringLayout.WEST, lblNewLabel_24);
		lblId.setForeground(new Color(0, 0, 102));
		lblId.setFont(new Font("Cambria Math", Font.BOLD, 18));
		New_Debtor.add(lblId);

		JLabel lblDebit = new JLabel("Debit");
		sl_New_Debtor.putConstraint(SpringLayout.WEST, lblDebit, 54,
				SpringLayout.EAST, textField_8);
		sl_New_Debtor.putConstraint(SpringLayout.SOUTH, lblDebit, 0,
				SpringLayout.SOUTH, lblNewLabel_19);
		lblDebit.setForeground(new Color(0, 0, 102));
		lblDebit.setFont(new Font("Cambria Math", Font.BOLD, 18));
		New_Debtor.add(lblDebit);

		textField_11 = new JTextField();
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, textField_11, 0,
				SpringLayout.NORTH, lblNewLabel_17);
		sl_New_Debtor.putConstraint(SpringLayout.WEST, textField_11, 76,
				SpringLayout.EAST, lblId);
		textField_11.setColumns(10);
		New_Debtor.add(textField_11);

		textField_12 = new JTextField();
		sl_New_Debtor.putConstraint(SpringLayout.NORTH, textField_12, 0,
				SpringLayout.NORTH, lblNewLabel_18);
		sl_New_Debtor.putConstraint(SpringLayout.EAST, textField_12, 0,
				SpringLayout.EAST, textField_11);
		textField_12.setColumns(10);
		New_Debtor.add(textField_12);

		textField_13 = new JTextField();
		sl_New_Debtor.putConstraint(SpringLayout.WEST, textField_13, 0,
				SpringLayout.WEST, textField_11);
		sl_New_Debtor.putConstraint(SpringLayout.SOUTH, textField_13, 0,
				SpringLayout.SOUTH, lblNewLabel_19);
		textField_13.setColumns(10);
		New_Debtor.add(textField_13);

		textField_14 = new JTextField();
		sl_New_Debtor.putConstraint(SpringLayout.WEST, textField_14, 0,
				SpringLayout.WEST, textField_11);
		sl_New_Debtor.putConstraint(SpringLayout.SOUTH, textField_14, 0,
				SpringLayout.SOUTH, lblNewLabel_20);
		textField_14.setColumns(10);
		New_Debtor.add(textField_14);

		textField_15 = new JTextField();
		sl_New_Debtor.putConstraint(SpringLayout.SOUTH, textField_15, 0,
				SpringLayout.SOUTH, lblNewLabel_21);
		sl_New_Debtor.putConstraint(SpringLayout.EAST, textField_15, 0,
				SpringLayout.EAST, textField_11);
		textField_15.setColumns(10);
		New_Debtor.add(textField_15);

		JPanel Insurance_Companies = new JPanel();
		Insurance_Companies.setBackground(new Color(255, 250, 250));
		contentPane.add(Insurance_Companies, "name_54010054577595");
		SpringLayout sl_Insurance_Companies = new SpringLayout();
		Insurance_Companies.setLayout(sl_Insurance_Companies);

		JLabel lblNewLabel_38 = new JLabel("Inscurance Companies");
		sl_Insurance_Companies.putConstraint(SpringLayout.NORTH,
				lblNewLabel_38, 34, SpringLayout.NORTH, Insurance_Companies);
		sl_Insurance_Companies.putConstraint(SpringLayout.WEST, lblNewLabel_38,
				66, SpringLayout.WEST, Insurance_Companies);
		lblNewLabel_38.setForeground(new Color(105, 105, 105));
		lblNewLabel_38.setFont(new Font("Cambria Math", Font.BOLD, 30));
		Insurance_Companies.add(lblNewLabel_38);

		JButton btnNewButton_12 = new JButton("Back");
		sl_Insurance_Companies.putConstraint(SpringLayout.NORTH,
				btnNewButton_12, 388, SpringLayout.NORTH, Insurance_Companies);
		sl_Insurance_Companies.putConstraint(SpringLayout.WEST,
				btnNewButton_12, -219, SpringLayout.EAST, Insurance_Companies);
		sl_Insurance_Companies.putConstraint(SpringLayout.SOUTH,
				btnNewButton_12, -31, SpringLayout.SOUTH, Insurance_Companies);
		sl_Insurance_Companies.putConstraint(SpringLayout.EAST,
				btnNewButton_12, -45, SpringLayout.EAST, Insurance_Companies);
		btnNewButton_12.setForeground(new Color(0, 0, 102));
		btnNewButton_12.setFont(new Font("Cambria Math", Font.BOLD, 20));
		btnNewButton_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				

			}
		});
		Insurance_Companies.add(btnNewButton_12);

		JButton btnNewButton_16 = new JButton("DELETE");
		sl_Insurance_Companies.putConstraint(SpringLayout.WEST,
				btnNewButton_16, 0, SpringLayout.WEST, lblNewLabel_38);
		sl_Insurance_Companies.putConstraint(SpringLayout.EAST,
				btnNewButton_16, -439, SpringLayout.EAST, Insurance_Companies);
		btnNewButton_16.setForeground(new Color(0, 0, 102));
		btnNewButton_16.setFont(new Font("Cambria Math", Font.BOLD, 20));
		Insurance_Companies.add(btnNewButton_16);

		JButton btnNewButton_17 = new JButton("VIEW");
		sl_Insurance_Companies.putConstraint(SpringLayout.SOUTH,
				btnNewButton_16, -53, SpringLayout.NORTH, btnNewButton_17);
		sl_Insurance_Companies.putConstraint(SpringLayout.NORTH,
				btnNewButton_17, 388, SpringLayout.NORTH, Insurance_Companies);
		sl_Insurance_Companies.putConstraint(SpringLayout.WEST,
				btnNewButton_17, 68, SpringLayout.WEST, Insurance_Companies);
		sl_Insurance_Companies.putConstraint(SpringLayout.SOUTH,
				btnNewButton_17, -31, SpringLayout.SOUTH, Insurance_Companies);
		sl_Insurance_Companies.putConstraint(SpringLayout.EAST,
				btnNewButton_17, -218, SpringLayout.WEST, btnNewButton_12);
		btnNewButton_17.setForeground(new Color(0, 0, 102));
		btnNewButton_17.setFont(new Font("Cambria Math", Font.BOLD, 20));
		btnNewButton_17.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);

			}
		});
		Insurance_Companies.add(btnNewButton_17);

		JButton button = new JButton("ADD");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.next(contentPane);
			}
		});
		sl_Insurance_Companies.putConstraint(SpringLayout.NORTH, button, 77,
				SpringLayout.SOUTH, lblNewLabel_38);
		sl_Insurance_Companies.putConstraint(SpringLayout.WEST, button, 68,
				SpringLayout.WEST, Insurance_Companies);
		sl_Insurance_Companies.putConstraint(SpringLayout.SOUTH, button, -272,
				SpringLayout.SOUTH, Insurance_Companies);
		sl_Insurance_Companies.putConstraint(SpringLayout.EAST, button, -437,
				SpringLayout.EAST, Insurance_Companies);
		sl_Insurance_Companies.putConstraint(SpringLayout.NORTH,
				btnNewButton_16, 42, SpringLayout.SOUTH, button);
		button.setForeground(new Color(0, 0, 128));
		button.setFont(new Font("Cambria Math", Font.BOLD, 20));
		Insurance_Companies.add(button);

		JPanel Reg_Ins_Co = new JPanel();
		Reg_Ins_Co.setBackground(new Color(255, 250, 250));
		contentPane.add(Reg_Ins_Co, "name_54012244867064");
		SpringLayout sl_Reg_Ins_Co = new SpringLayout();
		Reg_Ins_Co.setLayout(sl_Reg_Ins_Co);

		JLabel lblNewLabel_39 = new JLabel("Name");
		sl_Reg_Ins_Co.putConstraint(SpringLayout.WEST, lblNewLabel_39, 51,
				SpringLayout.WEST, Reg_Ins_Co);
		lblNewLabel_39.setForeground(new Color(0, 0, 102));
		lblNewLabel_39.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Reg_Ins_Co.add(lblNewLabel_39);

		JLabel lblNewLabel_40 = new JLabel("Tel1");
		sl_Reg_Ins_Co.putConstraint(SpringLayout.WEST, lblNewLabel_40, 48,
				SpringLayout.WEST, Reg_Ins_Co);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.SOUTH, lblNewLabel_39, -49,
				SpringLayout.NORTH, lblNewLabel_40);
		lblNewLabel_40.setForeground(new Color(0, 0, 102));
		lblNewLabel_40.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Reg_Ins_Co.add(lblNewLabel_40);

		JLabel lblNewLabel_41 = new JLabel("Tel2");
		sl_Reg_Ins_Co.putConstraint(SpringLayout.WEST, lblNewLabel_41, 48,
				SpringLayout.WEST, Reg_Ins_Co);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.SOUTH, lblNewLabel_40, -47,
				SpringLayout.NORTH, lblNewLabel_41);
		lblNewLabel_41.setForeground(new Color(0, 0, 102));
		lblNewLabel_41.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Reg_Ins_Co.add(lblNewLabel_41);

		JLabel lblNewLabel_42 = new JLabel("Claims Tel");
		sl_Reg_Ins_Co.putConstraint(SpringLayout.WEST, lblNewLabel_42, 48,
				SpringLayout.WEST, Reg_Ins_Co);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.SOUTH, lblNewLabel_41, -48,
				SpringLayout.NORTH, lblNewLabel_42);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.SOUTH, lblNewLabel_42, -126,
				SpringLayout.SOUTH, Reg_Ins_Co);
		lblNewLabel_42.setForeground(new Color(0, 0, 102));
		lblNewLabel_42.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Reg_Ins_Co.add(lblNewLabel_42);

		textField_38 = new JTextField();
		sl_Reg_Ins_Co.putConstraint(SpringLayout.NORTH, textField_38, 4,
				SpringLayout.NORTH, lblNewLabel_39);
		Reg_Ins_Co.add(textField_38);
		textField_38.setColumns(10);

		textField_39 = new JTextField();
		sl_Reg_Ins_Co.putConstraint(SpringLayout.EAST, textField_38, 0,
				SpringLayout.EAST, textField_39);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.NORTH, textField_39, 4,
				SpringLayout.NORTH, lblNewLabel_40);
		Reg_Ins_Co.add(textField_39);
		textField_39.setColumns(10);

		textField_40 = new JTextField();
		sl_Reg_Ins_Co.putConstraint(SpringLayout.EAST, textField_39, 0,
				SpringLayout.EAST, textField_40);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.NORTH, textField_40, 4,
				SpringLayout.NORTH, lblNewLabel_41);
		Reg_Ins_Co.add(textField_40);
		textField_40.setColumns(10);

		textField_41 = new JTextField();
		sl_Reg_Ins_Co.putConstraint(SpringLayout.EAST, textField_40, 0,
				SpringLayout.EAST, textField_41);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.NORTH, textField_41, 4,
				SpringLayout.NORTH, lblNewLabel_42);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.WEST, textField_41, 67,
				SpringLayout.EAST, lblNewLabel_42);
		Reg_Ins_Co.add(textField_41);
		textField_41.setColumns(10);

		JLabel lblNewLabel_43 = new JLabel("Email");
		sl_Reg_Ins_Co.putConstraint(SpringLayout.NORTH, lblNewLabel_43, 0,
				SpringLayout.NORTH, lblNewLabel_39);
		lblNewLabel_43.setForeground(new Color(0, 0, 102));
		lblNewLabel_43.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Reg_Ins_Co.add(lblNewLabel_43);

		JLabel lblNewLabel_44 = new JLabel("Debit");
		sl_Reg_Ins_Co.putConstraint(SpringLayout.WEST, lblNewLabel_43, 0,
				SpringLayout.WEST, lblNewLabel_44);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.SOUTH, lblNewLabel_44, 0,
				SpringLayout.SOUTH, textField_39);
		lblNewLabel_44.setForeground(new Color(0, 0, 102));
		lblNewLabel_44.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Reg_Ins_Co.add(lblNewLabel_44);

		JLabel lblNewLabel_45 = new JLabel("Credit");
		sl_Reg_Ins_Co.putConstraint(SpringLayout.WEST, lblNewLabel_44, 0,
				SpringLayout.WEST, lblNewLabel_45);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.NORTH, lblNewLabel_45, 0,
				SpringLayout.NORTH, lblNewLabel_41);
		lblNewLabel_45.setForeground(new Color(0, 0, 102));
		lblNewLabel_45.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Reg_Ins_Co.add(lblNewLabel_45);

		JLabel lblNewLabel_46 = new JLabel("Balance");
		sl_Reg_Ins_Co.putConstraint(SpringLayout.WEST, lblNewLabel_45, 0,
				SpringLayout.WEST, lblNewLabel_46);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.NORTH, lblNewLabel_46, 0,
				SpringLayout.NORTH, lblNewLabel_42);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.WEST, lblNewLabel_46, 71,
				SpringLayout.EAST, textField_41);
		lblNewLabel_46.setForeground(new Color(0, 0, 102));
		lblNewLabel_46.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Reg_Ins_Co.add(lblNewLabel_46);

		textField_42 = new JTextField();
		sl_Reg_Ins_Co.putConstraint(SpringLayout.NORTH, textField_42, 4,
				SpringLayout.NORTH, lblNewLabel_39);
		Reg_Ins_Co.add(textField_42);
		textField_42.setColumns(10);

		textField_43 = new JTextField();
		sl_Reg_Ins_Co.putConstraint(SpringLayout.EAST, textField_42, 0,
				SpringLayout.EAST, textField_43);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.NORTH, textField_43, 4,
				SpringLayout.NORTH, lblNewLabel_40);
		Reg_Ins_Co.add(textField_43);
		textField_43.setColumns(10);

		textField_44 = new JTextField();
		sl_Reg_Ins_Co.putConstraint(SpringLayout.WEST, textField_43, 0,
				SpringLayout.WEST, textField_44);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.NORTH, textField_44, 4,
				SpringLayout.NORTH, lblNewLabel_41);
		Reg_Ins_Co.add(textField_44);
		textField_44.setColumns(10);

		textField_45 = new JTextField();
		sl_Reg_Ins_Co.putConstraint(SpringLayout.WEST, textField_44, 0,
				SpringLayout.WEST, textField_45);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.NORTH, textField_45, 4,
				SpringLayout.NORTH, lblNewLabel_42);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.WEST, textField_45, 64,
				SpringLayout.EAST, lblNewLabel_46);
		Reg_Ins_Co.add(textField_45);
		textField_45.setColumns(10);

		JButton btnNewButton_18 = new JButton("Back");
		sl_Reg_Ins_Co.putConstraint(SpringLayout.WEST, btnNewButton_18, 0,
				SpringLayout.WEST, lblNewLabel_43);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.EAST, btnNewButton_18, -146,
				SpringLayout.EAST, Reg_Ins_Co);
		btnNewButton_18.setForeground(new Color(0, 0, 102));
		btnNewButton_18.setFont(new Font("Cambria Math", Font.BOLD, 18));
		btnNewButton_18.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.previous(contentPane);

			}
		});
		Reg_Ins_Co.add(btnNewButton_18);

		JButton btnNewButton_19 = new JButton("SAVE");
		sl_Reg_Ins_Co.putConstraint(SpringLayout.NORTH, btnNewButton_18, 0,
				SpringLayout.NORTH, btnNewButton_19);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.SOUTH, btnNewButton_18, 0,
				SpringLayout.SOUTH, btnNewButton_19);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.SOUTH, btnNewButton_19, -30,
				SpringLayout.SOUTH, Reg_Ins_Co);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.EAST, btnNewButton_19, 170,
				SpringLayout.WEST, lblNewLabel_39);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.NORTH, btnNewButton_19, 37,
				SpringLayout.SOUTH, textField_41);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.WEST, btnNewButton_19, 0,
				SpringLayout.WEST, lblNewLabel_39);
		btnNewButton_19.setForeground(new Color(0, 0, 102));
		btnNewButton_19.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Reg_Ins_Co.add(btnNewButton_19);

		JLabel lblRegisterInscompany = new JLabel("Register Ins.Company");
		sl_Reg_Ins_Co.putConstraint(SpringLayout.NORTH, lblRegisterInscompany,
				31, SpringLayout.NORTH, Reg_Ins_Co);
		sl_Reg_Ins_Co.putConstraint(SpringLayout.WEST, lblRegisterInscompany,
				0, SpringLayout.WEST, lblNewLabel_40);
		lblRegisterInscompany.setForeground(new Color(105, 105, 105));
		lblRegisterInscompany.setFont(new Font("Cambria Math", Font.BOLD, 30));
		Reg_Ins_Co.add(lblRegisterInscompany);

		JPanel Banks = new JPanel();
		Banks.setForeground(new Color(105, 105, 105));
		Banks.setBackground(new Color(255, 250, 250));
		contentPane.add(Banks, "name_54015925295814");
		SpringLayout sl_Banks = new SpringLayout();
		Banks.setLayout(sl_Banks);

		JButton btnNewButton_21 = new JButton("Back");
		sl_Banks.putConstraint(SpringLayout.NORTH, btnNewButton_21, 374,
				SpringLayout.NORTH, Banks);
		sl_Banks.putConstraint(SpringLayout.EAST, btnNewButton_21, -131,
				SpringLayout.EAST, Banks);
		btnNewButton_21.setForeground(new Color(0, 0, 102));
		btnNewButton_21.setFont(new Font("Cambria Math", Font.BOLD, 20));
		btnNewButton_21.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				
			}
		});
		Banks.add(btnNewButton_21);

		JLabel lblBanks = new JLabel("Banks");
		sl_Banks.putConstraint(SpringLayout.NORTH, lblBanks, 10,
				SpringLayout.NORTH, Banks);
		sl_Banks.putConstraint(SpringLayout.WEST, lblBanks, 59,
				SpringLayout.WEST, Banks);
		lblBanks.setForeground(new Color(105, 105, 105));
		lblBanks.setFont(new Font("Cambria Math", Font.BOLD, 30));
		Banks.add(lblBanks);

		JButton btnNewButton_22 = new JButton("ADD");
		sl_Banks.putConstraint(SpringLayout.NORTH, btnNewButton_22, 65,
				SpringLayout.SOUTH, lblBanks);
		sl_Banks.putConstraint(SpringLayout.WEST, btnNewButton_22, 0,
				SpringLayout.WEST, lblBanks);
		sl_Banks.putConstraint(SpringLayout.SOUTH, btnNewButton_22, 141,
				SpringLayout.SOUTH, lblBanks);
		sl_Banks.putConstraint(SpringLayout.EAST, btnNewButton_22, 171,
				SpringLayout.WEST, lblBanks);
		btnNewButton_22.setForeground(new Color(0, 0, 102));
		btnNewButton_22.setFont(new Font("Cambria Math", Font.BOLD, 20));
		btnNewButton_22.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.next(contentPane);
			}
		});
		Banks.add(btnNewButton_22);

		JButton btnNewButton_23 = new JButton("DELETE");
		sl_Banks.putConstraint(SpringLayout.NORTH, btnNewButton_23, 51,
				SpringLayout.SOUTH, btnNewButton_22);
		sl_Banks.putConstraint(SpringLayout.WEST, btnNewButton_23, 59,
				SpringLayout.WEST, Banks);
		sl_Banks.putConstraint(SpringLayout.EAST, btnNewButton_23, 0,
				SpringLayout.EAST, btnNewButton_22);
		btnNewButton_23.setForeground(new Color(0, 0, 102));
		btnNewButton_23.setFont(new Font("Cambria Math", Font.BOLD, 20));
		Banks.add(btnNewButton_23);

		JButton btnNewButton_24 = new JButton("VIEW");
		sl_Banks.putConstraint(SpringLayout.SOUTH, btnNewButton_21, 0,
				SpringLayout.SOUTH, btnNewButton_24);
		sl_Banks.putConstraint(SpringLayout.SOUTH, btnNewButton_23, -60,
				SpringLayout.NORTH, btnNewButton_24);
		sl_Banks.putConstraint(SpringLayout.WEST, btnNewButton_21, 147,
				SpringLayout.EAST, btnNewButton_24);
		sl_Banks.putConstraint(SpringLayout.SOUTH, btnNewButton_24, -42,
				SpringLayout.SOUTH, Banks);
		sl_Banks.putConstraint(SpringLayout.EAST, btnNewButton_24, 171,
				SpringLayout.WEST, lblBanks);
		sl_Banks.putConstraint(SpringLayout.NORTH, btnNewButton_24, 374,
				SpringLayout.NORTH, Banks);
		sl_Banks.putConstraint(SpringLayout.WEST, btnNewButton_24, 0,
				SpringLayout.WEST, lblBanks);
		btnNewButton_24.setForeground(new Color(0, 0, 102));
		btnNewButton_24.setFont(new Font("Cambria Math", Font.BOLD, 20));
		btnNewButton_24.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				cl.next(contentPane);
				
			}
		});
		Banks.add(btnNewButton_24);

		JPanel Add_Bank = new JPanel();
		Add_Bank.setBackground(new Color(255, 250, 250));
		contentPane.add(Add_Bank, "name_54017445595723");
		SpringLayout sl_Add_Bank = new SpringLayout();
		Add_Bank.setLayout(sl_Add_Bank);

		JLabel lblNewLabel_55 = new JLabel("Bank");
		sl_Add_Bank.putConstraint(SpringLayout.NORTH, lblNewLabel_55, 100,
				SpringLayout.NORTH, Add_Bank);
		sl_Add_Bank.putConstraint(SpringLayout.WEST, lblNewLabel_55, 49,
				SpringLayout.WEST, Add_Bank);
		lblNewLabel_55.setForeground(new Color(0, 0, 102));
		lblNewLabel_55.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Add_Bank.add(lblNewLabel_55);

		JLabel lblNewLabel_56 = new JLabel("Debit");
		sl_Add_Bank.putConstraint(SpringLayout.WEST, lblNewLabel_56, 49,
				SpringLayout.WEST, Add_Bank);
		lblNewLabel_56.setForeground(new Color(0, 0, 102));
		lblNewLabel_56.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Add_Bank.add(lblNewLabel_56);

		JLabel lblNewLabel_57 = new JLabel("Credit");
		sl_Add_Bank.putConstraint(SpringLayout.WEST, lblNewLabel_57, 53,
				SpringLayout.WEST, Add_Bank);
		sl_Add_Bank.putConstraint(SpringLayout.SOUTH, lblNewLabel_57, -221,
				SpringLayout.SOUTH, Add_Bank);
		sl_Add_Bank.putConstraint(SpringLayout.SOUTH, lblNewLabel_56, -54,
				SpringLayout.NORTH, lblNewLabel_57);
		lblNewLabel_57.setForeground(new Color(0, 0, 102));
		lblNewLabel_57.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Add_Bank.add(lblNewLabel_57);

		JLabel lblNewLabel_58 = new JLabel("Balances");
		sl_Add_Bank.putConstraint(SpringLayout.WEST, lblNewLabel_58, 0,
				SpringLayout.WEST, lblNewLabel_55);
		lblNewLabel_58.setForeground(new Color(0, 0, 102));
		lblNewLabel_58.setFont(new Font("Cambria Math", Font.BOLD, 18));
		Add_Bank.add(lblNewLabel_58);

		textField_54 = new JTextField();
		sl_Add_Bank.putConstraint(SpringLayout.EAST, lblNewLabel_55, -126,
				SpringLayout.WEST, textField_54);
		sl_Add_Bank.putConstraint(SpringLayout.NORTH, textField_54, 4,
				SpringLayout.NORTH, lblNewLabel_55);
		Add_Bank.add(textField_54);
		textField_54.setColumns(10);

		textField_55 = new JTextField();
		sl_Add_Bank.putConstraint(SpringLayout.EAST, textField_54, 0,
				SpringLayout.EAST, textField_55);
		sl_Add_Bank.putConstraint(SpringLayout.NORTH, textField_55, 4,
				SpringLayout.NORTH, lblNewLabel_56);
		Add_Bank.add(textField_55);
		textField_55.setColumns(10);

		textField_56 = new JTextField();
		sl_Add_Bank.putConstraint(SpringLayout.NORTH, textField_56, 253,
				SpringLayout.NORTH, Add_Bank);
		sl_Add_Bank.putConstraint(SpringLayout.EAST, lblNewLabel_57, -112,
				SpringLayout.WEST, textField_56);
		sl_Add_Bank.putConstraint(SpringLayout.EAST, textField_55, 0,
				SpringLayout.EAST, textField_56);
		Add_Bank.add(textField_56);
		textField_56.setColumns(10);

		textField_57 = new JTextField();
		sl_Add_Bank.putConstraint(SpringLayout.NORTH, textField_57, 325,
				SpringLayout.NORTH, Add_Bank);
		sl_Add_Bank.putConstraint(SpringLayout.NORTH, lblNewLabel_58, -4,
				SpringLayout.NORTH, textField_57);
		sl_Add_Bank.putConstraint(SpringLayout.EAST, lblNewLabel_58, -92,
				SpringLayout.WEST, textField_57);
		sl_Add_Bank.putConstraint(SpringLayout.WEST, textField_57, 218,
				SpringLayout.WEST, Add_Bank);
		sl_Add_Bank.putConstraint(SpringLayout.EAST, textField_56, 0,
				SpringLayout.EAST, textField_57);
		Add_Bank.add(textField_57);
		textField_57.setColumns(10);

		JButton btnNewButton_25 = new JButton("Back");
		btnNewButton_25.setForeground(new Color(0, 0, 102));
		btnNewButton_25.setFont(new Font("Cambria Math", Font.BOLD, 20));
		btnNewButton_25.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.previous(contentPane);
			}
		});
		Add_Bank.add(btnNewButton_25);

		JButton btnNewButton_26 = new JButton("SAVE");
		sl_Add_Bank.putConstraint(SpringLayout.NORTH, btnNewButton_25, 0,
				SpringLayout.NORTH, btnNewButton_26);
		sl_Add_Bank.putConstraint(SpringLayout.WEST, btnNewButton_25, 170,
				SpringLayout.EAST, btnNewButton_26);
		sl_Add_Bank.putConstraint(SpringLayout.SOUTH, btnNewButton_25, 0,
				SpringLayout.SOUTH, btnNewButton_26);
		sl_Add_Bank.putConstraint(SpringLayout.EAST, btnNewButton_25, 341,
				SpringLayout.EAST, btnNewButton_26);
		sl_Add_Bank.putConstraint(SpringLayout.NORTH, btnNewButton_26, 60,
				SpringLayout.SOUTH, lblNewLabel_58);
		sl_Add_Bank.putConstraint(SpringLayout.WEST, btnNewButton_26, 0,
				SpringLayout.WEST, lblNewLabel_55);
		sl_Add_Bank.putConstraint(SpringLayout.SOUTH, btnNewButton_26, 123,
				SpringLayout.SOUTH, lblNewLabel_58);
		sl_Add_Bank.putConstraint(SpringLayout.EAST, btnNewButton_26, 171,
				SpringLayout.WEST, lblNewLabel_55);
		btnNewButton_26.setForeground(new Color(0, 0, 102));
		btnNewButton_26.setFont(new Font("Cambria Math", Font.BOLD, 20));
		btnNewButton_26.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.previous(contentPane);
			}
		});
		Add_Bank.add(btnNewButton_26);

		JLabel lblAddBank = new JLabel("Add Bank");
		lblAddBank.setBackground(new Color(255, 250, 250));
		sl_Add_Bank.putConstraint(SpringLayout.NORTH, lblAddBank, 22,
				SpringLayout.NORTH, Add_Bank);
		sl_Add_Bank.putConstraint(SpringLayout.WEST, lblAddBank, 0,
				SpringLayout.WEST, lblNewLabel_55);
		lblAddBank.setForeground(new Color(105, 105, 105));
		lblAddBank.setFont(new Font("Cambria Math", Font.BOLD, 30));
		Add_Bank.add(lblAddBank);
		
		JPanel View_Cust = new JPanel();
		View_Cust.setBackground(new Color(255, 250, 250));
		contentPane.add(View_Cust, "name_60508755892939");
		SpringLayout sl_View_Cust = new SpringLayout();
		sl_View_Cust.putConstraint(SpringLayout.WEST, scrollPane_1, 10, SpringLayout.WEST, View_Cust);
		sl_View_Cust.putConstraint(SpringLayout.SOUTH, scrollPane_1, -116, SpringLayout.SOUTH, View_Cust);
		sl_View_Cust.putConstraint(SpringLayout.EAST, scrollPane_1, -10, SpringLayout.EAST, View_Cust);
		View_Cust.setLayout(sl_View_Cust);
		View_Cust.add(scrollPane_1);
		
		
		
		JButton btnAmend = new JButton("AMEND");
		sl_View_Cust.putConstraint(SpringLayout.NORTH, btnAmend, 23, SpringLayout.SOUTH, scrollPane_1);
		sl_View_Cust.putConstraint(SpringLayout.WEST, btnAmend, 74, SpringLayout.WEST, View_Cust);
		sl_View_Cust.putConstraint(SpringLayout.SOUTH, btnAmend, -20, SpringLayout.SOUTH, View_Cust);
		sl_View_Cust.putConstraint(SpringLayout.EAST, btnAmend, 267, SpringLayout.WEST, View_Cust);
		btnAmend.setForeground(new Color(25, 25, 112));
		btnAmend.setFont(new Font("Cambria Math", Font.BOLD, 20));
		View_Cust.add(btnAmend);
		
		JButton btnBack_3 = new JButton("BACK");
		sl_View_Cust.putConstraint(SpringLayout.NORTH, btnBack_3, 21, SpringLayout.SOUTH, scrollPane_1);
		sl_View_Cust.putConstraint(SpringLayout.WEST, btnBack_3, -293, SpringLayout.EAST, View_Cust);
		sl_View_Cust.putConstraint(SpringLayout.SOUTH, btnBack_3, -24, SpringLayout.SOUTH, View_Cust);
		sl_View_Cust.putConstraint(SpringLayout.EAST, btnBack_3, -117, SpringLayout.EAST, View_Cust);
		btnBack_3.setForeground(new Color(25, 25, 112));
		btnBack_3.setFont(new Font("Cambria Math", Font.BOLD, 20));
		btnBack_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				
				model.setRowCount(0);
				
			}
		});
		View_Cust.add(btnBack_3);
		
		JLabel lblViewCustomers = new JLabel("View Customers");
		sl_View_Cust.putConstraint(SpringLayout.NORTH, scrollPane_1, 16, SpringLayout.SOUTH, lblViewCustomers);
		lblViewCustomers.setForeground(new Color(128, 128, 128));
		lblViewCustomers.setFont(new Font("Cambria Math", Font.BOLD, 30));
		sl_View_Cust.putConstraint(SpringLayout.NORTH, lblViewCustomers, 27, SpringLayout.NORTH, View_Cust);
		sl_View_Cust.putConstraint(SpringLayout.WEST, lblViewCustomers, 64, SpringLayout.WEST, View_Cust);
		sl_View_Cust.putConstraint(SpringLayout.SOUTH, lblViewCustomers, 85, SpringLayout.NORTH, View_Cust);
		sl_View_Cust.putConstraint(SpringLayout.EAST, lblViewCustomers, 347, SpringLayout.WEST, View_Cust);
		View_Cust.add(lblViewCustomers);
		
		JPanel View_Debtors = new JPanel();
		View_Debtors.setBackground(new Color(255, 250, 250));
		contentPane.add(View_Debtors, "name_62207383553595");
		SpringLayout sl_View_Debtors = new SpringLayout();
		View_Debtors.setLayout(sl_View_Debtors);
		
		JScrollPane scrollPane = new JScrollPane();
		sl_View_Debtors.putConstraint(SpringLayout.NORTH, scrollPane, 88, SpringLayout.NORTH, View_Debtors);
		sl_View_Debtors.putConstraint(SpringLayout.WEST, scrollPane, 10, SpringLayout.WEST, View_Debtors);
		sl_View_Debtors.putConstraint(SpringLayout.SOUTH, scrollPane, 309, SpringLayout.NORTH, View_Debtors);
		sl_View_Debtors.putConstraint(SpringLayout.EAST, scrollPane, -10, SpringLayout.EAST, View_Debtors);
		View_Debtors.add(scrollPane);
		
		table_2 = new JTable();
		scrollPane.setViewportView(table_2);
		
		JButton btnAmend_1 = new JButton("AMEND");
		sl_View_Debtors.putConstraint(SpringLayout.NORTH, btnAmend_1, 54, SpringLayout.SOUTH, scrollPane);
		sl_View_Debtors.putConstraint(SpringLayout.WEST, btnAmend_1, 54, SpringLayout.WEST, View_Debtors);
		sl_View_Debtors.putConstraint(SpringLayout.SOUTH, btnAmend_1, -52, SpringLayout.SOUTH, View_Debtors);
		btnAmend_1.setForeground(new Color(25, 25, 112));
		btnAmend_1.setFont(new Font("Cambria Math", Font.BOLD, 20));
		View_Debtors.add(btnAmend_1);
		
		JButton btnBack_4 = new JButton("BACK");
		sl_View_Debtors.putConstraint(SpringLayout.NORTH, btnBack_4, 0, SpringLayout.NORTH, btnAmend_1);
		sl_View_Debtors.putConstraint(SpringLayout.WEST, btnBack_4, 128, SpringLayout.EAST, btnAmend_1);
		sl_View_Debtors.putConstraint(SpringLayout.SOUTH, btnBack_4, -52, SpringLayout.SOUTH, View_Debtors);
		sl_View_Debtors.putConstraint(SpringLayout.EAST, btnBack_4, -165, SpringLayout.EAST, View_Debtors);
		btnBack_4.setForeground(new Color(25, 25, 112));
		btnBack_4.setFont(new Font("Cambria Math", Font.BOLD, 20));
		btnBack_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
			}
		});
		View_Debtors.add(btnBack_4);
		
		JLabel lblNewLabel_8 = new JLabel("View Debtors");
		sl_View_Debtors.putConstraint(SpringLayout.EAST, btnAmend_1, -17, SpringLayout.EAST, lblNewLabel_8);
		lblNewLabel_8.setForeground(new Color(128, 128, 128));
		lblNewLabel_8.setFont(new Font("Cambria Math", Font.BOLD, 30));
		sl_View_Debtors.putConstraint(SpringLayout.NORTH, lblNewLabel_8, 26, SpringLayout.NORTH, View_Debtors);
		sl_View_Debtors.putConstraint(SpringLayout.WEST, lblNewLabel_8, 45, SpringLayout.WEST, View_Debtors);
		View_Debtors.add(lblNewLabel_8);
		
		JPanel View_Companies = new JPanel();
		View_Companies.setBackground(new Color(255, 250, 250));
		contentPane.add(View_Companies, "name_62216887007490");
		SpringLayout sl_View_Companies = new SpringLayout();
		View_Companies.setLayout(sl_View_Companies);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		sl_View_Companies.putConstraint(SpringLayout.WEST, scrollPane_2, 10, SpringLayout.WEST, View_Companies);
		sl_View_Companies.putConstraint(SpringLayout.SOUTH, scrollPane_2, -165, SpringLayout.SOUTH, View_Companies);
		sl_View_Companies.putConstraint(SpringLayout.EAST, scrollPane_2, -10, SpringLayout.EAST, View_Companies);
		View_Companies.add(scrollPane_2);
		
		table_3 = new JTable();
		scrollPane_2.setViewportView(table_3);
		
		JButton btnAmend_2 = new JButton("AMEND");
		sl_View_Companies.putConstraint(SpringLayout.NORTH, btnAmend_2, 53, SpringLayout.SOUTH, scrollPane_2);
		sl_View_Companies.putConstraint(SpringLayout.WEST, btnAmend_2, 74, SpringLayout.WEST, View_Companies);
		sl_View_Companies.putConstraint(SpringLayout.SOUTH, btnAmend_2, -55, SpringLayout.SOUTH, View_Companies);
		sl_View_Companies.putConstraint(SpringLayout.EAST, btnAmend_2, 269, SpringLayout.WEST, View_Companies);
		btnAmend_2.setFont(new Font("Cambria Math", Font.BOLD, 20));
		View_Companies.add(btnAmend_2);
		
		JButton btnBack_5 = new JButton("BACK");
		sl_View_Companies.putConstraint(SpringLayout.NORTH, btnBack_5, 53, SpringLayout.SOUTH, scrollPane_2);
		sl_View_Companies.putConstraint(SpringLayout.WEST, btnBack_5, 58, SpringLayout.EAST, btnAmend_2);
		sl_View_Companies.putConstraint(SpringLayout.SOUTH, btnBack_5, 0, SpringLayout.SOUTH, btnAmend_2);
		sl_View_Companies.putConstraint(SpringLayout.EAST, btnBack_5, -157, SpringLayout.EAST, View_Companies);
		btnBack_5.setFont(new Font("Cambria Math", Font.BOLD, 20));
		btnBack_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
			}
		});
		View_Companies.add(btnBack_5);
		
		JLabel lblNewLabel_9 = new JLabel("View Companies");
		sl_View_Companies.putConstraint(SpringLayout.NORTH, scrollPane_2, 22, SpringLayout.SOUTH, lblNewLabel_9);
		lblNewLabel_9.setForeground(new Color(128, 128, 128));
		lblNewLabel_9.setFont(new Font("Cambria Math", Font.BOLD, 30));
		sl_View_Companies.putConstraint(SpringLayout.NORTH, lblNewLabel_9, 26, SpringLayout.NORTH, View_Companies);
		sl_View_Companies.putConstraint(SpringLayout.WEST, lblNewLabel_9, 44, SpringLayout.WEST, View_Companies);
		View_Companies.add(lblNewLabel_9);
		
		JPanel View_Banks = new JPanel();
		View_Banks.setBackground(new Color(255, 250, 250));
		contentPane.add(View_Banks, "name_62332575784650");
		SpringLayout sl_View_Banks = new SpringLayout();
		View_Banks.setLayout(sl_View_Banks);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		sl_View_Banks.putConstraint(SpringLayout.WEST, scrollPane_3, 10, SpringLayout.WEST, View_Banks);
		sl_View_Banks.putConstraint(SpringLayout.SOUTH, scrollPane_3, -197, SpringLayout.SOUTH, View_Banks);
		sl_View_Banks.putConstraint(SpringLayout.EAST, scrollPane_3, 669, SpringLayout.WEST, View_Banks);
		View_Banks.add(scrollPane_3);
		
		table_4 = new JTable();
		scrollPane_3.setViewportView(table_4);
		
		JButton btnNewButton_4 = new JButton("AMEND");
		sl_View_Banks.putConstraint(SpringLayout.NORTH, btnNewButton_4, 69, SpringLayout.SOUTH, scrollPane_3);
		sl_View_Banks.putConstraint(SpringLayout.WEST, btnNewButton_4, 65, SpringLayout.WEST, View_Banks);
		sl_View_Banks.putConstraint(SpringLayout.SOUTH, btnNewButton_4, -75, SpringLayout.SOUTH, View_Banks);
		btnNewButton_4.setForeground(new Color(0, 0, 128));
		btnNewButton_4.setFont(new Font("Cambria Math", Font.BOLD, 20));
		View_Banks.add(btnNewButton_4);
		
		JButton btnBack_6 = new JButton("BACK");
		sl_View_Banks.putConstraint(SpringLayout.NORTH, btnBack_6, 69, SpringLayout.SOUTH, scrollPane_3);
		sl_View_Banks.putConstraint(SpringLayout.WEST, btnBack_6, 105, SpringLayout.EAST, btnNewButton_4);
		sl_View_Banks.putConstraint(SpringLayout.SOUTH, btnBack_6, 122, SpringLayout.SOUTH, scrollPane_3);
		sl_View_Banks.putConstraint(SpringLayout.EAST, btnBack_6, 286, SpringLayout.EAST, btnNewButton_4);
		btnBack_6.setForeground(new Color(0, 0, 128));
		btnBack_6.setFont(new Font("Cambria Math", Font.BOLD, 20));
		btnBack_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) contentPane.getLayout();
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
				cl.previous(contentPane);
			}
		});
		View_Banks.add(btnBack_6);
		
		JLabel lblNewLabel_10 = new JLabel("View Banks");
		sl_View_Banks.putConstraint(SpringLayout.EAST, btnNewButton_4, 26, SpringLayout.EAST, lblNewLabel_10);
		sl_View_Banks.putConstraint(SpringLayout.NORTH, scrollPane_3, 25, SpringLayout.SOUTH, lblNewLabel_10);
		lblNewLabel_10.setForeground(new Color(128, 128, 128));
		lblNewLabel_10.setFont(new Font("Cambria Math", Font.BOLD, 30));
		sl_View_Banks.putConstraint(SpringLayout.NORTH, lblNewLabel_10, 36, SpringLayout.NORTH, View_Banks);
		sl_View_Banks.putConstraint(SpringLayout.WEST, lblNewLabel_10, 50, SpringLayout.WEST, View_Banks);
		View_Banks.add(lblNewLabel_10);
	}
}
