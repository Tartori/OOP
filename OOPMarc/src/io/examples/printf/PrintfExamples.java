
public class PrintfExamples {

	public static void main(String[] args) {
		int a = 1023;
		long b = 123456789012345L;
		short c = 123;
		char d = 'X';
		float e = 3.14159f;
		double f = 3.1415926535898; // 13 Nachkommastellen

		System.out.printf("a = |%d|%n", a); // int (dezimal)
		System.out.printf("a = |%05d|%n", a); // int (dezimal mit führenden Nullen - 5stellig)
		System.out.printf("a = |%o|%n", a); // int (oktal)
		System.out.printf("a = |%x|%n", a); // int (hex)
		System.out.printf("a = |%7d|%n", a); // int Feldw. 7,rechtsbuendig
		System.out.printf("a = |%-7d|%n%n", a);// int Feldw. 7,linksbuendig
		System.out.printf("b = |%20d|%n", b);// long Feldw.20,rechtsbuendig
		
		System.out.printf("c = |%+d|%n", c); // short
		System.out.printf("d = |%c|%n", d); // char
		System.out.printf("e = |%f|%n", e); // float Gleitkommadarstellung
		System.out.printf("e = |%e|%n%n", e); // float Exponentialdarstellung
		
		System.out.printf("f = |%15.3f|%n", f); // double Feldw. 15,
											// Nachkommast. 3 gerundet
		System.out.printf("f = |%-15.5f|%n", f); // dasselbe linksbuendig
		System.out.printf("f = |%15.5e|%n", f); // Exponentialdarstellung
	}
}