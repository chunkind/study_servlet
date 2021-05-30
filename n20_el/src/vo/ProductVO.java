package vo;
/*
 * 상품에 대한 정보를 저장하는 vo 클래스
 * property에 대한 개념을 여기서 잡는다.
 */
public class ProductVO {
	private String name;	// 상품명
	private int value;		// 상품가격
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public void setPrice(int value) {	//setValue()
		this.value = value;
	}
	
	public int getPrice() {
		return value;
	}
	
	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", value=" + value + "]";
	}
}
