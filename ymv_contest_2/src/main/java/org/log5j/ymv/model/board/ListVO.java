package org.log5j.ymv.model.board;


import java.util.List;

public class ListVO {
	private List<BoardVO> list;
	private PagingBean pagingBean;
	
	public ListVO() {
		super();
	}

	public ListVO(List<BoardVO> list, PagingBean pagingBean) {
		super();
		this.list = list;
		this.pagingBean = pagingBean;
	}

	public List<BoardVO> getList() {
		return list;
	}

	public void setList(List<BoardVO> list) {
		this.list = list;
	}
	public void setList(int i, RecruitBoardVO rbvo) {
		this.list.set(i, rbvo);
	}

	public PagingBean getPagingBean() {
		return pagingBean;
	}

	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}

	@Override
	public String toString() {
		return "ListVO [list=" + list + ", pagingBean=" + pagingBean + "]";
	}
	
}










