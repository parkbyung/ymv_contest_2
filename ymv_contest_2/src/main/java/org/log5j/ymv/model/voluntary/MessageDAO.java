package org.log5j.ymv.model.voluntary;

import java.util.List;

public interface MessageDAO {

	void sendMessageApplicate(MessageVO messageVO);

	List<MessageVO> findMessageByMemberNo(int memberNo);

}
