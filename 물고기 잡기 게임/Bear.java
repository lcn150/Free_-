package leech;

import java.util.Scanner;
public class Bear extends GameObject {  //키보드를 이용하는 Bear의 움직임
	private Scanner scanner;
	public Bear(int x, int y, int distance){
		super(x,y,distance);
		scanner = new Scanner(System.in);  //키보드 생성
	}
	@Override
	public char getShape() { //B모양 생성
		return 'B';
	}
	public void move() {
		System.out.print("왼쪽(a), 아래(s), 위(w), 오른쪽(d) >> ");
		char ch;
		ch =scanner.next().charAt(0);
		switch(ch) {
		case'a':   //왼쪽 버튼이면
			x--;
			if(x<0) x=0; //x가 경계선을 넘어가면
			break;
		case's':
			y++;
			if(y>Game.MAX_Y-1) y = Game.MAX_Y;
			break;
		case'w':
			y--;
			if(y<0) y=0;
			break;
		case'd':
			x++;
			if(x>Game.MAX_X-1) x = Game.MAX_X;
			break;
		}
		
	}
}