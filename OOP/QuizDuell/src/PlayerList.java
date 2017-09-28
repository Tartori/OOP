import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class PlayerList {
	
	private HashMap<String, Player> playerList = new HashMap<String, Player>();
	
	public void init() {
		String name = "fred";
		playerList.put(name,new Player(name));
		name = "anna";
		playerList.put(name,new Player(name));
		name = "sam";
		playerList.put(name,new Player(name));
	}

	public Collection<Player> allValues() {
			return playerList.values();
	}

	public void put(String aName, Player aPlayer) {
		playerList.put(aName,aPlayer);
	}

	public Player get(String aName) {
		return playerList.get(aName);
	}

	public boolean isEmpty() {
		return playerList.isEmpty();
	}

	public ArrayList<String> allNames() {
		ArrayList<String> stringList = new ArrayList<String>();
		for (Player player : playerList.values()) {
			stringList.add(player.getName());
		}
		return stringList;
	}
	
}
