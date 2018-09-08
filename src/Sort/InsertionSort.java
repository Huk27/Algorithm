package Sort;

public class InsertionSort {
	// �� ���ڸ� �ʿ� �� ���� �ٲ۴�. ������ ��ġ�� �����ϴ� ����
	// ���� ���� �Ǿ��ִٰ� �����ϱ� ������ �ڱ⺸�� ���� ���� ������ �ٷ� �� �ڿ� �����Ѵ�.
	// �ּ� : �̹� ���ĵǾ��ִٸ� O(n),  �־� : Big O(n^2)
	// 1 10 5 7 6 4 : 0
	// 1 10 5 7 6 4 : 1
	// 1 5 10 7 6 4 : 2
	// 1 5 7 10 6 4 : 3
	// 1 5 7 6 10 4 : 4-1
	// 1 5 6 7 10 4 : 4-2
	// ...... 4�� 10,7,6,5 �� �ٲپ� ���� 1 4 5 6 7 10 ���� ���ĵ�.
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i,j,n,temp,count=0;
		int inputArr[] = {1,10,5,7,6,4,9,3,2,8};
		n=inputArr.length;
		
		for(i=0;i<n;i++) {
			for(j=i;j>0;j--)		
			{
				count++;
				if(inputArr[j]<inputArr[j-1]) {
					temp=inputArr[j];
					inputArr[j]=inputArr[j-1];
					inputArr[j-1]=temp;
				}
				else
					break;	// �ڱ� ���� ū ���� ������ Ž�����ʿ� �����Ƿ� ����. ���������� ����.
			}
		}
		
		for(int a : inputArr){
			System.out.println(a);
		}
		System.out.println("ī��Ʈ : " + count);
		
	}

}
