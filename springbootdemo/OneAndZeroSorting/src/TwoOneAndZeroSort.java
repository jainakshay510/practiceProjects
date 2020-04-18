
public class TwoOneAndZeroSort {

	public static void main(String[] args) {
		
		int[] a= new int[]{0,1,2,1,1,1,2,0,0,2,2,2,0,0,1,1,0,1,1,1,2,2,2,0};
		
		sortOneTwoAnZeros(a);
		for(int i:a)
			System.out.println(i+" ");
	}
	
	public static void sortOneTwoAnZeros(int[] a) {
		
		int low=0;
		int high=a.length-1;
		int mid=0;
		int temp=0;
		
		while(mid<=high) {
			
			switch(a[mid]) {
			
			case 0:
				temp=a[low];
				a[low]=a[mid];
				a[mid]=temp;
				
				low++;
				mid++;
				break;
			case 1:
				mid++;
				break;
			case 2:
				temp=a[high];
				a[high]=a[mid];
				a[mid]=temp;
				high--;
				break;
			}
			
			
			
		}
		
		
	}
}
