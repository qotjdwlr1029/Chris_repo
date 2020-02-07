package chris.spring.web.board.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import chris.spring.web.board.BoardVO;
import chris.spring.web.util.SqlSessionFactoryBean;

public class BoardDAO {

	private SqlSession sqlSession;
	public BoardDAO() {
		sqlSession = SqlSessionFactoryBean.getSqlSessionInstance();
	}
	public void insertBoard(BoardVO vo) {
		sqlSession.insert("BoardDAO.insertBoard",vo);
		//board-mapping.xml에서 설정한 파일의 namespace태그의 이름 : BoardDAO
		//namespace태그 아래에 insert, update, delete, select가 있다.
	}
	public void updateBoard(BoardVO vo) {
		sqlSession.update("BoardDAO.updateBoard",vo);
	}
	public void deleteBoard(BoardVO vo) {
		sqlSession.delete("BoardDAO.deleteBoard",vo);
	}
	public BoardVO getBoard(BoardVO vo) {
		return sqlSession.selectOne("BoardDAO.getBoard",vo);
	}
	public List<BoardVO> getBoardList(BoardVO vo) {
		return sqlSession.selectList("BoardDAO.getBoardList", vo);
	}
	
}
