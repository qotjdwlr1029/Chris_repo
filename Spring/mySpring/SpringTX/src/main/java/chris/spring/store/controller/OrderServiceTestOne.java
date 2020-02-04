package chris.spring.store.controller;

import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import chris.spring.store.service.PlaceOrderService;
import chris.spring.store.vo.PurchaseOrderRequest;
import chris.spring.store.vo.PurchaseOrderResult;

public class OrderServiceTestOne {

	private PlaceOrderService placeOrderService;
	private AbstractApplicationContext context;
	
	public OrderServiceTestOne() {
		String[] configLocations = new String[] {"transactionOne.xml"};
		context = new ClassPathXmlApplicationContext(configLocations);
		placeOrderService = (PlaceOrderService) context.getBean("placeOrderService");
	}
	
	public void order() {
		//물품 구매시에 배송을 원하는 주소와 일련번호를 입력한다.
		PurchaseOrderRequest orderRequest = new PurchaseOrderRequest();
		orderRequest.setItemId(1);
		orderRequest.setAddress("서울시 종로구");
		PurchaseOrderResult orderResult = placeOrderService.order(orderRequest);
		System.out.println("주문상태 정보");
		System.out.println("아이템 : " + orderResult.getItem().getId());
		System.out.println("가격 : " + orderResult.getPaymentInfo().getPrice());
	}
	
	public void close() {
		context.close();
	}
	
	public static void main(String[] args) {
		OrderServiceTestOne test = new OrderServiceTestOne();
		test.order();
		test.close();
	}
}
