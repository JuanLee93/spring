package chap07;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

public class LoginInterceptor implements HandlerInterceptor {
/*
 * preHandle : 컨트롤러 실행 전 
 * postHandle : 컨트롤러 실행 후
 * afterCompletion : 뷰 까지 실행된 후에 
 */
	@Override
	public boolean preHandle(HttpServletRequest req, HttpServletResponse res, Object handler) 
		throws Exception {
		/*
		 * 세션객체 생성
		 * 로그인 세션이 존재하는지 여부를 체크
		 * 존재여부에 따라서 처리
		 */
		HttpSession sess = req.getSession();
		if (sess.getAttribute("loginInfo") == null) { // 로그인이 안된 상태
			res.setContentType("text/html; charset=utf-8");
			PrintWriter out = res.getWriter();
			out.println("<script>");
			out.println("alert('로그인후 이용가능합니다.')");
			out.println("location.href='/spring-spring/user/login.do';");
			out.println("</script>");
			return false;
		} else { // 로그인된 상태
			return true; // 가던길 가라
		} 
	}
}
