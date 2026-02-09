package vo;

public class OrderViewVO {
	// 1. 私有屬性：對應 View 的欄位
    private Integer orderId;
    private String customerName;
    private String employeeName;
    private String productName;
    private Integer productCost;
    private Integer amount;
    private Integer totalPrice;

    // 2. 空建構子 (基本規範)
    public OrderViewVO() {}

    // 3. 全欄位建構子 (方便 Service 封裝資料)
    public OrderViewVO(Integer orderId, String customerName, String employeeName, 
                       String productName, Integer productCost, Integer amount, Integer totalPrice) {
        this.orderId = orderId;
        this.customerName = customerName;
        this.employeeName = employeeName;
        this.productName = productName;
        this.productCost = productCost;
        this.amount = amount;
        this.totalPrice = totalPrice;
    }

    // 4. Getter 與 Setter (必備，供 UI 或 Service 存取)
    public Integer getOrderId() { return orderId; }

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Integer getProductCost() {
		return productCost;
	}

	public void setProductCost(Integer productCost) {
		this.productCost = productCost;
	}

	public Integer getAmount() {
		return amount;
	}

	public void setAmount(Integer amount) {
		this.amount = amount;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}
    
}
