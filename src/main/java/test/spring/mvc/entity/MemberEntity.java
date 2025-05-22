package test.spring.mvc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
import test.spring.mvc.dto.MemberDTO;

@Entity @Getter @Setter
@Table(name="member_table")
public class MemberEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "member_gen")
	@SequenceGenerator(name="member_gen", sequenceName="member_seq", initialValue=1, allocationSize=1)
	private int num;
	
	@Column(unique = true, length = 20)
	private String id;

	@Column(length = 20)
	private String passwd;

	@Column(length = 50)
	private String email;
	
	@Column(length = 50)
	private String name;
	
	public static MemberEntity toMemberEntity(MemberDTO dto) {
		MemberEntity entity = new MemberEntity();
		entity.setId(dto.getId());	
		entity.setEmail(dto.getEmail());
		entity.setName(dto.getName());
		entity.setPasswd(dto.getPasswd());
		return entity;
	}
}
