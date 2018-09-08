package Sort;

public class InsertionSort {
	// 각 숫자를 필요 할 때만 바꾼다. 적절한 위치에 삽입하는 정렬
	// 앞이 정렬 되어있다고 생각하기 때문에 자기보다 작은 값이 나오면 바로 그 뒤에 삽입한다.
	// 최소 : 이미 정렬되어있다면 O(n),  최악 : Big O(n^2)
	// 1 10 5 7 6 4 : 0
	// 1 10 5 7 6 4 : 1
	// 1 5 10 7 6 4 : 2
	// 1 5 7 10 6 4 : 3
	// 1 5 7 6 10 4 : 4-1
	// 1 5 6 7 10 4 : 4-2
	// ...... 4는 10,7,6,5 와 바꾸어 최종 1 4 5 6 7 10 으로 정렬됨.
	
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
					break;	// 자기 보다 큰 값이 나오면 탐색할필요 없으므로 멈춤. 삽입정렬의 장점.
			}
		}
		
		for(int a : inputArr){
			System.out.println(a);
		}
		System.out.println("카운트 : " + count);
		
	}

}
