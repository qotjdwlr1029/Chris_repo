package chris.spring.store.service;

import chris.spring.store.vo.ItemNotFoundException;
import chris.spring.store.vo.PurchaseOrderRequest;
import chris.spring.store.vo.PurchaseOrderResult;

public interface PlaceOrderService {

	public PurchaseOrderResult order(PurchaseOrderRequest orderRequest) throws ItemNotFoundException;
	
}
