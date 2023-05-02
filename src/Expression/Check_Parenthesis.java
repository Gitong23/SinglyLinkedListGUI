package Expression;

public class Check_Parenthesis {
	public static boolean checkParentheses(String s) {
		StackString sk = new StackString();
		for(int i=0; i < s.length(); i++) {
			char c = s.charAt(i);
			if(c == '{' || c == '(' || c == '[') {
				sk.push(""+c);
			}
			else if(c == '}' || c == ')' || c == ']') {
				if(sk.size() == 0)return false;
				String p = sk.pop();
				char cp = p.charAt(0);
				if(c == '}' && cp != '{' || c == ')' && cp != '(' || c == ']' && cp != '[') {
					return false;
				}
			}
		}
		if(sk.size() != 0) {
			return false;
		}
		return true;
	}
}
