import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode str2tree(String s) {
        if (s.length() == 0) return null;
        int val = 0;

        // Subtree
        int leftS, leftE, rightS, rightE;
        leftS = leftE = rightS = rightE = -1;

        int sigh = 1;
        if (s.charAt(0) == '-') sigh = -1;
        else val = s.charAt(0) - '0';

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                leftS = i;
                break;
            }
            val = val * 10 + s.charAt(i) - '0';
        }

        val *= sigh;
        TreeNode root = new TreeNode(val);

        if (leftS == -1) return root;

        // there is a left subtree
        int count = 0;
        for (int i = leftS + 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')') {
                if (count == 0) {
                    leftE = i;
                    break;
                }
                else count--;
            }
        }

        // remove brackets
        root.left = str2tree(s.substring(leftS + 1, leftE));

        for (int i = leftE + 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                rightS = i;
                break;
            }
        }

        if (rightS == -1) return root;

        // there is a right subtree
        count = 0;
        for (int i = rightS + 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')') {
                if (count == 0) {
                    rightE = i;
                    break;
                }
                else count--;
            }
        }

        root.right = str2tree(s.substring(rightS + 1, rightE));

        return root;
    }
}
