package liubo.tree;

public class TreeNode<E> {
    private E data;  //数据域
    private TreeNode<E> lchild;  //左孩子
    private TreeNode<E> rchild;  //右孩子
    
    TreeNode(){}
    
    TreeNode(E e){
        this.data = e;
    }
    
    TreeNode(E data,TreeNode<E> lchild, TreeNode<E> rchild){
        this.data = data;
        this.lchild = lchild;
        this.rchild = rchild;
    }
    
    public void setData(E data){
        this.data = data;
    }
    
    public E getData(){
        return this.data;
    }
    
    public void setLchild(TreeNode<E> lchild){
        this.lchild = lchild;
    }
    
    public TreeNode<E> getLchild(){
        return this.lchild;
    }
    
    public void setRchild(TreeNode<E> rchild){
        this.rchild = rchild;
    }
    
    public TreeNode<E> getRchild(){
        return this.rchild;
    }
}