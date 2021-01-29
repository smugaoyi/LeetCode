import java.util.*;

public class LCode451 {

    static class Solution {

        // 此类问题也可以看作时查找问题, 从一个字符串中找出出现频率最高的字符, 然后拍在最前面
        // 使用Java 提供的优先队列来按照出现次数进行排序
        public String frequencySort(String s) {

            if (s == null || s.length() < 2) return s;

            // 存储字符/对应字符出现次数
            int[] frequency = new int[128];
            char[] chars = s.toCharArray();

            // 计算每个字符出现次数
            for (int i = 0; i < chars.length; i++) {
                frequency[chars[i]]++;
            }

            // 定义一个大顶堆
            PriorityQueue<Character> heap2 = new PriorityQueue<>(new Comparator<Character>() {
                public int compare(Character a, Character b) {
                    return frequency[b] - frequency[a];
                }
            });

            // 将数据写入到PriorityQueue中
            for (int j = 0; j < 128; j++) {
                if (frequency[j] != 0)
                    heap2.offer((char) j);
            }

            StringBuilder stringBuilder = new StringBuilder();
            while (!heap2.isEmpty()) {
                char ch = heap2.poll();
                while (frequency[ch] > 0) {
                    stringBuilder.append(ch);
                    frequency[ch]--;
                }
            }

            return stringBuilder.toString();

        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();
        String res = solution.frequencySort("ssaatbbb");
        System.out.println(res);
    }

    class Solution2 {

        // 关于频次问题可以使用桶排序来完成
        // 可以以出现最大频次作为桶的个数
        public String frequencySort(String s) {

            if (s == null || s.length() < 2) return s;

            // 存储字符/对应字符出现次数
            int[] frequency = new int[128];
            char[] chars = s.toCharArray();

            // 计算每个字符出现次数
            for (int i = 0; i < chars.length; i++) {
                frequency[chars[i]]++;
            }

            // 找到出现最大的频次, 作为桶的个数
            int maxNums = 0;
            for (int nums : frequency) {
                if (nums > maxNums)
                    maxNums = nums;
            }

            // 1. 初始化桶
            List<Character>[] buckets = new List[maxNums + 1];

            // 2. 装桶
            for (int k = 0; k < 128; k++) {
                if (frequency[k] == 0)
                    continue;
                int value = frequency[k];
                // 当前桶为空, 创建一个新桶
                if (buckets[value] == null) {
                    buckets[value] = new ArrayList<>();
                }
                buckets[value].add((char) k);
            }

            StringBuilder stringBuilder = new StringBuilder();

            // 3. 将桶中的元素倒出, 从后向前倒出
            for (int j = buckets.length - 1; j >= 0; j--) {
                if (buckets[j] == null)
                    continue;
                for (char value : buckets[j]) {
                    while (frequency[value] > 0) {
                        stringBuilder.append(value);
                        frequency[value]--;
                    }
                }
            }

            return stringBuilder.toString();

        }
    }


}
