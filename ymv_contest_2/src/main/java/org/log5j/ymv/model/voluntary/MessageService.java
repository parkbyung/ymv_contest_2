package org.log5j.ymv.model.voluntary;

import java.util.List;

public interface MessageService {

	void sendMessageApplicate(VoluntaryServiceApplicateVO vsavo);

	List<MessageVO> findMessageByMemberNo(int memberNo);

	void sendMessageApplicateOK(int recruitNo, int parseInt);

	void sendMessageConfirm(int recruitNo, int parseInt);

}