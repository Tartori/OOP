public class MainProg {

	/**
	 * @param args unused
	 */
	public static void main(String[] args) {

		NIOListOfNumbers list = new NIOListOfNumbers();	
		list.readList("c:\\\\temp\\\\InFile.txt");
		list.writeList();		
		System.out.println("Done !!");
				
	}

}
