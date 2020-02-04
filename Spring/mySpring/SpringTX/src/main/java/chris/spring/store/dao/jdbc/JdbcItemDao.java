package chris.spring.store.dao.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import chris.spring.store.dao.ItemDao;
import chris.spring.store.vo.Item;

public class JdbcItemDao implements ItemDao {

	private JdbcTemplate jdbcTemplate;

	public JdbcItemDao(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


	@Override
	public Item findById(Integer itemId) {
		return jdbcTemplate.queryForObject("select * from item where item_id = ?",new Object[] {itemId},new RowMapper<Item>() {
			//결과를 매핑하기 위한 RowMapper메서드 구현
			@Override
			public Item mapRow(ResultSet rs, int rowNum) throws SQLException {
				Item item = new Item();
				item.setId(rs.getInt("item_id"));
				item.setPrice(rs.getInt("price"));
				return item;
			}
			
		});
	}

}
