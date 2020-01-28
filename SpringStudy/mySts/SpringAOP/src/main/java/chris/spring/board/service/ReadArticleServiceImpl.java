package chris.spring.board.service;

import chris.spring.board.vo.ArticleNotFoundException;
import chris.spring.board.vo.ArticleVO;

public class ReadArticleServiceImpl implements ReadArticleService {

	@Override
	public ArticleVO getArticleAndIncreaseReadCount(int id) throws ArticleNotFoundException {
		if(id ==0)
			throw new ArticleNotFoundException();
		return new ArticleVO();
	}

}
