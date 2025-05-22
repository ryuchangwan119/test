package test.spring.mvc.entity;
import java.sql.Date;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import test.spring.mvc.dto.BoardDTO;

@Getter
@Setter
@Table(name = "board_table")
@Entity
public class BoardEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "mem_seq")
	@SequenceGenerator(name="mem_seq", sequenceName = "member_seq", allocationSize=1, initialValue=1)
	private int id;
	
	@Column(length = 50, nullable = false)	// varchar2(50) not null
	private String writer;
	
	@Column(length = 50, nullable = false)
	private String passwd;
	
	@Column(length = 50, nullable = false)
	private String title;
	
	@Column(length = 4000, nullable = false)
	private String content;
	
	@Column(columnDefinition = "number(10) default 0")		// 조회수 기본값 0
	private int readCount;

	// 엔티티가 처음 데이터베이스에 저장될 때(INSERT 시)에 자동으로 현재 시간(시스템 타임스탬프)을 할당
	@CreationTimestamp
	@Column(updatable = false)	// 한 번 생성된 이후에는 수정되지 않으므로, 생성 시각을 유지
	private Date boardWriteTime;
	
	@UpdateTimestamp
	@Column(insertable = false)	// 해당 컬럼이 INSERT SQL 실행 시 포함되지않는다.
	private Date boardUpdateTime;
	
	public static BoardEntity toBoardEntity(BoardDTO dto) {
		BoardEntity entity = new BoardEntity();
		entity.setWriter(dto.getWriter());
		entity.setPasswd(dto.getPasswd());
		entity.setTitle(dto.getTitle());
		entity.setContent(dto.getContent());
		return entity;
	}
	
	public static BoardDTO toBoardDTO(BoardEntity entity) {
		BoardDTO dto = new BoardDTO();
		dto.setId(entity.getId());
		dto.setWriter(entity.getWriter());
		dto.setTitle(entity.getTitle());
		dto.setContent(entity.getContent());
		dto.setPasswd(entity.getPasswd());
		dto.setReadCount(entity.getReadCount());
		dto.setBoardWriteTime(entity.getBoardWriteTime());
		dto.setBoardUpdateTime(entity.getBoardUpdateTime());
		return dto;
	}
}
