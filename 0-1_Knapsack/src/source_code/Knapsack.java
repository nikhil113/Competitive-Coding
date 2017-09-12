package source_code;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Knapsack {
	
	public static void main(String... args) throws Exception{
		
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter the number of the items");
		int n = Integer.parseInt(br.readLine());
		System.out.println("enter the weights of all the item");
		String s1[] = br.readLine().split(" ");
		int wt[] = new int[n+1];
		for(int i=0;i<n;i++) {
			wt[i+1] = Integer.parseInt(s1[i]);
		}
		
		System.out.println("enter the value associated with each items");
		String s2[] = br.readLine().split(" ");
		int value[] = new int[n+1];
		for(int i=0;i<n;i++) {
			value[i+1] = Integer.parseInt(s2[i]);
		}
		
		System.out.println("enter the maximum weight allowed");
		int weight = Integer.parseInt(br.readLine());
		
		int dp[][] = new int[n+1][weight+1];
		
		/**
		 * when total weight is zero value will be always 0
		 */
		for(int i=0;i<=n;i++) {
			dp[i][0] = 0;
		}
		
		/**
		 * when list size is zero value will be again always 0
		 */
		for(int j=0;j<=weight;j++) {
			dp[0][j] = 0;
		}
		
		for(int i=1;i<=n;i++) {
			for(int j=1;j<=weight;j++) {
				if(wt[i] <= j && dp[i-1][j-wt[i]]+value[i] > dp[i-1][j]) {
					dp[i][j] = dp[i-1][j-wt[i]]+value[i];
				}else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		
		System.out.println("total max value = "+dp[n][weight]);
		
		int selectedWeights[] = new int[n];
		int i =n; int j=weight; int index=-1;
		while(i>0 && j>0) {
			
			if(dp[i][j] == dp[i-1][j]) {
				i--;
			}
			else {
				index++;
				selectedWeights[index] = wt[i];
				i--;
				j=j-wt[i];
			}
			
		}
		
		System.out.println("selected weights are :-");
		for(int z=0;z<=index;z++) {
			System.out.println(selectedWeights[z]);
		}
		
	}

}
