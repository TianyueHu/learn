package learn.standard.java.arithmetic.graph;

import java.util.Arrays;

public class ShortestPath {

    public static int[][] matrixInit(){
        int[][] matrix = new int[8][];
        for(int i = 0; i < 8; ++i){
            matrix[i] = new int[11];
            Arrays.fill(matrix[i], -1);
            matrix[i][i] = 0;
        }
        matrix[0][1] = 1;matrix[1][0] = 1;
        matrix[1][2] = 2;matrix[2][1] = 2;
        matrix[1][4] = 5;matrix[4][1] = 5;
        matrix[2][3] = 3;matrix[3][2] = 5;
        matrix[3][5] = 1;matrix[5][3] = 1;
        matrix[4][5] = 2;matrix[5][4] = 2;
        matrix[5][6] = 4;matrix[6][5] = 4;
        matrix[5][7] = 7;matrix[7][5] = 7;
        matrix[6][7] = 2;matrix[7][6] = 2;
        return matrix;
    }

    public static int dijkstra(int[][] matrix, int start, int end){
        if(matrix == null)
            throw new NullPointerException();
        if(start >= 0 && start < matrix.length
                && end >= 0 && end < matrix.length && start != end){
            boolean[] isVisited = new boolean[matrix.length];
            Arrays.fill(isVisited, false);
            int[] dist = new int[matrix.length];
            int[] prev = new int[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                dist[i] = matrix[start][i];
                prev[i] = start;
            }
            isVisited[start] = true;
            for (int i = 0; i < matrix.length; i++) {

                int minDist = Integer.MAX_VALUE;
                int minIndex = -1;
                for(int j = 0; j < dist.length; ++j){
                    if(!isVisited[j] && dist[j] != -1 && dist[j] < minDist){
                        minDist = dist[j];
                        minIndex = j;
                    }
                }
                if(minIndex == -1){
                    break;
                }
                System.out.println("minIndex : " + minIndex);
                isVisited[minIndex] = true;
                for(int k = 0; k < matrix.length; ++k){
                    if(matrix[minIndex][k] != -1 && (matrix[minIndex][k] + minDist < dist[k] || dist[k] == -1)){
                        dist[k] = matrix[minIndex][k] + minDist;
                        prev[k] = minIndex;
                    }
                }
            }
            return dist[end];
        }
        return 0;
    }

    public static void main(String[] args){
        int[][] matrix = matrixInit();
        System.out.println(dijkstra(matrix, 1, 7));
    }
}
