public class LCode215 {

    static class Solution {
        public int findKthLargest(int[] nums, int k) {
            int heapSize = nums.length;
            buildMaxHeap(nums, heapSize);
            for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
                // 删除堆顶元素，从上往下调整
                swap(nums, 0, i);
                --heapSize;
                maxHeapify(nums, 0, heapSize);
            }
            return nums[0];
        }

        public void buildMaxHeap(int[] a, int heapSize) {
            for (int i = heapSize / 2; i >= 0; --i) {
                maxHeapify(a, i, heapSize);
            }
        }

        /**
         * 调整
         *
         * @param a
         * @param i        当前要调整的子树的根
         * @param heapSize
         */
        public void maxHeapify(int[] a, int i, int heapSize) {
            // 从下往上调整
            // largest指向最大的节点
            int l = i * 2 + 1, r = i * 2 + 2, largest = i;
            if (l < heapSize && a[l] > a[largest]) {
                largest = l;
            }
            if (r < heapSize && a[r] > a[largest]) {
                largest = r;
            }
            if (largest != i) { // 如果最大的节点不是根i，则和i交换；交换完后，以largest为根的子树有可能也不满足大根堆，所以要递归
                swap(a, i, largest);
                maxHeapify(a, largest, heapSize);
            }
        }

        public void swap(int[] a, int i, int j) {
            int temp = a[i];
            a[i] = a[j];
            a[j] = temp;
        }
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 1, 6, 4, 5};

        Solution solution = new Solution();
        int kthLargest = solution.findKthLargest(nums, 2);
        System.out.println(kthLargest);// 5
    }

}
