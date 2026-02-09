package controller;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JOptionPane;

import controller.customer.Customer_register_Ui;
import controller.employee.Employee_login_Ui;
import controller.product.Product_Ui;
import model.Customer;
import service.customer.CustomerServiceImpl;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StartUi extends JFrame {
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField costomer_account_input;
	private JTextField customer_password_input;
	private JTextField employee_account_input;
	private JPasswordField emplyoee_password_input;

	/**
	 * Launch the application.
	 */
	
	
	public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            try {
                StartUi frame = new StartUi(null); // 啟動登入視窗
                frame.setVisible(true);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

	/**
	 * Create the frame.
	 */
	public StartUi(Customer customer) {
		
		 
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 773, 517);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("天天新鮮麵包訂購系統");
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 36));
		lblNewLabel.setBounds(166, 10, 379, 65);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 128, 128));
		panel.setBounds(10, 65, 357, 403);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("客戶登入");
		lblNewLabel_1.setBackground(new Color(255, 255, 255));
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 38));
		lblNewLabel_1.setBounds(90, 20, 165, 56);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("帳號:");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 29));
		lblNewLabel_2.setBounds(10, 110, 80, 37);
		panel.add(lblNewLabel_2);
		
		costomer_account_input = new JTextField();
		costomer_account_input.setBounds(90, 110, 181, 37);
		panel.add(costomer_account_input);
		costomer_account_input.setColumns(10);
		
		JLabel lblNewLabel_2_1 = new JLabel("密碼:");
		lblNewLabel_2_1.setFont(new Font("新細明體", Font.BOLD, 29));
		lblNewLabel_2_1.setBounds(10, 171, 80, 37);
		panel.add(lblNewLabel_2_1);
		
		customer_password_input = new JTextField();
		customer_password_input.setColumns(10);
		customer_password_input.setBounds(90, 171, 181, 37);
		panel.add(customer_password_input);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(377, 65, 370, 403);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("員工登入");
		lblNewLabel_1_1.setBounds(98, 20, 167, 57);
		lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 38));
		lblNewLabel_1_1.setBackground(Color.WHITE);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("帳號:");
		lblNewLabel_2_2.setFont(new Font("新細明體", Font.BOLD, 29));
		lblNewLabel_2_2.setBounds(8, 97, 80, 37);
		panel_1.add(lblNewLabel_2_2);
		
		employee_account_input = new JTextField();
		employee_account_input.setColumns(10);
		employee_account_input.setBounds(98, 100, 181, 37);
		panel_1.add(employee_account_input);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("密碼:");
		lblNewLabel_2_1_1.setFont(new Font("新細明體", Font.BOLD, 29));
		lblNewLabel_2_1_1.setBounds(8, 173, 80, 37);
		panel_1.add(lblNewLabel_2_1_1);
		
		emplyoee_password_input = new JPasswordField();
		emplyoee_password_input.setColumns(10);
		emplyoee_password_input.setBounds(98, 173, 181, 37);
		panel_1.add(emplyoee_password_input);
		
		
/*****************************************event****************************/
		
		CustomerServiceImpl customer_service_impl=new CustomerServiceImpl();
		service.employee.EmployeeServiceImpl employee_service = new service.employee.EmployeeServiceImpl();
		
		JButton employee_comfirm_button = new JButton("確認");
		employee_comfirm_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String account = employee_account_input.getText().trim();
			    String password = new String(emplyoee_password_input.getPassword()); // 建議使用 JPasswordField 以維護安全性

			    // 3. 呼叫 Service 進行資料庫比對 (MVC 核心)
			    model.Employee loginEmp = employee_service.login(account, password);

			    // 4. 根據驗證結果進行跳頁或提示
			    if (loginEmp != null) {
			        // --- 登入成功 (True) ---
			        JOptionPane.showMessageDialog(null, "登入成功！歡迎 " + loginEmp.getEmployee_name());
			        
			        // 跳轉至下一頁 (例如 Product_Ui)，並傳入登入成功的員工物件
			        Employee_login_Ui nextTable = new Employee_login_Ui(loginEmp); 
			        nextTable.setVisible(true);

			     // 3. 此時變數才有效，可以呼叫 dispose()
			        StartUi.this.dispose();
			        
			        
			    } else {
			        // --- 登入失敗 (False) ---
			        JOptionPane.showMessageDialog(null, "帳號或密碼錯誤，請重新輸入", "登入失敗", JOptionPane.ERROR_MESSAGE);
			        
			        // 清空密碼框，方便使用者重新輸入
			        emplyoee_password_input.setText("");
			        employee_account_input.requestFocus(); // 將游標自動移回帳號框
			    }
			}
		});
		employee_comfirm_button.setFont(new Font("新細明體", Font.BOLD, 29));
		employee_comfirm_button.setBounds(175, 258, 104, 50);
		panel_1.add(employee_comfirm_button);
		
		
		//此為客戶註冊按鈕，用來點擊新增到客戶資料庫
		JButton customer_register_button = new JButton("註冊");
		customer_register_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Customer_register_Ui customer_register_ui=new Customer_register_Ui();
				customer_register_ui.setVisible(true);
				dispose();
						
			}
		});
		customer_register_button.setFont(new Font("新細明體", Font.BOLD, 29));
		customer_register_button.setBounds(24, 261, 104, 45);
		panel.add(customer_register_button);
		
		JButton customer_comfirm_button = new JButton("確認");
		customer_comfirm_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Customer customer = customer_service_impl.find_customerdata_by_user_account_password(
					    costomer_account_input.getText(), 
					    customer_password_input.getText()
					);

					// 2. 判斷物件是否不為 null (代表登入成功)
				if (customer != null) {
				    // 1. 顯示成功訊息
				    JOptionPane.showMessageDialog(null, "登入成功!!\n" + customer.getCustomer_name() + "\t歡迎你!");
				    
				    // 2. 關鍵修正：將上面撈出來的 customer 物件傳進去
				    Product_Ui product_ui = new Product_Ui(customer); 
				    
				    // 3. 顯示新視窗並關閉舊視窗
				    product_ui.setVisible(true);
				    dispose(); 
				}else {
					    // 登入失敗：顯示錯誤訊息
						JOptionPane.showMessageDialog(
						        null, 
						        "帳號或密碼錯誤，請重新輸入！", 
						        "登入失敗", 
						        JOptionPane.ERROR_MESSAGE
						    );
					}
			}
		});
		customer_comfirm_button.setFont(new Font("新細明體", Font.BOLD, 29));
		customer_comfirm_button.setBounds(173, 261, 98, 45);
		panel.add(customer_comfirm_button);
		
	}
}
