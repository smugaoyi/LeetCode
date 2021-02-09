import java.util.Arrays;
import java.util.Comparator;

public class LCode452 {

    /**
     * 此题的本质是：寻找不重复的区间的个数，但是[1,2] [2,3]算是重复的区间，一个飞镖即可刺破
     */
    static class Solution {

        public int nonOverLappingInterval(int[][] points) {
            if (points.length == 0)
                return 0;

            Arrays.sort(points, Comparator.comparingInt(o -> o[1]));
            int count = 1;
            int end = points[0][1]; // 第一个元素的末端
            for (int i = 1; i < points.length; i++) {
                if (points[i][0] > end) { // 如果第i个元素的开始位置大于end，即算是一个不重复的区间，如[1,2] [3,4]
                    count++;
                    end = points[i][1];
                }
            }
            return count;
        }
    }
}
