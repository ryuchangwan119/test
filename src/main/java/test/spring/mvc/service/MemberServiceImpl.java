package test.spring.mvc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.spring.mvc.dto.MemberDTO;
import test.spring.mvc.entity.MemberEntity;
import test.spring.mvc.repository.MemberRepository;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberRepository repository;
	
	@Override
	public void memberSave(MemberDTO dto) {
		MemberEntity entity = MemberEntity.toMemberEntity(dto);
		repository.save(entity);
	}

	@Override
	public boolean checkIdDuplicate(String id) {
		boolean result = repository.existsById(id);
		return result;  // true = 이미 존재;
	}

}
