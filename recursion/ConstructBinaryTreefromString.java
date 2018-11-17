package recursion;


public class ConstructBinaryTreefromString {
    public TreeNode str2tree(String s){
	if(s == null || s.length() == 0) return null;
	int firstParen = s.indexOf("(");
	int val = firstParen == -1 ? Integer.parseInt(s) : Integer.parseInt(s.substring(0, firstParen));
	TreeNode cur = new TreeNode(val);
	if(firstParen == -1) return cur;
	
	int count = 0, start = firstParen; //use start index to tell whether we are
	//in left or right subtree
	
	for(int i = firstParen; i<s.length();i++){
	    if(s.charAt(i) == '(') count++;
	    else if(s.charAt(i) == ')') count--;
	    if(count == 0 && start == firstParen){
		cur.left = str2tree(s.substring(start+1, i));
		start = i+1;
	    }
	    else if(count == 0)
		cur.right = str2tree(s.substring(start+1, i));
	}
	return cur;
    }
}
