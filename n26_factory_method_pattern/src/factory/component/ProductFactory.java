package factory.component;

public class ProductFactory implements Factory{

	private static ProductFactory factory = new ProductFactory();
	private ProductFactory() {
		System.out.println("ProductFactory... 생성자");
	}
	public static ProductFactory getInstance(){
		return factory;
	}

	@Override
	public Product createProduct(String command) {
		Product product = null;
		if(command.equals("findNotebookModel")){
			product = new NoteBookProduct();
		}else if(command.equals("findItvModel")){
			product = new ITVProduct();
		}
		return product;
	}
}