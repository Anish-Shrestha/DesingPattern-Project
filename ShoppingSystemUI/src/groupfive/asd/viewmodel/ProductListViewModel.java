package groupfive.asd.viewmodel;

public class ProductListViewModel {
	public String productid;
	public String name;
	public String price;
	public String quantity;

	public ProductListViewModel(String productId, String name, String price, String quantity) {
		this.productid = productId;
		this.name = name;
		this.price = price;
		this.quantity = quantity;

	}

	public String getProductid() {
		return productid;
	}

	public void setProductid(String productid) {
		this.productid = productid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getQuantity() {
		return quantity;
	}

	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

}
