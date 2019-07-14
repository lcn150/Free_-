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
		       System.out.print("상품 추가(1), 모든상품조회(2) 끝내기(3)>>>");
		       menuNo = sc.nextInt();
		       switch(menuNo) {
		       case 1:  //상품추가
		    	   if(numOfproduct >=p.length) {
		    		   System.out.println("더 이상 상품추가를 할 수 없음");
		    		   break;
		    	   }
		    	   System.out.print("상품 종류 : 책(1) 음악CD(2) 회화책(3)>>");
		    	   typeNo = sc.nextInt();
		    	   if(typeNo<1 || typeNo>3) {
		    		   System.out.println("잘못된 상품 번호임....");
		    		   break;
		    	   }
		    	   addProduct(typeNo);
		    	   break;
		    	   
		       case 2:  //상품조회
		    	   for(int i=0; i<numOfproduct; i++) {
		    		   System.out.println("-----------------------");
		    		   p[i].printInfo();  //오버라이딩, 하위 클래스가 호출된다 동적바이딩으로 인해 
		    	   }
		       case 3: break;
		       default: System.out.println("잘못입력");
		    	   
		       }
		}
		
	}
	private static void addProduct(int typeNo) { // 입력받는 addProduct
		Scanner sc = new Scanner(System.in);
		System.out.print("상품 설명>>");
		String descript =sc.nextLine();
		System.out.print("생산자>>");
		String maker =sc.nextLine();
		System.out.print("상품가격>>");
		int price =sc.nextInt();
		sc.nextLine();
		switch(typeNo) {
		case 1: //책
			System.out.print("책 제목>>");
			String title =sc.nextLine();
			System.out.print("저자>>");
			String author =sc.nextLine();
			System.out.print("ISBN>>");
			int ISBN =sc.nextInt();
			
			p[numOfproduct] = new Book(productID++, descript, maker, price, ISBN, title, author);
			break;
		case 2: //음악CD
			System.out.print("앨범 제목>>");
			String albumTitle =sc.nextLine();
			System.out.print("가수>>");
			String artist =sc.nextLine();
			p[numOfproduct] = new CompectDisc(productID++, descript, maker, price, albumTitle, artist);
			break;
		case 3: //회화책
			System.out.print("책제목>>");
			String title2 =sc.nextLine();
			System.out.print("저자>>");
			String author2 =sc.nextLine();
			System.out.print("언어>>");
			String language =sc.nextLine();
			System.out.print("ISBN>>");
			int ISBN2 =sc.nextInt();
			p[numOfproduct] = new ConversationBook(productID++, descript, maker, price, ISBN2, title2, author2, language);
			break;
		}
		numOfproduct++;
	}
}
