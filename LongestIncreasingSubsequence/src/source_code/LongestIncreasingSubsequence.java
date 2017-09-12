package source_code;

/**
 * code for finding the longest increasing subsequence in the given array
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class LongestIncreasingSubsequence {
	
	public static void main(String...strings ) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter the size of the array");
		int n = Integer.parseInt(br.readLine());
		
		System.out.println("enter the elements of the array");
		int arr[] = new int[n];
		int prev[] = new int[n];
		
		String s1[] = br.readLine().split(" ");
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(s1[i]);
		}
		
		int dp[] = new int[n];
		dp[0] = 1;
		for(int i=1;i<n;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[i]>arr[j] && dp[i]<dp[j]+1) {
					dp[i] = dp[j]+1;
					prev[i] = j;
				}
			}
		}
		
		int max = Integer.MIN_VALUE;
		int maxIndex = 0;
		
		for(int i=0;i<n;i++) {
			if(dp[i]>=max) {
				max = dp[i];
				maxIndex = i;
			}
		}
		
		System.out.println("Length of longest increasing subsequence is "+max);
		
		System.out.println("Subsequence is as follows :- ");
		int count = max;
		int index = maxIndex;
		String ans = " ";
		while(count > 0) {
			ans = String.valueOf(arr[index])+" "+ans;
			count--;
			index = prev[index];
		}
		
		System.out.println(ans);
		
	}

}
