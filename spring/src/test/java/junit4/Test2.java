package junit4;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import chap07.BoardDao;
import chap07.BoardVo;

@WebAppConfiguration
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {chap07.MvcConfig.class})
public class Test2 {
	
	@Autowired
	BoardDao boardDao;
	
	@Test
	public void boardDaoTest() {
		int cnt = boardDao.count(new BoardVo());
		System.out.println(cnt);
	}
}
