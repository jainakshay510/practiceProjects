
public class QuickSort {
	
	public static void main(String[] args) {
		
		
		int arr[] = {10, 7, 8, 9, 1, 5}; 
        int n = arr.length; 
  
        
        quickSort(arr, 0, n-1); 
  
        System.out.println("sorted array"); 
        
        
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
		
	}
	
	
	public static void  quickSort(int[] a,int low,int high) {
		
		
		
		if(low<high) {
			
			int pivot=partition(a, low, high);
			
			quickSort(a,low,pivot-1);
			
			quickSort(a, pivot+1,high);
			
			
		}
	}
	
	public static int partition(int[] a,int low,int high) {
		
		int i=low-1;
		int pivot=a[high];
		for(int j=low;j<a.length;j++) {
			
			if(a[j]<pivot) {
				i++;
				int temp=a[i];
				a[i]=a[j];
				a[j]=temp;
			}
			
		}
		
		int temp1=a[i+1];
		a[i+1]=a[high];
		a[high]=temp1;
		
		return i+1;
		
	
	}

}
