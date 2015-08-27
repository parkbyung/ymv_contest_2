package org.log5j.ymv.model.voluntary;

import java.util.List;

import org.log5j.ymv.model.board.BoardVO;

public interface MessageDAO {

	void sendMessage(MessageVO messageVO);

	List<MessageVO> findMessageByMemberNo(int memberNo);

	List<BoardVO> findMessageBoardList(MessageBoardVO mgbvo);

	int totalContent();

	MessageVO findMessageBoardByMessageNo(int messageNo);

	void messageDelete(int messageNo);

}
