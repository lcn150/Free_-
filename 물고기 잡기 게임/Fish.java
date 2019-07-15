package leech;

import java.util.Random;   //Fish는 랜덤적으로 움직인다.
public class Fish extends GameObject{
	
     public Fish(int x,int y, int distance){  //생성자
    	 super(x, y,distance);
     }
     @Override
     public char getShape() {  //Fish모양
    	 return '@';
     }
     public void move() {    //Fish의 움직임
    	 int n = (int)(Math.random()*5);  //집가서 출력해보기 0 1 2 3 4
    	 if(n==0)
    		 x = x + distance;
    	 else if(n==1)
    		 x = x - distance;
    	 if(x<0) x=0;
    	 if(x>Game.MAX_X-1) x = Game.MAX_X-1;
    		 
    	 int r = (int)(Math.random()*5);  //집가서 출력해보기 0 1 2 3 4
    	 if(r==0)
    		 y = y + distance;
    	 else if(r==1)
    		 y = y - distance;
    	 if(y<0) y=0;
    	 if(y>Game.MAX_Y-1) y = Game.MAX_Y-1;
     }
}