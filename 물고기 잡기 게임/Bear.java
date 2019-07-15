package leech;

import java.util.Scanner;
public class Bear extends GameObject {  //Ű���带 �̿��ϴ� Bear�� ������
	private Scanner scanner;
	public Bear(int x, int y, int distance){
		super(x,y,distance);
		scanner = new Scanner(System.in);  //Ű���� ����
	}
	@Override
	public char getShape() { //B��� ����
		return 'B';
	}
	public void move() {
		System.out.print("����(a), �Ʒ�(s), ��(w), ������(d) >> ");
		char ch;
		ch =scanner.next().charAt(0);
		switch(ch) {
		case'a':   //���� ��ư�̸�
			x--;
			if(x<0) x=0; //x�� ��輱�� �Ѿ��
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