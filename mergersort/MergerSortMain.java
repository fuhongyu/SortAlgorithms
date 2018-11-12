package mergersort;
/**
 * 
 * @author FHY
 * �鲢�����ʵ��
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
		// ȡp��r֮����м�λ��q,��ֹ��p+r���ĺͳ���int�������ֵ,
		// Ҳ���Բ���  int mid = p+(n-p<<2);
		int mid = p+(n-p)/2;
		mergerSort_each(nums, p, mid);
		mergerSort_each(nums, mid+1, n);
		merge(nums, p, mid, n); //�ϲ���������
	}

	//�ϲ��ź��������������
	private static void merge(int[] nums, int p, int q, int r) {
		//����һ��nums[p]-nums[mid]    
		//�������nums[mid+1]-nums[n]		
		int[] result = new int[r-p+1];
		//��������ָ�룬ͨ��ָ��Ļ������д�С�Ƚ�
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
