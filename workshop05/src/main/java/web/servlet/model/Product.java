package web.servlet.model;

public class Product {
	int prodNo;
	String prodName;
	int prodPrice;
	String prodDesc;
	
	public static final String DEFAULT_DESC = "설명추가필요";
	
	public Product(int prodNo, String prodName, int prodPrice, String prodDesc) {
		super();
		this.prodNo = prodNo;
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodDesc = prodDesc;
	}
	public Product() {}
	public Product(String prodName, int prodPrice, String prodDesc) {
		super();
		this.prodName = prodName;
		this.prodPrice = prodPrice;
		this.prodDesc = prodDesc;
	}
	public Product(String prodName, int prodPrice) {
		this(prodName, prodPrice, DEFAULT_DESC);
	}
	
	public int getProdNo() {
		return prodNo;
	}
	public void setProdNo(int prodNo) {
		this.prodNo = prodNo;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public int getProdPrice() {
		return prodPrice;
	}
	public void setProdPrice(int prodPrice) {
		this.prodPrice = prodPrice;
	}
	public String getProdDesc() {
		return prodDesc;
	}
	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}
	
	@Override
	public String toString() {
		return "Product [prodNo=" + prodNo + ", prodName=" + prodName + ", prodPrice=" + prodPrice + ", prodDesc="
				+ prodDesc + "]";
	}
	
}
