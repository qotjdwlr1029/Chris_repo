package chris.spring.board.dao;

import chris.spring.board.vo.ArticleVO;

public class OracleArticleDAO implements ArticleDAO {

	@Override
	public void insert(ArticleVO article) {
		System.out.println("myOracleArticleDAO.insert() 메서드 실행");
	}

	@Override
	public void updateReadCount(int id) {
		System.out.println("myOracleArticleDAO.updateReadCount() 메서드 실행");
	}

}
