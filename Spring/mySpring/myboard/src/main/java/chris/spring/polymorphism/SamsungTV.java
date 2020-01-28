package chris.spring.polymorphism;

public class SamsungTV implements TV{

	private Speaker speaker;
	private int price;
	
	public void powerOn() {
		System.out.println("samsungTV ������ �Ҵ�. ���� " + price + "��");
	}
	public void powerOff() {
		System.out.println("samsungTV ������ ����.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker()�޼��� ȣ��");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("setPrice()�޼��� ȣ��");
		this.price = price;
	}

	
	
	
}
