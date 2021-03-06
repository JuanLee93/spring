package chap04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/*
 *  XXService 클래스틑 로직을 담당하는 클래스
 *  Controller가 특정 기능을 실행하기 위해서 호출
 */
@Component
public class MemberService {
	// 자동주입
	// 스프링이 타입이 같은 빈(객체)으로 주입
	@Autowired
	MemberDao dao; // dao 객체를 주입받을 필드
	
	// 주입방법 (1.setter 매서드, 2.생성자 3.자동주입)
	// 세터매서드 
//	public MemberService setDao(MemberDao dao) {
//		this.dao = dao;
//		return this;
//	}

	/* 회원등록 기능을 수행하는 메서드
	 * 여기서는 XXDao의 어떤 매서드를 호출, 비즈니스 로직 수행
	 */
	public int insert(String name) {
		int r = dao.insert(name);
		return r;
	}
}