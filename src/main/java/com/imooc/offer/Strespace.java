package com.imooc.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Strespace {
    public static void main(String[] args) {
        String array = "we are the world";
        String res = respace(array);
        ListNode mlistnode = new ListNode(25);
        ListNode m2list = new ListNode(26);
        mlistnode.next = m2list;
        m2list.next = new ListNode(27);
//        printListFromTailToHead(mlistnode);
        System.out.println(res);
        System.out.println(printListFromTailToHead(mlistnode));
        int[] pre ={1,2,4,7,3,5,6,8};
        int[] in ={4,7,2,1,5,3,8,6};
        TreeNode treeNode = reConstructBinaryTree(pre, in);
        diaplayTree(treeNode);
        System.out.println(treeNode);
    }

    private static void diaplayTree(TreeNode treeNode) {
        if (treeNode!=null){

            System.out.println(treeNode.val);
        }else {
            return;
        }
        if (treeNode.left!=null){
            System.out.println(treeNode.left.val);
        }else
        if (treeNode.right!=null){
            System.out.println(treeNode.right.val);

        }
//        diaplayTree(treeNode.left);
//        diaplayTree(treeNode.right);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        if (pre == null || in == null) {
            return null;
        }
        if (pre.length == 0 || in.length == 0) {
            return null;
        }
        if (pre.length != in.length) {
            return null;
        }
        TreeNode root = new TreeNode(pre[0]);
        for (int i = 0; i < pre.length; i++) {
            if (pre[0] == in[i]) {
                root.left = reConstructBinaryTree(
                        Arrays.copyOfRange(pre,1,i+1),Arrays.copyOfRange(in,0,i));
                root.right = reConstructBinaryTree(
                        Arrays.copyOfRange(pre,i+1,pre.length),Arrays.copyOfRange(in,i+1,in.length));
            }
        }
        return root;
    }
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
        if (listNode == null) {
            return list;
        }
        Stack<ListNode> stack = new Stack<>();

        while (listNode != null) {
            stack.push(listNode);
            listNode = listNode.next;
        }
        while (!stack.empty()){
            list.add(stack.pop().val);
        }

        return list;

    }

    static String respace(String str) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            if (String.valueOf(str.charAt(i)).equals(" ")) {

                stringBuilder.append("插入的字符");
            } else {
                stringBuilder.append(str.charAt(i));

            }
        }
        return stringBuilder.toString();
    }

    public static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }
}
