package test.spring.mvc.service;

import org.springframework.stereotype.Service;

import test.spring.mvc.dto.MemberDTO;

@Service
public interface MemberService {
	public void memberSave(MemberDTO dto);
	 boolean checkIdDuplicate(String id);  // 추가
}
