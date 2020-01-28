package chris.spring.polymorphism;

public class LgTV implements TV{

	private Speaker speaker;
	private int price;
	
	public void setSpeaker(Speaker speaker) {
		this.speaker = speaker;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void powerOn() {
		System.out.println("LgTV 전원을 켠다. 가격 : "+ price + "원");
	}
	public void powerOff() {
		System.out.println("LgTV 전원을 끈다.");
	}
	public void volumeUp() {
		speaker.volumeUp();
	}
	public void volumeDown() {
		speaker.volumeDown();
	}
	
}
