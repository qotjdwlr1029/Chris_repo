package chris.spring.guestbook.dao;

import java.sql.Types;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;

import chris.spring.guestbook.vo.GuestMessage;

public class NamedParamGuestMessageDao implements GuestMessageDao {

	private NamedParameterJdbcTemplate template;
	private SimpleJdbcInsert insertMessage;

	public NamedParamGuestMessageDao(SimpleJdbcInsert insertMessage) {
		this.insertMessage = insertMessage;
		insertMessage.withTableName("guestbook");
		insertMessage.usingColumns("message_id","guest_name","message","registry_date");
	}

	public void setTemplate(NamedParameterJdbcTemplate template) {
		this.template = template;
	}
	
	public int nextVal() {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		return template.queryForObject("select guest_seq.nextval from dual", paramMap, Integer.class);
	}

	@Override
	public int count() {
		Map<String, Object> paramMap  = new HashMap<String, Object>();
		return template.queryForObject("select count(*) from guestbook", paramMap, Integer.class);
	}

	@Override
	public List<GuestMessage> select(int begin, int end) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("startRowNum", begin);
		paramMap.put("count", end-begin+1);
		return template.query("select * from(select rownum rnum, message_id, guest_name, message, registry_date from"
				+ "(select * from guestbook order by message_id desc)) where rnum >=:startRowNum and rnum <=:count",paramMap,
				new GuestMessageRowMapper());
	}

	@Override
	public int insert(GuestMessage message) {
//		BeanPropertySqlParameterSource paramSource = new BeanPropertySqlParameterSource(message);
//		int insertCount = template.update("insert into guestbook "
//				+ "(message_id, guest_name, message, registry_date) "
//				+ "values(guest_seq.nextval, :guestName, :message, :registry_date)", paramSource);
//		return insertCount;
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		message.setId(nextVal());
		paramSource.addValue("message_id",message.getId());
		paramSource.addValue("guest_name", message.getGuestName());
		paramSource.addValue("message", message.getMessage());
		paramSource.addValue("registry_date", message.getRegistryDate());
		return insertMessage.execute(paramSource);
	}

	@Override
	public int delete(int id) {
		Map<String, Object> paramMap = new HashMap<String, Object>();
		paramMap.put("id",id);
		return template.update("delete from guestbook where message_id=:id", paramMap);
	}

	@Override
	public int update(GuestMessage message) {
		MapSqlParameterSource paramSource = new MapSqlParameterSource();
		paramSource.addValue("message", message.getMessage());
		paramSource.addValue("id", message.getId(), Types.INTEGER);
		return template.update("update guestbook set message=:message where message_id=:id", paramSource );
	}

}
