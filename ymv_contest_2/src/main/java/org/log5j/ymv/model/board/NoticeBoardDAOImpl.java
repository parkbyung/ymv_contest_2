package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class NoticeBoardDAOImpl implements NoticeBoardDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;
	@Override
	
	public List<BoardVO> findNoticeBoardList(String pageNo) {
		List<BoardVO> list=sqlSessionTemplate.selectList("noticeBoard.findNoticeBoardList",Integer.parseInt(pageNo));
		return list;
	}

	@Override
	public int totalContent(){
		return sqlSessionTemplate.selectOne("noticeBoard.totalContent");
	}

	@Override
	public void registerNoticeBoard(NoticeBoardVO vo) {
		sqlSessionTemplate.insert("noticeBoard.registerNoticeBoard",vo);
	}

	@Override
	public BoardVO findNoticeBoardByBoardNo(int boardNo) {
		return sqlSessionTemplate.selectOne("noticeBoard.findNoticeBoardByBoardNo",boardNo);
	}

	@Override
	public void noticeBoardUpdate(NoticeBoardVO vo) {
		sqlSessionTemplate.update("noticeBoard.noticeBoardUpdate",vo);
	}

	@Override
	public void noticeBoardDelete(String boardNo) {
		sqlSessionTemplate.delete("noticeBoard.noticeBoardDelete",boardNo);
	}

	@Override
	public void registerPicture(PictureVO pvo) {
		sqlSessionTemplate.insert("noticeBoard.registerPicture",pvo);
	}

	@Override
	public PictureVO findPicture(int pictureNo) {
		return sqlSessionTemplate.selectOne("noticeBoard.findPicture",pictureNo);
	}

	@Override
	public void deletePicture(int pictureNo) {
		sqlSessionTemplate.delete("noticeBoard.deletePicture",pictureNo);
	}

	@Override
	public void updateHit(int boardNo) {
		sqlSessionTemplate.update("noticeBoard.updateHit", boardNo);
	}

	@Override
	public void updatePicture(PictureVO pvo) {
		sqlSessionTemplate.update("noticeBoard.updatePicture",pvo)	;	
	}
}
