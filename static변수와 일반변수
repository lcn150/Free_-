package leech;


class StaticSample{
	public int n;        //인스턴스변수, 실행시 메모리할당, 동적할당
	public void g() {
		m=20;
	}
	public void h() {
		m =30;
	}
	public static int m;   //클래스변수, 컴파일시 메모리 할당, 정적할당
	public static void f() {
		m=5;
	}
}

public class newname {
	public static void main(String[] args) {
		StaticSample s1, s2;   //주소를 저장하는 레퍼런스 변수
		s1 = new StaticSample();
		s2 = new StaticSample();
		s1.n = 5;      //일반 인스턴스 변수n
		System.out.println(s1.n);     //5출력
		s1.g();  //m=20
		s2.n = 8;      //일반 인스턴스 변수n
		System.out.println(s2.n);    //8출력
		s2.h();    //m=30
		s2.f();    //static m=5
		System.out.println(s1.m);   //5출력
    
    
		//StaticSample.n = 100;  //n은 일반변수라서 오류가 발생한다.
		
		StaticSample.m = 100;   //static선언한 변수와 메소드는 객체생성없어도 접근가능하다
		System.out.println(StaticSample.m);   //100출력
		StaticSample.f();     
		System.out.println(StaticSample.m);  //5출력
	}
}
