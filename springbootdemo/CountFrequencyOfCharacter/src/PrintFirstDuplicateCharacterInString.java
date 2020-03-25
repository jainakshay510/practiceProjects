import java.util.HashSet;
import java.util.Set;

public class PrintFirstDuplicateCharacterInString {

	public static void main(String[] args) {
		
		printFirstDuplicateInString("akshay");
		
		
		
		
	}
	
	
	public static void printFirstDuplicateInString(String s) {
		
		Set set=new HashSet<String>();
		
		for(Character c:s.toCharArray()) {
			if(set.contains(String.valueOf(c))) {
				System.out.println(c);
				return;
			}
			else {
				set.add(String.valueOf(c));
			}
		}
		
	}
}
