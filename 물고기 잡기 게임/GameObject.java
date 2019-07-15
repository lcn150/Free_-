package leech;

public abstract class GameObject{   //Bear와 Fish의 부모클래스
	protected int distance;
	protected int x, y;
	public GameObject(int startx, int starty, int distance){//super()로 호출
		this.x = startx;
		this.y = starty;
		this.distance = distance;
	}
	public int getX() { return x;}
	public int getY() { return y;}
	
	public boolean collide(GameObject p) {
		if(this.x ==p.getX() && this.y ==p.getY())
			return true;
		else
			return false;
	}
	public abstract void move();  //무조건 자식클래스에서 구현(추상클래스)
	public abstract char getShape();   //추상클래스
}