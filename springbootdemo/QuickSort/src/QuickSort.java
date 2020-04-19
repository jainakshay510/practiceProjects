

public class QuickSort {
	
	public static void main(String[] args) {
		
		
		int arr[] = {10, 7, 8,5, 9, 1, 5}; 
        int n = arr.length; 
  
        
        quickSort(arr, 0, n-1); 
  
        System.out.println("sorted array"); 
        
        
        for (int i=0; i<n; ++i) 
            System.out.print(arr[i]+" "); 
        System.out.println(); 
		
	}
	
	
	public static void  quickSort(int[] a,int start,int end) {
		
		
		
		if(start<end) {
			
			int pivot=partition(a, start,end);
			
			quickSort(a,start,pivot-1);
			
			quickSort(a, pivot+1,end);
			
			
		}
	}
	
	public static int partition(int[] a,int start,int end) {
		
		int pIndex=start;
		int pivot=a[end];
		for(int j=start;j<a.length-1;j++) {
			
			if(a[j]<=pivot) {
				
				int temp=a[pIndex];
				a[pIndex]=a[j];
				a[j]=temp;
				
				pIndex++;
			}
			
		}
		
		int temp1=a[pIndex];
		a[pIndex]=a[end];
		a[end]=temp1;
		
		return pIndex;
		
	
	}

}
