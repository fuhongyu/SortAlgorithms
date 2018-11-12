package quicksort;
/**
 * 
 * @author FHY
 * 快速排序算法实现
 *
 */
public class QuickSortMain {
	public static void main(String[] args) {
		int[] nums = {2,4,1,6,3,8,5};
		int n = nums.length;
		quickSort(nums, n);
		for (int i : nums) {
			System.out.println(i);
		}
	}

	private static void quickSort(int[] nums, int n) {
		quickSort_each(nums, 0, n-1);	
	}
	
	private static void quickSort_each(int[] nums, int p, int n) {
			if (p>=n) return;
			int q = getPartition(nums,p, n);//获取分区
			quickSort_each(nums, p, q-1);
			quickSort_each(nums, q+1, n);		
	}
	
	/**
	 * 
	 * @param nums 数组
	 * @param p 要比较的左边界
	 * @param r 要比较的右边界
	 * @return 返回划分分区的中间节点
	 * 将最后一个元素作为标志位pivot,通过比较将小于标志位的元素放到左边，大于标志位的放到右边
	 */
	private static int getPartition(int[] nums, int p, int r) {
		int pivot = nums[r]; //把最后一个元素作为标志
		int i = p; 
		
		for(int j = p; j <= r-1; j++){
			if(nums[j] < pivot){
				//交换nums[j]和nums[i]
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
			}
		}
		//交换pivot和nums[i]
		int temp1 = nums[i];
		nums[i] = nums[r];
		nums[r] = temp1;
		return i;
	}
}
