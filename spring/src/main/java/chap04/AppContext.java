package chap04;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration // spring 설정파일
@ComponentScan(basePackages = {"chap04"}) // basePackages의 배열값(패키지)를 스캔해서 빈을 등록
public class AppContext {
/*
	// MemberController 빈으로 등록 (굳이 만든이유? @Bean을 어쩔수 없이 써야하는 상황이 생김. ->@Component을 못씀->스캔을 못할때-> 다른 lib들이 이미 만들어져있음)
	@Bean
	public MemberController memberController() {
		MemberController con = new MemberController();
//		con.setService(memberService());
		return con;
	}
	
	//MemberDao 빈으로 등록
	
	@Bean
	public MemberDao memberDao() {
		return new MemberDao();
	}
	
	//MemberService 빈으로 등록
	@Bean
	public MemberService memberService() {
		// MemberDao 객체를주입
		//return new MemberService().setDao(memberDao());
		return new MemberService();
	}
*/	
}