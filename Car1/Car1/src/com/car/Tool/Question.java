package com.car.Tool;

public class Question {
	private String question;
	private String option1;
	private String option2;
	private String option3;
	private String option4;
	private String answer;
	private String explain;
	private String pic;
	private String type;
	private String chapter;
	
	public Question()
	{
		this.question="";
		this.option1="";
		this.option2="";
		this.option3="";
		this.option4="";
		this.answer="";
		this.explain="";
		this.pic="";
		this.type="";
		this.chapter="";
	}
	
	public void show()
	{
		System.out.println("question:"+getQuestion());
		System.out.println("option1:"+getOption1());
		System.out.println("option2:"+getOption2());
		System.out.println("option3:"+getOption3());
		System.out.println("option4:"+getOption4());
		System.out.println("pic:"+getPic());
		System.out.println("answer:"+getAnswer());
		System.out.println("explain:"+getExplain());
		System.out.println("chapter:"+getChapter());
		System.out.println("type:"+getType());
	}
	
	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getOption1() {
		return option1;
	}

	public void setOption1(String option1) {
		this.option1 = option1;
	}

	public String getOption2() {
		return option2;
	}

	public void setOption2(String option2) {
		this.option2 = option2;
	}

	public String getOption3() {
		return option3;
	}

	public void setOption3(String option3) {
		this.option3 = option3;
	}

	public String getOption4() {
		return option4;
	}

	public void setOption4(String option4) {
		this.option4 = option4;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public String getExplain() {
		return explain;
	}

	public void setExplain(String explain) {
		this.explain = explain;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getChapter() {
		return chapter;
	}

	public void setChapter(String chapter) {
		this.chapter = chapter;
	}
	
	
	
}
