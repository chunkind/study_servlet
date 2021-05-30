package model;
//	장바구니의 정보를 담고 있는 vo 클래스
public class Cart {
	
	private String name;
	private String url;	
	private int price;
	private int amount;		//수량
	
	public Cart( String name, String url, int price, int amount) {
		super();
		
		this.name = name;
		this.url = url;
		this.price = price;
		this.amount = amount;
	}
	
	public Cart(){
		super();
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Cart [ name=" + name
				+ ", url=" + url + ", price=" + price
				+ ", amount=" + amount + "]";
	}
}