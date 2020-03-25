import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SquaredArrayOutput {
	
	public  static void main(String[] args) {
		
		List<Integer> list=Arrays.asList(new Integer[] {-6,-3,-2,3,5,8,10});
		
		//If we just square the array and then sort the squared aray output that will take nlogn time complexity
		//we need to do it in n time complexity
		
		List<Integer> resultList=new ArrayList<>(list.size());
		for(int i=0;i<list.size();i++) {
			resultList.add(0);
		}
		System.out.println(resultList.size());
		
		int left=0;
		int right=list.size()-1;
		for(int i=resultList.size()-1;i>=0;i--) {
			int a =Math.abs(list.get(left));
			int b=Math.abs(list.get(right));
			if(a>b) {
				resultList.set(i,list.get(left)*list.get(left));
				left++;
			}
			else {
				resultList.set(i,list.get(right)*list.get(right));
				right--;
			}
		}
		
		System.out.println(resultList);
		
		
	}

}
