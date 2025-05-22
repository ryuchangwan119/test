package test.spring.mvc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import test.spring.mvc.entity.MemberEntity;

@Repository
public interface MemberRepository extends JpaRepository<MemberEntity, Integer> {

	// select * from member_table where id=? and passwd=?;
	public MemberEntity findByIdAndPasswd(String id, String passwd);
		
	@Query("select m from MemberEntity m where m.id = :id and m.passwd = :passwd")
	public MemberEntity findByLogin(@Param("id") int id, @Param("passwd") String passwd);
		
	// select count(*) from member_table where id=? and passwd=?;
	public int countByIdAndPasswd(String id, String passwd);
		
	// id + passwd로 일치하는 회원 수 조회
	@Query("select count(m) from MemberEntity m where m.id = :id and m.passwd = :passwd")
	public int countByLogin(@Param("id") int id, @Param("passwd") String passwd);
	
	// select count(*) from member_table where id = ?;   0보다 크면 true를 리턴한다.
	boolean existsById(String id); 
}
