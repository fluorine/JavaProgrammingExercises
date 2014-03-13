public class IsSubstring {
    public static void main(String[] args) {
	evaluate("hola", "hola mundo");
	evaluate("lla", "edmola");
	evaluate("Dios", "Dios es Santo");
	evaluate("bien", "muy bien hecho");
	evaluate("hk", "hok");
	evaluate("tr", "Intromisión");
	evaluate("aba", "aabbaab");
    }
    
    public static void evaluate(String sub, String text) {
	if(isSubstring(sub, text)) {
	    System.out.println("\"" + sub + "\" is substring of \"" + text + "\"");
	} else {
	    System.out.println("\"" + sub + "\" is NOT a substring of \"" + text + "\"");
	}
    }
    
    public static boolean isSubstring(String sub, String text) {
	for(int t = 0, s = 0; t < text.length(); t++) {
	    if(text.charAt(t) == sub.charAt(s)) {
		s++;
		
		if(s == sub.length())
		    return true;
	    } else {
		s = 0;
	    }
	}
	
	return false;
    }
}
