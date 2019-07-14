package leech;

public class CompectDisc extends Product{

	private String albumTitle;
	private String artist;
	public CompectDisc(int pID, String descript, String maker, int price, String albumTitle, String artist) {
		super(pID, descript,  maker, price);
		this.albumTitle = albumTitle;
		this.artist = artist;
	}
	public String getAlbumTitle() { return albumTitle;}
	public String getArtist() { return artist;}
	
	public void printInfo() {
		super.printInfo();
		System.out.println("�ٹ� ����: "+ albumTitle);
		System.out.println("���� : "+ artist);
	}
}