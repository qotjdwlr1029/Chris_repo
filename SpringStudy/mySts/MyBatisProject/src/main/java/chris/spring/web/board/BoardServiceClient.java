package chris.spring.web.board;

import java.util.List;

import chris.spring.web.board.impl.BoardDAO;

public class BoardServiceClient {

	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setTitle("myBatis");
		vo.setWriter("삼장법사");
		vo.setContent("내용");
		boardDAO.insertBoard(vo);
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		for(BoardVO board : boardList) {
			System.out.println("===> " + board.toString());
		}
	}

}
