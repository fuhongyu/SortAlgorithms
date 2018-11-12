package mergersort;
/**
 * 
 * @author FHY
 * 归并排序的实现
 */
public class MergerSortMain {
	public static void main(String[] args) {
		int[] nums = {2,4,1,6,3,8,5};
		int n = nums.length;
		mergerSort(nums, n);
		for (int i : nums) {
			System.out.println(i);
		}
	}

	private static void mergerSort(int[] nums, int n) {
		mergerSort_each(nums, 0, n-1);
	}

	private static void mergerSort_each(int[] nums, int p, int n) {
		if(p>=n) return;
		// 取p到r之间的中间位置q,防止（p+r）的和超过int类型最大值,
		// 也可以采用  int mid = p+(n-p<<2);
		int mid = p+(n-p)/2;
		mergerSort_each(nums, p, mid);
		mergerSort_each(nums, mid+1, n);
		merge(nums, p, mid, n); //合并有序数组
	}

	//合并排好序的两个子数组
	private static void merge(int[] nums, int p, int q, int r) {
		//数组一：nums[p]-nums[mid]    
		//数组二：nums[mid+1]-nums[n]		
		int[] result = new int[r-p+1];
		//定义三个指针，通过指针的滑动进行大小比较
		int i = p;		
		int j = q+1;
		int k = 0;
		
		while(i<=q && j<=r){
			if(nums[i] <= nums[j]){
				result[k++] = nums[i++];
			}else{
				result[k++] = nums[j++];
			}
		}
		
		int start = i;
		int end = q; 
		if(j<=r){
			start = j;
			end = r;		
		}
		while(start<=end){
			result[k++] = nums[start++];
		}
		
		for(int count=0; count<=r-p; count++){
			nums[p+count] = result[count];
		}
	}
}
