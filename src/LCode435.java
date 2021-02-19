import java.util.Arrays;
import java.util.Comparator;

/**
 * 不重叠区间的个数：
 * 先计算出不重叠的区间的个数，然后用区间的总数减去不重叠的区间的个数，即需要移除的区间的个数
 */
public class LCode435 {

    static class Solution {
        public int eraseOverlapIntervals(int[][] intervals) {
            if (intervals.length == 0) {
                return 0;
            }

            Arrays.sort(intervals, new Comparator<int[]>() {
                @Override
                public int compare(int[] interval1, int[] interval2) {
                    return interval1[1] - interval2[1];
                }
            });

            int n = intervals.length;
            int right = intervals[0][1];
            int ans = 1;
            for (int i = 1; i < n; ++i) {
                if (intervals[i][0] >= right) {
                    ++ans;
                    right = intervals[i][1];
                }
            }
            return n - ans;
        }
    }

    public static void main(String[] args) {

        int[][] arr = {{1, 2}, {2, 3}, {2, 4}};

        Solution solution = new Solution();
        int i = solution.eraseOverlapIntervals(arr);
        System.out.println(i);

    }
}
