package Bean;

public class Question {

	private int questionId;
	private String questionString;
	private String answerString;
	
	public Question(String questioString,String answerString) {
		this.questionString=questioString;
		this.answerString=answerString;
	}

	public Question(int questionId,String questionString,String answerString) {
		// TODO 自動生成されたコンストラクター・スタブ
		this(questionString, answerString);
		this.questionId=questionId;
	}

	public int getQuestionId() {
		return questionId;
	}

	public void setQuestionId(int questionId) {
		this.questionId = questionId;
	}

	public String getQuestionString() {
		return questionString;
	}

	public void setQuestionString(String questionString) {
		this.questionString = questionString;
	}

	public String getAnswerString() {
		return answerString;
	}

	public void setAnswerString(String answerString) {
		this.answerString = answerString;
	}
}
