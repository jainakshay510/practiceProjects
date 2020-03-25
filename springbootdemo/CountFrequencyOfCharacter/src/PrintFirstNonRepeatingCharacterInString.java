import java.util.HashSet;
import java.util.Set;

public class PrintFirstNonRepeatingCharacterInString {

	
public static void main(String[] args) {
		
	printFirstNonRepeatingInString("GeeksForGeeks");
		
	}
	
	
	public static void printFirstNonRepeatingInString(String s) {
		
		int countArraySize=256;
		
		int[] countArray=new int[256];
		
		for(int i=0;i<s.length();i++) {
			countArray[s.charAt(i)]++;
		}
		
		int index=-1;
		for(int i=0;i<s.length();i++) {
			if(countArray[s.charAt(i)]==1) {
				index=i;
				break;
			}
		}
		
		System.out.println(s.charAt(index));
		
	}
}
