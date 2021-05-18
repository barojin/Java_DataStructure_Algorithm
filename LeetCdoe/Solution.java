package DSA.LeetCdoe;

import java.lang.reflect.Array;
import java.util.*;

public class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        for (int[] edge : edges){
            int a = edge[0];
            int b = edge[1];
            System.out.println(edge[0] + " " + edge[1]);

        }
        ArrayList<Integer> list = new ArrayList();
        return list.stream().mapToInt(i -> i).toArray();
    }

    public static void main(String[] args) {
        int[][] input = new int[][]{{1,2 },{1,3},{2,3}};
        int[] out = new Solution().findRedundantConnection(input);
        System.out.println(Arrays.toString(out));
    }
}
