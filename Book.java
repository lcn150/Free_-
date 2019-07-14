package leech;

public class Book extends Product{
	private int ISBN;
	private String title;
	private String author;
	
	public Book(int pID, String descript, String maker, int price, int ISBN, String title, String author) {
		super(pID, descript, maker, price);
		this.ISBN = ISBN;
		this.title = title;
		this.author = author;
	}
	public int getISBN() { return ISBN;}
	public String gettitle() { return title;}
	public String getauthor() { return author; }
 
	public void printInfo() {
		super.printInfo();
		System.out.println("ISBN : "+ISBN);
		System.out.println("책 제목 : "+title);
		System.out.println("저자 : "+author);
		
	}
}
