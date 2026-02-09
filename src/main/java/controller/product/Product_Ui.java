package controller.product;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controller.OrderController;
import dao.product.ProductDaoImpl;
import model.Customer;
import model.Employee;
import model.Product;
import service.employee.EmployeeServiceImpl;
import service.product.ProductService;
import service.product.ProductServiceImpl;
import util.Tool;
import view.ButtonColumn;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.util.List;

import javax.swing.JTable;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Product_Ui extends JFrame {

	 private static final long serialVersionUID = 1L;
	    private JPanel contentPane;
	    private JTextField amount_input;
	    private JTable table;
	    private JLabel show_price; 
	    private JLabel show_this_totalprice;
	    private Customer loginCustomer; // 確保有這行

	    // 1. 進入點
	    public static void main(String[] args) {
	        EventQueue.invokeLater(() -> {
	            try {
	                Product_Ui frame = new Product_Ui();
	                frame.setVisible(true);
	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        });
	    }

	    // 2. 有參數建構子 (供 StartUi 呼叫)
	    public Product_Ui(Customer customer) {
	        this.loginCustomer = customer;
	        initComponents(); // 呼叫下方定義的方法
	    }

	    // 3. 無參數建構子 (供測試使用)
	    public Product_Ui() {
	        this(null);
	    }
	/**
	 * Create the frame.
	 */
	    private void initComponents() {
	    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setBounds(100, 100, 1076, 626);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);
			
			JPanel panel = new JPanel();
			panel.setBackground(new Color(255, 255, 128));
			panel.setBounds(10, 10, 1040, 567);
			contentPane.add(panel);
			panel.setLayout(null);
			
			JPanel panel_1 = new JPanel();
			panel_1.setBounds(10, 10, 296, 59);
			panel.add(panel_1);
			panel_1.setBackground(new Color(255, 128, 64));
			panel_1.setLayout(null);
			
			JLabel lblNewLabel = new JLabel("產品訂購");
			lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 26));
			lblNewLabel.setBounds(86, 10, 112, 38);
			panel_1.add(lblNewLabel);
			
			JPanel panel_2 = new JPanel();
			panel_2.setBackground(new Color(192, 192, 192));
			panel_2.setBounds(10, 89, 296, 307);
			panel.add(panel_2);
			panel_2.setLayout(null);
			
			JComboBox<Product> productComboBox = new JComboBox<>();
			productComboBox.setBounds(77, 10, 200, 30);
			panel_2.add(productComboBox);
			
			
			JLabel lblNewLabel_1 = new JLabel("產品名稱:");
			lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 14));
			lblNewLabel_1.setBounds(10, 10, 68, 30);
			panel_2.add(lblNewLabel_1);
			
			JLabel lblNewLabel_1_1 = new JLabel("    數量:");
			lblNewLabel_1_1.setFont(new Font("新細明體", Font.BOLD, 14));
			lblNewLabel_1_1.setBounds(10, 62, 68, 30);
			panel_2.add(lblNewLabel_1_1);
			
			amount_input = new JTextField();
			amount_input.setBounds(77, 63, 200, 30);
			panel_2.add(amount_input);
			amount_input.setColumns(10);
			
			JLabel lblNewLabel_1_2 = new JLabel("產品單價:");
			lblNewLabel_1_2.setFont(new Font("新細明體", Font.BOLD, 14));
			lblNewLabel_1_2.setBounds(10, 113, 68, 30);
			panel_2.add(lblNewLabel_1_2);
			
			show_price = new JLabel(""); 
	        show_price.setFont(new Font("新細明體", Font.BOLD, 22));
	        show_price.setBounds(77, 109, 136, 34);
	        panel_2.add(show_price);
			
			JLabel lblNewLabel_1_2_1 = new JLabel("元");
			lblNewLabel_1_2_1.setFont(new Font("新細明體", Font.BOLD, 14));
			lblNewLabel_1_2_1.setBounds(223, 113, 54, 30);
			panel_2.add(lblNewLabel_1_2_1);
			
			JLabel lblNewLabel_1_2_2 = new JLabel("預計總價:");
			lblNewLabel_1_2_2.setFont(new Font("新細明體", Font.BOLD, 14));
			lblNewLabel_1_2_2.setBounds(10, 153, 68, 30);
			panel_2.add(lblNewLabel_1_2_2);
			
			show_this_totalprice = new JLabel("");
			show_this_totalprice.setFont(new Font("新細明體", Font.BOLD, 22));
			show_this_totalprice.setBounds(77, 153, 136, 34);
			panel_2.add(show_this_totalprice);
			
			JLabel lblNewLabel_1_2_1_1 = new JLabel("元");
			lblNewLabel_1_2_1_1.setFont(new Font("新細明體", Font.BOLD, 14));
			lblNewLabel_1_2_1_1.setBounds(220, 153, 54, 30);
			panel_2.add(lblNewLabel_1_2_1_1);
			
			JComboBox<Employee> employeeComboBox = new JComboBox<>();
			employeeComboBox.setBounds(77, 200, 200, 30); // 調整座標，避免重疊
			panel_2.add(employeeComboBox);
			
			JLabel lblNewLabel_1_3 = new JLabel("負責員工:");
			lblNewLabel_1_3.setFont(new Font("新細明體", Font.BOLD, 14));
			lblNewLabel_1_3.setBounds(10, 200, 68, 30);
			panel_2.add(lblNewLabel_1_3);
			
			JLabel time = new JLabel("");
			time.setFont(new Font("新細明體", Font.PLAIN, 17));
			time.setBounds(326, 406, 288, 35);
			panel.add(time);
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

			// 2. 建立 Swing Timer (每 1000 毫秒執行一次，即 1 秒)
			javax.swing.Timer timer = new javax.swing.Timer(1000, new java.awt.event.ActionListener() {
			    @Override
			    public void actionPerformed(java.awt.event.ActionEvent e) {
			        // 抓取當下系統時間並更新 JLabel
			        time.setText("系統時間：" + sdf.format(new java.util.Date()));
			    }
			});

			// 3. 啟動計時器
			timer.start();

			
			
			//此為表格最上方的欄位名稱
			String[] columns = {"訂單編號", "客戶姓名", "負責員工", "產品名稱", "數量", "總價", "操作", "P_NO", "E_NO"};

			DefaultTableModel model = new DefaultTableModel(null, columns) {
			    @Override
			    public boolean isCellEditable(int row, int column) {
			        return column == 6; // 只有按鈕那一欄可以點
			    }
			};

			table = new JTable(model);
			// --- 隱藏最後兩欄 ---
			table.getColumnModel().getColumn(7).setMinWidth(0);
			table.getColumnModel().getColumn(7).setMaxWidth(0);
			table.getColumnModel().getColumn(8).setMinWidth(0);
			table.getColumnModel().getColumn(8).setMaxWidth(0);
			
			JScrollPane scrollPane = new JScrollPane(table);
			scrollPane.setBounds(316, 10, 714, 386);
			panel.add(scrollPane); // 必須確保 panel 已經存在

			// 關鍵：這行必須在上述步驟完成後
			new ButtonColumn(table, 6); 
			 
			 
			/**********************event********************************/
			//工具列
			Connection connection = Tool.connect_with_database();
			ProductServiceImpl product_service = new ProductServiceImpl();
			EmployeeServiceImpl employee_service = new EmployeeServiceImpl();
			

			JButton print_NewButton = new JButton("列印");
			print_NewButton.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					if (table.getRowCount() == 0) {
				        JOptionPane.showMessageDialog(null, "目前清單為空，無法列印");
				        return;
				    }

				    try {
				        // 2. 設定列印參數
				        // MessageFormat 讓你可以定義標頭 (Header) 與 頁尾 (Footer)
				        java.text.MessageFormat header = new java.text.MessageFormat("麵包店訂單清單");
				        java.text.MessageFormat footer = new java.text.MessageFormat("頁碼 {0}");

				        // 3. 執行列印 (會自動彈出系統列印對話框)
				        // JTable.PrintMode.FIT_WIDTH 確保表格內容縮放至紙張寬度
				        boolean complete = table.print(JTable.PrintMode.FIT_WIDTH, header, footer);

				        if (complete) {
				            JOptionPane.showMessageDialog(null, "列印完成");
				        } else {
				            JOptionPane.showMessageDialog(null, "列印已取消");
				        }
				    } catch (java.awt.print.PrinterException ex) {
				        JOptionPane.showMessageDialog(null, "列印出錯: " + ex.getMessage());
				        ex.printStackTrace();
				    }
				}
			});
			print_NewButton.setBounds(694, 406, 140, 35);
			panel.add(print_NewButton);
			
			// jtable都新增完後，點擊將資料送入資料庫
			JButton to_data_base = new JButton("送出");
			to_data_base.setBounds(895, 406, 135, 35);
			panel.add(to_data_base);

			to_data_base.addActionListener(e -> {
			    DefaultTableModel tableModel = (DefaultTableModel) table.getModel();
			    int rowCount = tableModel.getRowCount();
			    if (rowCount == 0) {
			        JOptionPane.showMessageDialog(null, "清單內無資料可送出");
			        return;
			    }
			    controller.OrderController orderController = new controller.OrderController();
			    int startId = (int)(System.currentTimeMillis() % 100000); 

			    for (int i = 0; i < rowCount; i++) {
			        if ("待送出".equals(tableModel.getValueAt(i, 0))) {
			            model.Orders order = new model.Orders();
			            int currentId = startId + i;
			            order.setOrders_id(currentId);
			            order.setOrders_no("ORD" + currentId);
			            order.setCustomer_no((this.loginCustomer != null) 
			                     ? this.loginCustomer.getCustomer_no() 
			                     : "C001"); // C001 需為資料庫中存在的預設編號
			            order.setProduct_no((String) tableModel.getValueAt(i, 7));  
			            order.setEmployee_no((String) tableModel.getValueAt(i, 8)); 
			            order.setAmount((int) tableModel.getValueAt(i, 4));
			            int totalPrice = Integer.parseInt(tableModel.getValueAt(i, 5).toString());
			            order.setTotal_price(totalPrice);
			            orderController.processOrder(order);
			            tableModel.setValueAt(currentId, i, 0); 
			        }
			    }
			    JOptionPane.showMessageDialog(null, "訂單已送出!!歡迎再次選購");
			});

			// --- 3. [員工選單] 載入 ---
			List<Employee> allEmployees = employee_service.select_all_employees();
			for (Employee emp : allEmployees) {
			    employeeComboBox.addItem(emp); 
			}
			if (employeeComboBox.getItemCount() > 0) {
			    employeeComboBox.setSelectedIndex(0);
			}

			// --- 4. [新增按鈕] 事件 ---
			JButton btnNewButton = new JButton("新增");
			btnNewButton.setBounds(178, 267, 99, 30);
			panel_2.add(btnNewButton);
			
			JButton button = new JButton("New button");
			button.setBounds(895, 494, -38, 35);
			panel.add(button);
			
			JButton close_button = new JButton("關閉");
			close_button.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					System.exit(0);
				}
			});
			close_button.setBounds(895, 494, 135, 35);
			panel.add(close_button);
			
			
			btnNewButton.addActionListener(e -> {
			    model.Product selectedProduct = (model.Product) productComboBox.getSelectedItem();
			    String amountStr = amount_input.getText().trim();
			    model.Employee selectedEmp = (model.Employee) employeeComboBox.getSelectedItem();

			    if (selectedEmp == null || amountStr.isEmpty() || !amountStr.matches("\\d+")) {
			        JOptionPane.showMessageDialog(null, "請確認員工已選擇且數量為數字");
			        return;
			    }

			    String col1 = "待送出"; 
			    String col2 = (this.loginCustomer != null) 
			              ? this.loginCustomer.getCustomer_name() 
			              : "測試訪客";
			    String col3 = selectedEmp.getEmployee_name();  
			    String col4 = selectedProduct.getProduct_name(); 
			    Integer col5 = Integer.parseInt(amountStr);
			    String col6 = product_service.calculate_total_price(selectedProduct.getProduct_cost(), amountStr);

			    Object[] rowdata = {col1, col2, col3, col4, col5, col6, "刪除", 
			                        selectedProduct.getProduct_no(), selectedEmp.getEmployee_no()};
			    model.addRow(rowdata);
			    amount_input.setText("");
			    show_this_totalprice.setText("");
			}); // <--- 注意這裡：原本這裡少括號，導致後面的程式碼失效

			// --- 5. [產品選單] 載入與監聽 ---
			List<Product> allProducts = product_service.select_all();
			for (Product p : allProducts) {
			    productComboBox.addItem(p); 
			}

			if (productComboBox.getItemCount() > 0) {
			    productComboBox.setSelectedIndex(0); 
			    Product first = (Product) productComboBox.getSelectedItem();
			    show_price.setText(String.valueOf(first.getProduct_cost())); 
			}

			productComboBox.addActionListener(evt -> {
			    Object selectedItem = productComboBox.getSelectedItem();
			    if (selectedItem instanceof model.Product) {
			        model.Product currentProduct = (model.Product) selectedItem;
			        show_price.setText(String.valueOf(currentProduct.getProduct_cost()));
			        String inputAmount = amount_input.getText().trim();
			        if (inputAmount.isEmpty()) inputAmount = "0";
			        String totalVal = product_service.calculate_total_price(currentProduct.getProduct_cost(), inputAmount);
			        show_this_totalprice.setText(totalVal);
			    }
			});

			// --- 6. [數量輸入] 監聽 ---
			amount_input.addKeyListener(new java.awt.event.KeyAdapter() {
			    @Override
			    public void keyReleased(java.awt.event.KeyEvent e) {
			        model.Product selectedProduct = (model.Product) productComboBox.getSelectedItem();
			        if (selectedProduct != null) {
			            String amountStr = amount_input.getText().trim();
			            if (amountStr.isEmpty()) amountStr = "0";
			            String total = product_service.calculate_total_price(selectedProduct.getProduct_cost(), amountStr);
			            show_this_totalprice.setText(total);
			        }
			    }
			});
			
	   
}
}
