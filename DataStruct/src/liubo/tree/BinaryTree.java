package liubo.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * @author Cherish
 * 二叉树的链式存储结构
 * @param <E>
 */

public class BinaryTree<E> {
    private TreeNode<E> root;  //根节点
    private List<TreeNode> nodeList = null;  //二叉树节点的链式结构
    
    public BinaryTree(){
        
    }
    
    public BinaryTree(TreeNode<E> root){
        this.root = root;
    }
    
    //把一个数组转化为一颗完全二叉树
    public TreeNode<E> buildTree(E[] array){
        nodeList = new LinkedList<TreeNode>();        
        //将数组中的元素依次转换为TreeNode节点，存放于链表中
        for(int i=0; i< array.length; i++){
            nodeList.add(new TreeNode(array[i]));  
        }
        //对前（array.length / 2 - 1）个父节点，按照父节点与孩子节点的数字关系建立完全二叉树
        //对完全二叉树，按从上到下，从左到右的顺序依次编号0,1,2,3....N,则i>0的节点，其左孩子为（2*i+1），
        //其右孩子为（2*i+2）
        for(int j=0; j < (array.length/2-1);j++){
            //左孩子
            nodeList.get(j).setLchild(nodeList.get(j*2+1));
            //右孩子
            nodeList.get(j).setRchild(nodeList.get(j*2+2));
        }
        //最后一个父节点：因为最后一个父节点可能没有右孩子，所以单独处理
        int index = array.length/2 -1;
        //左孩子
        nodeList.get(index).setLchild(nodeList.get(index*2+1));
        //右孩子：如果数组的长度为奇数才有右孩子
        if(array.length % 2 == 1){
            nodeList.get(index).setRchild(nodeList.get(index*2+2));
        }
        root=nodeList.get(0); //设置根节点
        return root;
    }
    
    //得到树的高度
    public int height(TreeNode<E> node){
        if(node == null){
            return 0;
        }else{
            int i = height(node.getLchild());
            int j = height(node.getRchild());
            return (i<j)?(j+1):(i+1);
        }
    }
    
    //得到节点的个数
    public int size(TreeNode<E> node){
        if(node == null){
            return 0;
        }else{
            return 1+ size(node.getLchild())+size(node.getRchild());
        }
    }
    
    //递归实现先序遍历 NLR
    public void preOrder(TreeNode<E> node){
        if(node != null){
            System.out.print(node.getData() + " ");
            preOrder(node.getLchild());
            preOrder(node.getRchild());
        }
    }
    //非递归实现先序遍历 NLR
    public void nonRecPreOrder(TreeNode<E> node){
        Stack<TreeNode<E>> nodeStack = new Stack<TreeNode<E>>();
        TreeNode<E> nodeTemp = node; //nodeTemp作为遍历指针
        while(nodeTemp != null || !nodeStack.isEmpty()){  //当nodeTemp非空或栈非空时循环
            if(nodeTemp != null){  //根指针非空，遍历左子树
                nodeStack.push(nodeTemp);  //根指针进栈
                System.out.print(nodeStack.peek().getData() + " "); //根指针退栈，访问根节点
                nodeTemp = nodeTemp.getLchild();  //每遇到非空二叉树先向左走
            }else{ //再向右子树走
                nodeTemp = nodeStack.pop(); //peek()仅输出值不删除栈顶的值 pop()输出后删除。
                nodeTemp = nodeTemp.getRchild();
            }
        }    
    }
    
    //递归实现中序遍历 LNR
    public void inOrder(TreeNode<E> node){
        if(node != null){
            inOrder(node.getLchild());
            System.out.print(node.getData() + " ");
            inOrder(node.getRchild());
        }
    }
    
    //非递归实现中序遍历 LNR
    public void nonRecInOrder(TreeNode<E> node){
        Stack<TreeNode<E>> nodeStack = new Stack<TreeNode<E>>();
        TreeNode<E> nodeTemp = node;  //nodeTemp作为遍历指针
        while(nodeTemp != null || !nodeStack.isEmpty()){  //当nodeTemp非空或栈非空时循环
            if(nodeTemp != null){  //根指针非空，遍历左子树
                nodeStack.push(nodeTemp);  //根指针进栈
                nodeTemp = nodeTemp.getLchild();  //每遇到非空二叉树先向左走
            }else{
                nodeTemp = nodeStack.pop();  //根指针退栈，访问根节点
                System.out.print(nodeTemp.getData() +" ");
                nodeTemp = nodeTemp.getRchild();  //再向右子树走
            }        
        }
    }
    
    //递归实现后序遍历 LNR
    public void postOrder(TreeNode<E> node){
        if(node != null){
            postOrder(node.getLchild());
            postOrder(node.getRchild());
            System.out.print(node.getData() + " ");
        }
    }
    
    //非递归实现后序遍历 LNR
    public void nonRecPostOrder(TreeNode<E> node){
        Stack<TreeNode<E>> nodeStack = new Stack<TreeNode<E>>();
        TreeNode<E> nodeTemp = node; //nodeTemp作为遍历指针
        TreeNode<E> preNode = null;  //表示最近一次访问的节点
        while(nodeTemp != null || !nodeStack.isEmpty()){  //当nodeTemp非空或栈非空时循环
            while(nodeTemp != null){  //一直向左走，遍历左子树
                nodeStack.push(nodeTemp);
                nodeTemp = nodeTemp.getLchild();
            }
            nodeTemp = nodeStack.peek();
            if(nodeTemp.getRchild()==null || nodeTemp.getRchild() == preNode){  //右子树为空或右子树已被访问时，该节点出栈
                nodeTemp = nodeStack.pop();
                System.out.print(nodeTemp.getData()+" ");
                preNode = nodeTemp;  //将该节点赋值给最近一个访问节点                    
                nodeTemp = null;  //此处很重要，将刚出栈节点设置为空，对应于while循环的条件之一，否则陷入死循环
            }else{
                nodeTemp = nodeTemp.getRchild(); //遍历右子树
            }
        }
    }
    
    
    //层次遍历
    public void levelOrder(TreeNode<E> root){
        Queue<TreeNode<E>> nodeQueue = new LinkedList<TreeNode<E>>();
        TreeNode<E> node = null;
        nodeQueue.add(root);  //将根节点入队    
        while(!nodeQueue.isEmpty()){  //队列不空循环
            node = nodeQueue.peek();
            System.out.print(node.getData()+" ");
            nodeQueue.poll();    //队头元素出队
            if(node.getLchild() != null){    //左子树不空，则左子树入队列
                nodeQueue.add(node.getLchild());
            }
            if(node.getRchild() != null){    //右子树不空，则右子树入队列
                nodeQueue.add(node.getRchild());
            }
        }
    }
    
    public static void main(String args[]){
        //将一个数组转化为一颗完全二叉树
        Object[] array = {1,2,3,4,5,6,7,8};
        BinaryTree bt = new BinaryTree();
        TreeNode root = bt.buildTree(array);
        System.out.print("树的高度：");  
        System.out.println(bt.height(root));
        System.out.print("节点的个数：");  
        System.out.println(bt.size(root));
        System.out.println("先序遍历：");  
        bt.preOrder(root); 
        System.out.println("\n"+"非递归先序遍历："); 
        bt.nonRecPreOrder(root);
        System.out.println(); 
        
  
        System.out.println("中序遍历：");  
        bt.inOrder(root);  
        System.out.println("\n"+"非递归中序遍历："); 
        bt.nonRecInOrder(root);
        System.out.println();
  
        System.out.println("后序遍历：");  
        bt.postOrder(root);  
        System.out.println("\n"+"非递归后序遍历："); 
        bt.nonRecPostOrder(root);
        System.out.println(); 
        
        System.out.println("层次遍历：");  
        bt.levelOrder(root); 
        
        //手工构建一颗二叉树
        TreeNode nodeA = new TreeNode("A");
        TreeNode nodeB = new TreeNode("B");
        TreeNode nodeC = new TreeNode("C");
        TreeNode nodeD = new TreeNode("D");
        TreeNode nodeE = new TreeNode("E");
        TreeNode nodeF = new TreeNode("F");
        TreeNode nodeG = new TreeNode("G");
        TreeNode nodeH = new TreeNode("H");
        TreeNode nodeI = new TreeNode("I");
        nodeA.setLchild(nodeB);
        nodeA.setRchild(nodeD);
        nodeB.setRchild(nodeC);
        nodeD.setLchild(nodeE);
        nodeD.setRchild(nodeF);
        nodeF.setLchild(nodeG);
        nodeF.setRchild(nodeI);
        nodeG.setRchild(nodeH);
        
        
        System.out.println("\n\n"+"*****************");
        System.out.print("树的高度：");  
        System.out.println(bt.height(nodeA));
        System.out.print("节点的个数：");  
        System.out.println(bt.size(nodeA));
        System.out.println("先序遍历：");  
        bt.preOrder(nodeA);  
        System.out.println();  
  
        System.out.println("中序遍历：");  
        bt.inOrder(nodeA);  
        System.out.println();  
  
        System.out.println("后序遍历：");  
        bt.postOrder(nodeA);  
        System.out.println(); 
        
        System.out.println("层次遍历：");  
        bt.levelOrder(nodeA); 
    }
}