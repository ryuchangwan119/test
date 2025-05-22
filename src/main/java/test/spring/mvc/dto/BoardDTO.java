package test.spring.mvc.dto;
import java.util.Date;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
//@NoArgsConstructor		// 기본 생성자
//@AllArgsConstructor		// 모든 매개변수를 받는 생성자
public class BoardDTO {
	private int id;			// id
	private String writer;		// 작성자
	private String passwd;		// 비밀번호
	private String title;		// 제목
	private String content;		// 본문
	private int readCount;		// 조회수
	private Date boardWriteTime;	// 글 작성 시간 (java.util.Date)
	private Date boardUpdateTime;	// 글 수정 시간
}