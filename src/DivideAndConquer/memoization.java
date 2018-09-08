package DivideAndConquer;

import java.math.BigInteger;
import java.util.Scanner;

public class memoization {
	/*
	 		* 입력
			첫 줄의 질문의 수 Q( 1 <= Q <= 32767) 가 입력으로 들어온다.
			다음 Q 줄에 5 개의 자연수 a_1 , p , q , k , n 이 주어진다. a_1 , p,q,k,n 은 109 +9 이하이다. a_1 은 첫 번째 항의 값을 나타낸다.
			출력
			각 줄에 a_n 을 k 로 나눈 나머지를 출력한다.
			입출력 예
			입력
			
			4
			1 3 2 100 4
			1 2 1 2 5
			1 2 1 1000000 20
			2 3 4 32767 5
			
			출력
			
			53
			1
			48575
			322

	 */
	public static BigInteger arr[] = new BigInteger[10000000];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int Q;
		Scanner in = new Scanner(System.in);
		Q=Integer.parseInt(in.nextLine());
		BigInteger a_1[] = new BigInteger[Q];
		BigInteger p[] = new BigInteger[Q];
		BigInteger q[] = new BigInteger[Q];
		BigInteger k[] = new BigInteger[Q];
		BigInteger n[] = new BigInteger[Q];
		
		for(int i=0; i<Q; i++) {
			a_1[i]=new BigInteger((in.next()));
			p[i]=new BigInteger((in.next()));
			q[i]=new BigInteger((in.next()));
			k[i]=new BigInteger((in.next()));
			n[i]=new BigInteger((in.next()));
			//System.out.println(a_1[i] + " " + p[i] + " " + q[i] + " " + k[i] + " " + n[i] + " i : " + i);
		}
		
		for(int j=0; j<Q; j++) {
			arr[0]=new BigInteger(a_1[j].toString());
			for(int x=0;x<n[j].intValue()-1;x++) {
				arr[x+1]=arr[x].multiply(p[j]).add(q[j]);
			}
			System.out.println(arr[n[j].intValue()-1].remainder(k[j]));
		}
		
	}

}
