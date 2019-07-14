package leech;


class Point{  //부모클래스
	private int x,y;
	
	public void set(int x, int y) { 
		this.x = x;
		this.y = y;
	}
	
	public void showPoint() {    //자식클래스에서만 사용가능(기말)x,y가 private 선언이기 때문에
		System.out.println("("+ x+","+y+")");
	}
	
	public Point() {
		System.out.println("Super class");  //객체 생성하면 동시에 출력
	}
	
	public Point(int x, int y) {  //생성자
		this.x = x;
		this.y = y;
	}
}
 class ColorPoint extends Point{  //Point클래스를 상속받은 자식클래스
	private String color;      //x,y,color
	
	public void setColor(String color) {  //set(), showPoint(), setColor()
		this.color = color;
	}
	
	public void showColorPoint() {  //자식클래스에서 사용가능하도록 따로 생성해야함
		System.out.println(color);
		showPoint();   //Point의 showPoint()
	}
	
	public ColorPoint() {
	 //필드 초기화
		System.out.println("Sub class");  //객체 생성하면 동시에 출력
	}
	
	public ColorPoint(int x, int y, String color) {//자식클래스의 생성자
		super(x,y); //super()메소드를 이용하여 생략가능
		this.color = color;
	}
}

public class ColorPointEx {
	public static void main(String[] args) {
		Point p =new Point();  //부모클래스 객체 생성, Super Class출력
		
		p.set(1, 2);
		p.showPoint();  // (1,2)
		
		ColorPoint cp = new ColorPoint();  //sub클래스뿐만아니라super클래스가 먼저생성된다
		//Super class
		//Sub class
		cp.set(3, 4);
		cp.setColor("red");
		cp.showColorPoint(); //red; (3,4);
		//267쪽코드
		
		ColorPoint ccp = new ColorPoint(5,6,"blue");
		ccp.showColorPoint();    //blue; (5,6);
	}
}
