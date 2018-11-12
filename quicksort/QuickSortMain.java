package quicksort;
/**
 * 
 * @author FHY
 * ���������㷨ʵ��
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
			int q = getPartition(nums,p, n);//��ȡ����
			quickSort_each(nums, p, q-1);
			quickSort_each(nums, q+1, n);		
	}
	
	/**
	 * 
	 * @param nums ����
	 * @param p Ҫ�Ƚϵ���߽�
	 * @param r Ҫ�Ƚϵ��ұ߽�
	 * @return ���ػ��ַ������м�ڵ�
	 * �����һ��Ԫ����Ϊ��־λpivot,ͨ���ȽϽ�С�ڱ�־λ��Ԫ�طŵ���ߣ����ڱ�־λ�ķŵ��ұ�
	 */
	private static int getPartition(int[] nums, int p, int r) {
		int pivot = nums[r]; //�����һ��Ԫ����Ϊ��־
		int i = p; 
		
		for(int j = p; j <= r-1; j++){
			if(nums[j] < pivot){
				//����nums[j]��nums[i]
				int temp = nums[i];
				nums[i] = nums[j];
				nums[j] = temp;
				i++;
			}
		}
		//����pivot��nums[i]
		int temp1 = nums[i];
		nums[i] = nums[r];
		nums[r] = temp1;
		return i;
	}
}
