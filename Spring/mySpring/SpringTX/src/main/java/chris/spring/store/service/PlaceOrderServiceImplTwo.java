package chris.spring.store.service;

import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.TransactionCallback;
import org.springframework.transaction.support.TransactionTemplate;

import chris.spring.store.dao.ItemDao;
import chris.spring.store.dao.PaymentInfoDao;
import chris.spring.store.dao.PurchaseOrderDao;
import chris.spring.store.vo.Item;
import chris.spring.store.vo.ItemNotFoundException;
import chris.spring.store.vo.PaymentInfo;
import chris.spring.store.vo.PurchaseOrder;
import chris.spring.store.vo.PurchaseOrderRequest;
import chris.spring.store.vo.PurchaseOrderResult;

public class PlaceOrderServiceImplTwo implements PlaceOrderService {

	private ItemDao itemDao;
	private PaymentInfoDao paymentInfoDao;
	private PurchaseOrderDao purchaseOrderDao;
	private TransactionTemplate transactionTemplate;
	
	public void setTransactionTemplate(TransactionTemplate transactionTemplate) {
		this.transactionTemplate = transactionTemplate;
	}

	public void setItemDao(ItemDao itemDao) {
		this.itemDao = itemDao;
	}

	public void setPaymentInfoDao(PaymentInfoDao paymentInfoDao) {
		this.paymentInfoDao = paymentInfoDao;
	}

	public void setPurchaseOrderDao(PurchaseOrderDao purchaseOrderDao) {
		this.purchaseOrderDao = purchaseOrderDao;
	}

	@Override
	public PurchaseOrderResult order(PurchaseOrderRequest orderRequest) throws ItemNotFoundException {
		return transactionTemplate.execute(new TransactionCallback<PurchaseOrderResult>() {

			@Override
			public PurchaseOrderResult doInTransaction(TransactionStatus status) {
				Item item = itemDao.findById(orderRequest.getItemId());
				if(item==null)
					throw new ItemNotFoundException(orderRequest.getItemId());
				PaymentInfo paymentinfo = new PaymentInfo(item.getPrice());
				paymentInfoDao.insert(paymentinfo);
				PurchaseOrder order = new PurchaseOrder(item.getId(),orderRequest.getAddress(),paymentinfo.getId());
				purchaseOrderDao.insert(order);
				return new PurchaseOrderResult(item, paymentinfo, order);
			}
			
		});
	}

}
