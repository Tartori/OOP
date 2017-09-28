import java.util.ArrayList;

public class MockQuestionPool implements IQuestionPool {

	private static ArrayList<Question> pool = new ArrayList<Question>();

	public MockQuestionPool() {
		pool.add(new Question("Was ist KEIN Tier?", "Goldbär", "Goldmull",
				"Goldfuchs", "Goldhamster"));
		pool.add(new Question("Was ist ein Tier?", "Goldmull", "Goldhase",
				"Goldwolf", "Goldbär"));
		pool.add(new Question("Was ist KEINE Stadt der Schweiz?", "Berlin", "Bern",
				"Zürich", "Basel"));
		pool.add(new Question("Was ist eine Stadt der Schweiz?", "Biel", "Berlin",
				"Bamberg", "Bremen"));
		pool.add(new Question("Was ist KEIN Teil einer Digitalkamera?", "Sieb", "Linse",
				"Chip", "Sensor"));
		pool.add(new Question("Was ist ein Teil einer Digitalkamera?", "Chip", "Maus",
				"Sieb", "Eimer"));
		pool.add(new Question("Which city is NOT a capital?", "Frankfort", "Paris",
				"London", "Bern"));
	}

	public Question getRandomQuestion() {
		int random = (int) (Math.random() * pool.size());
		return (pool.get(random));
	}

}
