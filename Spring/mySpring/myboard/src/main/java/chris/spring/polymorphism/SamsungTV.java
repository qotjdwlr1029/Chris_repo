package chris.spring.polymorphism;

public class SamsungTV implements TV{

	private Speaker speaker;
	private int price;
	
	public void powerOn() {
		System.out.println("samsungTV 전원을 켠다. 가격 " + price + "원");
	}
	public void powerOff() {
		System.out.println("samsungTV 전원을 끈다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}

	public void setSpeaker(Speaker speaker) {
		System.out.println("setSpeaker()메서드 호출");
		this.speaker = speaker;
	}

	public void setPrice(int price) {
		System.out.println("setPrice()메서드 호출");
		this.price = price;
	}

	
	
	
}
