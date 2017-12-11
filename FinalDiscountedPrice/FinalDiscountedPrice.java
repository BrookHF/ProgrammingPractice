import java.util.*;

/**
 * price = {5, 1, 3, 4, 6, 2}
 * discount = {1, 0, 2, 2, 2, 0}
 * output: 14 \n 1 5
 */
class solution {

	private static String finalPrice(int[] array) {
		Deque<int[]> stack = new ArrayDeque<>();
		int[] discount = new int[array.length];
		for(int i=0; i<array.length; i++) {
			if(stack.isEmpty() || stack.peek()[0] < array[i]) {
				stack.push(new int[]{array[i], i});
			} else {
				while(!stack.isEmpty() && stack.peek()[0] >= array[i]) {
					discount[stack.pop()[1]] = array[i];
				}
			}
		}
		int sum = 0;
		List<String> noDiscount = new ArrayList<>();
		for(int i=0; i<array.length; i++) {
			sum += (array[i] - discount[i]);
			if(discount[i] == 0) {
				noDiscount.add("" + i);
			}
		}
		return sum + "\n" + String.join(" ", noDiscount);
	}

	public static void main(String[] args) {
		int[] array = new int[]{5, 1, 3, 4, 6, 2};
		System.out.println(finalPrice(array));
	}
}