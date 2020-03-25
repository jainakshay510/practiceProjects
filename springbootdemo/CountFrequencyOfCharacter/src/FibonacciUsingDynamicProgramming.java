
public class FibonacciUsingDynamicProgramming {

	
	public static void main(String[] args) {
		
		printFibonacciUsingDynamicProgramming(3);
	}
	
	
	public static void printFibonacciUsingDynamicProgramming(int n) {
		
		int[] f=new int[n+2];  //One extra to store case n=0
		
		f[0]=0;
		f[1]=1;
		for(int i=2;i<=n;i++) {
			f[i]=f[i-1]+f[i-2];
			
		}
		
		System.out.println(f[n]);
		
		
		
		
	}
}
