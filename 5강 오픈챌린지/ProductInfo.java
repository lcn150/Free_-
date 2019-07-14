package leech;

import java.util.Scanner;

public class ProductInfo {
	static int productID =0;
	static int numOfproduct =0;
	static Product[] p = new Product[10];
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int typeNo =0;
		int menuNo =0;
		while(menuNo!= 3) {
		       System.out.print("��ǰ �߰�(1), ����ǰ��ȸ(2) ������(3)>>>");
		       menuNo = sc.nextInt();
		       switch(menuNo) {
		       case 1:  //��ǰ�߰�
		    	   if(numOfproduct >=p.length) {
		    		   System.out.println("�� �̻� ��ǰ�߰��� �� �� ����");
		    		   break;
		    	   }
		    	   System.out.print("��ǰ ���� : å(1) ����CD(2) ȸȭå(3)>>");
		    	   typeNo = sc.nextInt();
		    	   if(typeNo<1 || typeNo>3) {
		    		   System.out.println("�߸��� ��ǰ ��ȣ��....");
		    		   break;
		    	   }
		    	   addProduct(typeNo);
		    	   break;
		    	   
		       case 2:  //��ǰ��ȸ
		    	   for(int i=0; i<numOfproduct; i++) {
		    		   System.out.println("-----------------------");
		    		   p[i].printInfo();  //�������̵�, ���� Ŭ������ ȣ��ȴ� �������̵����� ���� 
		    	   }
		       case 3: break;
		       default: System.out.println("�߸��Է�");
		    	   
		       }
		}
		
	}
	private static void addProduct(int typeNo) { // �Է¹޴� addProduct
		Scanner sc = new Scanner(System.in);
		System.out.print("��ǰ ����>>");
		String descript =sc.nextLine();
		System.out.print("������>>");
		String maker =sc.nextLine();
		System.out.print("��ǰ����>>");
		int price =sc.nextInt();
		sc.nextLine();
		switch(typeNo) {
		case 1: //å
			System.out.print("å ����>>");
			String title =sc.nextLine();
			System.out.print("����>>");
			String author =sc.nextLine();
			System.out.print("ISBN>>");
			int ISBN =sc.nextInt();
			
			p[numOfproduct] = new Book(productID++, descript, maker, price, ISBN, title, author);
			break;
		case 2: //����CD
			System.out.print("�ٹ� ����>>");
			String albumTitle =sc.nextLine();
			System.out.print("����>>");
			String artist =sc.nextLine();
			p[numOfproduct] = new CompectDisc(productID++, descript, maker, price, albumTitle, artist);
			break;
		case 3: //ȸȭå
			System.out.print("å����>>");
			String title2 =sc.nextLine();
			System.out.print("����>>");
			String author2 =sc.nextLine();
			System.out.print("���>>");
			String language =sc.nextLine();
			System.out.print("ISBN>>");
			int ISBN2 =sc.nextInt();
			p[numOfproduct] = new ConversationBook(productID++, descript, maker, price, ISBN2, title2, author2, language);
			break;
		}
		numOfproduct++;
	}
}
