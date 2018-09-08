package DivideAndConquer;

import java.util.Scanner;

public class color {
	/*
	 * �Է� ����
		ù° �ٿ��� ��ü ������ �� ���� ���� N �� �־��� �ִ�. N �� 2,4,8,16,32,64,128 ���� �ϳ��̴�.
		�������� �� �����ٰ� ���簢��ĭ���� ���� ���� ���� ���ʷ� �Է��� ��° �� ���� ������ �ٱ��� �־�����. �Ͼ������ ĥ���� ĭ�� 0 , ��ũ������ ĥ���� ĭ�� 1 �� �־����� �� ���ڻ��̿��� ��ĭ�� �ϳ��� �ִ�.
		��� ����
		ù° �ٿ��� �߶��� �Ͼ�� �������� ������ ����ϰ�
		��° �ٿ��� ��ũ�� �������� ������ ����Ѵ�.
		����� ��
		�Է�
		
		8
		1 1 0 0 0 0 1 1
		1 1 0 0 0 0 1 1
		0 0 0 0 1 1 0 0
		0 0 0 0 1 1 0 0
		1 0 0 0 1 1 1 1
		0 1 0 0 1 1 1 1
		0 0 1 1 1 1 1 1
		0 0 1 1 1 1 1 1
		
		���
		
		9
		7
	 */
	public static int white=0,pink=0;
	public static int input[][];
	
	public static void dq(int N, int x, int y) {
		/*
		 * dq(�����̱���,x��ǥ,y��ǥ)
		 * static 2���迭 input �迭�� �����ͼ� white,pink�� �����Ѵ�.
		 * white,pink �������� : sum ���� == N*N
		 * sum ���� : input[i][j] �� ��ϵ� 1 or 0 ��.
		 * N������ ���ҿ��� �����̰� ��� ��ũ���̸� sum�� N*N=4 �� �� ��.
		 * ��δ� ���� ������ white++
		 * �κ������� ������, �ٽ� �۰� �ɰ���.(N->N/2) ���̰�, 4���� ������ ���ҵ� �����̿� dq ����.
		 */
		int sum=0;
		for(int i=x; i<x+N; i++) {
			for(int j=y; j<y+N; j++) {
				if(input[i][j]==1)
					sum++;
			}
		}
		if(sum==N*N) pink++;
		else if(sum==0) white++;
		else {
			int DN=N/2;
			dq(DN,x,y);
			dq(DN,x+DN,y);
			dq(DN,x,y+DN);
			dq(DN,x+DN,y+DN);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int N=in.nextInt();
		int arr[][] = new int[N][N];
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				arr[i][j]=in.nextInt();
			}
		}
		input=arr;
		
		dq(N,0,0);
		in.close();
		System.out.println(white);
		System.out.println(pink);
	}

}
