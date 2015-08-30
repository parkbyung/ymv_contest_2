package org.log5j.ymv.model.board;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.ApplicantVO;
import org.log5j.ymv.model.voluntary.ConfirmBoardVO;
import org.log5j.ymv.model.voluntary.ConfirmPageVO;
import org.log5j.ymv.model.voluntary.ConfirmVO;
import org.springframework.stereotype.Service;
@Service
public class RecruitBoardServiceImpl implements RecruitBoardService {
	@Resource(name="recruitBoardDAOImpl")
	private RecruitBoardDAO recruitBoardDAO;
	
	@Override
	public ListVO findBoardList(String pageNo){
		if(pageNo==null||pageNo=="") 
			pageNo="1";
		List<BoardVO> list=recruitBoardDAO.findBoardList(pageNo);
		int total=recruitBoardDAO.totalContent();
		PagingBean paging=new PagingBean(total,Integer.parseInt(pageNo));
		ListVO lvo=new ListVO(list,paging);
		return lvo;
	}
	@Override
	public RecruitBoardVO showContent(int recruitNo,HttpServletRequest request) {
		return recruitBoardDAO.findRecruitBoardByRecruitNo(recruitNo);
	}
	@Override
	public void updateBoard(BoardVO bvo) {
		recruitBoardDAO.updateBoard(bvo);
		
	}
	@Override
	public RecruitBoardVO findRecruitBoardByRecruitNo(int recruitNo){
	      return recruitBoardDAO.findRecruitBoardByRecruitNo(recruitNo);
	   }
	@Override
	public List<FieldVO> findFieldList() {
		return recruitBoardDAO.findFieldList();
	}
	@Override
	public List<LocationVO> findLocationList() {
		return recruitBoardDAO.findLocationList();
	}
	
	@Override
	public void registerVolunteer(RecruitBoardVO rbvo) {
		recruitBoardDAO.registerVolunteer(rbvo);
	}
	
	@Override
	public void deleteRecruitVolunteer(int recruitNo) {
		recruitBoardDAO.deleteRecruitVolunteer(recruitNo);
	}
	@Override
	public void deleteVoluntaryServiceApplicateNo(int recruitNo) {
		recruitBoardDAO.deleteVoluntaryServiceApplicateNo(recruitNo);
	}
	@Override
	public ListVO findCompanyBoardList(CompanyVO cpvo) {
		if(cpvo.getPageNo()==0) {
			cpvo.setPageNo(1);
		}
		List<BoardVO> list=recruitBoardDAO.findCompanyBoardList(cpvo);
		int total=recruitBoardDAO.totalCompanyContent(cpvo.getMemberNo());
		PagingBean paging=new PagingBean(total,cpvo.getPageNo());
		ListVO lvo=new ListVO(list,paging);
		return lvo;
	}
	@Override
	public void deletePicture(int pictureNo) {
		recruitBoardDAO.deletePicture(pictureNo);
	}
	@Override
	public ListVO findNormalBoardList(CompanyVO cpvo) {
		if(cpvo.getPageNo()==0) {
			cpvo.setPageNo(1);
		}
		List<BoardVO> list=recruitBoardDAO.findNormalBoardList(cpvo);
		int total=recruitBoardDAO.totalNormalContent(cpvo.getMemberNo());
		PagingBean paging=new PagingBean(total,cpvo.getPageNo());
		ListVO lvo=new ListVO(list,paging);
		return lvo;
	}
	@Override
	public void registerApplicantOK(ApplicantVO alvo) {
		recruitBoardDAO.registerApplicantOK(alvo);
	}
	@Override
	public List<ApplicantVO> findApplicantOkList(int recruitNo) {
		return recruitBoardDAO.findApplicantOkList(recruitNo);
	}
	@Override
	public MemberVO findMailAddressByMemberNo(int memberNo) {
		return recruitBoardDAO.findMailAddressByMemberNo(memberNo);
	}
	@Override
	public void registerConfirm(ConfirmVO confirmvo) {
		recruitBoardDAO.registerConfirm(confirmvo);
	}
	@Override
	public void registerConfirmBoard(ConfirmBoardVO confirmbvo) {
		recruitBoardDAO.registerConfirmBoard(confirmbvo);
	}
	@Override
	public ListVO findConfirmBoardListByMemberNo(ConfirmPageVO confirmPageVO) {
		 if (confirmPageVO.getPageNo() == 0)
	         confirmPageVO.setPageNo(1);
	      List<BoardVO> list = recruitBoardDAO.findConfirmBoardListByMemberNo(confirmPageVO);
	      int total = recruitBoardDAO.totalContentConfirm(confirmPageVO.getMemberNo());
	      PagingBean paging = new PagingBean(total,confirmPageVO.getPageNo());
	      ListVO lvo = new ListVO(list, paging);
	      return lvo;
	}
	@Override
	public ConfirmBoardVO findConfirmBoardByConfirm(ConfirmVO cvo){
		return recruitBoardDAO.findConfirmBoardByConfirm(cvo);
	}

	@Override
	public void updateApplicationChoice(RecruitBoardVO rbvo) {
		recruitBoardDAO.updateApplicationChoice(rbvo);
	}
	@Override
	public RecruitBoardVO checkDate(RecruitBoardVO rbvo){
		String today = (new SimpleDateFormat("yyyy-MM-dd")).format( new Date() );
        int compare = today.compareTo(rbvo.getRecruitingEnd());
        if(compare > 0){
        	rbvo.setMojib("모집완료");
			}else if(compare < 0){
				rbvo.setMojib("모집중");
			}else{
				rbvo.setMojib("모집중");
			}
		return rbvo;
	}
	@Override
	public RecruitBoardVO checkDate(RecruitBoardVO rbvo,String choice){
		rbvo=checkDate(rbvo);
		if(choice.equals("Y")){
			rbvo.setMojib("모집완료");
		}else{
			rbvo.setMojib("모집중");
		}
		return rbvo;
	}
}
