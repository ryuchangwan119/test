package test.spring.mvc.controller;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import test.spring.mvc.dto.BoardDTO;
import test.spring.mvc.service.BoardService;

@Controller
@RequestMapping("board/")
public class BoardController {
	
	@Autowired
	BoardService service;
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}
	
	@RequestMapping("main")
	public String main() {
		return "board/main";
	}
	
	@RequestMapping("write")
	public String writeForm(Model model) {
		model.addAttribute("boardDTO", new BoardDTO());
		return "board/writeForm";
	}
	
	@RequestMapping("writePro")
	public String writePro(Model model, BoardDTO dto) {
		int result = service.write(dto);
		
		if(result == 1) {
			return "/board/main";	// 실패시 글작성 페이지
		} else {
			 model.addAttribute("write", 0);
			return "/board/writeForm";		// 성공시 메인페이지
	
		}
	}
	
	@RequestMapping("list")
	public String list(Model model) {
		List<BoardDTO> boardList = service.writeList();
		model.addAttribute("boardList", boardList);
		return "/board/list";
	}
	
	@RequestMapping("listDetail")
	public String list(@RequestParam("id") int id, Model model, HttpServletRequest request,
            HttpServletResponse response) {
		
		boolean isViewed = false;
		
		Cookie[] cookies = request.getCookies();
		
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				if(cookie.getName().equals("viewed_" + id)) {
					isViewed = true;
					break;
				}
			}
		}
		
		if(!isViewed) {
			service.increaseReadCount(id);	// Service에서 DB 조회수 증가
			Cookie newCookie = new Cookie("viewed_" + id, "true");
			newCookie.setMaxAge(60 * 60); // 1시간 동안 유지
			newCookie.setPath("/");       // 전체 경로에 대해 적용
			response.addCookie(newCookie);
		}
		
		BoardDTO dto = service.writeDetail(id);
		
		if (dto == null) {
			model.addAttribute("errorMessage", "존재하지 않는 게시글입니다.");
		}
		model.addAttribute("dto", dto);
		return "/board/listDetail";
	}
	
	@RequestMapping("update")
	public String updateForm(@RequestParam("id") int id, Model model) {
	    BoardDTO dto = service.boardUpdate(id);
	    System.out.println("id : " + id);
	    model.addAttribute("dto", dto);
	    return "/board/updateForm";
	}
	
	@RequestMapping("updatePro")
	public String updatePro(BoardDTO dto, Model model) {
    	service.boardUpdatePro(dto);
    	BoardDTO updatedDto = service.writeDetail(dto.getId());
    	System.out.println("passwd : " + updatedDto.getPasswd());
    	model.addAttribute("dto", updatedDto);
		return "/board/listDetail";
	}
}
