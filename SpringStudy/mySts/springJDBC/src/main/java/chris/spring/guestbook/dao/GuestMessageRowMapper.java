package chris.spring.guestbook.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import chris.spring.guestbook.vo.GuestMessage;

public class GuestMessageRowMapper implements RowMapper<GuestMessage> {

	//template의 메서드들중 우리가 사용하기 위한 update, queryForList, queryForObject, query
	//메서드들의 인자값중 하나인 RowMapper인자를 구현하기 위한 클래스이다.
	//DataBase로부터 받아온 값을 매핑하기 위해서 사용하는 클래스이다.
	
	@Override
	public GuestMessage mapRow(ResultSet rs, int rowNum) throws SQLException {
		GuestMessage message = new GuestMessage();
		message.setId(rs.getInt("message_id"));
		message.setGuestName(rs.getString("guest_name"));
		message.setMessage(rs.getString("message"));
		message.setRegistryDate(rs.getDate("registry_date"));
		return message;
	}

}
