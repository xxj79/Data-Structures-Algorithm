package string;

import java.util.*;

public class StringCompression {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan = new Scanner(System.in);
		System.out.println(compression(scan.nextLine()));
		scan.close();
	}

	private static String compression(String s){
		StringBuilder sb = new StringBuilder();
		char last = s.charAt(0);
		int count = 0;
		for(int i=0;i<s.length();i++){
			if(s.charAt(i)==last) count++;
			else{
				sb.append(last+""+ (count>1 ? count : ""));
				count = 1;
			}
			last = s.charAt(i);
		}
		sb.append(last+""+ (count>1 ? count : ""));
		
		String str = sb.toString();
		return str.length()<s.length()?str:s;
	}
}
