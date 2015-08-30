package org.log5j.ymv.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.cookie.CookieService;
import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.MessageService;
import org.log5j.ymv.model.voluntary.MessageVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageBoardController {
	@Resource
	private CookieService cookieService;
	@Resource
	private MessageService messageService;

	@RequestMapping("message_board.ymv")
	public ModelAndView messageBoard(String pageNo, HttpServletRequest request) {	
		MemberVO mvo = (MemberVO) request.getSession().getAttribute("mvo");
		ListVO lvo = messageService.findMessageBoardList(pageNo,mvo.getMemberNo());
		return new ModelAndView("message_board","lvo",lvo);
	}

	@RequestMapping("message_show_content.ymv")
	public ModelAndView messageShowContent(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();
		int messageNo = Integer.parseInt(request.getParameter("messageNo"));
		MessageVO mgvo = messageService.findMessageBoardByMessageNo(messageNo);
		mv.addObject("mgvo", mgvo);
		mv.setViewName("message_show_content");
		return mv;
	}

	@RequestMapping("message_board_delete.ymv")
	public ModelAndView noticeBoardDelete(String messageNo) {
		messageService.messageDelete(messageNo);
		return new ModelAndView("redirect:message_board.ymv");
	}
}
