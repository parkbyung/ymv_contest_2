package org.log5j.ymv.model.voluntary;

import org.log5j.ymv.model.board.BoardVO;

public class MessageBoardVO implements BoardVO {
	private int memberNo;
	private int pageNo;
	
	public MessageBoardVO() {
		super();
	}

	public MessageBoardVO(int memberNo, int pageNo) {
		super();
		this.memberNo = memberNo;
		this.pageNo = pageNo;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	@Override
	public String toString() {
		return "MessageBoardVO [memberNo=" + memberNo + ", pageNo=" + pageNo
				+ "]";
	}

	
}
