import java.util.HashMap;
import java.util.Scanner;

public class QuizDuellMenu {

	private Scanner in;
	private PlayerList playerList;
	private IQuestionPool pool;
	
	public QuizDuellMenu(PlayerList pList, IQuestionPool pool) {
		in = new Scanner(System.in);
		playerList = pList;
		this.pool = pool;
	}

	public void run() {

		boolean more = true;
		Player currentPlayer = null;

		while (more) {
			System.out.println("Log I)n  N)ew Duel  C)ontinue Duel D)isplay Duels  Log O)ut  Q)uit");
			String command = in.nextLine().toUpperCase();

			if (command.equals("I")) {
				System.out.print("User name: ");
				currentPlayer = playerList.get(in.nextLine());
				if (currentPlayer == null) {
					System.out.println("Player not known!");
			   }
			} else if (command.equals("O")) {
				currentPlayer = null;
			} else if (command.equals("Q")) {
				// quit the program
				more = false;
			} else if (command.equals("N")) {
				if (currentPlayer == null)
					System.out.println("Log in first!");
				else {
					// choose opponent
					Player player2 = selectOpponent(currentPlayer);
					// Create new duel
					Duel d = new Duel(currentPlayer, player2, pool);
					currentPlayer.addDuell(d);
					player2.addDuell(d);
				   // TODO let the current player play the next round
					playRound(d,currentPlayer);
				}
			} else if (command.equals("D")) {
				if (currentPlayer == null)
					System.out.println("Log in first!");
				else {
					for (Duel d: currentPlayer.getDuells()) {						
						System.out.println(d.getDescription());
					}
				}
			} else if (command.equals("C")) {
				if (currentPlayer == null)
					System.out.println("Log in first!");
				else {
					System.out.println("Enter Duel number:");
					String number = in.nextLine();
					Duel d = currentPlayer.getDuell(new Integer(number));
					if (d != null ) {
						System.out.println(d.getDescription());
						if (d.isFinished()) {
							System.out.println("Duel is finished.");														
						}
						else if (d.canBeContinued(currentPlayer)) {
							// TODO let the current player play the next round
							playRound(d,currentPlayer);
						} else {
							System.out.println("Waiting for opponent.");							
						}
					} else {
						System.out.println("Incorrect Duell number!!!");						
					}
				}
			} else {
				System.out.println("Incorrect command");				
			}
		}
	}

	private void playRound(Duel d, Player p) {
		System.out.println("Playing "+ d.displayCurrentRound());
		System.out.println("Now should the player answer the questions...");

		while(d.roundActive()){
			System.out.println(d.getNextQuestion());
			if(d.evaluateAnswer(in.nextLine())){
				System.out.println("Correct Answer!!");
			}
			else {
				System.out.println("Wrong answer, Correct answer is "+d.getCorrectAnswer());
			}
		}
        d.cleanUpRound();
		System.out.println(d.getDescription());

	}

	private Player selectOpponent(Player currentPlayer) {
		displayAvailableOpponents(currentPlayer);
		System.out.print("Opponent's name: ");
		Player opponent = playerList.get(in.nextLine());
		return opponent;
	}

	private void displayAvailableOpponents(Player player1) {
		if (playerList.isEmpty()) {
			System.out.println("No opponents available!");
		} else {
			System.out.println("Available opponents:");
			for (Player player : playerList.allValues()) {
				String name = player.getName();
				if (!name.equals(player1.getName())) {
					System.out.println(name);
				}
			}
		}
	}

	/*private Player getPlayer(String aName) {
		if (aName != null && !aName.isEmpty()) {
			Player p = playerList.get(aName);
			if (p != null) {
				return p;
			} else {
				p = new Player(aName);
				playerList.put(aName, p);
				return p;
			}
		}
		return null;
	}*/

}
