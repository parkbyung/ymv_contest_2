package org.log5j.ymv.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.log5j.ymv.model.member.MemberService;
import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.MessageService;
import org.log5j.ymv.model.voluntary.MessageVO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {
	@Resource
	private MessageService messageService;

	@RequestMapping("home.ymv")
	@NoLoginCheck
	public ModelAndView home(HttpServletRequest request){
		//HttpSession session=request.getSession(false);
		MemberVO mvo=(MemberVO)request.getSession().getAttribute("mvo");
		List<MessageVO> messagelist = new ArrayList<MessageVO>();
		if(mvo!=null){
			request.getSession().setAttribute("mvo", mvo);
			List<MessageVO> mglist = messageService.findMessageByMemberNo(mvo.getMemberNo());
			for(int i = 0 ; i < mglist.size() ; i++){
				if(mvo.getMemberNo() == mglist.get(i).getReceiveNo()){
					messagelist.add(mglist.get(i));
				}
			}
			request.getSession().setAttribute("messagelist", messagelist);
		}
		return new ModelAndView("home");
	}
	/**
	 * 
	 * 작성자 : 임영학
	 * 내용 : 
	 * @return
	 */
	@RequestMapping("loginCheck.ymv")
	@NoLoginCheck
	public String loginCheck(){
		return "loginCheck";
	}
	@RequestMapping("adminLoginCheck")
	@NoLoginCheck
	public String adminLoginCheck(){
		return "adminLoginCheck";
	}
	@RequestMapping("companyLoginCheck")
	@NoLoginCheck
	public String companyLoginCheck(){
		return "companyLoginCheck";
	}
}
