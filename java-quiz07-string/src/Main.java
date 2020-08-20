public class Main {

	public static void main(String[] args){
		int [] nums = new int[] {1,2,3,4,5};
		System.out.println(MyArrays.toString(nums));

	}
}

class MyArrays {

	public static String toString(int[] nums) {
		StringBuilder s = new StringBuilder();
		s.append("[");
		for (int i = 0; i < nums.length; i++) {
			if (i != nums.length-1)
				s.append(nums[i] + ",");
			else
				s.append(nums[i] + "]");
		}
		return s.toString();
	}

}

