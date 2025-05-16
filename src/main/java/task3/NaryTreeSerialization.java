package task3;

import java.util.List;
import java.util.ArrayList;

class NaryTreeNode {
    int val;
    List<NaryTreeNode> children;

    NaryTreeNode(int x) {
        val = x;
        children = new ArrayList<>();
    }
}

public class NaryTreeSerialization {
    public static String serialize(NaryTreeNode root) {
        if (root == null) {
            return "NULL";
        }
        if (root.children.isEmpty()) {
            return "(" + root.val + ", NULL)";
        }

        StringBuilder sb = new StringBuilder();
        sb.append("(").append(root.val).append(", ");
        for (int i = 0; i < root.children.size(); i++) {
            sb.append(serialize(root.children.get(i)));
            if (i < root.children.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(")");
        return sb.toString();
    }

    public static void main(String[] args) {
        NaryTreeNode root = new NaryTreeNode(1);
        NaryTreeNode child1 = new NaryTreeNode(2);
        NaryTreeNode child2 = new NaryTreeNode(3);
        NaryTreeNode child3 = new NaryTreeNode(4);

        root.children.add(child1);
        root.children.add(child2);
        root.children.add(child3);

        child2.children.add(new NaryTreeNode(5));
        child2.children.add(new NaryTreeNode(6));

        System.out.println(serialize(root));
    }
}
