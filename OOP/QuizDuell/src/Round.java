import java.util.ArrayList;

public class Round {

	static int MAX_QUESTIONS = 3;
	private IQuestionPool questionPool;
	private ArrayList<Question> questions;
	private int round_number;
	private int answeredQuestions;
	
	public Round(int nbr, IQuestionPool pool) {
		round_number = nbr;
		questionPool = pool;
		questions = new ArrayList<Question>();
	}
	
	public void start() {
		for (int i=0; i<=MAX_QUESTIONS;i++)
		   questions.add(questionPool.getRandomQuestion());
		answeredQuestions = 0;
	}

	public String getDescription() {
		return "Round "+round_number;
	}

	public Question getCurrentQuestion(){return questions.get(answeredQuestions);}

	public boolean hasNextQuestion() {
		return (this.answeredQuestions < MAX_QUESTIONS);
	}

	public Question nextQuestion() {
		return questions.get(answeredQuestions++);
	}
	
	public void changePlayer() {
		answeredQuestions = 0;
	}	
	
	public Integer getNumber() {
		return this.round_number;
	}
}
