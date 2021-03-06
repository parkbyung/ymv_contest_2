package org.log5j.ymv.model.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.ApplicantVO;
import org.log5j.ymv.model.voluntary.ConfirmBoardVO;
import org.log5j.ymv.model.voluntary.ConfirmPageVO;
import org.log5j.ymv.model.voluntary.ConfirmVO;

public interface RecruitBoardService {
	public ListVO findBoardList(String pageNo);
	public RecruitBoardVO showContent(int recruitNo,HttpServletRequest request);
	public void updateBoard(BoardVO bvo);
	 public RecruitBoardVO findRecruitBoardByRecruitNo(int recruitNo);
	public List<FieldVO> findFieldList();
	public List<LocationVO> findLocationList();
	public void registerVolunteer(RecruitBoardVO rbvo);
	public void deleteRecruitVolunteer(int recruitNo);
	public void deleteVoluntaryServiceApplicateNo(int recruitNo);
	public ListVO findCompanyBoardList(CompanyVO cpvo);
	public void deletePicture(int pictureNo);
	public ListVO findNormalBoardList(CompanyVO cpvo);
	public void registerApplicantOK(ApplicantVO alvo);
	public List<ApplicantVO> findApplicantOkList(int recruitNo);
	public MemberVO findMailAddressByMemberNo(int memberNo);
	public void registerConfirm(ConfirmVO confirmvo);
	public void registerConfirmBoard(ConfirmBoardVO confirmbvo);
	public ListVO findConfirmBoardListByMemberNo(ConfirmPageVO confirmPageVO);
	public ConfirmBoardVO findConfirmBoardByConfirm(ConfirmVO cvo);
	public void updateApplicationChoice(RecruitBoardVO rbvo);
	RecruitBoardVO checkDate(RecruitBoardVO rbvo);
	RecruitBoardVO checkDate(RecruitBoardVO rbvo, String choice);
}
