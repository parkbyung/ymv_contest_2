package org.log5j.ymv.model.voluntary;

import java.util.List;

import javax.annotation.Resource;

import org.log5j.ymv.model.board.BoardVO;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDAOImpl implements MessageDAO{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void sendMessage(MessageVO messageVO) {
		sqlSessionTemplate.insert("message.sendMessageApplicate",messageVO);
	}

	@Override
	public List<MessageVO> findMessageByMemberNo(int memberNo) {
		List<MessageVO> list = sqlSessionTemplate.selectList("message.findMessageByMemberNo",memberNo);
		return list;
	}

	@Override
	public List<BoardVO> findMessageBoardList(MessageBoardVO mgbvo) {
		List<BoardVO> list=sqlSessionTemplate.selectList("message.findMessageBoardList",mgbvo);
		return list;
	}

	@Override
	public int totalContent() {
		return sqlSessionTemplate.selectOne("message.totalContent");
	}

	@Override
	public MessageVO findMessageBoardByMessageNo(int messageNo) {
		return sqlSessionTemplate.selectOne("message.findMessageBoardByMessageNo",messageNo);
	}

	@Override
	public void messageDelete(int messageNo) {
		sqlSessionTemplate.delete("message.messageDelete",messageNo);
	}

}
