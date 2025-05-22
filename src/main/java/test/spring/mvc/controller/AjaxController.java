package test.spring.mvc.controller;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import test.spring.mvc.dto.AjaxDTO;

@Controller
public class AjaxController {
	@GetMapping("/ajaxTest")
	public String ajaxTestPage() {
		return "/ajax/ajaxTest"; // /WEB-INF/views/ajaxTest.jsp
	}
	
	@GetMapping("/ajax/getTest")
	@ResponseBody
	public String getTest(@RequestParam("message") String message) {
    	return "GET 요청 수신 : " + message;
	}
	
	@PostMapping("/ajax/postTest")
	@ResponseBody
	public String postTest(@RequestParam("message") String message) {
    	return message;
	}
	
	@GetMapping("/ajax/ajaxDTOTest")
	public String axajDTOTest() {
    	return "ajax/ajaxDTOTest";
	}
	
	@GetMapping("/ajax/getDTOTest")
	@ResponseBody
	public String getDTOTest(AjaxDTO dto) {
		return "GET DTO 요청 수신: msg=" + dto.getMsg() + ", extra=" + dto.getExtra();
	}
	
	@PostMapping("/ajax/postDTOTest")
	@ResponseBody
	public String postDTOTest(AjaxDTO dto) {
		return "GET DTO 요청 수신: msg=" + dto.getMsg() + ", extra=" + dto.getExtra();
	}
	
	@GetMapping("/ajax/ajaxDTOList")
	public String ajaxDTOListTestPage() {
    	return "/ajax/ajaxDTOList"; // /WEB-INF/views/ajax/ajaxDTOListTest.jsp
	}
	
	@GetMapping("/ajax/getDTOList")
	@ResponseBody
	public List<AjaxDTO> getDTOList() {
    	List<AjaxDTO> list = new ArrayList<>();

    	AjaxDTO dto1 = new AjaxDTO();
    	dto1.setMsg("MSG_DTO1");
    	dto1.setExtra("Extra_DTO1");

    	AjaxDTO dto2 = new AjaxDTO();
    	dto2.setMsg("MSG_DTO2");
    	dto2.setExtra("Extra_DTO2");

    	list.add(dto1);
    	list.add(dto2);
    	return list;
	}
}
