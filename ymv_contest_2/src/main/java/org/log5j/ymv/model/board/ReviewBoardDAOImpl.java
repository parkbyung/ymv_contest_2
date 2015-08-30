package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ReviewBoardDAOImpl implements ReviewBoardDAO {
	@Resource
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<BoardVO> findReviewBoardList(String pageNo) {
		List<BoardVO> list = sqlSessionTemplate.selectList(
				"reviewBoard.findReviewBoardList", Integer.parseInt(pageNo));
		return list;
	}

	@Override
	public int totalContent() {
		return sqlSessionTemplate.selectOne("reviewBoard.totalContent");
	}

	@Override
	public BoardVO findReviewBoardByBoardNo(int boardNo) {
		return sqlSessionTemplate.selectOne(
				"reviewBoard.findReviewBoardByBoardNo", boardNo);
	}

	@Override
	public void registerReviewComment(CommentVO cmvo) {
		sqlSessionTemplate.insert("reviewBoard.registerReviewComment", cmvo);
	}

	@Override
	public List<CommentVO> findCommentListByBoardNo(String boardNo) {
		return sqlSessionTemplate.selectList(
				"reviewBoard.findCommentListByBoardNo", boardNo);
	}

	@Override
	public void deleteReviewComment(CommentVO cmvo) {
		sqlSessionTemplate.delete("reviewBoard.deleteReviewComment", cmvo);
	}

	@Override
	public void updateReviewBoard(ReviewBoardVO vo) {
		sqlSessionTemplate.update("reviewBoard.updateReviewBoard", vo);
	}

	@Override
	public void deleteReviewBoard(String boardNo) {
		sqlSessionTemplate.delete("reviewBoard.deleteReviewBoard",
				Integer.parseInt(boardNo));
	}

	@Override
	public void deleteReviewBoardComment(String boardNo) {
		sqlSessionTemplate.delete("reviewBoard.deleteReviewBoardComment",
				Integer.parseInt(boardNo));
	}

	@Override
	public void registerReviewBoard(ReviewBoardVO vo) {
		sqlSessionTemplate.insert("reviewBoard.registerReviewBoard", vo);
	}

	@Override
	public void registerPicture(PictureVO pvo) {
		sqlSessionTemplate.insert("reviewBoard.registerPicture", pvo);
	}

	@Override
	public PictureVO findPicture(int pictureNo) {
		return sqlSessionTemplate.selectOne("reviewBoard.findPicture",
				pictureNo);
	}

	@Override
	public void deletePicture(int pictureNo) {
		sqlSessionTemplate.delete("reviewBoard.deletePicture", pictureNo);
	}

	@Override
	public void updateHit(int boardNo) {
		sqlSessionTemplate.update("reviewBoard.updateHit", boardNo);
	}

	@Override
	public void updatePicture(PictureVO pvo) {
		sqlSessionTemplate.update("reviewBoard.updatePicture", pvo);
	}

}