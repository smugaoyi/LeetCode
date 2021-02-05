import java.util.Arrays;
import java.util.Comparator;

public class LCode435 {


    public static void main(String[] args) {

        int[][] arr = {{1, 2}, {2, 3}, {3, 4}};

        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o2[1] - o1[1];
            }
        });


        for (int i = 0; i < arr.length; i++) {
            System.out.println("-----");
            for (int j = 0; j < arr[i].length; j++) {
                System.out.println(arr[i][j]);
            }

        }
    }
}
