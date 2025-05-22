package test.spring.mvc.service;
import java.util.List;
import test.spring.mvc.dto.BoardDTO;

public interface BoardService {
	public int write(BoardDTO dto);
	public List<BoardDTO> writeList();
	public BoardDTO writeDetail(int id);
	public void increaseReadCount(int id);
	public BoardDTO boardUpdate(int id);
	public void boardUpdatePro(BoardDTO dto);
	
}
