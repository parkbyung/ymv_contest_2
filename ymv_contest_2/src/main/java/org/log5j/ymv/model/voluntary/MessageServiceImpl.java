package org.log5j.ymv.model.voluntary;

import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.BoardVO;
import org.log5j.ymv.model.board.ListVO;
import org.log5j.ymv.model.board.PagingBean;
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
	public List<MessageVO> findMessageByMemberNo(int memberNo) {
		
		return messageDAO.findMessageByMemberNo(memberNo);
	}
	
	@Override
	public void sendMessageApplicate(VoluntaryServiceApplicateVO vsavo) {
		//신청자
		RecruitBoardVO rcvo = recruitBoardDAO.findRecruitBoardByRecruitNo(vsavo.getRecruitNo());
		String title = "봉사활동 '"+rcvo.getTitle()+"' 을 신청해주셔서 감사합니다.";
		String content = "'"+rcvo.getTitle()+"' 을 신청해주셨습니다. \n\n더 열심히 하는 너와 나의 봉사고리가 되겠습니다. \n\n감사합니다.";
		MemberVO mvo = memberDAO.findMemberByMemberNo(vsavo.getMemberNo());
		messageDAO.sendMessage(new MessageVO("신청관련",title,content,mvo.getMemberNo(),mvo.getName(),vsavo.getRecruitNo()));		
		//로그인할때는 message_no를 가져오기 널이면 그냥 넘기고 널이 아니면 리스트해서 돌리기.
	}

	@Override
	public void sendMessageApplicateOK(int recruitNo, int memberNo) {
		//신청자 뽑고 난 뒤
		RecruitBoardVO rcvo = recruitBoardDAO.findRecruitBoardByRecruitNo(recruitNo);
		String title = "봉사신청 하신 '"+rcvo.getTitle()+"' 에 관련된 내용을 알려드립니다. ";
		String content = "'"+rcvo.getTitle()+"' 을 신청해주셨고, 당당히 선정되셨습니다. \n\n축하합니다. \n\n더 열심히 하는 너와 나의 봉사고리가 되겠습니다. \n\n감사합니다.";
		MemberVO mvo = memberDAO.findMemberByMemberNo(memberNo);
		messageDAO.sendMessage(new MessageVO("선정관련",title,content,mvo.getMemberNo(),mvo.getName(),recruitNo));	
	}

	@Override
	public void sendMessageConfirm(int recruitNo, int memberNo) {
		//확인서 발급을 위한 봉사활동자 선택 후
		RecruitBoardVO rcvo = recruitBoardDAO.findRecruitBoardByRecruitNo(recruitNo);
		String title = "봉사신청 하신 '"+rcvo.getTitle()+"' 에 관련된 내용을 알려드립니다. ";
		String content = "'"+rcvo.getTitle()+"' 에 관련된 봉사를 해주셔서 감사드립니다. \n\n지금 바로 봉사활동 확인서 출력 가능합니다. \n\n더 열심히 하는 너와 나의 봉사고리가 되겠습니다. \n\n감사합니다.";
		MemberVO mvo = memberDAO.findMemberByMemberNo(memberNo);
		messageDAO.sendMessage(new MessageVO("확인관련",title,content,mvo.getMemberNo(),mvo.getName(),recruitNo));	
	}

	@Override
	public ListVO findMessageBoardList(String pageNo, int memberNo) {
		if (pageNo == null || pageNo =="")
			pageNo = "1";
		MessageBoardVO mgbvo = new MessageBoardVO(memberNo, Integer.parseInt(pageNo));
		List<BoardVO> list = messageDAO.findMessageBoardList(mgbvo);
		int total = messageDAO.totalContent(memberNo);
		PagingBean paging = new PagingBean(total, Integer.parseInt(pageNo));
		ListVO lvo = new ListVO(list, paging);
		return lvo;
	}

	@Override
	public MessageVO findMessageBoardByMessageNo(int messageNo) {
		return messageDAO.findMessageBoardByMessageNo(messageNo);
	}

	@Override
	public void messageDelete(String messageNo) {
		messageDAO.messageDelete(Integer.parseInt(messageNo));
	}
	
}
