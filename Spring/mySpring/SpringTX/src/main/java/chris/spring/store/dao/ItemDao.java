package chris.spring.store.dao;

import chris.spring.store.vo.Item;

public interface ItemDao {

	Item findById(Integer itemId);
	
}
