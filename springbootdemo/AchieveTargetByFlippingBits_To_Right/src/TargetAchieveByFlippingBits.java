
public class TargetAchieveByFlippingBits {

	public static void main(String[] args) {
		
		String target="010010";
		StringBuffer s=new StringBuffer("");
		
		for(int i=0;i<target.length();i++) {
			s.append("0");
		}
		
		int count=0;
		int i=0;
		
		while(!target.equals(s.toString())) {
			
			if(target.charAt(i)==s.charAt(i)) {
				
			}
			else {
				count++;
				for(int j=i;j<target.length();j++) {
					if(s.charAt(j)=='0') {
						s.setCharAt(j,'1');
					}
					else {
						s.setCharAt(j,'0');
					}
				}
			}
			
			i++;
			
		}
		System.out.println(count+s.toString());
	}
}

