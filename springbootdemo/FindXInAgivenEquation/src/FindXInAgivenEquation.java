
import java.lang.*;
import java.util.*;

public class FindXInAgivenEquation {

	
	public static void main(String[] args) {
		
		List<String> list=Arrays.asList(new String[] {"2 / 4x = 10","4x + 2 = 10","2 + 6 = 2x","1x0 * 12 = 1200"});
		for(String s:list) {
			findX(s);
		}
	}
	
	//str is an equation like "2 + 3x = 8"
	
	
	public static String findX(String str) {
		
		List<String> s=Arrays.asList(str.split(" "));
		String t=s.stream().filter(i->i.contains("x")).findAny().get();
		int pos=s.indexOf(t);
		int result=0;
		if(s.indexOf(t)>s.indexOf("=")) {
			
			int a=Integer.valueOf(s.get(0));
			int b=Integer.valueOf(s.get(2));
			String sign=s.get(1);
			
			 result=calculate(a,b,sign,pos);
			System.out.println(result);
			
		}
		else {
			if(pos==0) {
				int a=Integer.valueOf(s.get(2));
				int b=Integer.valueOf(s.get(4));
				String sign=s.get(1);
				
				 result=calculate(a,b,sign,pos);
				System.out.println(result);

			}
			else {
				int a=Integer.valueOf(s.get(0));
				int b=Integer.valueOf(s.get(4));
				String sign=s.get(1);
				
				 result=calculate(a,b,sign,pos);
				System.out.println(result);

			}
		}
		
		
		return str;
	}
	
	public static int calculate(int a ,int b,String sign,int pos) {
		
		if(sign.equals("+")) {
			if(pos==0) {
				return b-a;
			}
			else if(pos==2){
				return a-b;
			}
			else {
				return a+b;
			}
		}
		else if(sign.equals("-")) {
			if(pos==0) {
				return b+a;
			}
			else if(pos==2){
				return a-b;
			}
			else {
				return a-b;
			}
		}
		else if(sign.equals("*")) {
			if(pos==0) {
				return b/a;
			}
			else if(pos==2){
				return b/a;
			}
			else {
				return a/b;
			}
		}
		else if(sign.equals("/")) {
			if(pos==0) {
				return b*a;
			}
			else if(pos==2){
				return a/b;
			}
			else {
				return a/b;
			}
		}
		return 0;
	}
}



