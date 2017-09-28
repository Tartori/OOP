public class Answer {
    private String answer;
    private Boolean isCorrect;
    
    public Answer(String text, Boolean correct) {
    	answer = text;
    	isCorrect = correct;
    }
    
    public Boolean isCorrect() {
    	return isCorrect;
    }

	public String getAnswer() {
		return answer;
	}
}
