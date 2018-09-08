package DivideAndConquer;

import java.util.Scanner;

public class color {
	/*
	 * 입력 형식
		첫째 줄에는 전체 종이의 한 변의 길이 N 이 주어져 있다. N 은 2,4,8,16,32,64,128 중의 하나이다.
		색종이의 각 가로줄과 정사각형칸들의 색이 윗줄 부터 차례로 입력의 둘째 줄 부터 마지막 줄까지 주어진다. 하얀색으로 칠해진 칸은 0 , 핑크색으로 칠해진 칸은 1 로 주어지며 각 숫자사이에는 빈칸이 하나씩 있다.
		출력 형식
		첫째 줄에는 잘라진 하얀색 색종이의 개수를 출력하고
		둘째 줄에는 핑크색 색종이의 개수를 출력한다.
		입출력 예
		입력
		
		8
		1 1 0 0 0 0 1 1
		1 1 0 0 0 0 1 1
		0 0 0 0 1 1 0 0
		0 0 0 0 1 1 0 0
		1 0 0 0 1 1 1 1
		0 1 0 0 1 1 1 1
		0 0 1 1 1 1 1 1
		0 0 1 1 1 1 1 1
		
		출력
		
		9
		7
	 */
	public static int white=0,pink=0;
	public static int input[][];
	
	public static void dq(int N, int x, int y) {
		/*
		 * dq(색종이길이,x좌표,y좌표)
		 * static 2차배열 input 배열을 가져와서 white,pink를 증감한다.
		 * white,pink 증감조건 : sum 변수 == N*N
		 * sum 변수 : input[i][j] 에 기록된 1 or 0 값.
		 * N길이의 분할에서 색종이가 모두 핑크색이면 sum은 N*N=4 가 될 것.
		 * 모두다 같지 않으면 white++
		 * 부분적으로 같으면, 다시 작게 쪼갠다.(N->N/2) 줄이고, 4개로 나눠진 분할된 색종이에 dq 돌림.
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
