package org.log5j.ymv.controller;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.log5j.ymv.model.member.MemberVO;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.mvc.WebContentInterceptor;
/**
 * 
 * @내용 : 로그인 체크가 필요하지 않는 메서드에는 새로 생성한 
 * @NoCheckLogin 어노테이션을 선언하고 
 * @NoCheckLogin 어노테이션이 선언되지 않는 메서드를 구분하여 
 * 세션체크를 하여 세션이 없으면 alert를 띄워주고 로그인페이지로 이동시킨다. 
 *
 */
public class LoginInterceptor extends WebContentInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws ServletException {
        //@NoCheckLogin 어노테이션이 컨트롤러에 사용되었는지 체크함
        NoLoginCheck usingAuth = ((HandlerMethod) handler).getMethodAnnotation(NoLoginCheck.class);
        AdminLoginCheck admin = ((HandlerMethod) handler).getMethodAnnotation(AdminLoginCheck.class);
        CompanyLoginCheck company = ((HandlerMethod) handler).getMethodAnnotation(CompanyLoginCheck.class);
        //NoCheckLogin 어노테이션이 없음으로 무조건 로그인 체크
        if(usingAuth == null) {
            HttpSession session=request.getSession();
            MemberVO memberVO=(MemberVO)session.getAttribute("mvo");
            if(memberVO==null){
            	try {
					response.sendRedirect("loginCheck.ymv");
					return false;
				} catch (IOException e) {
					e.printStackTrace();
				}
            }else if(admin!=null){
            	if(!memberVO.getMemberType().equals("admin")){
            		try {
						response.sendRedirect("adminLoginCheck.ymv");
					} catch (IOException e) {
						e.printStackTrace();
					}
					return false;
            	}
            }else if(company!=null){
            	if(!memberVO.getMemberType().equals("company")){
            		try {
						response.sendRedirect("companyLoginCheck.ymv");
					} catch (IOException e) {
						e.printStackTrace();
					}
					return false;
            	}
            }
        }
        //NoCheckLogin 어노테이션이 있음으로 로그인 체크 하지 않음
        else {

        }
      return true;
    }   
}