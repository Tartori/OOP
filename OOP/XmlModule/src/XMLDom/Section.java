package XMLDom;

/** Class representing a section in the online help
 *
 *  @author A. Laube
 *  @version 1.0
 */
public class Section {

	private String name;
	private String number;
	private Integer level;
	
	
	public Section(String name, String number, Integer level) {
		super();
		this.name = name;
		this.number = number;
		this.level = level;
	}

	public String toString(){
		String ret="";
		for(int i = 0; i<level; i++){
			ret+=" ";
		}
		return ret+number+" "+name;
	}

	public String getName() {
		return name;
	}


	public String getNumber() {
		return number;
	}


	public Integer getLevel() {
		return level;
	}

}
