package leech;

import java.util.Scanner;  //입력을 할 수 있도록 한다

class Phone{               //name과 tel이 들어있는 Phone클래스
	private String name;    //name
	private String tel;     //tel
	public Phone(String name,String tel){  //Phone클래스의 생성자
		this.name = name;
		this.tel = tel;
	}
	public String getname() {  //이름을 찍을 수 있는 getname메소드
		return name;
	}
	public String gettel() {   //번호를 찍을 수 있는  gettel메소드
		return tel;
	}
}

//정보입력 - 검색 - 출력
public class PhoneBook {   //main인 PhoneBook클래스
	private Scanner sc;    //키보드 사용가능하도록
	private Phone[] pA;    //레퍼런스 변수(인원수가 여러명일 수 있기 때문에 배열을 사용한다.)
	
	PhoneBook(){  //PhoneBook클래스의 생성자
		sc = new Scanner(System.in);  //키보드 생성자
	}
	
	void read() {   //처음의 입력 read메소드
		System.out.print("입력 인원 수: ");
		int n = sc.nextInt();    //인원수 n명 입력
		pA = new Phone[n];       //동적배열(n명을 pA에 저장)
		for(int i=0; i<pA.length; i++) {     //입력된 사람만큼 입력 가능
			System.out.print("이름과 번호를 입력하세요>>");
			String name = sc.next();    //name입력
			String tel = sc.next();     //tel입력
			
			pA[i] = new Phone(name, tel); //pA[]에 name과 tel이 저장됨
		}
		System.out.println("입력이 완성되었습니다.");
	}
	
	String search(String name){    //찾기 위한 search메소드
		for(int i=0; i<pA.length; i++) {        //전체 사람n명 만큼 동안
			if(pA[i].getname().equals(name)) {  //배열의 값이 이름과 맞는지 확인
				return pA[i].gettel();  //번호 불러와서 찍는다.
			}
		}
		return null;
	}
	
	void run() {  //실행의 run메소드
		read();   //입력 read메소드
		while(true) {
			System.out.print("검색 이름입력>>>");  //찾을 이름을 입력
			String name = sc.next();    //키보드로 이름을 찾는다.
			if(name.equals("그만"))      //그만이라는 입력을 받으면
				break;                  //나가기
			String tel =search(name);    //name에 맞는 tel을 찾는다.
			
			if(tel ==null) {            //name에 대한 tel을 못 찾았다면
				System.out.println(name+"님의 번호가 없습니다.");
			}
			else {   //name에 대한 tel을 찾았다면
			System.out.println(name+"에 대한 검색결과 번호는"+tel);
			}
		}
		sc.close();
	}
	
	public static void main(String[] args) {
		PhoneBook phonebook = new PhoneBook();  //phonebook 객체 생성
		phonebook.run();    //실행
		System.out.println("프로그램 종료!");   //break('그만') 후에 일어난 결과
	}
}
