package liubo.tree;

public class ThreadBinaryTree {

    private Node preNode;   //线索化时记录前一个节点

    //节点存储结构
    static class Node {
        String data;        //数据域
        Node left;          //左指针域
        Node right;         //右指针域
        boolean isLeftThread = false;   //左指针域类型  false：指向子节点、true：前驱或后继线索
        boolean isRightThread = false;  //右指针域类型  false：指向子节点、true：前驱或后继线索

        Node(String data) {
            this.data = data;
        }
    }

    /**
     * 通过数组构造一个二叉树（完全二叉树）
     * @param array
     * @param index
     * @return
     */
    static Node createBinaryTree(String[] array, int index) {
        Node node = null;

        if(index < array.length) {
            node = new Node(array[index]);
            node.left = createBinaryTree(array, index * 2 + 1);
            node.right = createBinaryTree(array, index * 2 + 2);
        }

        return node;
    }

    /**
     * 中序线索化二叉树
     * @param node  节点
     */
    void inThreadOrder(Node node) {
        if(node == null) {
            return;
        }

        //处理左子树
        inThreadOrder(node.left);

        //左指针为空,将左指针指向前驱节点
        if(node.left == null) {
            node.left = preNode;
            node.isLeftThread = true;
        }

        //前一个节点的后继节点指向当前节点
        if(preNode != null && preNode.right == null) {
            preNode.right = node;
            preNode.isRightThread = true;
        }
        preNode = node;

        //处理右子树
        inThreadOrder(node.right);
    }

    /**
     * 中序遍历线索二叉树，按照后继方式遍历（思路：找到最左子节点开始）
     * @param node
     */
    void inThreadList(Node node) {
        //1、找中序遍历方式开始的节点
        while(node != null && !node.isLeftThread) {
            node = node.left;
        }

        while(node != null) {
            System.out.print(node.data + ", ");

            //如果右指针是线索
            if(node.isRightThread) {
                node = node.right;

            } else {    //如果右指针不是线索，找到右子树开始的节点
                node = node.right;
                while(node != null && !node.isLeftThread) {
                    node = node.left;
                }
            }
        }
    }

    /**
     * 中序遍历线索二叉树，按照前驱方式遍历（思路：找到最右子节点开始倒序遍历）
     * @param node
     */
    void inPreThreadList(Node node) {
        //1、找最后一个节点
        while(node.right != null && !node.isRightThread) {
            node = node.right;
        }

        while(node != null) {
            System.out.print(node.data + ", ");

            //如果左指针是线索
            if(node.isLeftThread) {
                node = node.left;

            } else {    //如果左指针不是线索，找到左子树开始的节点
                node = node.left;
                while(node.right != null && !node.isRightThread) {
                    node = node.right;
                }
            }
        }
    }

    /**
     * 前序线索化二叉树
     * @param node
     */
    void preThreadOrder(Node node) {
        if(node == null) {
            return;
        }

        //左指针为空,将左指针指向前驱节点
        if(node.left == null) {
            node.left = preNode;
            node.isLeftThread = true;
        }

        //前一个节点的后继节点指向当前节点
        if(preNode != null && preNode.right == null) {
            preNode.right = node;
            preNode.isRightThread = true;
        }

        preNode = node;

        //处理左子树
        if(!node.isLeftThread) {
            preThreadOrder(node.left);
        }

        //处理右子树
        if(!node.isRightThread) {
            preThreadOrder(node.right);
        }
    }

    /**
     * 前序遍历线索二叉树（按照后继线索遍历）
     * @param node
     */
    void preThreadList(Node node) {
        while(node != null) {

            while(!node.isLeftThread) {
                System.out.print(node.data + ", ");
                node = node.left;
            }

            System.out.print(node.data + ", ");
            node = node.right;
        }
        
    }

    public static void main(String[] args) {
        String[] array = {"A", "B", "C", "D", "E", "F", "G", "H"};
        Node root = createBinaryTree(array, 0);

        ThreadBinaryTree tree = new ThreadBinaryTree();
        tree.inThreadOrder(root);
        System.out.println("中序按后继节点遍历线索二叉树结果：");
        tree.inThreadList(root);
        System.out.println("\n中序按后继节点遍历线索二叉树结果：");
        tree.inPreThreadList(root);

        Node root2 = createBinaryTree(array, 0);
        ThreadBinaryTree tree2 = new ThreadBinaryTree();
        tree2.preThreadOrder(root2);
        tree2.preNode = null;
        System.out.println("\n前序按后继节点遍历线索二叉树结果：");
        tree.preThreadList(root2);
    }
}