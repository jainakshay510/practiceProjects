import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CountFrequency {
	
	public static void main(String[] args) {
		
		String str="AkshAy";
		countFrequency(str);
		
		List<Integer> list=new ArrayList<>();
		list.add(1);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(5);
		list.add(1);
		list.add(0);
		list.add(2);
		
		
		
		//System.out.println(pairsWithSumEqualToGivenSum(list,3));
		
		
		//printPairsUsingSet(list,3);
		
		
	}
	
	
	public static void countFrequency(String s) {
		
		char[] ch=s.toCharArray();
		
		int[] freq=new int[256];
		Map<Character,Integer> map=new HashMap<>();
		for(int i=0;i<s.length();i++) {
			freq[Math.abs(s.charAt(i)-'a')]+=1;
			
			if(map.containsKey(s.charAt(i))) {
				map.put(s.charAt(i),map.get(s.charAt(i))+1);
			}
			else {
				map.put(s.charAt(i),1);
			}
			
		}
		
		Set<Character> set=map.keySet();
		for(Character c:set) {
			System.out.println(c+"  "+map.get(c));
		}
		
		for(int f:freq) {
			if(f>0) {
			System.out.print(f+" ");}
			
		}
		
		System.out.println();
	}
	
	
	public static boolean pairsWithSumEqualToGivenSum(List<Integer> a,int sum) {
		
		Collections.sort(a);
		System.out.println(a);
		int i=0;
		int j=a.size()-1;
		while(i<j) {
			int tempSum=a.get(i)+a.get(j);
			
			if(tempSum==sum) {
				
				System.out.println(a.get(i)+"  "+a.get(j)+" "+tempSum);
				i++;j--;
			}
			else if(tempSum>sum) {
				j--;
			}
			else {
				i++;
			}
		}
		
		System.out.println("nahi chala");
		return false;
		
	}
	
	
	public static void printPairsUsingSet(List<Integer> a,int n) {
		
		if(a.size()<2) {
			System.out.println("Atleast two pairs required");
		}
		Collections.sort(a);
		
		Set set=new HashSet<>(a.size());
		
		for(Integer temp:a) {
			int target=n-temp;
			
			if(!set.contains(target)) {
				set.add(temp);
			}
			else {
				System.out.println("Pairs is "+temp+" "+target);
			}
			
		}
		
		
		
	}

}
