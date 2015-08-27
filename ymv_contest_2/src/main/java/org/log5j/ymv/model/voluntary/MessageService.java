package org.log5j.ymv.model.voluntary;

import java.util.List;

import org.log5j.ymv.model.board.ListVO;

public interface MessageService {

	void sendMessageApplicate(VoluntaryServiceApplicateVO vsavo);

	List<MessageVO> findMessageByMemberNo(int memberNo);

	void sendMessageApplicateOK(int recruitNo, int parseInt);

	void sendMessageConfirm(int recruitNo, int parseInt);

	ListVO findMessageBoardList(String pageNo, int memberNo);

}