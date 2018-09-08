package DivideAndConquer;

import java.math.BigInteger;
import java.util.Scanner;

public class memoization {
	/*
	 		* �Է�
			ù ���� ������ �� Q( 1 <= Q <= 32767) �� �Է����� ���´�.
			���� Q �ٿ� 5 ���� �ڿ��� a_1 , p , q , k , n �� �־�����. a_1 , p,q,k,n �� 109 +9 �����̴�. a_1 �� ù ��° ���� ���� ��Ÿ����.
			���
			�� �ٿ� a_n �� k �� ���� �������� ����Ѵ�.
			����� ��
			�Է�
			
			4
			1 3 2 100 4
			1 2 1 2 5
			1 2 1 1000000 20
			2 3 4 32767 5
			
			���
			
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
