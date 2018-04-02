package liubo.array;

public class KMP {
	public static int[] getNext(String t){
		int[] next = new int[t.length()];
		next[0] = -1;
		int suffix = 0;
		int prefix = -1;
		
		while(suffix < t.length()-1){
			if(prefix==-1||t.charAt(prefix)==t.charAt(suffix)){
				++prefix;
				++suffix;
				next[suffix] = prefix;
			}else{
				prefix = next[prefix];
			}
		}
		return next;
	}
	public static int KMPAlgorithm(String s, String t) {  
	    int i = 0;  
	    int j = 0;  
	    //得到next数组  
	    int[] next = getNext(t);  
	    while (i < s.length() && j < t.length()) {  
	        if (j == -1 || s.charAt(i) == t.charAt(j)) {  
	            i++;  
	            j++;  
	        } else {  
	            //根据next数组的指示j进行回溯，而i永远不会回溯  
	            j = next[j];  
	        }  
	    }  
	    if (j == t.length()) {  
	        return i - j;  
	    } else {  
	        return -1;  
	    }  
	} 
	public static void main(String[] args) {
		String s = "ABACDEABACEFER";
		String t = "ABACE";
		int index = KMPAlgorithm(s, t);
		System.out.println("index:"+index);
	}
}
