package chap07;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardDao boardDao;
	
	@Override
	public List<BoardVo> selectList(BoardVo vo) {
//		Map map = new HashMap(); //map은 key 와 value로 쌍으로 이루어진 구조
//		map.put("searchType", searchType);
//		map.put("searchWord", searchWord);
		return boardDao.selectList(vo); //메서드를 리턴할수는 없다.
	}

	@Override
	public int insert(BoardVo vo) {
		return boardDao.insert(vo);
	}

	@Override
	public BoardVo selectOne(int boardno) {
		return boardDao.selectOne(boardno);
	}

	@Override
	public int update(BoardVo vo) {
		return boardDao.update(vo);
	}

	@Override
	public int delete(BoardVo vo) {
		return boardDao.delete(vo);
	}

	@Override
	public BoardVo2 selectOne2(int boardno) {
		return boardDao.selectOne2(boardno);
	}

	@Override
	public int count(BoardVo vo) {
		return boardDao.count(vo);
	}
	
}