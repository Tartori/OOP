import java.util.ArrayList;


public class Duel {
	
	static int MAX_ROUND = 6;

	static int counter = 1;

	private int number;
	private Player player1;
	private Player player2;
	private Round currentRound;
	private int round_count = 1;
	private ArrayList<Round> rounds = new ArrayList<>();
	private StatusType status;
	private IQuestionPool pool;
	private int player1score;
	private int player2score;

	public Duel(Player currentPlayer, Player player22, IQuestionPool pool2) {
		this.number = counter++;
		this.player1 = currentPlayer;
		this.player2 = player22;
		status = StatusType.PLAYER1;
		this.pool = pool2;
		newRound();
	}

	public int getNumber() {
		return number;
	}

	public String getDescription() {
		return "Duell " + number + " : " + player1.getName() + " - "
				+ player2.getName() + " : "
				+ getScore(player1) + " - "
				+ getScore(player2) + " : "
				+ "Round: "
				+ currentRound.getNumber() + " : " + status;
	}

	private int getScore(Player player) {
		if (player1 == player) return player1score;
		if (player2 == player) return player2score;
		return 0;
	}

	public String getNextQuestion(){return currentRound.nextQuestion().getDescription();}

	public boolean evaluateAnswer(String s){
		boolean hasScored=currentRound.getCurrentQuestion().getResult(s);
		if(hasScored){
			if(status==StatusType.PLAYER1) {player1score++;}
			else{player2score++;}
		}
		return hasScored;
	}

	public String getCorrectAnswer(){return currentRound.getCurrentQuestion().getcorrectAnswer();}


	public boolean roundActive(){
		return currentRound.hasNextQuestion();
	}

	public void cleanUpRound(){
		currentRound.changePlayer();
		status=status == StatusType.PLAYER1?StatusType.PLAYER2:StatusType.PLAYER1;
		if(status==StatusType.PLAYER1){
			newRound();
		}
	}

	public String displayCurrentRound() {
		return currentRound.getDescription();
	}

	public boolean isFinished() {
		return (this.status == StatusType.FINISHED);
	}

	private void newRound() {
		if (round_count <= MAX_ROUND) {
			currentRound = new Round(round_count,pool);
			currentRound.start();
			rounds.add(currentRound);
			round_count++;
			currentRound.start();
		} else
			this.status = StatusType.FINISHED;
	}

	public boolean canBeContinued(Player currentPlayer) {
		if (currentPlayer == player1 && this.status == StatusType.PLAYER1)
			return true;
		if (currentPlayer == player2 && this.status == StatusType.PLAYER2)
			return true;
		return false;
	}
	
}
