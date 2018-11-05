package DivideAndConquer;

public class HanoiTower {

	public static void hanoi(int N, String from, String center, String to) {
	
		if(N==1) System.out.println("원판 1을 " + from + "에서 " + to + "로 옮긴다.");
		else{
		hanoi(N-1, from, to, center);
		System.out.println("원판 " + N + "을 " + from + "에서 " + to + "로 옮긴다. ");
		hanoi(N-1, center, from, to);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi(3,"A","B","C");
	}

}
