package chris.spring.web.board;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;

import chris.spring.web.board.impl.BoardDAO;

@Controller
@SessionAttributes("board")
public class BoardController {

	@Autowired
	private BoardService boardService;
	
	@RequestMapping(value = "/insertBoard.do")
	public String insertBoard(BoardVO vo) throws IOException {
							//Command 객체
		System.out.println("글 등록 처리");
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/myProject/" + fileName));
		}
		//1. 사용자의 입력 정보 추출
		//2. 데이터베이스 연동 처리
//		BoardDAO boardDao = new BoardDAO();
		boardService.insertBoard(vo);
		//3. 화면 네비게이션
		return "getBoardList.do";		
		//POJO형식으로 변경된 클래스 이므로 내 마음대로 변경이 가능하다.
		//따라서 return타입을 void로 변경해서 3.화면 네비게이션 부분을 지웠다.
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("Board") BoardVO vo, BoardDAO boardDao) {
		System.out.println("글 수정 처리");
		System.out.println("번호 : " + vo.getSeq());
		System.out.println("제목 : " + vo.getTitle());
		System.out.println("작성자 이름 : "+vo.getWriter());
		System.out.println("내용 : " + vo.getContent());
		System.out.println("등록일 : " + vo.getRegDate());
		System.out.println("조회수 : "+ vo.getCnt());
		//1. 사용자의 입력 정보 추출
		//2. 데이터베이스 연동 처리
		boardDao.updateBoard(vo);
		//3. 화면 네비게이션
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("글 삭제 처리");
		//1. 사용자의 입력 정보 추출
		//2. 데이터베이스 연동 처리
		boardService.deleteBoard(vo);
		//3. 화면 네비게이션
		return "getBoardList.do";		
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("글 상세 보기처리");
		//1. 사용자의 입력 정보 추출
		//2. 데이터베이스 연동 처리
		BoardVO board = boardService.getBoard(vo);
		//3. 화면 네비게이션
		model.addAttribute("board", board);
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(
			@RequestParam(value = "searchCondition", defaultValue="TITLE", required=false)String condition 
			,@RequestParam(value="searchKeyword", defaultValue = "",required= false)String keyword,BoardVO vo, Model model) {
		//null값을 체크해서 기본값으로 설정 : 에러방지
		if(vo.getSearchCondition()==null) {
			vo.setSearchCondition("TITLE");
		}
		if(vo.getSearchKeyword()==null)vo.setSearchKeyword("");
		//1. 사용자의 입력 정보 추출
		//2. DB 연동 처리
		List<BoardVO> boardList = boardService.getBoardList(vo);
		//3. 화면 네비게이션		 
		model.addAttribute("boardList",boardList);
		return "getBoardList.jsp";
		//ViewResolver를 안쓰니깐 .jsp를 적어야 한다.
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("제목","TITLE");
		conditionMap.put("내용","CONTENT"	);
		return conditionMap;
	}
	
}
