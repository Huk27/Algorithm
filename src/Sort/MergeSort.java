package Sort;

public class MergeSort {
	// 1. ��尡 �ϳ� �� �ɶ����� ���� �Ѵ�.
	// 2. �� ��带 ���ϸ�, 2��,4���� ���Ҹ� ���� �迭�� �����Ѵ�.
	// 3. ������ ���� 2���� �迭�� ���ϸ� �����Ѵ�.
	// N*logN
	
	static int mergeCount=0,mergeSortCount=0;
	public static int[] sorted = new int[30];
	 
    public static void mergeSort(int[] arr, int m, int n) {	// �ϳ��� ���� �� ���� ������ ��� �ɰ� �� merge ȣ��.
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
		System.out.println("\n �պ� ���� >> ");
		for(int a : arr) System.out.print(a+ " ");
		
	}

}
