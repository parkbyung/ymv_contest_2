package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
@Service
public class NoticeBoardServiceImpl implements NoticeBoardService {
	@Resource
	private NoticeBoardDAO noticeBoardDAO;
	
	@Override
	public ListVO findNoticeBoardList(String pageNo) {
		if (pageNo == null || pageNo == "")
			pageNo = "1";
		List<BoardVO> list = noticeBoardDAO.findNoticeBoardList(pageNo);
		int total = noticeBoardDAO.totalContent();
		PagingBean paging = new PagingBean(total, Integer.parseInt(pageNo));
		ListVO lvo = new ListVO(list, paging);
		return lvo;
	}

	@Override
	public void registerNoticeBoard(NoticeBoardVO vo) {
		noticeBoardDAO.registerNoticeBoard(vo);
	}

	@Override
	public BoardVO findNoticeBoardByBoardNo(int boardNo) {
		return noticeBoardDAO.findNoticeBoardByBoardNo(boardNo);
	}

	@Override
	public void noticeBoardUpdate(NoticeBoardVO vo) {
		noticeBoardDAO.noticeBoardUpdate(vo);
	}

	@Override
	public void noticeBoardDelete(String boardNo) {
		noticeBoardDAO.noticeBoardDelete(boardNo);
	}

	@Override
	public void registerPicture(PictureVO pvo) {
		noticeBoardDAO.registerPicture(pvo);
	}

	@Override
	public PictureVO findPicture(int pictureNo) {
		return noticeBoardDAO.findPicture(pictureNo);
	}

	@Override
	public void deletePicture(int pictureNo) {
		noticeBoardDAO.deletePicture(pictureNo);
	}
	
	@Override
	public void findPostingByNoticeBoardNoNotHit(int boardNo) {
		noticeBoardDAO.findNoticeBoardByBoardNo(boardNo);
		
	}

	@Override
	public NoticeBoardVO findPostingByNoticeBoardNoUpdateHit(int boardNo) {
		noticeBoardDAO.updateHit(boardNo);
		NoticeBoardVO nvo = (NoticeBoardVO) noticeBoardDAO.findNoticeBoardByBoardNo(boardNo);
		return nvo;
	}

	@Override
	public void updatePicture(PictureVO pvo) {
		noticeBoardDAO.updatePicture(pvo);
	}

}
