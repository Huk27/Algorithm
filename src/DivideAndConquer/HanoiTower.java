package DivideAndConquer;

public class HanoiTower {

	public static void hanoi(int N, String from, String center, String to) {
	
		if(N==1) System.out.println("���� 1�� " + from + "���� " + to + "�� �ű��.");
		else{
		hanoi(N-1, from, to, center);
		System.out.println("���� " + N + "�� " + from + "���� " + to + "�� �ű��. ");
		hanoi(N-1, center, from, to);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		hanoi(3,"A","B","C");
	}

}
