package chris.spring.web.board;

import java.util.List;

import chris.spring.web.board.impl.BoardDAO;

public class BoardServiceClient {

	public static void main(String[] args) {
		BoardDAO boardDAO = new BoardDAO();
		BoardVO vo = new BoardVO();
		
		vo.setTitle("myBatis");
		vo.setWriter("삼장법사");
		vo.setContent("DB연동");
		
		boardDAO.insertBoard(vo);//데이터 입력
		vo.setSearchCondition("TITLE");
		vo.setSearchKeyword("");
		
		List<BoardVO> boardList = boardDAO.getBoardList(vo);//데이터베이스에서 목록을 얻어옴
		for(BoardVO board : boardList) {
			System.out.println("===> " + board.toString());
		}
	}

}
