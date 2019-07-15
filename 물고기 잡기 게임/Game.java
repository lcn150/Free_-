package leech;


public class Game {
	public static final int MAX_X =20;   //x축
	public static final int MAX_Y =10;   //y축
	private char map[][] = new char[MAX_Y][MAX_X]; //10X20판 생성
	private GameObject[] m = new GameObject[2];  //곰과 물고기m[0], m[1]
	int state;//상태 정보 저장   ex) 0은 게임중, 1은 Bear승, 2는 fish승
	Game(){ //초기에는 -표시만 //생성자Game
		for(int i=0; i<MAX_Y; i++) {
			for(int j=0; j<MAX_X; j++) {
				map[i][j] = '-';
			}
		}
		m[0] = new Bear(0,0,1);  //bear생성
		m[1] = new Fish(5,5,2);  //fish생성
		state = 0;
	}
	void run() {
		System.out.println("Bear의 Fish먹기 게임을 시작합니다.");
		update();
		draw();
		while(!gameEnd()) {
		    clear();
		    m[0].move();    //bear의 움직임
		    m[1].move();    //fish의 움직임
		    update();
		    draw();
		}
		//while 종료->bear가 fish를 잡았을때(총돌했음)
		System.out.println("Bear승!");
	}
	boolean gameEnd() {
		if(m[0].collide(m[1])) {
			return true;
		}
		return false;
	}
	void update() {  //b와@의 위치를 매번 업데이트해줌 
		for(int i=m.length-1; i>=0; i--) {
			map[m[i].getY()][m[i].getX()] = m[i].getShape();
		}
	}
	void clear() {
		for(int i=0; i<=m.length-1; i++) {    //B와@를 -로 바꿔준다
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