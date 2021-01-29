public class LCode51 {

    /**
     * p0，p1代表0和1的填充位置，循环结束时，分别指向0区和1区的末尾的下一个位置
     */
    static class Solution {
        public void sortColors(int[] nums) {
            int n = nums.length;
            int p0 = 0, p1 = 0;
            for (int i = 0; i < n; ++i) {
                if (nums[i] == 1) {
                    int temp = nums[i];
                    nums[i] = nums[p1];
                    nums[p1] = temp;
                    ++p1;
                } else if (nums[i] == 0) {
                    int temp = nums[i];
                    nums[i] = nums[p0];
                    nums[p0] = temp;
                    if (p0 < p1) { //
                        temp = nums[i];
                        nums[i] = nums[p1];
                        nums[p1] = temp;

                        //swap(nums, i, p1);
                    }
                    ++p0;
                    ++p1;
                }
            }
        }

        public void swap(int[] arr, int i, int j) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};

        Solution solution = new Solution();
        solution.sortColors(nums);

        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
