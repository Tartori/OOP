import java.util.ArrayList;

public class Question {

	private String questionText;
	private ArrayList<Answer> answers;

	public Question(String q, String correct, String wrong1, String wrong2, String wrong3) {
		this.questionText =q;
		answers = new ArrayList<Answer>();
		answers.add(new Answer(correct,true));
		answers.add(new Answer(wrong1,false));
		answers.add(new Answer(wrong2,false));
		answers.add(new Answer(wrong3,false));
		scramble();
	}
		
	private void scramble() {
		for (int i=0; i<3; i++) {
			int random = (int) (Math.random()*4);
			Answer a = answers.remove(random);
			answers.add(a);
		}
}

	public String getDescription() {
		return questionText + "\n" + 
	                    "\t A - " + answers.get(0).getAnswer() +"\n" + 
				        "\t B - " + answers.get(1).getAnswer() +"\n" + 
	                    "\t C - " + answers.get(2).getAnswer() +"\n" + 
				        "\t D - " + answers.get(3).getAnswer();
	}

	public Boolean getResult(String a) {
       char c = a.charAt(0);
       switch (c) {
       case 'A':
    	   return answers.get(0).isCorrect();
       case 'B':
    	   return answers.get(1).isCorrect();
       case 'C':
    	   return answers.get(2).isCorrect();
       case 'D':
    	   return answers.get(3).isCorrect();
    	        }
       return false;
    	   
	}

	public String getcorrectAnswer() {
		int i=0;
		for (Answer a : answers) {
			if (a.isCorrect()) {
				char r = (char) ('A'+i);
				return ""+r;
			} 				
			i++;
		}
		return "X";
	}

}
