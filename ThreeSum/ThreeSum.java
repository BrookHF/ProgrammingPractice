import java.util.*;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that 
 * a + b + c = 0? Find all unique triplets in the array which gives the sum 
 * of zero.
 * 
 * Note: The solution set must not contain duplicate triplets.
 *
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 * 
 */

class ThreeSum {

	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		Arrays.sort(nums);
		for(int i=0; i<nums.length; i++) {
			int left = i+1, right = nums.length-1;
			while(left < right) {
				if(nums[i] + nums[left] + nums[right] == 0) {
					List<Integer> list = new ArrayList<>();
					list.add(nums[i]);
					list.add(nums[left]);
					list.add(nums[right]);
					res.add(list);
				} else if(nums[i] + nums[left] + nums[right] > 0) {
					right--;
				} else {
					left++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args){
		System.out.println("result: " + threeSum(S));
	}
}