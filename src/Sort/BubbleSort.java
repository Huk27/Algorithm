package Sort;

public class BubbleSort {
	// �� �ڸ� ��� �ٲ۴�. 10���� ��ǲ�̶�� 10*9 �� �ݺ��ȴ�.
	// Big O(N^2)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,n,temp,count=0;
		int inputArr[] = {1,10,5,7,6,4,9,3,2,8};
		n=inputArr.length; 
		
		for(i=0;i<n;i++) {
			for(j=0;j<n-1;j++) {
				count++;
				if(inputArr[j]>inputArr[j+1]) {
					temp=inputArr[j];
					inputArr[j]=inputArr[j+1];
					inputArr[j+1]=temp;
				}
			}
		}
		
		for(int a : inputArr){
			System.out.println(a);
		}
		System.out.println("ī��Ʈ : " + count);
	}

}
