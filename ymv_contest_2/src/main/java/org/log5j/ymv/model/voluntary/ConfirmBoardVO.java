package org.log5j.ymv.model.voluntary;

public class ConfirmBoardVO {
	private int boardNo;
	private String title;
	private String field;
	private String location;
	private String age;
	private String recruitingStart;
	private String recruitingEnd;
	private String content;
	private int memberNo;
	private String timePosted;
	private int hit;
	private String volunteeringStartDate;
	private String volunteeringEndDate;
	private String volunteeringStartTime;
	private String volunteeringEndTime;
	
	public ConfirmBoardVO() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public ConfirmBoardVO(int boardNo, String title, String field,
			String location, String age, String recruitingStart,
			String recruitingEnd, String content, int memberNo) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.field = field;
		this.location = location;
		this.age = age;
		this.recruitingStart = recruitingStart;
		this.recruitingEnd = recruitingEnd;
		this.content = content;
		this.memberNo = memberNo;
	}
	

	public ConfirmBoardVO(int boardNo, String title, String field,
			String location, String age, String recruitingStart,
			String recruitingEnd, String content, int memberNo,
			String volunteeringStartDate, String volunteeringEndDate,
			String volunteeringStartTime, String volunteeringEndTime) {
		super();
		this.boardNo = boardNo;
		this.title = title;
		this.field = field;
		this.location = location;
		this.age = age;
		this.recruitingStart = recruitingStart;
		this.recruitingEnd = recruitingEnd;
		this.content = content;
		this.memberNo = memberNo;
		this.volunteeringStartDate = volunteeringStartDate;
		this.volunteeringEndDate = volunteeringEndDate;
		this.volunteeringStartTime = volunteeringStartTime;
		this.volunteeringEndTime = volunteeringEndTime;
	}


	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getRecruitingStart() {
		return recruitingStart;
	}

	public void setRecruitingStart(String recruitingStart) {
		this.recruitingStart = recruitingStart;
	}

	public String getRecruitingEnd() {
		return recruitingEnd;
	}

	public void setRecruitingEnd(String recruitingEnd) {
		this.recruitingEnd = recruitingEnd;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public int getMemberNo() {
		return memberNo;
	}

	public void setMemberNo(int memberNo) {
		this.memberNo = memberNo;
	}

	public String getTimePosted() {
		return timePosted;
	}

	public void setTimePosted(String timePosted) {
		this.timePosted = timePosted;
	}

	public int getHit() {
		return hit;
	}

	public void setHit(int hit) {
		this.hit = hit;
	}

	public String getVolunteeringStartDate() {
		return volunteeringStartDate;
	}

	public void setVolunteeringStartDate(String volunteeringStartDate) {
		this.volunteeringStartDate = volunteeringStartDate;
	}

	public String getVolunteeringEndDate() {
		return volunteeringEndDate;
	}

	public void setVolunteeringEndDate(String volunteeringEndDate) {
		this.volunteeringEndDate = volunteeringEndDate;
	}

	public String getVolunteeringStartTime() {
		return volunteeringStartTime;
	}

	public void setVolunteeringStartTime(String volunteeringStartTime) {
		this.volunteeringStartTime = volunteeringStartTime;
	}

	public String getVolunteeringEndTime() {
		return volunteeringEndTime;
	}

	public void setVolunteeringEndTime(String volunteeringEndTime) {
		this.volunteeringEndTime = volunteeringEndTime;
	}

	
	
	
}
