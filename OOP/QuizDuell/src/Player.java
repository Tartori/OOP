import java.util.ArrayList;

public class Player {
	
	private String name;
	private ArrayList<Duel> duells = new ArrayList<Duel>(); 
	
	public Player(String aName) {
		name = aName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ArrayList<Duel> getDuells() {
		return duells;
	}

	public void addDuell(Duel d) {
		duells.add(d);
	}

	public Duel getDuell(int number) {
		Duel duell = null;
		for (Duel d: duells) {
			if (d.getNumber() == number) {
				duell = d;
			    break;
			}    
		}
		return duell;
	}

}
