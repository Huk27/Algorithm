package DivideAndConquer;

import java.math.BigInteger;
public class LargeIntegerProd {

	public static void main(String[] args) {
		// 기본아이디어 : 분할정복, 큰 정수 A,B 가 있다고 하면 A와 , B를 분할한다.
		// solution : (aPart1*bPart1)*10^2x + (aPart1*bPart2+aPart2*bPart1)*10^x + (aPart2*bPart2) = ")
		int a = Integer.MAX_VALUE/100000000;
		int b = Integer.MAX_VALUE/10;
		int atemp,btemp,x=0;
		System.out.println(a);
		System.out.println(b);
		atemp=a;
		btemp=b;

		while(atemp!=0 && btemp!=0){
			atemp=atemp/10;
			btemp=btemp/10;
			x++;
		}
		System.out.println("x : " + x);
		int aPart1 = (int) (a/Math.pow(10, x));
		int aPart2 = (int) (a%Math.pow(10, x));
		int bPart1 = (int) (b/Math.pow(10, x));
		int bPart2 = (int) (b%Math.pow(10, x));
		System.out.println("solution : (aPart1*bPart1)*10^2x + (aPart1*bPart2+aPart2*bPart1)*10^x + (aPart2*bPart2) = " +
				BigInteger.valueOf((long) ((aPart1*bPart1)*Math.pow(10, 2*x) + (aPart1*bPart2+aPart2*bPart1)*Math.pow(10, x) + (aPart2*bPart2)))
				);
		System.out.println("result : " + BigInteger.valueOf(a).multiply(BigInteger.valueOf(b)));
	}

}
