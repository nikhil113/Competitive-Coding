package Main;

/**
 * code for merging k sorted array.
 * 
 * We are creating one priority queue and one final sorted array.
 * Firstly we take the first element from every array and put in the priority queue.
 * Then we start head element of the priority queue and put in the final sorted array.
 * Then we take the next element from the array from the extracted element belongs to and
 * we will put the element in the priority queue.And this process continues and finally 
 * we will get the sorted array(or the merged array).
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

class Node implements Comparable<Node>{
	int value;
	int arrNo;
	@Override
	public int compareTo(Node node) {
		
		if(this.value<=node.value)
			return -1;
		else
			return 1;
	}
}

public class Main {
	
	public static int[] mergeKSortedArray(Node node[][],int k,int n) {
		
		PriorityQueue<Node> queue = new PriorityQueue<>();
		int sortedArray[] = new int[k*n];
		int visited = 0;
		int curIndex[] = new int[k];
		
		for(int i=0;i<k;i++) {
			queue.add(node[i][0]);
			visited++;
		}
		
		int index = -1;
		
		while(visited < k*n) {
			index++;
			Node temp = queue.poll();
			sortedArray[index] = temp.value;
			int row = temp.arrNo;
			curIndex[row]++;
			if(curIndex[row] < n) {
				queue.add(node[row][curIndex[row]]);
				visited++;
			}
		}
		
		while(queue.isEmpty() == false) {
			index++;
			sortedArray[index] = queue.poll().value;
		}
		
		return sortedArray;
	}
	
	
	public static void main(String[] args) throws IOException{
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("enter the number of array");
		int k = Integer.parseInt(br.readLine());
		System.out.println("enter the size of the array");
		int n =Integer.parseInt(br.readLine());
		Node node[][] = new Node[k][n];
		for(int i=0;i<k;i++) {
			System.out.println("enter the elements of array no. "+i+1);
			String values[] = br.readLine().split(" ");
			
			for(int j=0;j<n;j++) {
				int value = Integer.parseInt(values[j]);
				Node ob = new Node();
				ob.value = value;
				ob.arrNo = i;
				node[i][j]=ob;
			}
		}
		
		int sortedArray[] = mergeKSortedArray(node,k,n);
		System.out.println("Resultant array after merging");
		for(int i=0;i<k*n;i++) {
			System.out.println(sortedArray[i]);
		}
		
	}

}
