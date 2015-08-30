package org.log5j.ymv.model.board;

import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.member.MemberVO;
import org.log5j.ymv.model.voluntary.ApplicantVO;
import org.log5j.ymv.model.voluntary.ConfirmBoardVO;
import org.log5j.ymv.model.voluntary.ConfirmPageVO;
import org.log5j.ymv.model.voluntary.ConfirmVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;
@Repository
public class RecruitBoardDAOImpl implements RecruitBoardDAO {
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<BoardVO> findBoardList(String pageNo){
		List<BoardVO> list = sqlSessionTemplate.selectList("recruitboard.findBoardList", pageNo);
		return list;
	}

	@Override
	public int totalContent(){
		return sqlSessionTemplate.selectOne("recruitboard.totalContent");
	}

	@Override
	public BoardVO showContent(int recruitNo) {
		return (BoardVO)sqlSessionTemplate.selectOne("recruitboard.showContent",recruitNo);
	}

	@Override
	public RecruitBoardVO findRecruitBoardByRecruitNo(int recruitNo){
	      return sqlSessionTemplate.selectOne("recruitboard.findRecruitBoardByRecruitNo",recruitNo);
	   }

	@Override
	public List<FieldVO> findFieldList() {
		List<FieldVO> list = sqlSessionTemplate.selectList("recruitboard.findFieldList");
		return list;
	}

	@Override
	public List<LocationVO> findLocationList() {
		List<LocationVO> list = sqlSessionTemplate.selectList("recruitboard.findLocationList");
		return list;
	}

	@Override
	public RecruitBoardVO findRecruitBoardByrecruitNo(int recruitNo) {
		return sqlSessionTemplate.selectOne("recruitboard.findRecruitBoardByrecruitNo", recruitNo);
	}
	
	@Override
	public void registerVolunteer(RecruitBoardVO rbvo) {
		sqlSessionTemplate.insert("recruitboard.registerVolunteer",rbvo);
	}

	@Override
	public void updateBoard(BoardVO bvo) {
		sqlSessionTemplate.update("recruitboard.updateBoard",bvo);
	}

	@Override
	public void deleteRecruitVolunteer(int recruitNo) {
		sqlSessionTemplate.delete("recruitboard.deleteRecruitVolunteer",recruitNo);
	}

	@Override
	public void deleteVoluntaryServiceApplicateNo(int recruitNo) {
		sqlSessionTemplate.delete("member.deleteVoluntaryServiceApplicateNo",recruitNo);		
	}

	@Override
	public List<BoardVO> findCompanyBoardList(CompanyVO cpvo) {
		List<BoardVO> list = sqlSessionTemplate.selectList("recruitboard.findCompanyBoardList",cpvo);
		return list;
	}

	@Override
	public int totalCompanyContent(int memberNo) {
		return sqlSessionTemplate.selectOne("recruitboard.totalCompanyContent",memberNo);
	}

	@Override
	public void deletePicture(int pictureNo) {
		sqlSessionTemplate.delete("recruitboard.deletePicture",pictureNo);
	}
	
	@Override
	public List<BoardVO> findNormalBoardList(CompanyVO cpvo) {
		List<BoardVO> list = sqlSessionTemplate.selectList("recruitboard.findNormalBoardList",cpvo);
		return list;
	}

	@Override
	public int totalNormalContent(int memberNo) {
		return sqlSessionTemplate.selectOne("recruitboard.totalNormalContent",memberNo);
	}

	@Override
	public void registerApplicantOK(ApplicantVO alvo) {
		sqlSessionTemplate.insert("applicant.registerApplicantOK",alvo);
	}

	@Override
	public List<ApplicantVO> findApplicantOkList(int recruitNo) {
		return sqlSessionTemplate.selectList("applicant.findApplicantOkList",recruitNo);
	}
	@Override
	public MemberVO findMailAddressByMemberNo(int memberNo) {
		return sqlSessionTemplate.selectOne("applicant.findMailAddressByMemberNo", memberNo);
	}

	@Override
	public void registerConfirm(ConfirmVO confirmvo) {
		sqlSessionTemplate.insert("applicant.registerConfirm",confirmvo);
	}

	@Override
	public void registerConfirmBoard(ConfirmBoardVO confirmbvo) {
		sqlSessionTemplate.insert("applicant.registerConfirmBoard",confirmbvo);
	}

	@Override
	public List<BoardVO> findConfirmBoardListByMemberNo(ConfirmPageVO confirmPageVO) {
		List<BoardVO> list=sqlSessionTemplate.selectList("applicant.findConfirmBoardListByMemberNo",confirmPageVO);
		return list;
	}

	@Override
	public int totalContentConfirm(int memberNo) {
		return sqlSessionTemplate.selectOne("applicant.totalContentConfirm",memberNo);
	}
	
	@Override
	public ConfirmBoardVO findConfirmBoardByConfirm(ConfirmVO cvo){
		return sqlSessionTemplate.selectOne("applicant.findConfirmBoardByConfirm",cvo);
	}

	@Override
	public void updateApplicationChoice(RecruitBoardVO rbvo) {
		sqlSessionTemplate.update("recruitboard.updateApplicationChoice", rbvo);
	}


}
