package tw.leonchen.model;

public class TruckBean {
	private int id;
	private String brand;

	public TruckBean(int id, String brand) {
		super();
		this.id = id;
		this.brand = brand;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public TruckBean() {

	}

}
