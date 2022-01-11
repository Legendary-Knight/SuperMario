
public class GraphicsCard {
	private double price;
	private String brand;
	private String model;
	
	// 1) write the default constructor that sets the values to
	// $900, "NVidia", "3060"
	public GraphicsCard () {
		price = 900.0;
		brand = "NVidia";
		model = "3060";
	}
	public GraphicsCard (double newPrice, String newBrand, String newModel) {
		price = newPrice;
		model = newModel;
		brand = newBrand;
	}
	// Getters - allow access (read) to private instance variables
	// public returnType getNameOfAttrivute (){return attribute}
	public double getPrice() {
		return price;
	}
	public String getBrand() {
		return brand;
	}
	public String getModel() {
		return model;
	}
	public String getString () {
		return price + " " + model + " " + brand;
	}
	
	public void setPrice (double newPrice) {
		price = newPrice;
	}
	public void setBrand (String newBrand) {
		brand = newBrand;
	}
	public void setModel (String newModel) {
		model = newModel;
	}
	
	public static void main(String[] args) {
		GraphicsCard gc = new GraphicsCard();
		System.out.println(gc.getBrand());
		System.out.println(gc.getPrice());
		System.out.println(gc.getModel());
		System.out.println(gc.getString());
			
	}
	
}
