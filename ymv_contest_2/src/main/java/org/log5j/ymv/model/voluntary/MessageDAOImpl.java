package org.log5j.ymv.model.voluntary;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MessageDAOImpl implements MessageDAO{
	@Resource(name="sqlSessionTemplate")
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public void sendMessageApplicate(MessageVO messageVO) {
		sqlSessionTemplate.insert("message.sendMessageApplicate",messageVO);
	}

	@Override
	public List<MessageVO> findMessageByMemberNo(int memberNo) {
		List<MessageVO> list = sqlSessionTemplate.selectList("message.findMessageByMemberNo",memberNo);
		return list;
	}

}
