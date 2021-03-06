package liubo.jianzhiOffer.rebuildTree;

//solution类，实现重建二叉树
public class Solution {
   //主功能函数
   public static TreeNode reConstructBinaryTree(int [] pre,int [] in) {
       if(pre == null || in == null){
           return null;
       }
       TreeNode mm = reConstructBinaryTreeCore(pre, in, 0, pre.length-1, 0, in.length-1);
       return mm;
   }
   //核心递归
   public static TreeNode reConstructBinaryTreeCore(int[] pre, int[] in, int preStart, int preEnd, int inStart, int inEnd) {
       TreeNode tree = new TreeNode(pre[preStart]);
       tree.left = null;
       tree.right = null;
       if (preStart == preEnd && inStart == inEnd) {
           return tree;
       }
       int root = 0;
       for(root= inStart; root < inEnd; root++){
           if (pre[preStart] == in[root]) {
               break;
           }
       }
       int leifLength = root - inStart;
       int rightLength = inEnd - root;
       if (leifLength > 0) {
           tree.left = reConstructBinaryTreeCore(pre, in, preStart+1, preStart+leifLength, inStart, root-1);
       }
       if (rightLength > 0) {
           tree.right = reConstructBinaryTreeCore(pre, in, preStart+1+leifLength, preEnd, root+1, inEnd);
       }
       return tree;
   }
 //将二叉树先序遍历，用于测试结果
   public static void preTraverseBinTree(TreeNode node){
       if (node==null) {
             return;
         }
       System.out.print(node.val+",");
       if (node.left!=null) {
           preTraverseBinTree(node.left);
         }
       if(node.right!=null){
           preTraverseBinTree(node.right);
       }
     }
   //将二叉树中序遍历，用于测试结果
   public static void inTraverseBinTree(TreeNode node){
       if (node==null) {
             return;
         }
       if (node.left!=null) {
           inTraverseBinTree(node.left);
         }
       System.out.print(node.val+",");
       if(node.right!=null){
           inTraverseBinTree(node.right);
       }
     }
 //将二叉树后序遍历，用于测试结果
   public static void postTraverseBinTree(TreeNode node){
       if (node==null) {
             return;
         }
       if (node.left!=null) {
           postTraverseBinTree(node.left);
         }
       if(node.right!=null){
           postTraverseBinTree(node.right);
       }
       System.out.print(node.val+",");
     }
     //主函数，用于测试结果
   public static void main(String[] args){
       int pre[] = {1,2,4,7,3,5,8,9,6};
       int in[]  = {4,7,2,1,8,5,9,3,6};
       TreeNode tree = reConstructBinaryTree(pre, in);
       System.out.print("先序遍历结果:  {");
       preTraverseBinTree(tree);
       System.out.println("}");
       System.out.print("中序遍历结果:  {");
       inTraverseBinTree(tree);
       System.out.println("}");
       System.out.print("后序遍历结果:  {");
       postTraverseBinTree(tree);
       System.out.println("}");
     }
}