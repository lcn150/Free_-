package leech;


public class Game {
	public static final int MAX_X =20;   //x��
	public static final int MAX_Y =10;   //y��
	private char map[][] = new char[MAX_Y][MAX_X]; //10X20�� ����
	private GameObject[] m = new GameObject[2];  //���� �����m[0], m[1]
	int state;//���� ���� ����   ex) 0�� ������, 1�� Bear��, 2�� fish��
	Game(){ //�ʱ⿡�� -ǥ�ø� //������Game
		for(int i=0; i<MAX_Y; i++) {
			for(int j=0; j<MAX_X; j++) {
				map[i][j] = '-';
			}
		}
		m[0] = new Bear(0,0,1);  //bear����
		m[1] = new Fish(5,5,2);  //fish����
		state = 0;
	}
	void run() {
		System.out.println("Bear�� Fish�Ա� ������ �����մϴ�.");
		update();
		draw();
		while(!gameEnd()) {
		    clear();
		    m[0].move();    //bear�� ������
		    m[1].move();    //fish�� ������
		    update();
		    draw();
		}
		//while ����->bear�� fish�� �������(�ѵ�����)
		System.out.println("Bear��!");
	}
	boolean gameEnd() {
		if(m[0].collide(m[1])) {
			return true;
		}
		return false;
	}
	void update() {  //b��@�� ��ġ�� �Ź� ������Ʈ���� 
		for(int i=m.length-1; i>=0; i--) {
			map[m[i].getY()][m[i].getX()] = m[i].getShape();
		}
	}
	void clear() {
		for(int i=0; i<=m.length-1; i++) {    //B��@�� -�� �ٲ��ش�
			map[m[i].getY()][m[i].getX()] = '-';
		}
	}
	void draw() {
		System.out.println("************************************************");
		for(int i=0; i<MAX_Y; i++) {
			for(int j=0; j<MAX_X; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Game game = new Game();
		game.run();
        
	}
}