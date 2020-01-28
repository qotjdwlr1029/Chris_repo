package chris.spring.board.service;

import chris.spring.board.vo.ArticleNotFoundException;
import chris.spring.board.vo.ArticleVO;

public interface ReadArticleService {

	ArticleVO getArticleAndIncreaseReadCount(int id) throws ArticleNotFoundException;
	
}
