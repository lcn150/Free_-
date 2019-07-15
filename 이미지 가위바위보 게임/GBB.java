package leech;

import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GBB extends JFrame{
	private ImageIcon[] gbbImage = {
	       new ImageIcon("C:\\Users\\lco16\\eclipse-workspace\\leech\\src\\leech\\1.jpg"),
	       new ImageIcon("C:\\Users\\lco16\\eclipse-workspace\\leech\\src\\leech\\2.jpg"),
	       new ImageIcon("C:\\Users\\lco16\\eclipse-workspace\\leech\\src\\leech\\3.jpg"),
	};
	private static String SAME = "비겼다 !!!";
	private static String ME = "내가 이겼다 !!!";
	private static String Computer = "컴퓨터가 이겼다 !!!";
	
	private MenuPanel menuPanel = new MenuPanel();  //두개의 패널 생성
	private GamePanel gamePanel = new GamePanel();
	
	GBB(){  //생성자
		//윈도우 프레임을 구성하는 코드
		super("가위 바위  보 게임~~");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		add(menuPanel, BorderLayout.NORTH);  //레이아웃 구성 위는 메뉴 판넬
		add(gamePanel, BorderLayout.CENTER); //아래는 게임 판넬
		
		setSize(1000, 700);
		setVisible(true);
		
	}
	class MenuPanel extends JPanel{  //swingx에 있음
		//가위 바위 보 이미지가 올라오고, 마우스를 클릭해서 가위바위 보를 선택
		private JButton[] gbbBtn = new JButton[3];
		MenuPanel(){
			setBackground(Color.GRAY);
			for(int i =0; i<gbbBtn.length; i++) {
		     	gbbBtn[i] =new JButton(gbbImage[i]);
			    add(gbbBtn[i]);
			    gbbBtn[i].addActionListener(new MyActionListener()); 
			    //버튼에 이벤트처리할 수 있는 기능 삽입
			    gbbBtn[i].setSize(50,50);
			}
			
		}
		 //세개의 버튼에 이벤트 처리, 이벤트리스너를 작성해서 완성
		//이벤트 처리, 이벤트리스너를 작성
		class MyActionListener implements ActionListener{  //인터페이스 구현(클릭동작을하면 발생하는 이벤트)
			public void actionPerformed(ActionEvent e) { //ActionListener의 추상클래스 구현
				JButton btn = (JButton)e.getSource();  //타입변환해줌
				int computer = (int)(Math.random()*3); //컴퓨터의 난수
				String winner = "SAME";      //누가 이겼는지 판별
				//이벤트 소스 판단
				//com이 가위 바위 보 이미지 중 하나를 선택함. Math.random()
				int damage =5;
				if(btn.getIcon() == gbbImage[0] && computer ==2  ||
				btn.getIcon() == gbbImage[1] && computer == 0 ||
				btn.getIcon() == gbbImage[2] && computer ==1) {// 이겼을때 
					setBackground(Color.YELLOW);	
					winner = ME;
					damage++;
					
				}
				
				else if(btn.getIcon() == gbbImage[0] && computer ==1  ||
						btn.getIcon() == gbbImage[1] && computer == 2 ||
						btn.getIcon() == gbbImage[2] && computer ==0) {// 졌을때
				     	setBackground(Color.DARK_GRAY);
				  			winner = Computer;
				  			damage--;
						
				}
				else if(btn.getIcon() == gbbImage[0] && computer ==0  ||
				   btn.getIcon() == gbbImage[1] && computer == 1 ||
				   btn.getIcon() == gbbImage[2] && computer ==2) {// 비겼을때
					setBackground(Color.ORANGE);
					  winner = SAME;		
				}
			     gamePanel.draw(btn.getIcon(), gbbImage.clone()[computer], winner);
			     if(damage==4) {
			    	 System.out.println("내가 피해를 입었다");
			     }
			     else if(damage==5){
			    	 System.out.println("아무런 피해가없다");
			     }
			     else if(damage==6) {
			    	 System.out.println("컴퓨터가 아파한다");
			     }
			}
		}
	}
	
	class GamePanel extends JPanel{
		//실제 게임이 진행되는 화면, 내가 선택한 이미지와 컴퓨터가 선택한 이미지를 그림
		//누가 이겼는지를 판단하여 승자를 출력함
	    private JLabel me = new JLabel("me");
	    private JLabel com = new JLabel("com");
	    private JLabel win = new JLabel("winner");
	    
		GamePanel(){
			setBackground(Color.GREEN);
			add(me);
			add(com);
			add(win);
			win.setForeground(Color.RED);  //winner의 색변화 (글자의 색 지정)
		}
		//게임에서 이긴사람을 출력하는 함수
		public void draw(Icon myImage, Icon comImage, String w) {
			me.setIcon(myImage);
			com.setIcon(comImage);
			win.setText(w);
		}
	}
	public static void main(String[] args) {
		new GBB();
	}
}