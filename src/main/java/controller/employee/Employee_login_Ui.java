package controller.employee;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import model.Employee;
import model.Product;
import service.product.ProductServiceImpl;

import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Employee_login_Ui extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private Employee loginEmp;
	private JTextField product_no_input;
	private JTextField product_name_input;
	private JTextField product_cost_input;
	private JTextField product_id_input;
	private JTable table;
	private DefaultTableModel model;
	private ProductServiceImpl productServiceImpl = new ProductServiceImpl();
	private JTextField product_no_add_input;
	private JTextField product_name_add_input;
	private JTextField product_cost_add_input;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee_login_Ui frame = new Employee_login_Ui();
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
	public Employee_login_Ui(Employee emp) {
		this.loginEmp = emp; // 將傳進來的員工存起來
		initComponents();    // 呼叫初始化 UI 的方法
	}
	public Employee_login_Ui() {
		this(null); // 呼叫下方的初始化邏輯
	}
	private void initComponents() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1216, 636);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		// 這裡可以根據 loginEmp 是否有值來顯示歡迎詞
		if (loginEmp != null) {
			lblNewLabel.setText(loginEmp.getEmployee_name() + " 您好");
		}
		
		lblNewLabel.setFont(new Font("新細明體", Font.BOLD, 41));
		lblNewLabel.setBounds(86, 10, 235, 54);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(239, 74, 224, 513);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("產品更新");
		lblNewLabel_2.setFont(new Font("新細明體", Font.BOLD, 22));
		lblNewLabel_2.setBounds(62, 10, 109, 36);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("產品編號:");
		lblNewLabel_3.setFont(new Font("新細明體", Font.PLAIN, 17));
		lblNewLabel_3.setBounds(10, 82, 77, 37);
		panel.add(lblNewLabel_3);
		
		product_no_input = new JTextField();
		product_no_input.setBounds(83, 84, 131, 35);
		panel.add(product_no_input);
		product_no_input.setColumns(10);
		
		JLabel lblNewLabel_3_1 = new JLabel("產品名稱:");
		lblNewLabel_3_1.setFont(new Font("新細明體", Font.PLAIN, 17));
		lblNewLabel_3_1.setBounds(10, 157, 77, 37);
		panel.add(lblNewLabel_3_1);
		
		product_name_input = new JTextField();
		product_name_input.setColumns(10);
		product_name_input.setBounds(83, 157, 131, 35);
		panel.add(product_name_input);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("產品售價:");
		lblNewLabel_3_1_1.setFont(new Font("新細明體", Font.PLAIN, 17));
		lblNewLabel_3_1_1.setBounds(10, 238, 77, 37);
		panel.add(lblNewLabel_3_1_1);
		
		product_cost_input = new JTextField();
		product_cost_input.setColumns(10);
		product_cost_input.setBounds(83, 240, 131, 35);
		panel.add(product_cost_input);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBackground(new Color(255, 128, 192));
		panel_2.setBounds(5, 74, 224, 513);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_2_2 = new JLabel("產品新增");
		lblNewLabel_2_2.setFont(new Font("新細明體", Font.BOLD, 22));
		lblNewLabel_2_2.setBounds(62, 10, 109, 36);
		panel_2.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("產品編號:");
		lblNewLabel_3_3.setFont(new Font("新細明體", Font.PLAIN, 17));
		lblNewLabel_3_3.setBounds(10, 82, 77, 37);
		panel_2.add(lblNewLabel_3_3);
		
		product_no_add_input = new JTextField();
		product_no_add_input.setColumns(10);
		product_no_add_input.setBounds(83, 84, 131, 35);
		panel_2.add(product_no_add_input);
		
		JLabel lblNewLabel_3_1_2 = new JLabel("產品名稱:");
		lblNewLabel_3_1_2.setFont(new Font("新細明體", Font.PLAIN, 17));
		lblNewLabel_3_1_2.setBounds(10, 157, 77, 37);
		panel_2.add(lblNewLabel_3_1_2);
		
		product_name_add_input = new JTextField();
		product_name_add_input.setColumns(10);
		product_name_add_input.setBounds(83, 157, 131, 35);
		panel_2.add(product_name_add_input);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("產品售價:");
		lblNewLabel_3_1_1_1.setFont(new Font("新細明體", Font.PLAIN, 17));
		lblNewLabel_3_1_1_1.setBounds(10, 238, 77, 37);
		panel_2.add(lblNewLabel_3_1_1_1);
		
		product_cost_add_input = new JTextField();
		product_cost_add_input.setColumns(10);
		product_cost_add_input.setBounds(83, 240, 131, 35);
		panel_2.add(product_cost_add_input);
		
		
		
		JLabel lblNewLabel_1 = new JLabel("商品後臺設定");
		lblNewLabel_1.setFont(new Font("新細明體", Font.BOLD, 41));
		lblNewLabel_1.setBounds(331, 10, 254, 54);
		contentPane.add(lblNewLabel_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 128));
		panel_1.setBounds(473, 74, 224, 513);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_1 = new JLabel("產品刪除");
		lblNewLabel_2_1.setFont(new Font("新細明體", Font.BOLD, 22));
		lblNewLabel_2_1.setBounds(57, 10, 109, 36);
		panel_1.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("產品ID:");
		lblNewLabel_3_2.setFont(new Font("新細明體", Font.PLAIN, 17));
		lblNewLabel_3_2.setBounds(10, 82, 77, 37);
		panel_1.add(lblNewLabel_3_2);
		
		product_id_input = new JTextField();
		product_id_input.setColumns(10);
		product_id_input.setBounds(83, 82, 131, 35);
		panel_1.add(product_id_input);
		
		
		
		JLabel show_time = new JLabel("讀取時間...");
		show_time.setBounds(635, 13, 326, 51);
		contentPane.add(show_time);
		show_time.setFont(new Font("微軟正黑體 Light", Font.BOLD, 21));
		new javax.swing.Timer(1000, e -> {
			show_time.setText(new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new java.util.Date()));
	    }).start();
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBackground(new Color(128, 128, 192));
		panel_1_1.setBounds(707, 74, 483, 513);
		contentPane.add(panel_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("產品總覽");
		lblNewLabel_2_1_1.setFont(new Font("新細明體", Font.BOLD, 22));
		lblNewLabel_2_1_1.setBounds(182, 10, 109, 36);
		panel_1_1.add(lblNewLabel_2_1_1);
		
		model = new DefaultTableModel();
		model.setColumnIdentifiers(new String[]{"ID", "編號", "名稱", "售價"}); // 設定欄位名

		table = new JTable(model); // 將 model 綁定到 table
		JScrollPane scrollPane = new JScrollPane(table); // 必須用 ScrollPane 否則看不到標題
		scrollPane.setBounds(10, 60, 463, 374);
		panel_1_1.add(scrollPane);
/********************************event********************************************/	
		//此為新增的功能
		JButton product_add_button = new JButton("確認");
		product_add_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        // 1. 抓取「新增專用」輸入框的文字內容
		        String no = product_no_add_input.getText().trim();
		        String name = product_name_add_input.getText().trim();
		        String costStr = product_cost_add_input.getText().trim();

		        // 2. 檢查欄位是否填寫完整
		        if (no.isEmpty() || name.isEmpty() || costStr.isEmpty()) {
		            javax.swing.JOptionPane.showMessageDialog(null, "新增失敗：請填寫完整產品資訊！");
		            return;
		        }

		        try {
		            // 3. 將成本轉為數字 (使用 Integer.parseInt [Oracle Docs])
		            int cost = Integer.parseInt(costStr);

		            // 4. 封裝成 Product 物件 (呼叫 model 層)
		            model.Product p = new model.Product(no, name, cost);

		            // 5. 呼叫 Service 的新增方法 (MVC：View -> Service)
		            productServiceImpl.add_product(p);

		            // 6. 成功後立即刷新右側 JTable
		            refreshTable();

		            // 7. 提示並清空輸入框，方便下次輸入
		            javax.swing.JOptionPane.showMessageDialog(null, "產品 [" + name + "] 新增成功！");
		            product_no_add_input.setText("");
		            product_name_add_input.setText("");
		            product_cost_add_input.setText("");

		        } catch (NumberFormatException ex) {
		            javax.swing.JOptionPane.showMessageDialog(null, "錯誤：成本欄位請輸入數字！");
		        }
		    }
		});
		product_add_button.setBounds(94, 325, 120, 35);
		panel_2.add(product_add_button);
		
		
		
		//此為更新產品資料庫的功能
		JButton product_update_button = new JButton("確認");
		product_update_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
		        // 1. 從輸入框抓取當下的文字內容 (注意名稱要對應你的 JTextField 宣告)
		        String no = product_no_input.getText().trim();
		        String name = product_name_input.getText().trim();
		        String costStr = product_cost_input.getText().trim();

		        // 2. 檢查是否為空
		        if (no.isEmpty() || name.isEmpty() || costStr.isEmpty()) {
		            javax.swing.JOptionPane.showMessageDialog(null, "請輸入完整資料再執行更新");
		            return;
		        }

		        try {
		            // 3. 將字串轉為整數
		            int cost = Integer.parseInt(costStr);

		            // 4. 建立 Product 物件 (使用你的建構子: String, String, int)
		            Product p = new Product(no, name, cost);

		            // 5. 呼叫 Service 的更新
		            productServiceImpl.update_product(p);

		            // 6. 刷新表格並提示
		            refreshTable();
		            javax.swing.JOptionPane.showMessageDialog(null, "產品 " + no + " 更新成功！");

		        } catch (NumberFormatException ex) {
		            javax.swing.JOptionPane.showMessageDialog(null, "成本請輸入數字");
		        }
		    }
		});
		product_update_button.setBounds(94, 325, 120, 35);
		panel.add(product_update_button);
		
		
		//此為刪除功能
		JButton product_delete_button_1 = new JButton("確認");
		product_delete_button_1.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent e) {
		        try {
		            // 1. 從輸入框取得 ID
		            String idStr = product_id_input.getText().trim();
		            if (idStr.isEmpty()) {
		                javax.swing.JOptionPane.showMessageDialog(null, "請輸入要刪除的 ID");
		                return;
		            }
		            int id = Integer.parseInt(idStr);

		            // 2. 呼叫 Service 執行刪除
		            productServiceImpl.delete_product(id);

		            // 3. 重新整理表格
		            refreshTable();
		            
		            // 4. 清空輸入框
		            product_id_input.setText("");
		            javax.swing.JOptionPane.showMessageDialog(null, "刪除成功！");
		            
		        } catch (NumberFormatException ex) {
		            javax.swing.JOptionPane.showMessageDialog(null, "ID 格式錯誤，請輸入數字");
		        }
		    }
		});
		product_delete_button_1.setBounds(94, 326, 120, 35);
		panel_1.add(product_delete_button_1);
		
		
		
		//此為顯示資料庫的更新功能
		JButton btnNewButton = new JButton("更新");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				refreshTable(); 
			}
		});
		btnNewButton.setFont(new Font("新細明體", Font.PLAIN, 17));
		btnNewButton.setBounds(330, 444, 143, 36);
		panel_1_1.add(btnNewButton);
		
		
	

	}
	private void refreshTable() {
        model.setRowCount(0);
        java.util.List<model.Product> list = productServiceImpl.select_all();
        for (model.Product p : list) {
            model.addRow(new Object[] {
                p.getProduct_id(),
                p.getProduct_no(),
                p.getProduct_name(),
                p.getProduct_cost()
            });
        }
    }
}
