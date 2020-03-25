import java.util.List;
import java.util.ArrayList;

public class OneAndZeroSort {

	
	public static void main(String[] ar) {
		
		
		
		int[] a= new int[]{0,1,0,0,1,1,0,1};
		
		List<Integer> list=new ArrayList<>();
		int countZero=0;
		int countOne=0;
		for(int i=0;i<a.length;i++) {
			
			if(a[i]==0) {
				countZero++;
			}
			else if(a[i]==1) {
				countOne++;
			}
			
		}
		
		for(int i=0;i<countZero;i++) {
			list.add(0);
		}
		for(int i=0;i<countOne;i++) {
			list.add(1);
		}
		
		System.out.println(list);
		
		
//		int[] s=new int[] {1,2,3,2,1,0};
//		int sum=0;
//		
//		if(s[0]<=s[1] && s[s.length-1]>=s[s.length-2]) {
//				
//			System.out.println();
//		}
//		else if(s[0]>=s[1] && s[s.length-1]<s.length) {
//			
//		}
		
		String str="Total number of confirmed cases so far in the country as on 23 March 2020 at 10.30 AM including foreign nationals is 415";
		 String[] strArray=str.split(" ");
		 System.out.println(strArray[0]);
		 StringBuilder stBuilder=new StringBuilder("");
		 for(int i =0;i<strArray.length;i++) {
			 
			 String temp=reverse(strArray[i]);
			 stBuilder=stBuilder.append(temp+" ");
		 }
		
		 System.out.println(stBuilder.toString());
	}
	
	public static String reverse(String st) {
		
		if(st.isEmpty())
			return "";
		
		return reverse(st.substring(1))+st.charAt(0);
		
	}
}


class SingletonA{
	
	private volatile SingletonA instance;
	
	public SingletonA getInstance() {
		
		try {
			if(instance==null)
				synchronized (this) {
			
						if(instance==null) {
							
							instance=new SingletonA();
							return instance;
						}
			
			
			}
		}
		catch(Exception e) {
			
		}
		return instance	;
	}
		
	
		
		private SingletonA() {
			
		}
	}
	

