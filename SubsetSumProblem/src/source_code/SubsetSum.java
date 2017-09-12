package source_code;

/**
 * code to check whether a subset exist with the sum equal to the given sum.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SubsetSum {
	
	public static void main(String...strings ) throws NumberFormatException, IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("enter the size of the array");
		int n = Integer.parseInt(br.readLine());
		
		System.out.println("enter the elements of the array");
		String s[] = br.readLine().split(" ");
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(s[i]);
		}
		
		System.out.println("enter the value of sum");
		int sum = Integer.parseInt(br.readLine());
		
		boolean dp[][]=new boolean[n][sum+1];
		for(int i=0;i<n;i++) {
			dp[i][0] = true;
		}
		
		for(int j=1;j<=sum;j++) {
			if(arr[0] == j)
				dp[0][j]=true;
		}
		
		for(int i=1;i<n;i++) {
			for(int j=1;j<=sum;j++) {
				if((j-arr[i]>=0 && dp[i-1][j-arr[i]]==true) || (dp[i-1][j])) {
					dp[i][j]=true;
				}else {
					dp[i][j]=false;
				}
			}
		}
		
		System.out.println("answer is "+dp[n-1][sum]);
		if(dp[n-1][sum]) {
			System.out.println("sub array is : ");
			
			int i=n-1; int j=sum; int index=-1;
			int subArray[] = new int[n];
			int temp = 0;
			while(i>0 && j>0) {
				if(dp[i][j] == dp[i-1][j]) {
					i--;
				}else {
					index++;
					subArray[index] = arr[i];
					temp += arr[i];
					j = j-arr[i];
					i--;
				}
			}
		
			/**
			 * It may possible that sum has already completed ex. 1 7 6 3.
			 * Thats why comparing with sum also.
			 */
			if(dp[0][j] && temp < sum) {
				index++;
				subArray[index]=arr[0];
			}
			
			for(int z=index;z>=0;z--) {
				System.out.print(subArray[z]+" ");
			}
			System.out.println();
		}
		
	}

}
