import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LCode347 {

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {

            Map<Integer, Integer> occurrences = new HashMap<>();
            for (int num : nums) {
                occurrences.put(num, occurrences.getOrDefault(num, 0) + 1);
            }

            // int[] 的第一个元素代表数组的值，第二个元素代表了该值出现的次数
            PriorityQueue<int[]> queue = new PriorityQueue<>((m, n) ->
                    m[1] - n[1]
            );
//            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
//                public int compare(int[] m, int[] n) {
//                    return m[1] - n[1];
//                }
//            });
            for (Map.Entry<Integer, Integer> entry : occurrences.entrySet()) {
                int num = entry.getKey(), count = entry.getValue();
                if (queue.size() == k) {
                    if (queue.peek()[1] < count) {
                        queue.poll();
                        queue.offer(new int[]{num, count});
                    }
                } else {
                    queue.offer(new int[]{num, count});
                }
            }
            int[] ret = new int[k];
            for (int i = 0; i < k; ++i) {
                ret[i] = queue.poll()[0];
            }
            return ret;
        }
    }

    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 1, 2, 2, 3, 4, 5};
        Solution solution = new Solution();
        int[] ints = solution.topKFrequent(nums, 2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(ints[i]);
        }
    }


}