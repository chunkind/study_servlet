package factory.component;
/*
 * 공장.. 뭔가를 생산해 내는 곳이다.. 생성하는 장소
 * 구상객체명 :: ProductFactory
 */
public interface Factory {
	public Product createProduct(String command);
}
