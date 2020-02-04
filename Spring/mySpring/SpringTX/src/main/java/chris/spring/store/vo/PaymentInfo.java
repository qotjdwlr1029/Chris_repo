package chris.spring.store.vo;

public class PaymentInfo {

	private Integer id;
	private int price;
	
	public PaymentInfo() {
		super();
	}

	public PaymentInfo(int price) {
		super();
		this.price = price;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
}
