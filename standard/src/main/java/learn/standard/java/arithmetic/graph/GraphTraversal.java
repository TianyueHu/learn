package learn.standard.java.arithmetic.graph;

import java.util.*;

public class GraphTraversal {

    static class Node {
        int val;
        Node next;
        Node(int _val) {
            val = _val;
        }
    }

    public static boolean[][] matrixInit(){
        boolean[][] matrix = new boolean[11][];
        for(int i = 0; i < 11; ++i){
            matrix[i] = new boolean[11];
            Arrays.fill(matrix[i], false);
        }
        matrix[0][1] = true; matrix[1][0] = true;
        matrix[0][3] = true; matrix[3][0] = true;
        matrix[1][2] = true; matrix[2][1] = true;
        matrix[1][3] = true; matrix[3][1] = true;
        matrix[2][5] = true; matrix[5][2] = true;
        matrix[3][4] = true; matrix[4][3] = true;
        matrix[7][8] = true; matrix[8][7] = true;
        matrix[7][9] = true; matrix[9][7] = true;
        matrix[8][9] = true; matrix[9][8] = true;
        matrix[8][10] = true; matrix[10][8] = true;
        return matrix;
    }

    public static Node[] adjacencyListInit(){
        Node[] nodes = new Node[10];
        //...
        return nodes;
    }

    public static Node[] adjacencyListInit(boolean[][] matrix){
        if(matrix != null) {
            Node[] nodes = new Node[matrix.length];
            for (int i = 0; i < matrix.length; ++i) {
                nodes[i] = new Node(i);
            }
            for (int i = 0; i < matrix.length; ++i) {
                for (int j = 0; j < matrix[0].length; ++j) {
                    if(matrix[i][j]){
                        Node next = nodes[i].next;
                        nodes[i].next = new Node(j);
                        nodes[i].next.next = next;
                    }
                }
            }
            return nodes;
        }
        throw new NullPointerException();
    }

    public static List<Integer> dfsRecursion(boolean[][] matrix){
        if(matrix != null){

            List<Integer> order = new ArrayList<>();
            if(matrix.length > 0 && matrix.length == matrix[0].length) {
                boolean[] isVisited = new boolean[matrix.length];
                for(int i = 0; i < matrix.length; ++i)
                    if(!isVisited[i])
                        dfsRecursion(matrix, i, order, isVisited);
            }
            return order;
        }
        throw new NullPointerException();
    }

    private static void dfsRecursion(boolean[][] matrix, int index,
                                     List<Integer> order, boolean[] isVisited){
        if(index >= 0 && index < isVisited.length) {
            isVisited[index] = true;
            order.add(index);
            for (int j = 0; j < matrix.length; ++j) {
                if (matrix[index][j] && !isVisited[j]) {
                    dfsRecursion(matrix, j, order, isVisited);
                }
            }
        }
    }

    public static List<Integer> dfsRecursion(Node[] nodes){
        if(nodes != null){
            List<Integer> order = new ArrayList<>();
            if(nodes.length > 0) {
                boolean[] isVisited = new boolean[nodes.length];
                Arrays.fill(isVisited, false);
                for(int i = 0; i < nodes.length; ++i)
                    if(!isVisited[i])
                        dfsRecursion(nodes, order, i, isVisited);
            }
            return order;
        }
        throw new NullPointerException();
    }

    public static void dfsRecursion(Node[] nodes, List<Integer> order,
                                    int index, boolean[] isVisited){
        if(index >= 0 && index < isVisited.length){
            isVisited[index] = true;
            Node node = nodes[index];
            order.add(node.val);
            Node next = node.next;
            while(next != null){
                if(!isVisited[next.val])
                    dfsRecursion(nodes, order, next.val, isVisited);
                next = next.next;
            }
        }
    }

    public static List<Integer> dfs(boolean[][] matrix){
        if(matrix == null)
            throw new NullPointerException();
        List<Integer> order = new ArrayList<>();
        if(matrix.length > 0 && matrix[0].length == matrix.length){
            boolean[] isVisited = new boolean[matrix.length];
            Stack<Integer> indexStack = new Stack<>();
            for(int i = 0; i < matrix.length; ++i){
                if(!isVisited[i]){
                    indexStack.push(i);
                    order.add(i);
                    isVisited[i] = true;
                    while(!indexStack.isEmpty()){
                        int index = indexStack.peek();
                        boolean find = false;
                        for(int j = 0; j < matrix.length; ++j){

                            if(matrix[index][j] && !isVisited[j]){
                                find = true;
                                indexStack.push(j);
                                order.add(j);
                                isVisited[j] = true;
                                break;
                            }
                        }
                        if(!find)
                            indexStack.pop();
                    }
                }
            }
        }
        return order;
    }

    public static List<Integer> dfs(Node[] nodes){
        if(nodes == null)
            throw new NullPointerException();
        List<Integer> order = new ArrayList<>();
        if(nodes.length > 0){
            boolean[] isVisited = new boolean[nodes.length];
            Stack<Integer> indexStack = new Stack<>();
            for(int i = 0; i < nodes.length; ++i){
                if(!isVisited[i]){
                    order.add(i);
                    isVisited[i] = true;
                    indexStack.push(i);
                    while (!indexStack.isEmpty()){
                        int index = indexStack.peek();
                        Node next = nodes[index].next;
                        boolean find = false;
                        while(next != null){
                            if(!isVisited[next.val]){
                                order.add(next.val);
                                isVisited[next.val] = true;
                                indexStack.push(next.val);
                                find = true;
                                break;
                            }
                            next = next.next;
                        }
                        if(!find)
                            indexStack.pop();
                    }
                }
            }
        }
        return order;
    }

    public static List<Integer> bfs(boolean[][] matrix){
        if(matrix == null)
            throw new NullPointerException();
        List<Integer> order = new ArrayList<>();
        if(matrix.length > 0 && matrix[0].length == matrix.length){
            boolean[] isVisited = new boolean[matrix.length];
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < matrix.length; ++i){
                if(!isVisited[i]){
                    queue.offer(i);
                    isVisited[i] = true;
                    order.add(i);
                    while(!queue.isEmpty()){
                        int index = queue.poll();

                        for(int j = 0; j < matrix.length; ++j){
                            if(!isVisited[j] && matrix[index][j]){
                                queue.offer(j);
                                isVisited[j] = true;
                                order.add(j);
                            }
                        }
                    }
                }
            }
        }
        return order;
    }

    public static List<Integer> bfs(Node[] nodes){
        if(nodes == null)
            throw new NullPointerException();
        List<Integer> order = new ArrayList<>();
        if(nodes.length > 0){
            boolean[] isVisited = new boolean[nodes.length];
            Queue<Integer> queue = new LinkedList<>();
            for(int i = 0; i < nodes.length; ++i){
                if(!isVisited[i]){
                    queue.offer(i);
                    isVisited[i] = true;
                    order.add(i);
                    while(!queue.isEmpty()){
                        int index = queue.poll();
                        Node node = nodes[index];
                        Node next = node.next;
                        while(next != null){
                            if(!isVisited[next.val]){
                                queue.offer(next.val);
                                isVisited[next.val] = true;
                                order.add(next.val);
                            }
                            next = next.next;
                        }
                    }
                }
            }
        }
        return order;
    }

    public static void main(String[] args){
        boolean[][] matrix = matrixInit();
        Node[] nodes = adjacencyListInit(matrix);
        System.out.println(dfsRecursion(matrix));
        System.out.println(dfsRecursion(nodes));
        System.out.println(dfs(matrix));
        System.out.println(dfs(nodes));
        System.out.println(bfs(matrix));
        System.out.println(bfs(nodes));
    }
}
