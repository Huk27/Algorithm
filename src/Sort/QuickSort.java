package Sort;

public class QuickSort {
	static int count=0;
	// ��ǥ�� ���� ���� �˰���, O(log N * N)
	// pivot �� ������, ū �迭, �����迭�� ����ؼ� ������.
	// 5 1 7 3 2 4 : 1�� �ǹ�, 5-->4 ���� ū�� ����, 4-->5 ���� ������ ���� �� ���� �ٲ۴�.
	// 5 1 4 3 2 7 : 1��° ����( 7 <--> 4 )
	// 2 1 4 3 5 7 : 2 �� 7 �� ���Ҵµ�, �����ʿ��� << �� ã�� 2�� 7���� �� �Ʒ������Ƿ�, 5�� 2 ��ȯ.
	// 1 2 4 3 5 7 : 4�� 1�� �ǹ� �ٲ��� �ϴµ� 1�� �� �Ʒ� �����Ƿ� 1,2 ��ȯ
	// 1 2 3 4 5 7 : 3,4 ��ȯ.
	// 
	
	public static void quick(int arr[],int start, int end) {
		if(start>=end)
			return;
		System.out.println(++count+" ��°, pivot : " + arr[start]);
		for(int a : arr){
			System.out.print(a + " ");
		}
		System.out.println(" ");
		int pivot = arr[start];
		int i = start+1;
		int j = end;
		int temp;
		
		while(i<j) {	// �������� ������ �ݺ��Ѵ�.
			while(arr[i]<=pivot && i<end)	i++;	// �Ǻ����� ū���� --> �������� ã�Ƴ�����.
			while(arr[j]>=pivot && j>start)	j--;	// �Ǻ����� �������� <-- �������� ã�Ƴ�����.
			System.out.println(count+"��° i : " + i + " j : " + j);
			System.out.println(" ");
			for(int a : arr){
				System.out.print(a + " ");
			}
			if(i>=j) {	// �����ȴٸ�, �Ǻ����� ���� ���� �Ǻ��� ��ȯ�Ѵ�.
				System.out.println(" ");
				System.out.println(arr[start] + " �� " + arr[j] + " �� ��ȯ�մϴ�.");
				temp=arr[j];
				arr[j]=arr[start];
				arr[start]=temp;
				
			}
			else {	// �������� �ʾҴٸ�, �Ǻ����� ū ���� �������� ��ȯ���ش�.
				System.out.println(" ");
				System.out.println(arr[j] + " �� " + arr[i] + " �� ��ȯ�մϴ�.");
				temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
		}
		
		/* �������� ����, Ű �� ����(j)���� ����,�������� �迭�� �� �ٽ� ���������ش�. */
		quick(arr,start,j-1);
		quick(arr,j+1,end); 
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n;
		int inputArr[] = {1,10,5,7,6,4,8,2};
		n=inputArr.length;
		quick(inputArr,0,n-1);
		for(int a : inputArr){
			System.out.print(a + " ");
		}
	}

}
