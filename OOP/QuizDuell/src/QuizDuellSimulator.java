public class QuizDuellSimulator {

	/**
	 * @param no args
	 */
	public static void main(String[] args) {
		
		
		PlayerList  playerList = new PlayerList();
		playerList.init();
		
	
		QuizDuellMenu menu = new QuizDuellMenu(playerList, new MockQuestionPool());		
     	 menu.run();
                
	}

}
