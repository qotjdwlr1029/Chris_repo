package chris.spring.store.dao.jdbc;

import java.util.HashMap;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import chris.spring.store.dao.PurchaseOrderDao;
import chris.spring.store.vo.PurchaseOrder;

public class JdbcPurchaseOrderDao implements PurchaseOrderDao {

	private SimpleJdbcInsert insert;
	private NamedParameterJdbcTemplate namedJdbcTemplate;

	public JdbcPurchaseOrderDao(SimpleJdbcInsert insert) {
		super();
		this.insert = insert;
		//어떤 테이블의 어떤 컬럼명을 insert구문 사용시에 사용할지 지정해주는 메서드이다.
		insert.withTableName("purchase_order").usingColumns("purchase_order_id","item_id","payment_info_id","address");
	}

	public void setNamedJdbcTemplate(NamedParameterJdbcTemplate namedJdbcTemplate) {
		this.namedJdbcTemplate = namedJdbcTemplate;
	}

	public int nextVal() {
		//이름 기반의 파라미터 값을 설정하기 위해서 Map이나 SqlParameterSource를 전달받는다.
		//queryForObject(쿼리문, 값설정을 하기위한 map, RowMapper)값을 넣는다.
		//RowMapper는 database로 받아온 값들을 Mapping하기위한 정보가 담겨져있다.
		//맨마지막의 Integer.class의 의미는 앞의 쿼리문으로 받아오는 값을 정수형으로 받아오겠다라고 선언하는것과 다름없다.
		//generic을 거는것과 다름 없는 이야기 이다.
		Map<String, Object> emptyMap = new HashMap<String, Object>();
		return namedJdbcTemplate.queryForObject("select purchase_seq.nextval from dual",emptyMap, Integer.class);
	}

	@Override
	public void insert(PurchaseOrder order) {
		Map<String, Object> args = new HashMap<String, Object>();
		order.setId(nextVal());
		args.put("purchase_order_id", order.getId());
		args.put("item_id",order.getItemId());
		args.put("address", order.getAddress());
		args.put("payment_info_id", order.getPaymentInfoId());
		insert.execute(args);
	}

}