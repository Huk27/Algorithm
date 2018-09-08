package Sort;

public class MergeSort {
	// 1. 노드가 하나 가 될때까지 분할 한다.
	// 2. 각 노드를 비교하며, 2개,4개의 원소를 가진 배열로 병합한다.
	// 3. 마지막 남은 2개의 배열을 비교하며 병합한다.
	// N*logN
	
	static int mergeCount=0,mergeSortCount=0;
	public static int[] sorted = new int[30];
	 
    public static void mergeSort(int[] arr, int m, int n) {	// 하나가 남을 때 까지 반으로 계속 쪼갠 후 merge 호출.
        int middle;
        mergeSortCount++;
        if (m < n) {
            middle = (m + n) / 2;
            mergeSort(arr, m, middle);
            mergeSort(arr, middle + 1, n);
            merge(arr, m, middle, n);
        }
    }
 
    public static void merge(int[] arr, int m, int middle, int n) {	
        int i, j, k, t;
        mergeCount++;	
        i = m;
        j = middle + 1;
        k = m;
 
        while (i <= middle && j <= n) {
            if (arr[i] <= arr[j])
                sorted[k] = arr[i++];
            else
                sorted[k] = arr[j++];
            k++;
        }
 
        if (i > middle) {
            for (t = j; t <= n; t++, k++)
                sorted[k] = arr[t];
        } else {
            for (t = i; t <= middle; t++, k++)
                sorted[k] = arr[t];
        }
 
        for (t = m; t <= n; t++)
            arr[t] = sorted[t];
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {1,10,5,7,6,4,8,2,9,3};
		mergeSort(arr,0,arr.length-1);
		System.out.println("mergeCount : " + mergeCount + " mergeSortCount : "+mergeSortCount);
		System.out.println("\n 합병 정렬 >> ");
		for(int a : arr) System.out.print(a+ " ");
		
	}

}
