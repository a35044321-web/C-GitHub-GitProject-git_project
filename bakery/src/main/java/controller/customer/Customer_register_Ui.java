package controller.customer;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controller.StartUi;
import model.Customer;
import service.customer.CustomerServiceImpl;
import util.Tool;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;

public class Customer_register_Ui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField customer_no_input;
	private JTextField customer_name_input;
	private JTextField customer_adress_input;
	private JTextField customer_account_input;
	private JTextField customer_password_input;
	private JTextField customer_phone_number_input;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer_register_Ui frame = new Customer_register_Ui();
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
	public Customer_register_Ui() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 641, 514);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("使用者註冊頁面");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 41));
		lblNewLabel.setBounds(165, 10, 296, 54);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 74, 605, 401);
		contentPane.add(panel);
		panel.setLayout(null);
		
		customer_no_input = new JTextField();
		customer_no_input.setBounds(112, 24, 165, 28);
		panel.add(customer_no_input);
		customer_no_input.setColumns(10);
		
		customer_name_input = new JTextField();
		customer_name_input.setColumns(10);
		customer_name_input.setBounds(112, 62, 165, 28);
		panel.add(customer_name_input);
		
		customer_adress_input = new JTextField();
		customer_adress_input.setColumns(10);
		customer_adress_input.setBounds(112, 139, 165, 28);
		panel.add(customer_adress_input);
		
		JLabel lblNewLabel_1_1_1_1 = new JLabel("使用者帳號:");
		lblNewLabel_1_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 19));
		lblNewLabel_1_1_1_1.setBounds(10, 173, 117, 33);
		panel.add(lblNewLabel_1_1_1_1);
		
		customer_account_input = new JTextField();
		customer_account_input.setColumns(10);
		customer_account_input.setBounds(112, 177, 165, 28);
		panel.add(customer_account_input);
		
		JLabel lblNewLabel_1_1_1_1_1 = new JLabel("使用者地址:");
		lblNewLabel_1_1_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 19));
		lblNewLabel_1_1_1_1_1.setBounds(10, 135, 117, 33);
		panel.add(lblNewLabel_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_1 = new JLabel("使用者姓名:");
		lblNewLabel_1_1_1_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 19));
		lblNewLabel_1_1_1_1_1_1.setBounds(10, 62, 117, 33);
		panel.add(lblNewLabel_1_1_1_1_1_1);
		
		JLabel lblNewLabel_1_1_1_1_1_2 = new JLabel("使用者編號:");
		lblNewLabel_1_1_1_1_1_2.setFont(new Font("新細明體", Font.PLAIN, 19));
		lblNewLabel_1_1_1_1_1_2.setBounds(10, 24, 117, 33);
		panel.add(lblNewLabel_1_1_1_1_1_2);
		
		JLabel lblNewLabel_1_1_1_1_2 = new JLabel("使用者密碼:");
		lblNewLabel_1_1_1_1_2.setFont(new Font("新細明體", Font.PLAIN, 19));
		lblNewLabel_1_1_1_1_2.setBounds(10, 216, 117, 28);
		panel.add(lblNewLabel_1_1_1_1_2);
		
		customer_password_input = new JTextField();
		customer_password_input.setColumns(10);
		customer_password_input.setBounds(112, 216, 165, 28);
		panel.add(customer_password_input);
		
		JLabel lblNewLabel_1_1_1_1_1_1_1 = new JLabel("使用者電話:");
		lblNewLabel_1_1_1_1_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 19));
		lblNewLabel_1_1_1_1_1_1_1.setBounds(10, 100, 117, 33);
		panel.add(lblNewLabel_1_1_1_1_1_1_1);
		
		customer_phone_number_input = new JTextField();
		customer_phone_number_input.setColumns(10);
		customer_phone_number_input.setBounds(112, 100, 165, 28);
		panel.add(customer_phone_number_input);
		
		
		JTextArea output = new JTextArea();
		output.setBounds(297, 24, 280, 331);
		panel.add(output);
		
		JLabel show_time = new JLabel("讀取時間...");
		show_time.setBounds(10, 305, 145, 51);
		panel.add(show_time);
		show_time.setFont(new Font("微軟正黑體 Light", Font.BOLD, 15));
		new javax.swing.Timer(1000, e -> {
			show_time.setText(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
	    }).start();
		
		/***************************event***************************************/
		
		
		CustomerServiceImpl customer_service_impl=new CustomerServiceImpl();
		
		//此為確認按鈕，用來判斷user輸入的數值是否正確。
		JButton btnNewButton = new JButton("確認");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(customer_service_impl.find_customerdata_by_user_account(customer_account_input.getText())) {
				String customer_no=customer_no_input.getText();
				String customer_name=customer_name_input.getText();
				String customer_phone_number=customer_phone_number_input.getText();
				String customer_adress=customer_adress_input.getText();
				String user_account=customer_account_input.getText();
				String user_password=customer_password_input.getText();
				Customer customer=new Customer(customer_no,customer_name,customer_phone_number,customer_adress,user_account,user_password);
				CustomerServiceImpl customerserviceimpl=new CustomerServiceImpl();
				customerserviceimpl.add_customer(customer);
				output.setText("註冊成功!");
				}else {
					output.setText("帳號重複，請重新輸入!");
				}
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 18));
		btnNewButton.setBounds(190, 308, 87, 47);
		panel.add(btnNewButton);
		
		
		//此為清除所有輸入資料
		JButton clean_input_field = new JButton("清除");
		clean_input_field.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				customer_no_input.setText("");
				customer_name_input.setText("");
				customer_phone_number_input.setText("");
				customer_adress_input.setText("");
				customer_account_input.setText("");
				customer_password_input.setText("");
			}
		});
		clean_input_field.setFont(new Font("新細明體", Font.PLAIN, 18));
		clean_input_field.setBounds(190, 254, 87, 47);
		panel.add(clean_input_field);
		
		
		
		//此為返回上一頁，至登入頁面
		JButton back_to_start_page = new JButton("返回");
		back_to_start_page.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StartUi back_to_start_page=new StartUi(null);
				back_to_start_page.setVisible(true);
				dispose();
			}
		});
		back_to_start_page.setFont(new Font("新細明體", Font.PLAIN, 18));
		back_to_start_page.setBounds(10, 254, 87, 47);
		panel.add(back_to_start_page);
		
		
		
		

	}
}
