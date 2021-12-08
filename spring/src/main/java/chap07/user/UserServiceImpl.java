package chap07.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDao dao;
	
	@Override
	@Transactional
	public boolean insert(UserVo vo, HttpServletRequest req) {
		boolean r = false;
		int cnt = dao.insert(vo);
		// school 데이터 등록
		// UserVo 객체에는 userno가 저장된 상태
		// 학교정보를 배열로 받아오기
		/*
		String[] school = req.getParameterValues("school");
		String[] year = req.getParameterValues("year");
		SchoolVo svo = new SchoolVo();
		svo.setUserno(vo.getUserno());
		
		for (int i=0; i<school.length; i++) {
			svo.setSchool(school[i]);  //insert가 세번일어남
			svo.setYear(year[i]);
			cnt +=dao.insertSchool(svo);
			//if (i == 1) throw new Exception("");
		}
		*/
		//배열 필드 사용
		SchoolVo svo = new SchoolVo();
		svo.setUserno(vo.getUserno());
		
		for (int i=0; i<vo.getSchool().length; i++) {
			svo.setSchool(vo.getSchool()[i]);
			svo.setYear(vo.getYear()[i]);
			cnt += dao.insertSchool(svo);
		}
		
		// cnt : 배열의 길이 +1
		if (cnt == vo.getSchool().length+1) {
		r = true;
		}
		
		return r;
	}

	@Override
	public int idcheck(String id) {
		return dao.idcheck(id);
	}

	@Override
	public boolean login(UserVo vo, HttpSession sess) {
		UserVo uv = dao.login(vo); // 대입연산. dao는 sql문을 호출중. 아디,비번으로 조회한 userVo객체가 담김.
		if (uv != null) { // 로그인 성공. 
			sess.setAttribute("loginInfo", uv); // 그 객체를 loginInfo라는 이름으로 저장
			return true; // true 값을 controller로 갖고 돌아간다.
		}
		return false;
	}


}
