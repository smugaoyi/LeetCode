import java.util.Arrays;

public class LCode455 {

    static class Solution {
        public int findContentChildren(int[] g, int[] s) {
            Arrays.sort(g);
            Arrays.sort(s);
            int numOfChildren = g.length, numOfCookies = s.length;
            int count = 0;
            for (int i = 0, j = 0; i < numOfChildren && j < numOfCookies; i++, j++) {
                while (j < numOfCookies && g[i] > s[j]) {
                    j++;
                }
                if (j < numOfCookies) {
                    count++;
                }
            }
            return count;
        }
    }

    public static void main(String[] args) {
        int[] g = {1, 2, 3};
        int[] s = {1, 1};

        Solution solution = new Solution();
        int contentChildren = solution.findContentChildren(g, s);
        System.out.println(contentChildren);
    }


}
