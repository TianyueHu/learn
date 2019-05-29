package learn.standard.java.arithmetic.dp;

import java.util.Arrays;

public class LongestCommonSubstring {

    public static int longestCommonSubstring(String str1, String str2){
        if(str1 != null && str2 != null && str1.length() > 0 && str2.length() > 0){
            int[][] matrix = new int[str1.length() + 1][];
            matrix[0] = new int[str2.length() + 1];
            Arrays.fill(matrix[0], 0);
            int max = 0;
            for(int i = 1; i < str1.length() + 1; ++i){
                matrix[i] = new int[str2.length() + 1];
                Arrays.fill(matrix[i], 0);
                for(int j = 1; j < str2.length() + 1; ++j){
                    if(str1.charAt(i - 1) == str2.charAt(j - 1)){
                        matrix[i][j] = matrix[i - 1][j - 1] + 1;
                        max = Math.max(max, matrix[i][j]);
                    }
                }
            }
            return max;
        }
        return 0;
    }

    public static void main(String[] args){
        System.out.println(longestCommonSubstring("huzheting", "zhangtingqi"));
        System.out.println(longestCommonSubstring("hu", "zhangtingqi"));
        System.out.println(longestCommonSubstring("huzheting", "zhetingqi"));
        System.out.println(longestCommonSubstring("huting", "huzheting"));
        System.out.println(longestCommonSubstring("huzheting", "uzheti"));
        System.out.println(longestCommonSubstring("huzheting", "huzetng"));
        System.out.println(longestCommonSubstring("", "huzheting"));

    }
}
