package Sort;

public class QuickSort {
	static int count=0;
	// 대표적 분할 정복 알고리즘, O(log N * N)
	// pivot 을 가지고, 큰 배열, 작은배열로 계속해서 나눈다.
	// 5 1 7 3 2 4 : 1이 피벗, 5-->4 갈땐 큰값 선택, 4-->5 갈땐 작은값 선택 후 서로 바꾼다.
	// 5 1 4 3 2 7 : 1번째 수행( 7 <--> 4 )
	// 2 1 4 3 5 7 : 2 와 7 이 남았는데, 오른쪽에서 << 로 찾은 2가 7보다 더 아래있으므로, 5와 2 교환.
	// 1 2 4 3 5 7 : 4와 1이 피벗 바뀌어야 하는데 1이 더 아래 있으므로 1,2 교환
	// 1 2 3 4 5 7 : 3,4 교환.
	// 
	
	public static void quick(int arr[],int start, int end) {
		if(start>=end)
			return;
		System.out.println(++count+" 번째, pivot : " + arr[start]);
		for(int a : arr){
			System.out.print(a + " ");
		}
		System.out.println(" ");
		int pivot = arr[start];
		int i = start+1;
		int j = end;
		int temp;
		
		while(i<j) {	// 엇갈리기 전까지 반복한다.
			while(arr[i]<=pivot && i<end)	i++;	// 피봇보다 큰값을 --> 방향으로 찾아나간다.
			while(arr[j]>=pivot && j>start)	j--;	// 피봇보다 작은값을 <-- 방향으로 찾아나간다.
			System.out.println(count+"번째 i : " + i + " j : " + j);
			System.out.println(" ");
			for(int a : arr){
				System.out.print(a + " ");
			}
			if(i>=j) {	// 엇갈렸다면, 피봇보다 작은 값을 피봇과 교환한다.
				System.out.println(" ");
				System.out.println(arr[start] + " 와 " + arr[j] + " 을 교환합니다.");
				temp=arr[j];
				arr[j]=arr[start];
				arr[start]=temp;
				
			}
			else {	// 엇갈리지 않았다면, 피봇보다 큰 값과 작은값을 교환해준다.
				System.out.println(" ");
				System.out.println(arr[j] + " 와 " + arr[i] + " 을 교환합니다.");
				temp=arr[j];
				arr[j]=arr[i];
				arr[i]=temp;
			}
		}
		
		/* 엇갈리고 나면, 키 값 기준(j)으로 왼쪽,오른쪽의 배열을 또 다시 퀵정렬해준다. */
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
