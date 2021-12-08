package chap07.user;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {

	@Autowired
	SqlSessionTemplate sst; // 얘가 있어야 mybatis 실행가능
	
	public int insert(UserVo vo) {
		return sst.insert("user.insert", vo);
	}
	
	public int idcheck(String id) {
		return sst.selectOne("user.idcheck", id);
	}
	
	public UserVo login(UserVo vo) {
		return sst.selectOne("user.login", vo); //리턴값을 받아서 또 리턴
	}

	public UserVo logout(UserVo vo) {
		return sst.selectOne("user.logout", vo);
	}
	
	public int insertSchool(SchoolVo vo) {
		return sst.insert("user.insertSchool", vo);
	}
}
