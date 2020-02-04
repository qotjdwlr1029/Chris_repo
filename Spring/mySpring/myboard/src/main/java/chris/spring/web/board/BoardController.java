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
							//Command ��ü
		System.out.println("�� ��� ó��");
		MultipartFile uploadFile = vo.getUploadFile();
		if(!uploadFile.isEmpty()) {
			String fileName = uploadFile.getOriginalFilename();
			uploadFile.transferTo(new File("C:/myProject/" + fileName));
		}
		//1. ������� �Է� ���� ����
		//2. �����ͺ��̽� ���� ó��
//		BoardDAO boardDao = new BoardDAO();
		boardService.insertBoard(vo);
		//3. ȭ�� �׺���̼�
		return "getBoardList.do";		
		//POJO�������� ����� Ŭ���� �̹Ƿ� �� ������� ������ �����ϴ�.
		//���� returnŸ���� void�� �����ؼ� 3.ȭ�� �׺���̼� �κ��� ������.
	}
	
	@RequestMapping("/updateBoard.do")
	public String updateBoard(@ModelAttribute("Board") BoardVO vo, BoardDAO boardDao) {
		System.out.println("�� ���� ó��");
		System.out.println("��ȣ : " + vo.getSeq());
		System.out.println("���� : " + vo.getTitle());
		System.out.println("�ۼ��� �̸� : "+vo.getWriter());
		System.out.println("���� : " + vo.getContent());
		System.out.println("����� : " + vo.getRegDate());
		System.out.println("��ȸ�� : "+ vo.getCnt());
		//1. ������� �Է� ���� ����
		//2. �����ͺ��̽� ���� ó��
		boardDao.updateBoard(vo);
		//3. ȭ�� �׺���̼�
		return "getBoardList.do";
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		System.out.println("�� ���� ó��");
		//1. ������� �Է� ���� ����
		//2. �����ͺ��̽� ���� ó��
		boardService.deleteBoard(vo);
		//3. ȭ�� �׺���̼�
		return "getBoardList.do";		
	}
	
	@RequestMapping("/getBoard.do")
	public String getBoard(BoardVO vo, Model model) {
		System.out.println("�� �� ����ó��");
		//1. ������� �Է� ���� ����
		//2. �����ͺ��̽� ���� ó��
		BoardVO board = boardService.getBoard(vo);
		//3. ȭ�� �׺���̼�
		model.addAttribute("board", board);
		return "getBoard.jsp";
	}
	
	@RequestMapping("/getBoardList.do")
	public String getBoardList(
			@RequestParam(value = "searchCondition", defaultValue="TITLE", required=false)String condition 
			,@RequestParam(value="searchKeyword", defaultValue = "",required= false)String keyword,BoardVO vo, Model model) {
		//null���� üũ�ؼ� �⺻������ ���� : ��������
		if(vo.getSearchCondition()==null) {
			vo.setSearchCondition("TITLE");
		}
		if(vo.getSearchKeyword()==null)vo.setSearchKeyword("");
		//1. ������� �Է� ���� ����
		//2. DB ���� ó��
		List<BoardVO> boardList = boardService.getBoardList(vo);
		//3. ȭ�� �׺���̼�		 
		model.addAttribute("boardList",boardList);
		return "getBoardList.jsp";
		//ViewResolver�� �Ⱦ��ϱ� .jsp�� ����� �Ѵ�.
	}
	
	@ModelAttribute("conditionMap")
	public Map<String, String> searchConditionMap(){
		Map<String, String> conditionMap = new HashMap<String, String>();
		conditionMap.put("����","TITLE");
		conditionMap.put("����","CONTENT"	);
		return conditionMap;
	}
	
}
