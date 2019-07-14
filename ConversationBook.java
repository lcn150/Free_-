package leech;

public class ConversationBook extends Book{
	private String language;
	public ConversationBook(int pID, String descript, String maker, int price, int ISBN, String title, String author, String language) {
		super(pID, descript, maker, price, ISBN, title, author);
		this.language = language;
	}
	public String getLanguage() {
		return language;
	}
	public void printInfo() {
		super.printInfo();
		System.out.println("¾ð¾î : "+language);
	}

}
