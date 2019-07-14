package leech;


public class Product {
     private int pID;
     private String descript;
     private String maker;
     private int price;
     
     public Product(int pID, String descript, String maker, int price) {
    	 this.pID = pID;
    	 this.descript = descript;
    	 this.maker = maker;
    	 this.price = price;
     }
     public int getPID() { return pID;}
     public String getDescript() { return descript;}
     public String getMaker() { return maker;}
     public int getPrice() { return price;}
     
     public void printInfo() {
    	 System.out.println("상품ID : "+pID);
    	 System.out.println("상품 설명 : "+descript);
    	 System.out.println("생산자 : "+maker);
    	 System.out.println("가격 : "+price);
     }
}