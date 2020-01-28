package chris.spring.board.service;

import chris.spring.board.dao.ArticleDAO;
import chris.spring.board.vo.ArticleVO;

public class WriteArticleServiceImpl implements WriteArticleService {

	private ArticleDAO articleDAO;
	
	public WriteArticleServiceImpl() {
		// TODO Auto-generated constructor stub
	}
	
	
	public WriteArticleServiceImpl(ArticleDAO articleDAO) {
		super();
		this.articleDAO = articleDAO;
	}

	@Override
	public void write(ArticleVO article) {
		System.out.println("WriteArticleServiceImpl.write()메서드 실행");
		articleDAO.insert(article);
	}

}
