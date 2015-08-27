package org.log5j.ymv.controller;

import javax.annotation.Resource;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.NoticeBoardService;
import org.log5j.ymv.model.board.NoticeBoardVO;
import org.log5j.ymv.model.board.PictureVO;
import org.log5j.ymv.model.cookie.CookieService;
import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.MessageService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageBoardController {
	@Resource
	private CookieService cookieService;
	@Resource
	private MessageService messageService;
	
	/**
	 * 
	 * @작성자 : 임영학
	 * @내용 : Board DB에서 공지사항 게시글을 조회하고 넘겨받은 
	 * pageNo를 통해 페이징 처리를 하여 notice_board.jsp 로 보내준다.
	 *
	 * @param pageNo
	 * @return 
	 */
	@RequestMapping("message_board.ymv")
	public ModelAndView noticeBoard(String pageNo, HttpServletRequest request) {	
		MemberVO mvo = (MemberVO) request.getSession().getAttribute("mvo");
		System.out.println(mvo);
		ListVO lvo = messageService.findMessageBoardList(pageNo,mvo.getMemberNo());
		System.out.println("lvo"+lvo);
		return new ModelAndView("message_board","lvo",lvo);
	}
	
}
