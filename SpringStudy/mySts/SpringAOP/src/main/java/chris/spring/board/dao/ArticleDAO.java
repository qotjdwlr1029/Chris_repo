package chris.spring.board.dao;

import chris.spring.board.vo.ArticleVO;

public interface ArticleDAO {

	void insert(ArticleVO article);
	void updateReadCount(int id);
	
}
