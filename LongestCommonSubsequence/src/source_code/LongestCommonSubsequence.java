package source_code;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestCommonSubsequence {
	
	public static void main(String...strings ) throws IOException {
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter first string");
		String s1 = br.readLine();
		int l1 = s1.length();
		
		System.out.println("enter second string");
		String s2 = br.readLine();
		int l2 = s2.length();
		
		int dp[][] = new int[l1+1][l2+1];
		
		for(int i=1;i<=l1;i++) {
			for(int j=1;j<=l2;j++) {
				if(s1.charAt(i-1) == s2.charAt(j-1)) {
					dp[i][j] = dp[i-1][j-1]+1;
				}else {
					
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		
		System.out.println("length of longest common subsequence is "+dp[l1][l2]);
		
		int i=l1;int j=l2; int index=-1;
		char subsequence[] = new char[Math.max(l1, l2)];
		while(i>0 && j>0) {
			if(dp[i][j] == dp[i-1][j] || dp[i][j]==dp[i][j-1]){
				i--;
			}else {
				index++;
				subsequence[index]=s1.charAt(i-1);
				i--;
				j--;
			}
		}
		
		if(index != -1)
		System.out.print("common subsequence is ");
		for(int z=index;z>=0;z--){
			System.out.print(subsequence[z]);
		}
		
	}

}
