package source_code;

/**
 * Minimum coins required to make a given total
 */

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MinCoins {
	
	public static void main(String...strings ) throws Exception{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter the number of coins");
		int n = Integer.parseInt(br.readLine());
		
		System.out.println("enter the denominations of the coins");
		String s1[] = br.readLine().split(" ");
		int values[] = new int[n];
		for(int i=0;i<n;i++) {
			values[i] = Integer.parseInt(s1[i]);
		}
		
		System.out.println("enter the value of total");
		int total = Integer.parseInt(br.readLine());
		int dp[][] = new int[n][total+1];
		
		for(int j=1;j<=total;j++) {
			if(j%values[0] == 0) {
				dp[0][j] = j/values[0];
			} else {
				dp[0][j] = Integer.MAX_VALUE;
			}
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<=total;j++) {
				if(values[i] <= j) {
					int left = dp[i][j-values[i]];
					int up = dp[i-1][j];
					if(left != Integer.MAX_VALUE) {
						left = 1+left;
					}
					dp[i][j] = Math.min(left, up);
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
			
		if(dp[n-1][total] == Integer.MAX_VALUE) {
			System.out.println("Given total is not possible with given denominations");
		}else {
			System.out.println("No of coins required are : "+dp[n-1][total]);
		}
		
		
		/**
		 * Finding the frequency of each coins in the given total.
		 */
		
		if(dp[n-1][total] != Integer.MAX_VALUE) {
			
			Map<Integer,Integer> freqMap = new HashMap<>();
			int i=n-1; int j=total;
			int temp = 0;
			while(i>0 && j>0) {
				if(dp[i][j] == dp[i-1][j]) {
					i--;
				}else {
					if(freqMap.get(values[i]) == null) {
						freqMap.put(values[i], 1);
					} else {
						int v = freqMap.get(values[i]);
						v++;
						freqMap.put(values[i], v);
					}
					temp += values[i];
					j = j-values[i];
				}
			}
			
			while(dp[i][j] != Integer.MAX_VALUE && temp<total) {
				if(freqMap.get(values[i]) == null) {
					freqMap.put(values[i], 1);
				} else {
					int v = freqMap.get(values[i]);
					v++;
					freqMap.put(values[i], v);
				}
				temp += values[i];
				j = j-values[i];
			}
			
			Set<Integer> keySet = freqMap.keySet();
			for(Integer x : keySet) {
				System.out.println("freq of "+x+" in total is : "+freqMap.get(x));
			}
			
		}
		
	}

}
