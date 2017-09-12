import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	static int count =0;
	
	static void enhancedMergeSort(int arr[],int p,int q) {
		
		if(p<q) {
			int mid = (p+q)/2;
			enhancedMergeSort(arr, p, mid);
			enhancedMergeSort(arr, mid+1, q);
			merge(arr,p,mid,q);
		}
		
	}
	
	static void merge(int arr[],int p,int mid,int q) {
		int i=p;
		int j=mid+1;
		int k=-1;
		int temp[]=new int[q-p+1];
		while(i<=mid && j<=q) {
			if(arr[i]<=arr[j]) {
				k++;
				temp[k]=arr[i];
				i++;
			} else {
				k++;
				temp[k]=arr[j];
				j++;
				count=count+mid-i+1;
			}
		}
		while(i<=mid) {
			k++;
			temp[k]=arr[i];
			i++;
		}
		while(j<=q) {
			k++;
			temp[k]=arr[j];
			j++;
		}
		
		int z=0;
		for(i=0,z=p;i<=k;i++,z++) {
			arr[z] = temp[i];
		}
		
	}

	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int arr[]=new int[n];
		for(int i=0;i<n;i++) {
			arr[i]=Integer.parseInt(br.readLine());
		}
		
		enhancedMergeSort(arr,0,n-1);
		System.out.println(count);
		
		
	}
	
}
