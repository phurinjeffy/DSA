// 65011463 Phurin Vanasrivilai

package code;

public class TreeNode {
    public int data;
    public TreeNode left, right, parent;

    public TreeNode(int d) {
        data = d;
    }

    @Override
    public String toString() {
        // There are 4 cases left-child-only, right-child-only, both children, no child.
        if (left != null && right == null) 
            return left.data + "<-" + data + "->null";
        else if (left == null && right != null) 
            return "null<-" + data + "->" + right.data;
        else if (left != null && right != null) 
            return left.data + "<-" + data + "->" + right.data;
        else
            return "null<-" + data + "->null";
    }
}