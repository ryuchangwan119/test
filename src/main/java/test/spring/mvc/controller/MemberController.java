package test.spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import test.spring.mvc.dto.MemberDTO;
import test.spring.mvc.service.MemberService;

@Controller
@RequestMapping("member/*")
public class MemberController {

	@Autowired
	MemberService service;

	@RequestMapping("inputForm")
	public String inputForm() {
		return "member/inputForm";
	}
	
	@RequestMapping("inputPro")
	public String inputPro(MemberDTO dto) {
		service.memberSave(dto);
		return "redirect:/";
	}
	
	@RequestMapping("loginForm")
	public String loginForm() { 
		
		return "member/loginForm";
	}
	
	@RequestMapping("checkId")
	@ResponseBody
    public String checkId(@RequestParam("id") String id) {
        boolean exists = service.checkIdDuplicate(id);
        return exists ? "사용중인 아이디입니다." : "사용 가능한 아이디 입니다.";
    }

	@RequestMapping("loginPro")
	public String loginPro(MemberDTO dto) { 
		
		return "member/loginPro";
	}
}