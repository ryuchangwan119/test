package test.spring.mvc.service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import test.spring.mvc.dto.BoardDTO;
import test.spring.mvc.entity.BoardEntity;
import test.spring.mvc.repository.BoardRepository;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardRepository repository;

	@Override
	public int write(BoardDTO dto) {
		int result = 0;
		
		BoardEntity entity = BoardEntity.toBoardEntity(dto);
		BoardEntity savedEntity = repository.save(entity);
		
		if(savedEntity != null && savedEntity.getId() > 0) {
			result =  1;
		}
		return result;
	}

	@Override
	public List<BoardDTO> writeList() {
		// 데이터베이스에서 모든 BoardEntity 객체를 조회합니다.
		List<BoardEntity> boardEntityList = repository.findAll();
		
		// 조회된 데이터를 BoardDTO로 변환하여 담을 리스트를 생성합니다.
		List<BoardDTO> boardDTOList = new ArrayList<>();

		// 조회된 BoardEntity 리스트를 순회하면서 DTO로 변환합니다.
		for(BoardEntity entity : boardEntityList) {
			boardDTOList.add(BoardEntity.toBoardDTO(entity));
		}
		return boardDTOList;
	}

	@Override
	public BoardDTO writeDetail(int id) {
		Optional<BoardEntity> boardEntity = repository.findById(id);
		BoardDTO dto = null;
		if(boardEntity.isPresent()) {
			BoardEntity entity = boardEntity.get();
			
//			entity.setReadCount(entity.getReadCount() + 1);
//			repository.save(entity);	// 변경된 조회수를 DB에 반영 (update)
			
			dto = BoardEntity.toBoardDTO(entity);
		}
		return dto;
	}

	@Override
	public void increaseReadCount(int id) {
		Optional<BoardEntity> optional = repository.findById(id);
		
		if(optional.isPresent()) {
			BoardEntity entity = optional.get();
			 entity.setReadCount(entity.getReadCount() + 1);
			 repository.save(entity);	// Dirty Checking으로 Update 발생
		}
	}

	@Override
	public BoardDTO boardUpdate(int id) {
		Optional<BoardEntity> optionalEntity = repository.findById(id);
		BoardEntity entity = optionalEntity.get();
		BoardDTO dto = null;
		
		if(entity != null && entity.getId() > 0) {
			dto = BoardEntity.toBoardDTO(entity);
			System.out.println("passwd : " + dto.getPasswd());
		}
		return dto;
	}

	@Override
	public void boardUpdatePro(BoardDTO dto) {
	    Optional<BoardEntity> optional = repository.findById(dto.getId());

	    if (optional.isPresent()) {
	        BoardEntity entity = optional.get();

	        entity.setWriter(dto.getWriter());
	        entity.setTitle(dto.getTitle());
	        entity.setContent(dto.getContent());

	        repository.save(entity);	// Dirty Checking으로 업데이트
	    }
	}
}
