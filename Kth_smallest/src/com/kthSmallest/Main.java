package com.kthSmallest;

/**
 * Finding kth smallest through quick sort.
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
	
	static int enhancedQuickSort(int arr[], int p, int q, int k) {
		
		if(p<q) {
			int index = partition(arr , p , q);
			if(index == k) {
				return arr[index];
			} else if(k > index) {
				return enhancedQuickSort(arr,index+1,q,k);
			}else {
				return enhancedQuickSort(arr,p,index-1,k);
			}
		}
		else {
			return -1;
		}
	}
	
	static int partition(int arr[],int p,int q) {
		
		int i=p-1;
		int j=0;
		for(j=p;j<q;j++) {
			if(arr[j]<=arr[q]) {
				i++;
				int temp=arr[i];
				arr[i]=arr[j];
				arr[j]=temp;
			}
		}
		i++;
		int temp = arr[i];
		arr[i] = arr[q];
		arr[q] = temp;
		
		return i;
	}
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		int k = Integer.parseInt(br.readLine());
		int kthsmallest = enhancedQuickSort(arr, 0, n-1, k-1);
		System.out.println(kthsmallest);

		
	}

}
