package leech;

public abstract class GameObject{   //Bear�� Fish�� �θ�Ŭ����
	protected int distance;
	protected int x, y;
	public GameObject(int startx, int starty, int distance){//super()�� ȣ��
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
	public abstract void move();  //������ �ڽ�Ŭ�������� ����(�߻�Ŭ����)
	public abstract char getShape();   //�߻�Ŭ����
}