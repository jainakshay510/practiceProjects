
public class RemovingKdigitsFromADigitString {

	
	public static void main(String[] args) {
		
		String str="43216748936298";
		StringBuilder res=new StringBuilder("");
		getMinNumber(str, res,4);
		
		System.out.println(res);
	}
	
	public static void getMinNumber(String str,StringBuilder res,int k) {
		
		if(k==0) {
			res= res.append(str);
			return;
		}
		
		if(k>str.length()) {
			res= new StringBuilder("");
			return;
		}
		
		int minIndex=0;
		for(int i=1;i<=k;i++) {
			if(str.charAt(i)<str.charAt(minIndex))
				minIndex=i;
		}
		res.append(str.charAt(minIndex));
		
		String leftOverString=str.substring(minIndex+1);
		
		getMinNumber(leftOverString, res, k-minIndex);
	}
}
