package Sort;

public class SelectionSort {
	
	// �� �պ��� �ϳ� �� ������ ���Ҹ� ��� ��ġ�ϸ� �ּҰ��� �� �տ� ����, �Ǿ� �ε��� +1 �Ѵ�.
	// Big O(N^2)
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,min,j,n,index=0,temp,count=0;
		int inputArr[] = {1,10,5,7,6,4,9,3,2,8};
		n=inputArr.length; 
		 for(i=0;i<n;i++) {
			 min=Integer.MAX_VALUE;
			 for(j=i;j<n;j++) {
				 count++;
				 if(inputArr[j]<min) {
					 min=inputArr[j];
					 index=j;
				 }
			 }
			 temp=inputArr[i];
			 inputArr[i]=min;
			 inputArr[index]=temp;
		 }
		 
		 for(int a : inputArr) {
			 System.out.println(a);
		 }
		 System.out.println("ī��Ʈ : " + count);
	}

}
