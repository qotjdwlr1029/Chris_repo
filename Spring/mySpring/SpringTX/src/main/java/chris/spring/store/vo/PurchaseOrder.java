package chris.spring.store.vo;

public class PurchaseOrder {

	private Integer id;
	private Integer itemId;
	private String address;
	private Integer paymentInfoId;
	
	public PurchaseOrder() {
		super();
	}
	
	public PurchaseOrder(Integer itemId, String address, Integer paymentInfoId) {
		super();
		this.itemId = itemId;
		this.address = address;
		this.paymentInfoId = paymentInfoId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getItemId() {
		return itemId;
	}

	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public Integer getPaymentInfoId() {
		return paymentInfoId;
	}

	public void setPaymentInfoId(Integer paymentInfoId) {
		this.paymentInfoId = paymentInfoId;
	}
	
	
	
}
