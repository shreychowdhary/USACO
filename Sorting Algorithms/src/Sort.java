import java.util.Arrays;

public class Sort {
	public static void main(String[] args){
		int[] arr = new int[100000];
		for(int i = 0; i < arr.length; i++){
			arr[i] = (int)(Math.random() * Integer.MAX_VALUE);
		}
		

		long startTime = System.currentTimeMillis();
		/*System.out.println("Selection: " + checkSorting(selectionSort(Arrays.copyOf(arr, arr.length))));
		System.out.println(System.currentTimeMillis()-startTime);
		
		startTime = System.currentTimeMillis();
		System.out.println("Insert: " + checkSorting(insertSort(Arrays.copyOf(arr, arr.length))));
		System.out.println(System.currentTimeMillis()-startTime);*/
		

		startTime = System.currentTimeMillis();
		int[] quickArr = Arrays.copyOf(arr, arr.length);
		quickSort(quickArr,0,quickArr.length-1);
		System.out.println("Quick: " + checkSorting(quickArr));
		System.out.println(System.currentTimeMillis()-startTime);
		
		startTime = System.currentTimeMillis();		
		int[] mergeArr = Arrays.copyOf(arr, arr.length);
		mergeSort(mergeArr,0,mergeArr.length);
		System.out.println("Merge: " + checkSorting(mergeArr));
		System.out.println(System.currentTimeMillis()-startTime);
	}
	
	static int[] selectionSort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			int min = i;
			for(int j = i; j < arr.length; j++){
				if(arr[j] < arr[min]){
					min = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[min];
			arr[min] = tmp;
		}
		return arr;
	}
	
	static int[] insertSort(int[] arr){
		for(int i = 0; i < arr.length; i++){
			int j = i;
			while(j > 0 && arr[j] < arr[j-1]){
				int tmp = arr[j];
				arr[j] = arr[j-1];
				arr[j-1] = tmp;
				j--;
			}
		}
		return arr;
	}
	
	static void quickSort(int[] arr, int lo, int hi){
		if(lo < hi){
			int p = hi;
			int i = lo;
			while(i < p){
				if(arr[i] >= arr[p]){
					int tmp = arr[i];
					arr[i] = arr[p-1];
					arr[p-1] = arr[p];
					arr[p] = tmp;
					p--;
				}
				else{
					i++;
				}
			}
			quickSort(arr,lo,p-1);
			quickSort(arr,p+1,hi);
		}
	}
	
	static void mergeSort(int[] arr, int l, int r){
		if(r-l == 1){
			return;
		}
		int m = (l+r)/2;
		mergeSort(arr,l,m);
		mergeSort(arr,m,r);
		merge(arr,l,m,r);
	}
	
	static void merge(int[] arr, int l, int m, int r){
		int[] result = new int[r-l];
		int j = m;
		int c = 0;
		for(int i = l; i < m; i++){
			if(j >= r || arr[i] < arr[j]){
				result[c] = arr[i];
				c++;
			}
			else{
				while(j < r && arr[j] < arr[i]){
					result[c] = arr[j];
					j++;
					c++;
				}
				result[c]=arr[i];
				c++;
			}
		}
		while(j < r){
			result[c] = arr[j];
			j++;
			c++;
		}
		for(int i = l; i < r; i++){
			arr[i] = result[i-l];

		}
	}
	
	static boolean checkSorting(int[] arr){
		for(int i = 1; i < arr.length; i++){
			if(arr[i] < arr[i-1]){
				return false;
			}
		}
		return true;
	}
}
