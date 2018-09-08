package Sort;

public class QuickSort2 {

	public static void quick(int input[], int start, int end) {
		if(start>=end)
			return;
		
		int pivot=input[start];
		int left=start+1,right=end;
		while(left<right) {
			while(input[left]<=pivot && left<end) left++;
			while(input[right]>=pivot && right>start) right--;
			
			if(left>=right) {
				int temp=input[start];
				input[start] = input[right];
				input[right] = temp;
				
			}
			
			else {
				int temp=input[right];
				input[right]=input[left];
				input[left]=temp;
			}
		}
		quick(input,start,right-1);
		quick(input,right+1,end);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int input[] = {1,10,5,7,6,4,8,2};
		int n= input.length;
		quick(input,0,n-1);
		for(int a : input) {
			System.out.print(a+" ");
		}
	}

}
