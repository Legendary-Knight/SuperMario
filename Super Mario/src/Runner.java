
public class Runner {
	public static void main(String[] args) {
		GraphicsCard gc = new GraphicsCard();
		gc.setPrice(300);
		gc.setModel("??");
		gc.setBrand("efsdf");
		System.out.println(gc.getBrand());
		System.out.println(gc.getPrice());
		System.out.println(gc.getModel());
		System.out.println(gc.getString());
		
	}
}
