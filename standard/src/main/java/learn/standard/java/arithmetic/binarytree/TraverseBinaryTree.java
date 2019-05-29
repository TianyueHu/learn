package learn.standard.java.arithmetic.binarytree;

import java.util.*;

public class TraverseBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static TreeNode array2TreeNode(int[] array){
        if(array != null){
            if(array.length > 0 && array[0] != -1){
                Queue<TreeNode> queue = new LinkedList<>();
                TreeNode root = new TreeNode(array[0]);
                queue.offer(root);
                for(int i = 1; i < array.length && !queue.isEmpty(); i += 2){
                    TreeNode node = queue.poll();
                    if(array[i] != -1){
                        TreeNode leftChild = new TreeNode(array[i]);
                        node.left = leftChild;
                        queue.offer(leftChild);
                    }
                    if(i + 1 < array.length && array[i+1] != -1){
                        TreeNode rightChild = new TreeNode(array[i+1]);
                        node.right = rightChild;
                        queue.offer(rightChild);
                    }
                }
                queue.clear();
                return root;
            }
            return null;
        }
        throw new NullPointerException();
    }

    public static List<Integer> preOrder(TreeNode root){
        if(root != null){
            List<Integer> order = new LinkedList<>();
            Stack<TreeNode> stack = new Stack<>();
            stack.push(root);
            while(!stack.isEmpty()){
                TreeNode top = stack.pop();
                order.add(top.val);
                if(top.right != null){
                    stack.push(top.right);
                }
                if(top.left != null){
                    stack.push(top.left);
                }
            }
            return order;
        }
        throw new NullPointerException();
    }

    public static List<Integer> preOrder(int[] array){
        //假设-1代表该节点不存在
        if(array != null){
            List<Integer> order = new LinkedList<>();
            if(array.length > 0 && array[0] != -1) {
                Stack<Integer> stack = new Stack<>();
                stack.push(0);
                while (!stack.isEmpty()) {
                    int topIndex = stack.pop();

                    order.add(array[topIndex]);
                    if (topIndex * 2 + 2 < array.length && array[topIndex * 2 + 2] != -1) {
                        stack.push(topIndex * 2 + 2);
                    }
                    if (topIndex * 2 + 1 < array.length && array[topIndex * 2 + 1] != -1) {
                        stack.push(topIndex * 2 + 1);
                    }

                }
            }
            return order;
        }
        throw new NullPointerException();
    }

    public static List<Integer> inOrder(int[] array){
        if(array != null){
            List<Integer> order = new LinkedList<>();
            if(array.length > 0 && array[0] != -1){
                Stack<Integer> stack = new Stack<>();
                Boolean[] isVisited = new Boolean[array.length];
                Arrays.fill(isVisited, false);
                stack.push(0);
                while(!stack.isEmpty()){
                    int index = stack.peek();
                    if(!isVisited[index]){
                        isVisited[index] = true;
                        if(index * 2 + 1 < array.length && array[index * 2 + 1] != -1){
                            stack.push(index * 2 + 1);
                        }

                    }
                    else{
                        stack.pop();
                        order.add(array[index]);
                        if(index * 2 + 2 < array.length && array[index * 2 + 2] != -1){
                            stack.push(index * 2 + 2);
                        }
                    }
                }
                return order;
            }
            return order;
        }
        throw new NullPointerException();
    }

    public static List<Integer> inOrder(TreeNode root) {
        if(root != null){
            List<Integer> order = new LinkedList<>();
            Stack<TreeNode> s = new Stack<TreeNode>();
            Stack<Boolean> visit = new Stack<Boolean>();

            s.push(root);
            visit.push(false);

            while (!s.isEmpty()){
                TreeNode top = s.peek();
                boolean visited = visit.pop();
                if (!visited && top.left != null){
                    visit.push(true);
                    s.push(top.left);
                    visit.push(false);
                }
                else {
                    order.add(top.val);
                    s.pop();
                    if(top.right != null){
                        s.push(top.right);
                        visit.push(false);
                    }
                }
            }
            return order;
        }
        throw new NullPointerException();
    }

    public static List<Integer> postOrder(int[] array){
        if(array != null){
            List<Integer> order = new LinkedList<>();
            if(array.length > 0 && array[0] != -1){
                Stack<Integer> stack = new Stack<>();
                int[] status = new int[array.length];
                Arrays.fill(status, 0);
                stack.push(0);
                while (!stack.isEmpty()){
                    int index = stack.peek();
                    if(status[index] == 0){
                        status[index] = 1;
                        if(index * 2 + 1 < array.length && array[index * 2 + 1] != -1){
                            stack.push(index * 2 + 1);
                            continue;
                        }
                    }
                    if(status[index] == 1){
                        status[index] = 2;
                        if(index * 2 + 2 < array.length && array[index * 2 + 1] != -1){
                            stack.push(index * 2 + 2);
                            continue;
                        }
                    }
                    order.add(array[index]);
                    stack.pop();
                }
            }
            return order;
        }
        throw new NullPointerException();
    }

    public static List<Integer> postOrder(TreeNode root){
        if(root != null) {
            Stack<TreeNode> stack = new Stack<TreeNode>();
            Stack<Integer> vStack = new Stack<Integer>();
            List<Integer> order = new LinkedList<>();
            stack.push(root);
            vStack.push(0);
            while (!stack.isEmpty()) {
                TreeNode node = stack.pop();
                int visit = vStack.pop();
                switch (visit) {
                    case 0:
                        //状态0 表示刚入栈，接下来需要先遍历左子树，如果左子树为空，会继续执行状态1
                        if (node.left != null) {
                            stack.push(node);
                            vStack.push(1);
                            stack.push(node.left);
                            vStack.push(0);
                            break;
                        }
                    case 1:
                        //状态1 表示左子树已经遍历完成，接下来需要先遍历右子树，如果右子树为空，会继续执行状态2
                        if (node.right != null) {
                            stack.push(node);
                            vStack.push(2);
                            stack.push(node.right);
                            vStack.push(0);
                            break;
                        }
                    case 2:
                        //状态2 表示左右子树都遍历完成，输出自己的值
                        order.add(node.val);
                }
            }
            return order;
        }
        throw new NullPointerException();
    }
    public static void main(String[] args){
        int[] array = {1,2,3,4,5,6,7,8,9,-1,-1,10,11};
        TreeNode root = array2TreeNode(array);
        System.out.println("Tree: " + Arrays.toString(array));
        System.out.println("preorder: " + preOrder(array));
        System.out.println("preorder: " + preOrder(root));
        System.out.println("inorder: " + inOrder(array));
        System.out.println("inorder: " + inOrder(root));
        System.out.println("postorder: " + postOrder(array));
        System.out.println("postorder: " + postOrder(root));
    }
}
