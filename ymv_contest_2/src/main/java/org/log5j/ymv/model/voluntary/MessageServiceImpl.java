package org.log5j.ymv.model.voluntary;

import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.RecruitBoardDAO;
import org.log5j.ymv.model.board.RecruitBoardVO;
import org.log5j.ymv.model.member.MemberDAO;
import org.log5j.ymv.model.member.MemberVO;
import org.springframework.stereotype.Service;

@Service
public class MessageServiceImpl implements MessageService {
	@Resource(name="messageDAOImpl")
	private MessageDAO messageDAO;
	@Resource
	private RecruitBoardDAO recruitBoardDAO;
	@Resource
	private MemberDAO memberDAO;
	
	@Override
	public void sendMessageApplicate(VoluntaryServiceApplicateVO vsavo) {
		RecruitBoardVO rcvo = recruitBoardDAO.findRecruitBoardByRecruitNo(vsavo.getRecruitNo());
		String title = "'"+rcvo.getTitle()+"' 을 신청해주셔서 감사합니다.";
		String content = "'"+rcvo.getTitle()+"' 을 신청해주셨습니다. 더 열심히 하는 너와 나의 봉사고리가 되겠습니다. 감사합니다.";
		MemberVO mvo = memberDAO.findMemberByMemberNo(vsavo.getMemberNo());
		messageDAO.sendMessageApplicate(new MessageVO("applicate",title,content,mvo.getMemberNo(),mvo.getName(),vsavo.getRecruitNo()));		
		//로그인할때는 message_no를 가져오기 널이면 그냥 넘기고 널이 아니면 리스트해서 돌리기.
	}

	@Override
	public List<MessageVO> findMessageByMemberNo(int memberNo) {
		
		return messageDAO.findMessageByMemberNo(memberNo);
	}
	
}
