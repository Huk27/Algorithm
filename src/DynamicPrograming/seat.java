package DynamicPrograming;

import java.util.Scanner;

public class seat {
	public static int fibo[];
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		fibo = new int[40];
		fibo[1]=1;
		fibo[2]=2;
		for(int i=3; i<40; i++) {
			fibo[i]=fibo[i-2]+fibo[i-1];
		}
		
		Scanner in = new Scanner(System.in);
		int N = in.nextInt();
		int M = in.nextInt();
		if(M==0) {
			System.out.println(fibo[N]);
			return;
		}
		
		int arr[] = new int[M];
		int space[] = new int[M];
		for(int i=0; i<M; i++) {
			arr[i]=in.nextInt();
		}
		if(arr[0]!=1) space[0] = arr[0]-1;
		else space[0]=1;
		for(int i=1; i<M; i++) {
			space[i]=arr[i]-arr[i-1]-1;
			if(space[i]==0) space[i]=1;
		}
		
		int result=1;
		for(int a : space){
			//System.out.println(fibo[a]);
			result*=fibo[a];
		}
		if(N!=arr[M-1]) result*=fibo[(N-arr[M-1])];
		System.out.println(result);
	}

}
