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
	private static String SAME = "���� !!!";
	private static String ME = "���� �̰�� !!!";
	private static String Computer = "��ǻ�Ͱ� �̰�� !!!";
	
	private MenuPanel menuPanel = new MenuPanel();  //�ΰ��� �г� ����
	private GamePanel gamePanel = new GamePanel();
	
	GBB(){  //������
		//������ �������� �����ϴ� �ڵ�
		super("���� ����  �� ����~~");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Container c = getContentPane();
		c.setLayout(new BorderLayout());
		add(menuPanel, BorderLayout.NORTH);  //���̾ƿ� ���� ���� �޴� �ǳ�
		add(gamePanel, BorderLayout.CENTER); //�Ʒ��� ���� �ǳ�
		
		setSize(1000, 700);
		setVisible(true);
		
	}
	class MenuPanel extends JPanel{  //swingx�� ����
		//���� ���� �� �̹����� �ö����, ���콺�� Ŭ���ؼ� �������� ���� ����
		private JButton[] gbbBtn = new JButton[3];
		MenuPanel(){
			setBackground(Color.GRAY);
			for(int i =0; i<gbbBtn.length; i++) {
		     	gbbBtn[i] =new JButton(gbbImage[i]);
			    add(gbbBtn[i]);
			    gbbBtn[i].addActionListener(new MyActionListener()); 
			    //��ư�� �̺�Ʈó���� �� �ִ� ��� ����
			    gbbBtn[i].setSize(50,50);
			}
			
		}
		 //������ ��ư�� �̺�Ʈ ó��, �̺�Ʈ�����ʸ� �ۼ��ؼ� �ϼ�
		//�̺�Ʈ ó��, �̺�Ʈ�����ʸ� �ۼ�
		class MyActionListener implements ActionListener{  //�������̽� ����(Ŭ���������ϸ� �߻��ϴ� �̺�Ʈ)
			public void actionPerformed(ActionEvent e) { //ActionListener�� �߻�Ŭ���� ����
				JButton btn = (JButton)e.getSource();  //Ÿ�Ժ�ȯ����
				int computer = (int)(Math.random()*3); //��ǻ���� ����
				String winner = "SAME";      //���� �̰���� �Ǻ�
				//�̺�Ʈ �ҽ� �Ǵ�
				//com�� ���� ���� �� �̹��� �� �ϳ��� ������. Math.random()
				int damage =5;
				if(btn.getIcon() == gbbImage[0] && computer ==2  ||
				btn.getIcon() == gbbImage[1] && computer == 0 ||
				btn.getIcon() == gbbImage[2] && computer ==1) {// �̰����� 
					setBackground(Color.YELLOW);	
					winner = ME;
					damage++;
					
				}
				
				else if(btn.getIcon() == gbbImage[0] && computer ==1  ||
						btn.getIcon() == gbbImage[1] && computer == 2 ||
						btn.getIcon() == gbbImage[2] && computer ==0) {// ������
				     	setBackground(Color.DARK_GRAY);
				  			winner = Computer;
				  			damage--;
						
				}
				else if(btn.getIcon() == gbbImage[0] && computer ==0  ||
				   btn.getIcon() == gbbImage[1] && computer == 1 ||
				   btn.getIcon() == gbbImage[2] && computer ==2) {// �������
					setBackground(Color.ORANGE);
					  winner = SAME;		
				}
			     gamePanel.draw(btn.getIcon(), gbbImage.clone()[computer], winner);
			     if(damage==4) {
			    	 System.out.println("���� ���ظ� �Ծ���");
			     }
			     else if(damage==5){
			    	 System.out.println("�ƹ��� ���ذ�����");
			     }
			     else if(damage==6) {
			    	 System.out.println("��ǻ�Ͱ� �����Ѵ�");
			     }
			}
		}
	}
	
	class GamePanel extends JPanel{
		//���� ������ ����Ǵ� ȭ��, ���� ������ �̹����� ��ǻ�Ͱ� ������ �̹����� �׸�
		//���� �̰������ �Ǵ��Ͽ� ���ڸ� �����
	    private JLabel me = new JLabel("me");
	    private JLabel com = new JLabel("com");
	    private JLabel win = new JLabel("winner");
	    
		GamePanel(){
			setBackground(Color.GREEN);
			add(me);
			add(com);
			add(win);
			win.setForeground(Color.RED);  //winner�� ����ȭ (������ �� ����)
		}
		//���ӿ��� �̱����� ����ϴ� �Լ�
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